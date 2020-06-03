package de.clark.extensions

import org.openqa.selenium.chrome.ChromeOptions

object DriverManager {

    fun setChromeProperties() {
        try {
            System.setProperty("webdriver.chrome.driver", System.getenv("chromedriver"))
        } catch (e: NullPointerException) {
            print("Path to chromedriver wasn't setup %s".format((e)))
        }
    }

    fun setChromeOptions(): ChromeOptions{
        return ChromeOptions().addArguments(
                "--window-size=1920,1080",
                "--no-sandbox",
                "--disable-dev-shm-usage"
        )
    }
}