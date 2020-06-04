package de.clark.steps

import de.clark.TestContext
import de.clark.pages.ManagerPage
import io.cucumber.java8.En

class ManagerPageSteps(private var testContext: TestContext) : En {

    val managerPage: ManagerPage by lazy {
        ManagerPage(testContext.driver)
    }

    init {
        Then("I close popup") {
            managerPage.closePopup()
        }

        And("I see my application") {
            assert(managerPage.isMyApplicationDisplayed())
        }
    }
}
