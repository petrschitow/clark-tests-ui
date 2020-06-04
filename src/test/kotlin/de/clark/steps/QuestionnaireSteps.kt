package de.clark.steps

import de.clark.TestContext
import de.clark.pages.QuestionnairePage
import io.cucumber.java8.En
import io.cucumber.java8.Th

class QuestionnaireSteps(private var testContext: TestContext) : En {

    val questionnairePage: QuestionnairePage by lazy {
        QuestionnairePage(testContext.driver)
    }

    init {
        Then("I see title 'Angebot zur Privathaftpflicht'") {
            assert(questionnairePage.isMainTitleDisplayed())
        }

        When("I confirm the agreement") {
            questionnairePage.clickAgreement()
        }

        And("I click 'Angebot anfordern' button") {
            questionnairePage.clickAngebotAnfordernButton()
        }

        Then("I see first question") {
            assert(questionnairePage.isFirstQuestionDisplayed())
        }

        When("I choose the first answer in the first question") {
            questionnairePage.firstQuestionFirstAnswerClick()
        }

        Then("I see second question") {
            assert(questionnairePage.isSecondQuestionDisplayed())
        }

        When("I choose the first answer in the second question") {
            questionnairePage.secondQuestionFirstAnswerClick()
        }

        Then("I see third question") {
            assert(questionnairePage.isThirdQuestionDisplayed())
        }

        When("I choose the first answer in the third question") {
            questionnairePage.thirdQuestionFirstAnswerClick()
        }

        Then("I see fourth question") {
            assert(questionnairePage.isFourthQuestionDisplayed())
        }

        When("I enter the text as an answer to the fourth question: {string}") { answer: String ->
            questionnairePage.fourthQuestionAnswerTextInput(answer)
        }

        Then("I see title 'Dein Angebot ist da!'") {
            assert(questionnairePage.isFinalTitleDisplayed())
        }

        When("I click 'Zum Angebot' button") {
            questionnairePage.clickZumAngebotButton()
        }
    }

}