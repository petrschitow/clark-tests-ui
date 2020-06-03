package de.clark.extensions

import de.clark.utils.Log
import org.openqa.selenium.*

class WebElementImpl(val webElement: WebElement) : WebElement {

    companion object : Log() {}

    override fun isDisplayed(): Boolean {
        return webElement.isDisplayed
    }

    override fun clear() {
        webElement.clear()
        logger.info("Cleared")
    }

    override fun submit() {
        webElement.submit()
        logger.info("Submitted")
    }

    override fun getLocation(): Point {
        return webElement.location
    }

    override fun <X : Any?> getScreenshotAs(type: OutputType<X>?): X {
        return webElement.getScreenshotAs(type)
    }

    override fun findElement(by: By?): WebElement {
        val webElement = WebElementImpl(webElement.findElement(by))
        logger.info("Element with class[${webElement.getClass()}] found")
        return webElement
    }

    override fun click() {
        val webElementClass: String = this.getClass()
        webElement.click()
        logger.info("Clicked on element [$webElementClass]")
    }

    override fun getTagName(): String {
        return webElement.tagName
    }

    override fun getSize(): Dimension {
        return webElement.size
    }

    override fun getText(): String {
        return webElement.text
    }

    override fun isSelected(): Boolean {
        return webElement.isSelected
    }

    override fun isEnabled(): Boolean {
        return webElement.isEnabled
    }

    override fun sendKeys(vararg chars: CharSequence?) {
        chars.forEach { char -> webElement.sendKeys(char) }
        logger.info("Keys [${chars[0]} has been sent")
    }

    override fun getAttribute(name: String?): String {
        return webElement.getAttribute(name)
    }

    override fun getRect(): Rectangle {
        return webElement.rect
    }

    override fun getCssValue(name: String?): String {
        return webElement.getCssValue(name)
    }

    override fun findElements(by: By?): List<WebElement> {
        val listOfWebElements = webElement.findElements(by).map { WebElementImpl(it) }
        logger.info("Elements [$by] collected. Count: ${listOfWebElements.size}")
        return listOfWebElements
    }

    fun getClass(): String {
        return webElement.getAttribute("class")
    }

}