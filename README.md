# NoBroker Sprint Automation — Team 02

> **End-to-end test automation suite for [NoBroker.in](https://www.nobroker.in/)**  
> Built with Selenium · Cucumber BDD · TestNG · ExtentReports · Apache POI


## Table of Contents

- [Project Overview](#project-overview)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Setup & Installation](#setup--installation)
- [Configuration](#configuration)
- [Running the Tests](#running-the-tests)
- [Test Modules](#test-modules)
- [Reporting](#reporting)
- [Parallel Execution](#parallel-execution)


## Project Overview

This repository contains an automated regression test suite for the NoBroker web platform, developed as part of the **Capgemini Sprint Program — Team 02**. The framework follows a **Behaviour-Driven Development (BDD)** approach using Gherkin feature files, enabling both technical and non-technical stakeholders to understand and contribute to test scenarios.

The suite covers all major functional modules of NoBroker, including property rental flows, home services, moving & shifting, user profile management, and payment workflows.

## Tech Stack

| Layer | Technology | Version |
|---|---|---|
| Language | Java | 11+ |
| Browser Automation | Selenium WebDriver | 4.38.0 |
| BDD Framework | Cucumber (TestNG) | 7.28.0 |
| Test Runner | TestNG | 7.10.2 |
| Reporting | ExtentReports (Spark) | 5.1.2 |
| Excel Data Handling | Apache POI | 5.4.1 |
| DI Container | Cucumber PicoContainer | 7.14.0 |
| Build Tool | Apache Maven | 3.x |

## Project Structure

Capgemini-Nobroker-Sprint-Team02-master/
│
├── src/
│   ├── main/
│   │   ├── java/com/nobroker/sprint/
│   │   │   ├── pages/                  # Page Object Model classes
│   │   │   │   ├── AddInventoryPage.java
│   │   │   │   ├── PackersAndMoversPage.java
│   │   │   │   ├── RentalPage.java
│   │   │   │   └── ...                 # 25+ Page classes
│   │   │   └── utils/                  # Utility / helper classes
│   │   │       ├── AllUtilities.java   # Core utilities (wait, scroll, screenshot, reports)
│   │   │       ├── BaseClass.java      # Thread-safe WebDriver holder
│   │   │       ├── ExcelUtilities.java # Apache POI Excel reader/writer
│   │   │       ├── HandleCookies.java  # Cookie persistence & session restore
│   │   │       ├── Pages.java          # Thread-safe Page Object registry
│   │   │       └── ReaderUtilities.java# Properties file reader
│   │   └── resources/
│   │       ├── Common.properties       # URL, phone number, browser config
│   │       └── Notary.xlsx             # Notary test data
│   │
│   └── test/
│       ├── java/com/nobroker/sprint/
│       │   ├── features/               # Gherkin feature files (26 files)
│       │   ├── runner/
│       │   │   └── RunnerIO.java       # Cucumber TestNG runner (parallel)
│       │   └── stepdefinitions/        # Step definition classes (40+ files)
│       │       ├── Hooks.java          # @Before / @After lifecycle management
│       │       └── ...
│       └── resources/
│           ├── Landlord_Tenant_details.xlsx
│           ├── Readers/
│           │   ├── Common.properties
│           │   └── Config.xlsx         # Data-driven test config
│           └── common_data/
│               └── Login.properties    # Login credentials
│
├── Reports/                            # Generated ExtentReports HTML output
├── Screenshot/                         # Failure screenshot captures
├── test-output/                        # TestNG raw output & JUnit XML
├── pom.xml
└── testng.xml


## Prerequisites

Ensure the following are installed and available on your `PATH` before proceeding:

- **Java JDK 11 or higher** — `java -version`
- **Apache Maven 3.6+** — `mvn -version`
- **Google Chrome** (latest stable) — ChromeDriver is managed automatically by Selenium 4
- **Eclipse IDE** (recommended) with the M2Eclipse plugin, or any Maven-compatible IDE


## Setup & Installation

**1. Clone the repository**

bash
git clone https://github.com/<your-org>/Capgemini-Nobroker-Sprint-Team02.git
cd Capgemini-Nobroker-Sprint-Team02

**2. Install dependencies**

bash
mvn clean install -DskipTests

**3. Configure credentials** (see [Configuration](#configuration) section below)


## Configuration

### `src/test/resources/common_data/Login.properties`
properties
url          = https://www.nobroker.in
userphoneno  = <your-registered-phone-number>
browser      = chrome


Running the Tests
Tests are executed via the RunnerIO class located at:
src/test/java/com/nobroker/sprint/runner/RunnerIO.java
Run from your IDE
Right-click RunnerIO.java → Run As → TestNG Test
Run via Maven
bashmvn test -Dtest=RunnerIO

---

## Test Modules

The suite is organised into the following functional modules, each represented by a Gherkin feature file and corresponding step definitions:

| Module | Feature File | Description |
|---|---|---|
| **Rental & User Flow** | `RentalAndUserflow.feature` | Full rental search, blog subscription, shortlisting, AC repair |
| **Buy Module** | `Buy.feature` | Property buy flow and filters |
| **Home Loan** | `HomeLoan.feature`, `ApplyHomeLoanTest.feature` | Apply for home loan, form validation |
| **Packers & Movers** | `PackageAndMover.feature` | Within-city shifting with inventory |
| **Vehicle Shifting** | `VechicleShifting.feature` | Vehicle shifting flow with Excel-driven data |
| **Movers Between Cities** | `MoversBetweenCities.feature` | Inter-city relocation flow |
| **Home Cleaning** | `HomeCleaning.feature` | Schedule home cleaning service |
| **Home Renovation** | `HomeRenovation.feature` | Home renovation enquiry flow |
| **Home Repair** | `Home.feature` | Home repair booking |
| **Paintings & Cleaning** | `PaintingsAndCleaning.feature` | Painting and deep-cleaning service |
| **Notary & Advocate** | `NotaryAdvocate.feature` | Legal service booking |
| **PG / Hostel** | `PgHostel.feature` | Search and filter PG/hostel listings |
| **Post Property** | `PostProperty.feature`, `PostYourProperty.feature` | Post a property with valid/invalid inputs |
| **Profile** | `Profile.feature`, `NegativeProfile.feature` | User profile update, negative cases |
| **Refer & Earn** | `ReferAndEarn.feature` | Referral flow validation |
| **Rent Receipts** | `RentReceipts.feature` | Generate rent receipts (landlord/tenant) |
| **Forum Flow** | `ForumFlow.feature` | Ask a question on NoBroker forum |
| **Location Validation** | `LocationValidation.feature` | Error handling for invalid location inputs |
| **Map** | `Map.feature` | Map view and property pin interactions |
| **New Icons** | `NewIcon.feature` | Newly added UI icon navigation |
| **Avoid Brokers** | `Final.feature` | Avoid Broker feature end-to-end |
| **Careers** | `career.feature` | Careers page navigation |
| **Contact** | `Conatct.feature` | Contact page form submission |


## Reporting

After every test run, HTML reports are generated automatically.

| Report | Path | Description |
|---|---|---|
| **ExtentReports** | `Reports/Nobroker-Report.html` | Rich HTML report with step-level pass/fail, screenshots on failure, and scenario tagging |
| **TestNG Output** | `test-output/index.html` | Native TestNG result dashboard |

Open any `.html` report in a browser after a run:

bash
open Reports/Nobroker-Report.html


**Failure screenshots** are captured automatically and saved under `Screenshot/` with a timestamp and scenario name.


## Parallel Execution

The suite is configured for **parallel scenario execution** using TestNG's multi-threading support.

```xml
<!-- testng.xml -->
<suite thread-count="2" parallel="methods" name="NoBroker-Suite">
```

Thread safety is ensured via:
- `ThreadLocal<WebDriver>` in `BaseClass.java` — isolates driver per thread
- `ThreadLocal<ExtentTest>` in `AllUtilities.java` — isolates report nodes per thread
- `ThreadLocal<Pages>` in `Pages.java` — isolates page object registry per thread

The `@DataProvider(parallel = true)` annotation in `RunnerIO.java` enables Cucumber scenarios to run concurrently across the configured thread pool.

---

*Generated for branch: `master` · Last updated: April 2026*
