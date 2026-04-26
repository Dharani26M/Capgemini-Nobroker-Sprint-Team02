# 🚀 NoBroker Packers & Movers Automation Framework

## 📌 Project Description

This project is a **Hybrid Test Automation Framework** developed to automate and validate the **NoBroker Packers & Movers module** along with additional functionalities such as **Forum interaction and Location validation**.

The framework covers complete end-to-end business workflows:

* Vehicle Shifting
* Movers Between Cities
* Package & Movers Selection
* Inventory Management
* Booking & Order Summary
* Payment Flow
* Forum Question Posting
* Location Validation

It is designed following **enterprise automation standards (Capgemini/TCS level)** ensuring:

* High scalability
* Reusability
* Maintainability
* Robust execution

## 🏗️ Architecture Overview

This framework follows a **Hybrid Automation Architecture** combining:

* **BDD (Cucumber)**
* **Page Object Model (POM)**
* **TestNG Execution**
* **Dependency Injection (PicoContainer)**

### 🔄 Execution Flow

Feature File (Gherkin)
        ↓
Step Definitions
        ↓
Page Classes (POM)
        ↓
Utilities Layer
        ↓
TestNG Runner → Execution

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

## ✨ Key Features

* ✅ BDD implementation using Gherkin
* ✅ Page Object Model (POM) design
* ✅ Thread-safe WebDriver management
* ✅ Excel-based data-driven testing
* ✅ Advanced wait handling (Explicit & FluentWait)
* ✅ Screenshot capture on failure
* ✅ Extent Reports integration
* ✅ Dynamic element handling (stable dropdown logic)

## 📂 Project Structure
src/main/java/com/nobroker/sprint/
│
├── pages/                  → Page Object Model classes
│   ├── DashboardPage.java
│   ├── PackersAndMoversPage.java
│   ├── AddInventoryPage.java
│   ├── VechicleAddInventoryPage.java
│   ├── OrderSummary.java
│   ├── PaymentPage.java
│   ├── NobrokerForumPage.java
│   ├── NobrokerAskQuestion.java
│
├── utils/                  → Core framework utilities
│   ├── AllUtilities.java
│   ├── BaseClass.java
│   ├── ExcelUtilities.java
│   ├── HandleCookies.java
│   ├── ReaderUtilities.java
│   ├── Pages.java
│
src/test/java/com/nobroker/sprint/
│
├── features/               → Cucumber feature files
│   ├── ForumFlow.feature
│   ├── LocationValidation.feature
│   ├── MoversBetweenCities.feature
│   ├── PackageAndMover.feature
│   ├── VechicleShifting.feature
│
src/test/resources/
│
├── Readers/                → Test data & configuration
│   ├── Config.xlsx
│   ├── Common.properties
│
pom.xml                     → Maven dependencies
testng.xml                  → Test execution config

## 🧩 Design Patterns Used

### 🔹 Page Object Model (POM)

* Separates UI elements from test logic
* Improves maintainability

### 🔹 Singleton Pattern (Driver Management)

* Ensures one driver instance per thread

### 🔹 Page Manager Pattern

* Centralized access to page objects via `Pages.java`

## 🧪 BDD Implementation

### 🔹 What is BDD?

BDD (Behavior Driven Development) allows writing test cases in **human-readable format using Gherkin language**.

### 🔹 Sample Feature

gherkin
Feature: Vehicle Shifting

Scenario: Validate vehicle shifting flow
  Given User selects vehicle shifting
  When User enters shifting details
  Then Booking should be successful

## ▶️ Test Execution

### 🔹 Run via IDE

* Right-click on Test Runner class
* Click **Run**


## ⚙️ Configuration Management

Configuration is handled using:

* Common.properties


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
* Supports data-driven testing


## ⚠️ Exception Handling

Framework handles:

* StaleElementReferenceException
* NoSuchElementException

Using:

* FluentWait
* Retry logic
* Stable element detection

## 📊 Reporting

Integrated with **Extent Reports**

Features:

* Step-level reporting
* Screenshot on failure
* HTML report generation


## 🛠️ Setup Instructions

### 🔹 Prerequisites

* Java JDK 8+
* Maven
* IDE (Eclipse / IntelliJ)

### 🔹 Steps

1. Clone repository:

bash
git clone <repository-url>


2. Import as Maven Project

3. Install dependencies:

bash
mvn clean install

## ▶️ Execution Commands

bash
mvn clean install
mvn test

## ✅ Best Practices Followed

* ✔ Clean Code Principles
* ✔ Modular Design
* ✔ Separation of Concerns
* ✔ Reusable Components
* ✔ Thread-safe execution

