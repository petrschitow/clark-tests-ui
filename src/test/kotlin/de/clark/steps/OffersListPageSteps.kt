package de.clark.steps

import de.clark.TestContext
import de.clark.pages.OffersListPage
import io.cucumber.java8.En

class OffersListPageSteps(private var testContext: TestContext) : En {

    val offersListPage: OffersListPage by lazy {
        OffersListPage(testContext.driver)
    }

    init {

        Then("I see title 'Deine Angebote zur Privathaftpflicht'") {
            assert(offersListPage.isMainTitleDisplayed())
        }

        When("I choose primary offer"){
            offersListPage.clickOnAbschliessenPrimaryOffer()
        }

    }


}
