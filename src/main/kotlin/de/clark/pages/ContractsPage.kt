package de.clark.pages

import de.clark.constants.Endpoints.CONTRACTS_PAGE_URL
import de.clark.extensions.WebDriverSetup
import org.openqa.selenium.By

class ContractsPage(driver: WebDriverSetup) : BasePage(driver) {

    var url = CONTRACTS_PAGE_URL

    var angebote: By = By.xpath("//*[@class='_item_1yljn7']/a[text()[contains(.,'Angebote')]]")


    fun goToAngebote() {
        webDriver.findElement(angebote).click()
    }

}