package de.clark.pages

import de.clark.extensions.WebDriverSetup
import org.openqa.selenium.By

class InformationOverviewPage(driver: WebDriverSetup) : BasePage(driver) {

    val pageTitle: By = By.xpath("//h1[text()[contains(.,'Angaben-Übersicht')]]")
    val buyNowButton: By = By.xpath("//*[text()[contains(.,'Jetzt verbindlich kaufen')]]")

    fun isMainTitleDisplayed(): Boolean {
        return webDriver.findElement(pageTitle).isDisplayed
    }

    fun clickBuyButton() {
        webDriver.findElement(buyNowButton).click()
    }
}