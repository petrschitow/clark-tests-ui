package de.clark.pages

import de.clark.extensions.WebDriverSetup
import org.openqa.selenium.By

class SignInPage(driver: WebDriverSetup) : BasePage(driver) {

    val pageTitle: By = By.xpath("//h1[text()[contains(.,'Deinen Fortschritt sichern')]]")
    val emailLocator: By = By.xpath("//*[@type='email']")
    val passwordLocator: By = By.xpath("//*[@type='password']")
    val jetzztRegistrierenButton: By = By.xpath("//*[text()[contains(.,'Jetzt registrieren')]]")

    fun isMainTitleDisplayed(): Boolean {
        return webDriver.findElement(pageTitle).isDisplayed
    }

    fun enterEmail(email: String) {
        webDriver.findElement(emailLocator).sendKeys(email)
    }

    fun enterPassword(password: String) {
        webDriver.findElement(passwordLocator).sendKeys(password)
    }

    fun registerNow() {
        webDriver.findElement(jetzztRegistrierenButton).click()
    }
}