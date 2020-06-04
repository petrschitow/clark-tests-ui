package de.clark.pages

import de.clark.extensions.WebDriverSetup
import org.openqa.selenium.By

class PersonalInformationPage(driver: WebDriverSetup) : BasePage(driver) {

    val mainTitle: By = By.xpath("//h2[text()[contains(.,'Persönliche Angaben')]]")

    val maleSex: By = By.xpath("//span[text()='Herr']")
    val firstName: By = By.name("firstName")
    val lastName: By = By.name("lastName")
    val birthDate: By = By.name("birthdate")
    val street: By = By.name("street")
    val houseNumber: By = By.name("houseNumber")
    val zipCode: By = By.name("zipcode")
    val city: By = By.name("city")
    val phoneNumber: By = By.name("phoneNumber")

    fun isMainTitleDisplayed(): Boolean {
        return webDriver.findElement(mainTitle).isDisplayed
    }

    fun fillForm(
            firstName: String,
            lastname: String,
            birthDate: String,
            street: String,
            houseNumber: String,
            zipCode: String,
            city: String,
            phoneNumber: String) {
        webDriver.findElement(maleSex).click()
        webDriver.findElement(this.firstName).sendKeys(firstName)
        webDriver.findElement(this.lastName).sendKeys(lastname)
        webDriver.findElement(this.birthDate).sendKeys(birthDate)
        webDriver.findElement(this.street).sendKeys(street)
        webDriver.findElement(this.houseNumber).sendKeys(houseNumber)
        webDriver.findElement(this.zipCode).sendKeys(zipCode)
        webDriver.findElement(this.city).sendKeys(city)
        webDriver.findElement(this.phoneNumber).sendKeys(phoneNumber)


    }
}