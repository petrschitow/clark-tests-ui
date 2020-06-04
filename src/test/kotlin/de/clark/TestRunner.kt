package de.clark

import io.cucumber.junit.Cucumber
import io.cucumber.junit.CucumberOptions
import org.junit.After
import org.junit.runner.RunWith

@RunWith(Cucumber::class)
@CucumberOptions(
        features = ["src/test/resources/de/clark"],
        plugin = ["pretty", "html:target/cucumber"]
)
class TestRunner {

}