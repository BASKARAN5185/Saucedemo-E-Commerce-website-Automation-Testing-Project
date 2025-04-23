---

# SauceDemo E-Commerce Website Automation Test Project

This is a comprehensive **automation testing framework** for the [SauceDemo](https://www.saucedemo.com/) e-commerce demo site. Built using **Selenium WebDriver** and **TestNG**, it automates critical workflows such as **login**, **product browsing**, **cart management**, and **checkout** to validate application behavior and error handling.

---

## 📌 Project Overview

This project is ideal for QA automation practice. It automates real-user flows on a mock e-commerce site, including:

- 🔐 **Login tests** (valid, invalid, and empty credentials)
- 🛒 **Product browsing** and cart operations
- 💳 **Checkout process** and confirmation validation
- ⚠️ **Error handling** for edge cases
- 👥 **Role-based testing** for users like `standard_user`, `locked_out_user`

---

## ✨ Key Features

| Feature               | Description                                                   |
|-----------------------|---------------------------------------------------------------|
| ✅ Login Verification  | Validates login with multiple credential types                |
| 🛍️ Cart & Checkout     | Automates product add-to-cart, cart view, and checkout flow  |
| ⚠ Error Scenarios     | Validates input field checks, error messages, and edge cases  |
| 👤 Role-Based Testing  | Executes flows with different SauceDemo user profiles         |
| 🌐 Cross-Browser Ready | Compatible with Chrome and Firefox drivers                    |
| 📊 Reporting           | Integrated ExtentReports for test result visualization        |

---

## 🛠️ Technologies Used

| Technology            | Purpose                              |
|------------------------|---------------------------------------|
| **Java**               | Scripting language                    |
| **Selenium WebDriver** | Browser automation engine             |
| **TestNG**             | Test case management & reporting      |
| **Maven**              | Build & dependency manager            |
| **ExtentReports**      | Rich HTML-based test reports          |
| **WebDrivers**         | ChromeDriver / GeckoDriver support    |

---

## 📁 Project Structure

```
SauceDemo-Automation/
│
├── src/
│   ├── main/java/MyProject/saucedemo/
│   │   └── App.java
│   │
│   └── test/java/MyProject/saucedemo/
│       ├── BaseClass.java
│       ├── pageObjectClass/
│       │   ├── LoginPage.java
│       │   ├── LandingPage.java
│       │   ├── YourCartPage.java
│       │   ├── CheckOutPage.java
│       │   ├── CheckOutOverViewPage.java
│       │   └── CheckOutCompletePage.java
│       ├── testBase/
│       │   ├── LoginPageTest.java
│       │   ├── LandingPageTest.java
│       │   ├── CartPageTest.java
│       │   ├── CheckOutPageTest.java
│       │   ├── CheckOutOverViewPageTest.java
│       │   └── CheckOutCompletePageTest.java
│       └── utility/
│           ├── ExtentReportManager.java
│           ├── EnhanceExtentReportManager.java
│           └── TestDataProvider.java
│
├── End to End Testing.xml       # TestNG suite file
├── pom.xml                      # Maven configuration
├── test-output/                 # Test reports
└── README.md                    # Project documentation
```

---

## 🧰 Setup Instructions

### Prerequisites

- Java 8 or higher  
- Maven  
- ChromeDriver / GeckoDriver  
- Git

---

### 🔧 Installation & Configuration

1️⃣ **Clone the Repository**

```bash
git clone https://github.com/your-username/saucedemo-automation.git
cd saucedemo-automation
```

2️⃣ **Install Dependencies**

```bash
mvn install
```

3️⃣ **Set WebDriver Path in `BaseClass.java`**

```java
System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
System.setProperty("webdriver.gecko.driver", "/path/to/geckodriver");
```

---

## ▶️ Running Tests

Use Maven to run the test suite:

```bash
mvn test
```

- Uses `testng.xml` or `End to End Testing.xml` for suite configuration.
- Automatically launches tests in configured browser(s).

---

## 📊 Reports & Results

- 🧾 **TestNG Reports**: Located under `target/surefire-reports/`
- 🌐 **ExtentReports (HTML)**: Generated in `test-output/` or a configured path

These reports include pass/fail summaries, screenshots (if enabled), and step-by-step logging.

---

## 📬 Contributions

Feel free to fork the repository, make improvements or bug fixes, and submit a pull request.  
Any enhancements to structure, coverage, or usability are welcome!

---

## 🧠 Notes

- CI integration (e.g., Jenkins, GitHub Actions) is **not yet configured**.
- No license is applied; the project is intended for **learning and demonstration** only.
- SauceDemo is a public mock site by [Sauce Labs](https://saucelabs.com/) — not affiliated.

---
