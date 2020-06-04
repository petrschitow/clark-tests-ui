package de.clark.steps

import de.clark.TestContext
import de.clark.pages.AngebotePage
import io.cucumber.java8.En

class AngebotePageSteps(private var testContext: TestContext) : En {

    val angebotePage: AngebotePage by lazy {
        AngebotePage(testContext.driver)
    }

    init {

        Then("I see main title on the Angebote page") {
            assert(angebotePage.titleIsDisplayed())
        }

        When("I click to 1-click-kauf 'Privathaftpflicht'") {
            angebotePage.goToPrivathaftpflicht()
        }
    }
}