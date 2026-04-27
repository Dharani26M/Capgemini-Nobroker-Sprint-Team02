 NoBroker Automation – Buy Module | Capgemini Sprint Team 02

> End-to-end test automation of the [NoBroker](https://www.nobroker.in/) real estate platform using Selenium WebDriver, Cucumber BDD, and TestNG — developed as part of the Capgemini Sprint Evaluation by Team 02.

---

Project Overview

NoBroker is one of India's leading property platforms that connects buyers and owners directly — without brokers. This project automates the **Buy Module** of the NoBroker website, covering the complete property search journey, map features, home loan eligibility, renovation services, legal services, and social media navigation.

Module : Buy Module  
Approach: Behaviour Driven Development (BDD)  

---

Test Scenarios

| # | Feature File | Scenario | Status |
|---|---|---|---|
| 1 | `Buy.feature` | Search property in Chennai → Velachery, apply 2BHK filter, view projects, contact builder | ✅ Pass |
| 2 | `Map.feature` | Search property, switch to Map view, enable Metro layer and verify metro lines | ✅ Pass |
| 3 | `HomeRenovation.feature` | Navigate to Home Renovation → Wall Panel → Charcoal Panel, verify price page | ✅ Pass |
| 4 | `HomeLoan.feature` | Apply Home Loan, enter amount/interest/tenure, check eligibility | ✅ Pass |
| 5 | `NotaryAdvocate.feature` | Navigate to Notary/Advocate, fill form from Excel data, submit | ✅ Pass |
| 6 | `Contact.feature` | Click Facebook icon from menu and verify redirect | ❌ Defect Found |

Defect (Scenario 6): The Facebook icon in the NoBroker menu does not redirect to the Facebook page. The automation correctly identified this as an application defect — the test assertion `title.contains("Facebook.in")` fails because no navigation occurs.

---

Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── sprint_pages/           # Page Object Model (POM) classes
│   │       ├── Buy.java
│   │       ├── DashboardPage.java
│   │       ├── MapPage.java
│   │       ├── HomeLoanPage.java
│   │       ├── HomeRenovationPage.java
│   │       ├── NotaryAdvocatePage.java
│   │       └── ContactPage.java
│   └── resources/
│       ├── Common.properties       # URL, browser, phone config
│       └── Notary.xlsx             # Excel test data for Notary scenario
│
└── test/
    ├── java/
    │   ├── sprint_utils/           # Shared utility classes
    │   │   ├── AllUtilityDemo.java     # Waits, scroll, windows, ExtentReports
    │   │   ├── BaseClass.java          # ThreadLocal WebDriver holder
    │   │   ├── Pages.java              # Central PageFactory initializer
    │   │   ├── ExcelUtilities.java     # Apache POI Excel reader
    │   │   ├── HandleCookies.java      # Cookie-based session management
    │   │   └── ReaderUtilities.java    # Properties file reader
    │   ├── stepDefinition/         # Cucumber step definitions + hooks
    │   │   ├── BuyTest.java
    │   │   ├── MapTest.java
    │   │   ├── HomeLoanTest.java
    │   │   ├── HomeRenovationTest.java
    │   │   ├── NotaryAdvocateTest.java
    │   │   ├── ContactTest.java
    │   │   ├── Hooks.java              # @Before / @After setup and teardown
    │   │   └── StepEventListener.java  # Real-time step logging to ExtentReports
    │   └── testRunner/
    │       └── RunnerIO.java           # Cucumber + TestNG runner (parallel)
    └── featureFile/                # Gherkin BDD feature files
        ├── Buy.feature
        ├── Map.feature
        ├── HomeLoan.feature
        ├── HomeRenovation.feature
        ├── NotaryAdvocate.feature
        └── Contact.feature
```

---

Framework Architecture

```
Feature File (Gherkin)
        ↓
Step Definition (Java + Cucumber annotations)
        ↓
Page Object Model (sprint_pages)
        ↓
AllUtilityDemo (Selenium helpers + ExtentReports)
        ↓
Browser (Chrome / Edge / Firefox)
```

Hooks.java runs before and after every scenario:
- `@Before` → reads config from `Common.properties`, launches the browser, and initializes all page objects
- `@After` → captures a screenshot on failure, quits the browser, and flushes the ExtentReport

StepEventListener.java listens to every step start/finish and logs ✅ PASSED / ❌ FAILED / ⏭️ SKIPPED to the ExtentReport in real time.

---

Key Technical Highlights

Multi-Window Handling (Buy.java)
The `setProperty()` method tracks three simultaneous browser windows — parent, child1, and child2 — and switches between them in precise sequence using WebDriverWait loops.

Data-Driven Testing (NotaryAdvocateTest.java + ExcelUtilities.java)
Test data (name, phone, email) for the Notary scenario is read from `Notary.xlsx` using Apache POI, keeping test data fully separate from test code.

Inline DataTable in Gherkin (HomeLoan.feature)
Loan amount, interest rate, and tenure are passed directly as Cucumber DataTables inside the feature file, demonstrating parameterized test data in BDD.

Parallel Execution (RunnerIO.java)
All 6 scenarios run simultaneously using TestNG's `@DataProvider(parallel=true)`. Thread safety is maintained using `ThreadLocal<WebDriver>` in `BaseClass` and `ThreadLocal<Pages>` in `Pages.java`.

Extent Reports with Step-Level Logging
Every scenario and each of its steps appears in the generated HTML report at `Reports/Buy-Module-Report.html`, with screenshots automatically attached to failed steps.

---

 Configuration

Edit `src/main/resources/Common.properties` before running:

```properties
Url     = https://www.nobroker.in/
PhoneNo = <your_registered_phone_number>
browser = chrome   # chrome | edge | firefox
```

---

 How to Run

Prerequisites
- Java 11 or above
- Maven
- Chrome / Edge / Firefox browser installed
- Matching WebDriver (ChromeDriver, etc.) on PATH

Steps

```bash
# 1. Clone the repository
git clone https://github.com/Dharani26M/Capgemini-Nobroker-Sprint-Team02.git

# 2. Navigate into the project
cd Capgemini-Nobroker-Sprint-Team02

# 3. Update Common.properties with your phone number and preferred browser
```

4. Run the tests via RunnerIO

- Open the project in **Eclipse** or **IntelliJ IDEA**
- Navigate to `src/test/java/testRunner/RunnerIO.java`
- Right-click on `RunnerIO.java` → **Run As → TestNG Test**
- All 6 scenarios will execute in parallel across separate browser threads

**5. View the report**

Once execution completes, open the generated HTML report:
```
Reports/Buy-Module-Report.html
```

---

Tech Stack

| Tool | Purpose |
|---|---|
| Java | Primary programming language |
| Selenium WebDriver | Browser automation |
| Cucumber | BDD framework (Gherkin feature files) |
| TestNG | Test execution and parallel running |
| Apache POI | Reading Excel test data |
| ExtentReports | HTML test reporting with screenshots |
| Maven | Build and dependency management |
| Git + GitHub | Version control and collaboration |

---

Test Report

After each run, an HTML report is generated at:

```
Reports/Buy-Module-Report.html
```

The report includes:
- Each scenario with pass/fail status
- Step-by-step breakdown (Given / When / Then)
- Screenshots automatically attached to failed steps
- System info: Application name, Team name

---

 Notes

- The Notary scenario uses **Bangalore** as the city selection — update `NotaryAdvocatePage.java` if a different city is needed.
- The Home Loan scenario verifies up to the **Check Eligibility** step. The PAN and Continue steps are present in the code but commented out (de-scoped from this sprint).
- Scenario 6 (Facebook redirect) is a **confirmed application defect** — the automation test correctly fails and captures the failure in the report.
