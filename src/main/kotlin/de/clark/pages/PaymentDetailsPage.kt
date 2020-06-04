package de.clark.pages

import de.clark.extensions.WebDriverSetup
import org.openqa.selenium.By

class PaymentDetailsPage(driver: WebDriverSetup) : BasePage(driver) {
    val mainTitle: By = By.xpath("//h1[text()[contains(.,'Zahlungsdaten')]]")
    val iban: By = By.xpath("//*[@class=' iban-offer-form__form__text capybara-offer-iban-input cucumber-offer-iban-input']")
    val orderTariffButton: By = By.xpath("//*[text()[contains(.,'Tarif bestellen')]]")


    fun isMainTitleDisplayed(): Boolean {
        return webDriver.findElement(mainTitle).isDisplayed
    }

    fun inputIban(iban: String) {
        webDriver.findElement(this.iban).sendKeys(iban)
    }

    fun clickOrderTariffButton() {
        webDriver.findElement(orderTariffButton).click()
    }


}