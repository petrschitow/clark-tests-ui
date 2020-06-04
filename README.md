# clark-tests-ui

### Technologies that were used in the project:
   * Kotlin (main program language)
   * Junit (test-runner)
   * Selenium (web-driver)
   * Cucumber (BDD)
   * PicoContainer (DI. Share state between steps)
   
### Running tests:
1. Install Java and Maven on your computer: <br/>
https://www.oracle.com/java/technologies/javase-downloads.html <br/>
https://maven.apache.org/install.html

2. Install ChromeDriver and add it to the PATH: <br/>
https://chromedriver.chromium.org/

3. Run tests <br />
```mvn test -Dcucumber.filter.tags="@privathaftpflicht"``` - run tests with @privathaftpflicht tag <br/>

### Test reports: 
 After test execution you can find test reports in dir /target/cucumber <br/>
 Open file ```index.html``` in browser.