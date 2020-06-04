package de.clark.steps

import de.clark.TestContext
import de.clark.pages.SignInPage
import de.clark.utils.getRandom
import io.cucumber.java8.En

class SignInPageSteps(private var testContext: TestContext) : En {

    val signInPage: SignInPage by lazy {
        SignInPage(testContext.driver)
    }

    init {
        Then("I see title 'Deinen Fortschritt sichern'") {
            assert(signInPage.isMainTitleDisplayed())
        }

        When("I put random email and password") {
            testContext.email = "${getRandom()}@clark.de"
            testContext.password = "Pp${getRandom()}!"
            signInPage.enterEmail(testContext.email!!)
            signInPage.enterPassword(testContext.password!!)
        }

        And("I push Jetzzt Registrieren Button") {
            signInPage.registerNow()
        }
    }
}