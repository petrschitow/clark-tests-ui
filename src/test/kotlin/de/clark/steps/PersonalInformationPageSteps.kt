package de.clark.steps

import de.clark.TestContext
import de.clark.pages.PersonalInformationPage
import io.cucumber.java8.En

class PersonalInformationPageSteps(private var testContext: TestContext) : En {

    val personalInformationPage: PersonalInformationPage by lazy {
        PersonalInformationPage(testContext.driver)
    }


    init {
        Then("I see title 'Personliche Angaben'") {
            assert(personalInformationPage.isMainTitleDisplayed())
        }

        When("I fill form with test data") {
            testContext.firstName = "Peter"
            testContext.lastName = "Schitow"
            testContext.birthDate = "01.01.2000"
            testContext.street = "Main street"
            testContext.houseNumber = "4"
            testContext.zipCode = "60306"
            testContext.city = "Hannover"
            testContext.phoneNumber = "015229320777"
            personalInformationPage.fillForm(
                    testContext.firstName!!,
                    testContext.lastName!!,
                    testContext.birthDate!!,
                    testContext.street!!,
                    testContext.houseNumber!!,
                    testContext.zipCode!!,
                    testContext.city!!,
                    testContext.phoneNumber!!)
        }
    }

}