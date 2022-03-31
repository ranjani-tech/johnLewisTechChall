# johnLewisTechChall

JohnLewisTechChallenge:

** Project Scope **
Create a simple E2E test journey for the given scenario
```
      •	Navigate to https://www.johnlewis.com/ site.
      •	Search for any product to buy and progress it through to the checkout page.
      •	Provide any test details in the email field to continue securely.
      •	Choose the ‘Delivery’ option and enter test details in the mandatory fields.
      •	In the delivery options choose ‘Next or named day delivery’ and select the available date after 2 days. Click on ‘Continue to payment’.
      •	Validate the delivery date and time on the ‘Review and pay’ page.
      •	Take a screenshot of the review and pay page for confirmation.
```

```
      GIVEN Navigate to Johnlewis homepage
      WHEN  Select the product
      THEN  Checkout the product

```

**About the project**

This project is am implementation of Selenium web automation framework in a page-object oriented architecture.
The different layers and their scope are as follows:

**Layer I: Feature file (Path: [src/test/resources/com/web/jphnLewisChall])**

This layer contains feature files where a QA engineer writes simple scenarios in BDD format using Gherkin language.
Feature files increases the speed of writing new automated scenarios by reusing pre-existing scenario steps also allows non-engineering
team members to review test cases without getting into too much technical details.
 - Feature file can be custom changed to different product by updating
 ```
 And user selects the product as "$product" from "$page" 
 ```

**Layer II: Step definitions (Path: [src/test/java/com/adarga/web/StepDefinitions.java])**

This layer acts as a glue between scenario steps written in feature-file and their corresponding code execution setup.
The main objective of this layer is to process any/all test scenario inputs and call the relevant functions in page object
classes to cause test execution.
```
      StepDefinitions file split into three files:
      1. productPageStepDefinitions
      2. checkoutPageStepDefinitions
      3. validationPageStepDefinitions
```
**Layer III: Page layer(Path: [src/main/java/com/adarge/web/pages])**

This layer converts the action cues received from step definition layer to absolute commands for the base layer.
This layer has two main responsibilities,
1. Locate business/page specific web elements.
2. Execute generic commands for the base action layer using locators and input data from step-definition.
```
      This Page have split into three files:
      1. ProductPage
      2. CheckoutPage
      3. ValidationPage
```
**Layer IV: Base Action layer(Path: [src/main/java/com/adarge/web/base])**

This layer is free from business/page logic and deals with the technical mechanisms to execute framework specific commands
as required by the page layer. Usually this is the only place where platform specific actions are performed.

**Helper/Utility modules**

- Driver Provider: This class keeps a singleton driver instance to be used at framework specific operations in various test setup, initializers and page object command phases.
- Properties Provider: This class helps load project/test-run specific properties at the start of test execution so that we have a more centralized way of configuring our test environment.

**How to run:**

Option A:
1. Open the project in IntelliJ Idea
2. Right click on project > Maven > Sync project
3. Open file JohnLewisTechChallenge.feature
4. Click on "Run test" green play button on the left of the scenario
5. Incase error modify the build configuration glue = "com.adarga.web"

Option B:
1. Ensure that you have maven cli installed (`brew install maven`)
2. Go to root of project directory
3. Run `mvn clean Install test`

**This project is tested on Chrome browsers only**

**screenshot**
Screenshot taken during the after each steps.

**Refer ScreenRecording**
 [./adarga_ScreenRecording.mov](./adarga_ScreenRecording.mov)

**Report:**
Reports have auto generated and added into the Cucumber-reports folder.
To see the report click on the report open in browser.

Refer to the below path for checking cucumber report
 `adargahometest/cucumber-reports/cucumber-reports.html`
