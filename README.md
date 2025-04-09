# Serenity BDD - Parabank Automation

This is an automated test framework built with **Serenity BDD**, **Gradle**, and **JUnit** for testing the [Parabank](https://parabank.parasoft.com/parabank/index.htm) demo application.

## ✨ Features

- BDD styled test automation using Serenity
- Clear test reporting with Serenity Reports
- Page Object Model (POM) design
- Easily configurable via `serenity.properties`
- Gradle build system

<pre> ## 🗂️ Project Structure ``` serenity-parabank-automation/ ├── src/ │ ├── main/java/ # Page objects, utilities, and helpers │ └── test/java/ # Step definitions and test runners ├── build.gradle # Gradle build configuration ├── serenity.properties # Serenity framework config ├── settings.gradle # Gradle project settings ├── gradlew # Unix Gradle wrapper script ├── gradlew.bat # Windows Gradle wrapper script ├── build/ # Gradle build output ├── target/ # Serenity reports and test results └── README.md # Project documentation ``` </pre>

## 🚀 Getting Started

### ✅ Prerequisites

- Java 11 or higher
- Git
- IntelliJ IDEA (recommended)
- Internet connection for dependency downloads

### 🔧 Setup

Clone the project and navigate into the directory:

```bash
git clone https://github.com/your-username/serenity-parabank-automation.git
cd serenity-parabank-automation
```
---
### 🧪 Running Tests
Use the following Gradle command to run all tests:
```bash
./gradlew clean test aggregate

```
This will:
1. Clean previous builds
2. Run all defined tests
3. Generate a report under target/site/serenity/index.html

---

### 📊 Viewing the Serenity Report
Once tests are executed, open the report in your browser:
```bash
open target/site/serenity/index.html

```
Or on Windows:
```bash
start target\\site\\serenity\\index.html

```

### ⚙️ Configuration
You can modify test settings in the serenity.properties file, including:
```bash
webdriver.driver=chrome
serenity.base.url=https://parabank.parasoft.com/parabank/index.htm

```
### 📦 Dependency Management
Dependencies are handled via Gradle. To refresh or update:
```bash
./gradlew build --refresh-dependencies

```
### 📁 Reports Location
1. Test Results: target/test-results/
2. Serenity Reports: target/site/serenity/


## 📚 Resources

- [Serenity BDD Official Site](https://serenity-bdd.github.io/theserenitybook/latest/)
- [Gradle User Guide](https://docs.gradle.org/current/userguide/userguide.html)
- [Parabank Demo Site](https://parabank.parasoft.com/parabank/index.htm)
