package de.clark.pages

import de.clark.extensions.WebDriverSetup
import org.openqa.selenium.By

class OrderCompletedPage(driver: WebDriverSetup) : BasePage(driver)  {

    val mainTitle: By = By.xpath("//h1[text()[contains(.,'Bestellung abgeschlossen')]]")
    val backToOverviewButton: By = By.xpath("//*[text()[contains(.,'Zurück zur Übersicht')]]")

    fun isMainTitleDisplayed(): Boolean {
        return webDriver.findElement(mainTitle).isDisplayed
    }

    fun clickBackToOverviewButton(){
        webDriver.findElement(backToOverviewButton).click()
    }
}