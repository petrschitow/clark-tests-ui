package de.clark.steps

import de.clark.TestContext
import de.clark.pages.OrderCompletedPage
import io.cucumber.java8.En

class OrderCompletedPageSteps(private var testContext: TestContext) : En {
    val orderCompletedPage: OrderCompletedPage by lazy {
        OrderCompletedPage(testContext.driver)
    }

    init {
        Then("I see title 'Bestellung abgeschlossen'") {
            assert(orderCompletedPage.isMainTitleDisplayed())
        }

        When("I click 'Zurück zur Übersicht' button") {
            orderCompletedPage.clickBackToOverviewButton()
        }
    }
}