package de.clark

import de.clark.extensions.DriverManager
import org.junit.After
import org.openqa.selenium.By

class TestContext {

    val driver = DriverManager.runWebDriver()
    var email: String? = null
    var password: String? = null

    var firstName: String? = null
    var lastName: String? = null
    var birthDate: String? = null
    var street: String? = null
    var houseNumber: String? = null
    var zipCode: String? = null
    var city: String? = null
    var phoneNumber: String? = null

    var iban: String? = null

    @After
    fun afterTests(){
        println("AFTER")
//        driver.quit()
    }

}