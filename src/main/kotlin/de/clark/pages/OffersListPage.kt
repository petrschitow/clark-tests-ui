package de.clark.pages

import de.clark.extensions.WebDriverSetup
import org.openqa.selenium.By

class OffersListPage(driver: WebDriverSetup) : BasePage(driver) {

    val offersListMainTitle: By = By.xpath("//h1[text()[contains(.,'Deine Angebote zur')]]")
    val primaryButton:By = By.xpath("//*[@data-test-button-appearance='primary']")

    fun isMainTitleDisplayed(): Boolean {
        return webDriver.findElement(offersListMainTitle).isDisplayed
    }

    fun clickOnAbschliessenPrimaryOffer(){
        webDriver.findElement(primaryButton).click()
    }

}