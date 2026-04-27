# NoBroker – Careers, Services & Property Module
### Capgemini Sprint | Selenium + Cucumber BDD Automation Framework

---

## Table of Contents

1. [Project Overview](#project-overview)
2. [Tech Stack & Dependencies](#tech-stack--dependencies)
3. [Project Structure](#project-structure)
4. [Architecture & Design Patterns](#architecture--design-patterns)
5. [Test Scenarios](#test-scenarios)
6. [Configuration & Setup](#configuration--setup)
7. [How to Run Tests](#how-to-run-tests)
8. [Reporting](#reporting)
9. [Utilities Reference](#utilities-reference)

---

## Project Overview

This is a **Behavior-Driven Development (BDD)** test automation framework built for the **Careers, Home Services, Loan Eligibility, PG Search, and Property Posting modules** of [NoBroker.in](https://www.nobroker.in/). It was developed as part of a Capgemini Sprint engagement.

The framework automates end-to-end functional flows across five key feature areas of the NoBroker platform:

- Careers page navigation and LinkedIn redirect
- Home Cleaning service booking flow
- Loan Eligibility calculation
- PG/Hostel search with locality filters (data-driven)
- Post Your Property listing with city selection and preview

The suite supports **data-driven testing via Scenario Outline** and produces rich HTML reports via both Cucumber and ExtentReports.

---

## Tech Stack & Dependencies

| Technology | Purpose | Version |
|---|---|---|
| Java | Primary language | JDK 11+ |
| Maven | Build & dependency management | — |
| Selenium WebDriver | Browser automation | 4.38.0 |
| Cucumber (BDD) | Feature/step definition framework | 7.28.0 |
| TestNG | Test runner and parallel execution | 7.10.2 |
| Apache POI | Excel data reading (Config.xlsx) | 5.4.1 |
| ExtentReports | Rich HTML reporting | 5.1.2 |
| PicoContainer | Dependency injection between steps | 7.14.0 |

All dependencies are managed through `pom.xml`.

---

## Project Structure

```
Capgemini-Nobroker-Sprint-TeamXX-CareersServicesProperty-Module/
│
├── pom.xml                              # Maven build configuration
├── testng.xml                           # TestNG suite runner (parallel config)
│
├── src/
│   ├── main/
│   │   ├── java/com/nobroker/sprint/
│   │   │   ├── pages/                   # Page Object Model (POM) classes
│   │   │   │   ├── DashboardPage.java       # Home/Dashboard interactions & login
│   │   │   │   ├── CareersPage.java         # Careers page elements & LinkedIn redirect
│   │   │   │   ├── HomeCleaningPage.java    # Home Cleaning booking page
│   │   │   │   ├── LoanEligibilityPage.java # Loan Eligibility form & result page
│   │   │   │   ├── PGSearchPage.java        # PG/Hostel search & filter page
│   │   │   │   └── PostPropertyPage.java    # Post Your Property listing page
│   │   │   │
│   │   │   └── utils/                   # Reusable utility classes
│   │   │       ├── AllUtilities.java        # Core utilities (waits, scrolls, screenshots, ExtentReports)
│   │   │       ├── BaseClass.java           # ThreadLocal WebDriver holder
│   │   │       ├── Pages.java               # ThreadLocal Page object registry
│   │   │       ├── ExcelUtilities.java      # Apache POI Excel data reader
│   │   │       └── ReaderUtilities.java     # Properties file reader
│   │   │
│   │   └── resources/
│   │       └── Common.properties            # Fallback config (URL, browser, phone)
│   │
│   └── test/
│       ├── java/com/nobroker/sprint/
│       │   ├── features/                # Gherkin feature files (BDD scenarios)
│       │   │   ├── Careers.feature
│       │   │   ├── HomeCleaning.feature
│       │   │   ├── LoanEligibility.feature
│       │   │   ├── PGSearch.feature
│       │   │   └── PostProperty.feature
│       │   │
│       │   ├── runner/
│       │   │   └── RunnerIO.java            # Cucumber + TestNG runner (parallel)
│       │   │
│       │   └── stepdefinitions/         # Step definition implementations
│       │       ├── Hooks.java               # @Before / @After lifecycle hooks
│       │       ├── CareersSteps.java
│       │       ├── HomeCleaningSteps.java
│       │       ├── LoanEligibilitySteps.java
│       │       ├── PGSearchSteps.java
│       │       ├── PostPropertySteps.java
│       │       └── StepEventListener.java   # Custom Cucumber event listener
│       │
│       └── resources/
│           └── Readers/
│               ├── Common.properties        # Active test config (URL, browser, phone)
│               └── Config.xlsx              # Excel-based test data
│
├── Reports/
│   ├── CareersServices-Report.html      # Cucumber HTML report
│   └── extent.html                      # ExtentReports HTML report
│
└── Screenshot/                          # Auto-captured failure screenshots
```

---

## Architecture & Design Patterns

### Page Object Model (POM)
Every page in the application is represented as a dedicated Java class under `pages/`. WebElements are declared with `@FindBy` annotations and initialised via Selenium's `PageFactory`. Business logic (clicking, filling forms) lives inside the page class, keeping step definitions clean.

### ThreadLocal for Parallel Safety
Both `BaseClass` and `Pages` use `ThreadLocal<>` containers to isolate the WebDriver instance and page objects per thread, enabling safe parallel execution without cross-thread interference.

### Dependency Injection via PicoContainer
`BaseClass` is injected into `Hooks` and step definition classes by Cucumber-PicoContainer, ensuring all classes in the same scenario share the same driver instance without static state.

### Utility Layer (`AllUtilities`)
A single shared utility class provides wrappers for:
- Explicit/implicit waits
- JavaScript execution and scrolling
- Browser window and navigation control
- Actions API (click, sendKeys, dropdown navigation)
- Date/random generators
- ExtentReports logging (pass / fail / info / screenshot)

---

## Test Scenarios

### Feature 1 – Careers Page Navigation `@Careers`
**File:** `Careers.feature`

Validates that the Careers page is accessible via the navigation menu and that the "See all opportunities" button correctly redirects users to the LinkedIn page.

```gherkin
Scenario: Navigate to Careers page and view all opportunities
  When User clicks on menu button
  And User clicks on Careers option from menu
  Then Careers page should be displayed
  When User clicks on See all opportunities button
  Then User should be redirected to LinkedIn page
```

### Feature 2 – Home Cleaning Booking `@HomeCleaning`
**File:** `HomeCleaning.feature`

Validates the end-to-end home cleaning service booking flow including service type, bathroom count, and frequency selection.

```gherkin
Scenario: User books a home cleaning service successfully
  When User clicks on Home tile
  And User selects Home Cleaning option
  And User selects Weekly Cleaning service
  And User selects number of bathrooms
  And User selects frequency as Once in 2 weeks
  And User clicks on Proceed button
  Then Bathroom Clean Page should be displayed
```

### Feature 3 – Loan Eligibility Validation `@LoanEligibility`
**File:** `LoanEligibility.feature`

Validates that a user can input loan details and receive a calculated loan eligibility result successfully.

```gherkin
Scenario: Validate loan eligibility using Excel data
  When User clicks on Loan Eligibility option
  And User enters the details
  Then Loan eligibility should be calculated successfully
```

### Feature 4 – PG Search with Filters `@PGSearch`
**File:** `PGSearch.feature`

Data-driven scenario (Scenario Outline) that validates PG/Hostel search with locality filter across multiple data sets.

| locality | mobileno |
|---|---|
| porur | 9486778413 |

```gherkin
Scenario Outline: Search for PG with filters using multiple data sets
  When User clicks on the location field and enters location
  And User selects the locality "<locality>"
  And User clicks on PG Hostel tab
  And User clicks the Search button
  And User clicks the filters
  Then The shortlist page should be displayed

  Examples:
  | locality | mobileno   |
  | porur    | 9486778413 |
```

### Feature 5 – Post Your Property `@PostProperty`
**File:** `PostProperty.feature`

Validates the full property posting flow including city selection, posting initiation, and preview navigation.

```gherkin
Scenario: User posts a property with valid details
  When User clicks on Post Your Property button
  And User Click PostNow
  And User click SelectCity
  And User click StartPosting
  And User click the preview
  Then User should be navigated to the preview page
```

---

## Configuration & Setup

### Prerequisites

- Java JDK 11 or higher
- Maven 3.6+
- Google Chrome, Microsoft Edge, or Firefox installed
- Matching WebDriver (ChromeDriver, EdgeDriver, or GeckoDriver) — or rely on Selenium Manager (bundled with Selenium 4)
- Eclipse IDE (recommended, `.classpath` and `.project` are included)

### Clone & Import

```bash
git clone <repository-url>
cd Capgemini-Nobroker-Sprint-TeamXX-CareersServicesProperty-Module
```

Import as an existing Maven project in Eclipse: `File → Import → Existing Maven Projects`.

### Configure Test Settings

Edit `src/test/resources/Readers/Common.properties`:

```properties
Url       = https://www.nobroker.in/
PhoneNo   = <your-registered-mobile-number>
browser   = Chrome      # Options: Chrome | Edge | Firefox
```

### Test Data (Excel)

Additional test data is maintained in `src/test/resources/Readers/Config.xlsx`. Use `ExcelUtilities.getExcelData(sheetName, row, col)` to read values in step definitions.

---

## How to Run Tests

### Run via RunnerIO.java

All tests are executed through the `RunnerIO.java` runner file located at:

```
src/test/java/com/nobroker/sprint/runner/RunnerIO.java
```

Right-click on `RunnerIO.java` in Eclipse and select **Run As → TestNG Test** to execute the full test suite.

### Run specific tag

To run only scenarios with a specific tag, update the tags option in `RunnerIO.java`:

```java
tags = "@PGSearch"
```

Available tags: `@Careers`, `@HomeCleaning`, `@LoanEligibility`, `@PGSearch`, `@PostProperty`

---

## Reporting

After each test run, two reports are generated:

### Cucumber HTML Report
**Location:** `Reports/CareersServices-Report.html`

Standard Cucumber HTML report with scenario-level pass/fail status, step details, and error messages.

### ExtentReports Spark Report
**Location:** `Reports/extent.html`

Rich interactive report with:
- Scenario-level test nodes
- Step-level child nodes (via `StepEventListener`)
- Pass / Fail / Info status per step
- Embedded failure screenshots (saved to `Screenshot/`)
- System info (Application: NoBroker)

### TestNG Native Reports
**Location:** `test-output/`

Standard TestNG HTML and XML output including suite-level results and failed test rerun XML.

### Failure Screenshots
All failed scenario screenshots are captured automatically in the `@After` hook and embedded in the ExtentReports report. Screenshots are stored at:

```
Screenshot/<ScenarioName>_<timestamp>.png
```

---

## Utilities Reference

### `AllUtilities`
The central utility class. Key methods:

| Method | Description |
|---|---|
| `initializeDriver(driver)` | Binds driver, wait, and actions to the current thread |
| `WaitForVisibiltyOfElement(sec, element)` | Explicit visibility wait |
| `WaitForToBeClickableOfElement(sec, element)` | Explicit clickability wait |
| `waitForRefreshedVisibility(locator, timeout)` | Wait with DOM refresh |
| `scrollToElement(element)` | JS scroll to center |
| `jsClick(element)` | JavaScript click fallback |
| `navigateDownDropdown(element, count, ms)` | Arrow-key dropdown selection |
| `captureFailure(driver, testName)` | Screenshot + ExtentReports failure log |
| `getPropertyKeyValue(key)` | Read value from `Common.properties` |
| `getFutureDate(days)` | Generate a future date string |
| `getReport()` | Get/create singleton ExtentReports instance |
| `createTest(scenarioName)` | Create parent scenario node in report |
| `createStepNode(keyword, stepText)` | Create child step node in report |
| `pass(msg)` / `fail(msg)` / `info(msg)` | Log result to active step/scenario node |

### `ExcelUtilities`
| Method | Description |
|---|---|
| `getExcelData(sheet, row, col)` | Read a cell value from `Config.xlsx` |

### `ReaderUtilities`
| Method | Description |
|---|---|
| `getPropertyKeyValue(key)` | Read a value from `Common.properties` |

---

> This framework follows the Page Object Model pattern with BDD principles. All test scenarios are written in Gherkin and are independent, self-contained, and parallelisable.
