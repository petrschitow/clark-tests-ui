package de.clark.pages

import de.clark.extensions.WebDriverSetup
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions

class ManagerPage(driver: WebDriverSetup) : BasePage(driver) {

    val closePopupButton: By = By.xpath("//button[@class='cucumber-close-modal  _button_l85hl6 ember-view']")
    val myApplication: By = By.xpath("//*[@class='_title_niboal' and contains(text(), '')]")

    fun closePopup() {
        webDriver.findElement(closePopupButton).click()
    }

    fun isMyApplicationDisplayed(): Boolean {
//        val webElement: WebElement = webDriver.findElement(myApplication)
//        Actions(webDriver).moveToElement(webElement).build().perform()
        return webDriver.findElement(myApplication).isDisplayed
    }


}