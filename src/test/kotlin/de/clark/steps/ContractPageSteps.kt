package de.clark.steps

import de.clark.TestContext
import de.clark.pages.ContractsPage
import io.cucumber.java8.En

class ContractPageSteps(private var testContext: TestContext) : En {

    val contractsPage: ContractsPage by lazy {
        ContractsPage(testContext.driver)
    }

    init {

        Given("I open 'Vertage' page") {
            contractsPage.openPage(contractsPage.url)
            contractsPage.waitPageIsLoaded()
        }

        When("I click 'Angebote' link") {
            contractsPage.goToAngebote()
        }

    }
}