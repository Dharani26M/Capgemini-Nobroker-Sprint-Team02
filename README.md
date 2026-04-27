# 🚀 Property App - Combined Functionalities Automation Framework

## 📌 Project Description

This project is a **Hybrid Test Automation Framework** developed to automate and validate the **Property Application** covering combined functionalities such as **Blog Subscription, Shortlisting, Rental Agreement, Home Repair, and AC Repair services**.

The framework covers complete end-to-end business workflows:

* Blog Subscription with Email Preferences
* Property Shortlisting via Dashboard
* Rental Agreement Upload & Draft Management
* Home Repair Service Booking (Painting & More)
* AC Repair Service & Payment Flow

It is designed following **enterprise automation standards** ensuring:

* High scalability
* Reusability
* Maintainability
* Robust execution

---

## 🏗️ Architecture Overview

This framework follows a **Hybrid Automation Architecture** combining:

* **BDD (Cucumber)**
* **Page Object Model (POM)**
* **TestNG Execution**
* **Dependency Injection (PicoContainer)**

### 🔄 Execution Flow

```
Feature File (Gherkin)
        ↓
Step Definitions
        ↓
Page Classes (POM)
        ↓
Utilities Layer
        ↓
TestNG Runner → Execution
```

---

## 🧰 Tech Stack

| Technology           | Purpose                       |
| -------------------- | ----------------------------- |
| Java                 | Core programming language     |
| Selenium WebDriver 4 | Browser automation            |
| Cucumber             | BDD framework                 |
| TestNG               | Test execution                |
| Maven                | Build & dependency management |
| Apache POI           | Excel data handling           |
| Extent Reports       | Reporting                     |

---

## ✨ Key Features

* ✅ BDD implementation using Gherkin
* ✅ Page Object Model (POM) design
* ✅ Thread-safe WebDriver management
* ✅ Excel-based data-driven testing
* ✅ Scenario Outline with Examples for Blog subscription
* ✅ Advanced wait handling (Explicit & FluentWait)
* ✅ Screenshot capture on failure
* ✅ Extent Reports integration
* ✅ Dynamic element handling (stable dropdown logic)

---

## 📂 Project Structure

```
src/main/java/com/propertyapp/
│
├── pages/                        → Page Object Model classes
│   ├── LoginPage.java
│   ├── DashboardPage.java
│   ├── BlogPage.java
│   ├── ShortlistPage.java
│   ├── RentalAgreementPage.java
│   ├── HomeRepairPage.java
│   ├── ACRepairPage.java
│   ├── OrderSummaryPage.java
│   ├── PaymentPage.java
│
├── utils/                        → Core framework utilities
│   ├── AllUtilities.java
│   ├── BaseClass.java
│   ├── ExcelUtilities.java
│   ├── HandleCookies.java
│   ├── ReaderUtilities.java
│   ├── Pages.java
│
src/test/java/com/propertyapp/
│
├── features/                     → Cucumber feature files
│   ├── BlogSubscription.feature
│   ├── Shortlist.feature
│   ├── RentalAgreement.feature
│   ├── HomeRepair.feature
│   ├── ACRepair.feature
│
├── stepdefinitions/              → Step definition classes
│   ├── BlogSteps.java
│   ├── ShortlistSteps.java
│   ├── RentalSteps.java
│   ├── HomeRepairSteps.java
│   ├── ACRepairSteps.java
│
src/test/resources/
│
├── Readers/                      → Test data & configuration
│   ├── Config.xlsx
│   ├── Common.properties
│
pom.xml                           → Maven dependencies
testng.xml                        → Test execution config
```

---

## 🧩 Design Patterns Used

### 🔹 Page Object Model (POM)

* Separates UI elements from test logic
* Improves maintainability and reusability

### 🔹 Singleton Pattern (Driver Management)

* Ensures one driver instance per thread

### 🔹 Page Manager Pattern

* Centralized access to page objects via `Pages.java`

---

## 🧪 BDD Implementation

### 🔹 What is BDD?

BDD (Behavior Driven Development) allows writing test cases in **human-readable format using Gherkin language**.

### 🔹 Feature Tags

| Tag           | Module                          |
| ------------- | ------------------------------- |
| `@Blog`       | Blog subscription functionality |
| `@Shortlist`  | Property shortlisting           |
| `@Rental`     | Rental agreement upload         |
| `@HomeRepair` | Home repair service booking     |
| `@ACRepair`   | AC repair service & payment     |

### 🔹 Sample Scenarios

```gherkin
@Blog
Scenario Outline: User subscribes to blog successfully
  Given the user has logged into application
  When user selects Avoid Broker option
  And user navigates to blog section
  And user clicks subscribe option in blog
  And user enters email in blog subscription field "<email>"
  And user enters preferences in blog form
  And user submits blog subscription
  Then blog subscription should be successful

  Examples:
    | email               |
    | test12@gmail.com    |
    | user123@yahoo.com   |
    | sample3@mail.com    |
    |                     |


@Shortlist
Scenario: Shortlisting properties
  Given user logged in for shortlisting
  When user clicks MyDashBoard
  And clicks shortlist
  And your shortlist and clicks sales
  Then verify property available


@Rental
Scenario: Upload draft successfully
  Given user logged in for rental
  And user clicks on Rental Agreement module
  And user uploads the draft document
  And user enters required contract details
  And user clicks on Save and Continue
  Then user should be navigated to Summary page


@HomeRepair
Scenario: Verify login is required before booking home repair service
  When Click on Painting option for home repair
  And Select city for home repair
  And Select Home Repair service
  And Click on first product
  And Add second product
  Then Order Summary should be displayed


@ACRepair
Scenario: Verify user can trigger login in AC repair
  Given the user has logged into the application
  When Click on Painting option for AC repair
  And Select city for AC repair
  And Select AC repair service
  And Add AC service
  Then payment page should be displayed verified
```

---

## ▶️ Test Execution

### 🔹 Run via IDE

* Right-click on Test Runner class
* Click **Run**

### 🔹 Run by Tag

To execute specific feature modules, use tag-based filtering:

```bash
mvn test -Dcucumber.filter.tags="@Blog"
mvn test -Dcucumber.filter.tags="@Shortlist"
mvn test -Dcucumber.filter.tags="@Rental"
mvn test -Dcucumber.filter.tags="@HomeRepair"
mvn test -Dcucumber.filter.tags="@ACRepair"
```

---

## ⚙️ Configuration Management

Configuration is handled using:

* `Common.properties` — browser settings, base URL, timeouts
* `Config.xlsx` — test data (emails, city names, service types)

---

## 🔁 Utilities & Reusability

### 🔹 AllUtilities.java

Provides:

* WebDriver handling
* Wait strategies
* Scrolling utilities
* Screenshot capture
* Reporting integration

### 🔹 ExcelUtilities.java

* Reads test data from Excel
* Supports data-driven testing for Blog subscription email inputs

---

## ⚠️ Exception Handling

Framework handles:

* `StaleElementReferenceException`
* `NoSuchElementException`

Using:

* FluentWait
* Retry logic
* Stable element detection

---

## 📊 Reporting

Integrated with **Extent Reports**

Features:

* Step-level reporting
* Screenshot on failure
* HTML report generation

---

## 🛠️ Setup Instructions

### 🔹 Prerequisites

* Java JDK 8+
* Maven
* IDE (Eclipse / IntelliJ)
* Chrome / Firefox Browser

### 🔹 Steps

1. Clone repository:

```bash
git clone <repository-url>
```

2. Import as Maven Project

3. Install dependencies:

```bash
mvn clean install
```

---

## ▶️ Execution Commands

```bash
mvn clean install
mvn test
```

---

## ✅ Best Practices Followed

* ✔ Clean Code Principles
* ✔ Modular Design
* ✔ Separation of Concerns
* ✔ Reusable Components
* ✔ Thread-safe execution
* ✔ Data-driven testing via Scenario Outline
* ✔ Tag-based test filtering for selective execution
