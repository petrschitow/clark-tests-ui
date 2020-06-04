package de.clark.pages

import de.clark.constants.Constants.TIMEOUT
import de.clark.extensions.WebDriverSetup
import de.clark.extensions.WebElementImpl
import de.clark.utils.Log
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

abstract class BasePage(val webDriverSetup: WebDriverSetup) {
    companion object : Log() {}

    val webDriver = webDriverSetup.webDriver

    init {
        PageFactory.initElements(webDriver, this)
    }

    fun openPage(url: String) {
        webDriverSetup.get(url)
    }

    fun waitPageIsLoaded(timeout: Long = TIMEOUT) {
        WebDriverWait(webDriver, timeout).until {
            (webDriver as JavascriptExecutor).executeScript("return document.readyState") == "complete"
        }
        logger.info("Page ${webDriver.currentUrl} has been loaded")
    }

    fun waitElementIsVisible(by: By, timeout: Long = TIMEOUT): WebElementImpl {
        WebDriverWait(webDriver, timeout).until {
            ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(by))
        }
        logger.info("Element [$by] is visible")
        return webDriverSetup.findElement(by)
    }

    fun waitElementIsInvisible(by: By, timeout: Long = TIMEOUT) {
        WebDriverWait(webDriver, timeout).until {
            checkElementInvisibility(by)
        }
    }

    fun checkElementInvisibility(by: By): Boolean {
        try {
            webDriver.findElement(by)
        } catch (e: NoSuchElementException) {
            logger.info("Element [$by] is invisible")
            return true
        }
        logger.info("Element [$by] is NOT invisible")
        return false
    }


}