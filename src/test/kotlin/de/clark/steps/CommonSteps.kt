package de.clark.steps

import de.clark.TestContext
import de.clark.pages.CommonElements
import io.cucumber.java8.En

class CommonSteps(private var testContext: TestContext) : En {

    val commonElements: CommonElements by lazy {
        CommonElements(testContext.driver)
    }

    init {
        And("I click 'Weiter' button") {
            commonElements.clickWeiterButton()
        }

        And("I click confirmation check-box") {
            commonElements.clickAcceptCheckBox()
        }

    }


}