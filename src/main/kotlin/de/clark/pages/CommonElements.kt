package de.clark.pages

import de.clark.extensions.WebDriverSetup
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebElement

class CommonElements(driver: WebDriverSetup) : BasePage(driver) {

    val weiterButton: By = By.xpath("//*[text()[contains(.,'Weiter')]]")
    val acceptCheckBox: By = By.xpath("//label[@class=' custom-checkbox__label cucumber-accept-terms-checkbox ']")

    fun clickWeiterButton() {
        webDriver.findElement(weiterButton).click()
    }

    fun clickAcceptCheckBox() {
        val element: WebElement = webDriver.findElement(acceptCheckBox)
        (webDriver as JavascriptExecutor).executeScript(
                "arguments[0].scrollIntoView(true);",
                element
        )
        webDriver.findElement(acceptCheckBox).click()
    }
}