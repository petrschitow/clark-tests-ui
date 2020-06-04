package de.clark.steps

import de.clark.TestContext
import de.clark.pages.InformationOverviewPage
import io.cucumber.java8.En

class InformationOverviewPageSteps(private var testContext: TestContext) : En {

    val informationOverviewPage: InformationOverviewPage by lazy {
        InformationOverviewPage(testContext.driver)
    }

    init {
        Then("I see title 'Angaben-Übersicht'") {
            assert(informationOverviewPage.isMainTitleDisplayed())
        }

        And("I click 'Jetzt verbindlich kaufen' button") {
            informationOverviewPage.clickBuyButton()
        }
    }

}