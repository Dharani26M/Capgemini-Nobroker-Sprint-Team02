# NoBroker – Menu & Profile Module
### Capgemini Sprint | Team 02 | Selenium + Cucumber BDD Automation Framework

---

## Table of Contents

1. [Project Overview](#project-overview)
2. [Tech Stack & Dependencies](#tech-stack--dependencies)
3. [Project Structure](#project-structure)
4. [Architecture & Design Patterns](#architecture--design-patterns)
5. [Test Scenarios](#test-scenarios)
6. [Configuration & Setup](#configuration--setup)
7. [How to Run Tests](#how-to-run-tests)
8. [Cookie-Based Session Management](#cookie-based-session-management)
9. [Reporting](#reporting)
10. [Utilities Reference](#utilities-reference)
11. [Team & Credits](#team--credits)

---

## Project Overview

This is a **Behavior-Driven Development (BDD)** test automation framework built for the **Menu and Profile module** of [NoBroker.in](https://www.nobroker.in/). It was developed as part of a Capgemini Sprint engagement by Team 02.

The framework automates end-to-end functional flows across six key feature areas of the NoBroker platform:

- User Profile management (positive and negative scenarios)
- Post Your Property flow
- Rent Receipt generation and PDF download
- Refer & Earn referral submission
- Paintings & Cleaning home services navigation
- Rewards and VIP Membership (New Icon) flow

The suite supports **parallel test execution** and produces rich HTML reports via both Cucumber and ExtentReports.

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
Capgemini-Nobroker-Sprint-Team02-MenuAndProfile-Module/
│
├── pom.xml                              # Maven build configuration
├── testng.xml                           # TestNG suite runner (parallel config)
├── nobroker.data                        # Serialized session cookies (auto-generated)
│
├── src/
│   ├── main/
│   │   ├── java/com/nobroker/sprint/
│   │   │   ├── pages/                   # Page Object Model (POM) classes
│   │   │   │   ├── DashboardPage.java       # Home/Dashboard interactions & login
│   │   │   │   ├── ProfilePage.java         # Profile update page elements
│   │   │   │   ├── PropertyPremium.java     # Post Your Property page
│   │   │   │   ├── RentReceiptPage.java     # Rent Receipt form
│   │   │   │   ├── ReferAndEarnPage.java    # Refer & Earn modal/form
│   │   │   │   ├── NewIconPage.java         # Rewards / VIP Membership page
│   │   │   │   ├── PaintingsAndCleaningPage.java  # Home Services landing page
│   │   │   │   └── HomeInteriorsPage.java   # Home Interiors sub-page
│   │   │   │
│   │   │   └── utils/                   # Reusable utility classes
│   │   │       ├── AllUtilities.java        # Core utilities (waits, scrolls, screenshots, ExtentReports)
│   │   │       ├── BaseClass.java           # ThreadLocal WebDriver holder
│   │   │       ├── Pages.java               # ThreadLocal Page object registry
│   │   │       ├── HandleCookies.java       # Cookie save/load for session reuse
│   │   │       ├── ExcelUtilities.java      # Apache POI Excel data reader
│   │   │       └── ReaderUtilities.java     # Properties file reader
│   │   │
│   │   └── resources/
│   │       └── Common.properties            # Fallback config (URL, browser, phone)
│   │
│   └── test/
│       ├── java/com/nobroker/sprint/
│       │   ├── features/                # Gherkin feature files (BDD scenarios)
│       │   │   ├── Profile.feature
│       │   │   ├── NegativeProfile.feature
│       │   │   ├── PostProperty.feature
│       │   │   ├── RentReceipts.feature
│       │   │   ├── ReferAndEarn.feature
│       │   │   ├── PaintingsAndCleaning.feature
│       │   │   └── NewIcon.feature
│       │   │
│       │   ├── runner/
│       │   │   └── RunnerIO.java            # Cucumber + TestNG runner (parallel)
│       │   │
│       │   └── stepdefinitions/         # Step definition implementations
│       │       ├── Hooks.java               # @Before / @After lifecycle hooks
│       │       ├── PositiveProfile.java
│       │       ├── NegativeProfile.java
│       │       ├── PostProperty.java
│       │       ├── RentReceipts.java
│       │       ├── ReferAndEarn.java
│       │       ├── PaintingsAndCleanings.java
│       │       ├── NewIcon.java
│       │       └── StepEventListener.java   # Custom Cucumber event listener
│       │
│       └── resources/
│           └── Readers/
│               ├── Common.properties        # Active test config (URL, browser, phone)
│               └── Config.xlsx              # Excel-based test data
│
├── Reports/
│   ├── Menu_Profile-Report.html        # Cucumber HTML report
│   └── extent.html                     # ExtentReports HTML report
│
└── Screenshot/                         # Auto-captured failure screenshots
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

### Feature 1 – Profile (Positive) `@Profile @Positive`
**File:** `Profile.feature`

Validates that a profile name update persists after a page refresh.

```gherkin
Scenario: Profile Name Persistence and Refresh Validation
  When the user updates profile name to "Dharani Raj"
  And the user refreshes the current page
  Then the profile name should be displayed as "Dharani Raj"
```

### Feature 2 – Negative Profile `@Profile @Negative`
**File:** `NegativeProfile.feature`

Validates that an invalid profile name triggers an error message and changes are not saved.

```gherkin
Scenario: Update user profile name with invalid format
  When the user updates the profile name
  Then an error message should be displayed indicating an invalid name format
  And the profile changes should not be saved
```

### Feature 3 – Post Your Property `@Property`
**File:** `PostProperty.feature`

Navigates to the Post Your Property section via the main menu and validates property listing options appear after toggling property status.

```gherkin
Scenario: Navigate to Post Your Property section
  When the user clicks on Post Your Property from the menu
  And the user toggles the property status
  Then the user should see property listing options
```

### Feature 4 – Rent Receipts `@RentReceipt`
**File:** `RentReceipts.feature`

Data-driven scenario (Scenario Outline) that fills the rent receipt form with two sets of tenant/owner data and validates that the generated receipt redirects to a PDF URL.

| TenantName | OwnerName | RentAmount | PAN |
|---|---|---|---|
| Dha | Raj | 15000 | ABCDE1234F |
| Suresh | Kumar | 22000 | WXYZP9876Q |

```gherkin
Scenario Outline: Generate and download a Rent Receipt
  When the user fills the rent receipt form with "<TenantName>", "<OwnerName>", ...
  And the user clicks on Generate Receipt
  Then the page should navigate to a URL containing ".pdf"
```

### Feature 5 – Refer & Earn `@Referral`
**File:** `ReferAndEarn.feature`

Tests the owner referral flow using a Gherkin data table. Fills city, phone, name, property type, and description fields and submits.

```gherkin
Scenario: Refer an Owner and Earn
  When the user navigates to the Refer and Earn section
  And the user enters owner details for referral:
    | City    | Phone      | Name      | PropType | Description        |
    | Chennai | 9123456789 | Raj Kumar | Rent     | Interested in Rent |
```

### Feature 6 – Paintings & Cleaning `@Services`
**File:** `PaintingsAndCleaning.feature`

Navigates to the Painting and Cleaning home services module, selects Bangalore, picks Interior and Renovation → Home Interiors, and validates the Share button is visible.

```gherkin
Scenario: Navigate to Painting and Cleaning Home Interiors
  When the user navigates to the Painting and Cleaning section
  And the user selects the city "Bangalore" for cleaning services
  And the user selects Interior and Renovation
  And the user schedules a visit for Home Interiors
  Then the share button should be visible on the interiors page
```

### Feature 7 – New Icon / Rewards `@Navigation @Rewards @Membership`
**File:** `NewIcon.feature`

Clicks the "New" icon in the header, validates redirection to the NoBroker Rewards page, then clicks Buy VIP and verifies the URL contains "checkout".

```gherkin
Scenario: End-to-End validation of Rewards and VIP Membership flow
  When the user clicks on the "New" icon in the header
  Then the page title should contain "Rewards"
  When the user clicks on the Buy VIP button
  Then the URL should contain "checkout"
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
cd Capgemini-Nobroker-Sprint-Team02-MenuAndProfile-Module
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

### Run all tests via Maven

```bash
mvn test
```

### Run via TestNG XML directly

```bash
mvn test -DsuiteXmlFile=testng.xml
```

### Parallel execution

The `testng.xml` is pre-configured for parallel method execution with **2 threads**:

```xml
<suite thread-count="2" parallel="methods" name="NoBroker-MenuAndProfile-Suite">
```

Increase `thread-count` to run more scenarios concurrently.

### Run specific tag

To run only scenarios tagged `@RentReceipt`, add the tags option in `RunnerIO.java`:

```java
tags = "@RentReceipt"
```

---

## Cookie-Based Session Management

NoBroker login requires OTP verification. To avoid entering OTP before every test run, the framework implements a cookie persistence strategy:

1. On the **first run**, if no valid session is detected, the user has **30 seconds** to enter the OTP manually.
2. After successful login, cookies are serialized to `nobroker.data` in the project root.
3. On **subsequent runs**, cookies are loaded from `nobroker.data` and injected before navigating, restoring the session automatically.
4. If the session is invalid or expired, the framework falls back to manual OTP again and re-saves fresh cookies.

This is handled transparently in `Hooks.java` — no action is needed from the tester beyond the first-time OTP entry.

> **Note:** `nobroker.data` contains session cookies. Do not commit this file to version control. Add it to `.gitignore`.

---

## Reporting

After each test run, two reports are generated:

### Cucumber HTML Report
**Location:** `Reports/Menu_Profile-Report.html`

Standard Cucumber HTML report with scenario-level pass/fail status, step details, and error messages.

### ExtentReports Spark Report
**Location:** `Reports/extent.html`

Rich interactive report with:
- Scenario-level test nodes
- Step-level child nodes (via `StepEventListener`)
- Pass / Fail / Info status per step
- Embedded failure screenshots (saved to `Screenshot/`)
- System info (Application: NoBroker, Team: Capgemini Sprint Team 02)

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

### `HandleCookies`
| Method | Description |
|---|---|
| `loadCookies(driver, filePath)` | Deserialize and inject cookies; returns `true` if successful |
| `saveCookies(driver, filePath)` | Serialize current cookies to file |

### `ExcelUtilities`
| Method | Description |
|---|---|
| `getExcelData(sheet, row, col)` | Read a cell value from `Config.xlsx` |

### `ReaderUtilities`
| Method | Description |
|---|---|
| `getPropertyKeyValue(key)` | Read a value from `Common.properties` |

---

## Team & Credits

**Project:** Capgemini × NoBroker Sprint Automation  
**Module:** Menu & Profile  
**Team:** Sprint Team 02  
**Organisation:** Capgemini  
**Application Under Test:** [https://www.nobroker.in](https://www.nobroker.in)  

---

> This framework follows the Page Object Model pattern with BDD principles. All test scenarios are written in Gherkin and are independent, self-contained, and parallelisable.
