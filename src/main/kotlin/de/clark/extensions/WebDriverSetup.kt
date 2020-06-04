package de.clark.extensions

import de.clark.constants.Constants.TIMEOUT
import de.clark.utils.Log
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.remote.RemoteWebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.net.URL
import java.util.concurrent.TimeUnit

class WebDriverSetup() {

    companion object : Log() {}

    lateinit var webDriver: WebDriver

    constructor(options: ChromeOptions) : this() {
        this.webDriver = ChromeDriver(options)
    }

    constructor(options: ChromeOptions, url: String) : this() {
        this.webDriver = RemoteWebDriver(URL(url), options)
    }

    fun get(url: String) {
        webDriver.manage().window().maximize()
        webDriver.manage()?.timeouts()?.implicitlyWait(10, TimeUnit.SECONDS)
        webDriver.get(url)
        pageIsLoaded()
        logger.info("Page $url has been opened")
    }

    private fun pageIsLoaded(timeOut: Long = TIMEOUT) {
        WebDriverWait(webDriver, timeOut).until {
            (webDriver as JavascriptExecutor).executeScript("return document.readyState") == "complete"
        }
        logger.info("Page ${webDriver.currentUrl} has been loaded")
    }

    fun findElement(by: By): WebElementImpl {
        WebDriverWait(webDriver, TIMEOUT).until {
            ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(by))
        }
        logger.info("Element $by is clickable")
        val webElement = WebElementImpl(webDriver.findElement(by))
        logger.info("Element with class [${webElement.getClass()}] found")
        scrollToElement(webElement)
        return webElement
    }

    fun findElements(by: By): List<WebElementImpl> {
        WebDriverWait(webDriver, TIMEOUT).until {
            ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(by))
        }
        logger.info("Elements [$by] are clickable")
        val webElements = webDriver.findElements(by).map { WebElementImpl(it) }
        logger.info("Element collected. Count: ${webElements.size}")
        return webElements
    }

    fun switchToFrame(frameId: String, timeOut: Long = TIMEOUT) {
        WebDriverWait(webDriver, timeOut).until {
            ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameId)
        }
        webDriver.switchTo().frame(frameId)
        logger.info("Switched to frame $frameId")
    }

    fun switchToFrameBySelector(frameSelector: By, timeOut: Long = TIMEOUT) {
        WebDriverWait(webDriver, timeOut).until {
            ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameSelector)
        }
        webDriver.switchTo().frame(webDriver.findElement(frameSelector))
        logger.info("Switched to frame $frameSelector")
    }

    fun scrollToElement(webelement: WebElementImpl) {
        ((webDriver as JavascriptExecutor).executeScript(
                "arguments[0].scrollIntoView(true);" + "window.scrollBy(0, -400);"
        ))
        logger.info("Scrolled to element with class [${webelement.getClass()}")
    }

    fun moveToElement(webelement: WebElementImpl): WebElementImpl{
        Actions(webDriver).moveToElement(webelement.webElement).build().perform()
        logger.info("Cursor moved to class=[${webelement.getClass()}]")
        return webelement
    }

    fun quit(){
        webDriver.quit()
        logger.info("Webriver successfully quit")
    }

}