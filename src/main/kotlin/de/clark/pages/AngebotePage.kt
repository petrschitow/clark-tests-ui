package de.clark.pages

import de.clark.extensions.WebDriverSetup
import org.openqa.selenium.By

class AngebotePage(driver: WebDriverSetup) : BasePage(driver) {

    var title: By = By.xpath("//h1[text()[contains(.,'Was möchtest du absichern?')]]")
    var privathaftpflicht: By = By.xpath("//*[@title='Privathaftpflicht']")

    fun goToPrivathaftpflicht() {
        webDriver.findElement(privathaftpflicht).click()
    }

    fun titleIsDisplayed(): Boolean {
        return webDriver.findElement(title).isDisplayed
    }

}