package de.clark.steps

import de.clark.TestContext
import de.clark.pages.PaymentDetailsPage
import io.cucumber.java8.En

class PaymentDetailsPageSteps(private var testContext: TestContext) : En {
    val paymentDetaislPage: PaymentDetailsPage by lazy {
        PaymentDetailsPage(testContext.driver)
    }


    init {
        Then("I see main title 'Zahlungsdaten'") {
            assert(paymentDetaislPage.isMainTitleDisplayed())
        }

        When("I put IBAN number = {string}") { iban: String ->
            testContext.iban = iban
            paymentDetaislPage.inputIban(iban)
        }

        And("I click button 'Tarif bestellen'") {
            paymentDetaislPage.clickOrderTariffButton()
        }
    }

}