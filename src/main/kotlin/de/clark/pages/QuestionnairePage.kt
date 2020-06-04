package de.clark.pages

import de.clark.constants.Endpoints.QUESTIONNAIRE
import de.clark.extensions.WebDriverSetup
import org.openqa.selenium.By

class QuestionnairePage(driver: WebDriverSetup) : BasePage(driver) {

    val url = QUESTIONNAIRE

    val questionnairePageTitle: By = By.xpath("//h1[text()[contains(.,'Pri\u00ADvat\u00ADhaft\u00ADpflicht')]]")
//    val questionnairePageTitle2: By = By.xpath("//p[text()[contains(.,'Pri\u00ADvat\u00ADhaft\u00ADpflicht Fragebogen')]]")

    val agreement: By = By.id("consent-broker")


    val angebotAnfordernButton: By = By.xpath("//*[text()[contains(.,'Angebot anfordern')]]")
    val zumAngebotButton: By = By.xpath("//*[text()[contains(.,'Zum Angebot')]]")

    val firstQuestionTitle: By = By.xpath("//h1[text()[contains(.,'Wen möchtest du versichern?')]]")
    val firstQuestionFirstAnswer: By = By.xpath("//h2[text()[contains(.,'Mich alleine')]]")

    val secondQuestionTitle: By = By.xpath("//h1[text()[contains(.,'Trifft einer der aufgeführten Fälle auf dich zu?')]]")
    val secondQuestionFirstAnswer: By = By.xpath("//h2[text()[contains(.,'Ich bin im öffentlichen Dienst beschäftigt')]]")

    val thirdQuestionTitle: By = By.xpath("//h1[text()[contains(.,'Möchtest du bei einem Schadensfall einen Teil selbst bezahlen?')]]")
    val thirdQuestionFirstAnswer: By = By.xpath("//h2[text()[contains(.,'150,-EUR')]]")

    val fourthQuestionTitle: By = By.xpath("//h1[text()[contains(.,'Hast du noch weitere Informationen oder Anmerkungen für uns?')]]")
    val fourthQuestionAnswerField: By = By.xpath("//*[@class='form-list__item__input cucumber-text-input text-field-answer']")

    val finalTitle: By = By.xpath("//h1[text()[contains(.,'Dein Angebot ist da!')]]")

    fun isMainTitleDisplayed(): Boolean {
        return webDriver.findElement(questionnairePageTitle).isDisplayed
    }

    fun clickAgreement() {
        webDriver.findElement(agreement).click()
    }

    fun isFirstQuestionDisplayed(): Boolean {
        return webDriver.findElement(firstQuestionTitle).isDisplayed
    }

    fun firstQuestionFirstAnswerClick() {
        webDriver.findElement(firstQuestionFirstAnswer).click()
    }

    fun isSecondQuestionDisplayed(): Boolean {
        return webDriver.findElement(secondQuestionTitle).isDisplayed
    }

    fun secondQuestionFirstAnswerClick() {
        webDriver.findElement(secondQuestionFirstAnswer).click()
    }

    fun isThirdQuestionDisplayed(): Boolean {
        return webDriver.findElement(thirdQuestionTitle).isDisplayed
    }

    fun thirdQuestionFirstAnswerClick() {
        webDriver.findElement(thirdQuestionFirstAnswer).click()
    }

    fun isFourthQuestionDisplayed(): Boolean {
        return webDriver.findElement(fourthQuestionTitle).isDisplayed
    }

    fun fourthQuestionAnswerTextInput(text: String) {
        webDriver.findElement(fourthQuestionAnswerField).sendKeys(text)
    }

    fun isFinalTitleDisplayed(): Boolean {
        return webDriver.findElement(finalTitle).isDisplayed
    }

    fun clickAngebotAnfordernButton() {
        webDriver.findElement(angebotAnfordernButton).click()
    }

    fun clickZumAngebotButton() {
        webDriver.findElement(zumAngebotButton).click()
    }


}