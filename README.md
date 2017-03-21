# autotests-google-calculator
Created automation tests using general stack of technologies: Java + WebDriver + JUnit + mvn

Task:
1. Open https://google.com
2. Search for "google calculator"
3. Create automation tests on:
    - Search results (few verifications that page opened successfully - 2-3 tests will be enough)
    - Calculator functionality (few test for positive/negative scenarios of main operations - 10 tests will be enough)

General stack of technologies: 
- Java + WebDriver + JUnit + mvn

Preconditions:
-	Installed IntelliJ IDEA Community Edition 2016.3.5
-	Installed apache-maven-3.3.9
-	Installed Google Chrome browser
-	Installed Java JDK 1.8
-	Downloaded chromedriver.exe (Google Chrome Driver 2.28, link: http://www.seleniumhq.org/download/ )

Instructions:
-	Open "autotests-google-calculator" project in IntelliJ IDEA
-	Set corrected path to "webdriver.chrome.driver" in "systemPropertyVariables" of pom.xml
-	Select "clean" and "test" lifecycles in Maven Projects panel and run Maven build
