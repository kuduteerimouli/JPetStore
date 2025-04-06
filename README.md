## 🐾 JPetStore Automation Testing – Capstone Project
### 📌 Project Overview
This repository showcases the Automation Testing Capstone Project focused on the JPetStore E-Commerce Application. The project was undertaken to demonstrate real-world application of automation testing tools and frameworks, simulating the tasks typically performed by Software Development Engineers in Test (SDETs).

It features a hybrid test automation framework designed using Selenium WebDriver, TestNG, Cucumber (BDD), Apache POI, and advanced reporting tools like Extent Reports and Allure.

### 🎯 Project Objectives
Automate end-to-end user workflows:

User Registration

Login

Adding Items to Cart

Updating Cart

Billing & Payment

Order Placement

Sign-Out

Additional goals:
- Enable cross-browser compatibility  
- Generate detailed and interactive reports  
- Ensure scalability and maintainability using best practices like Page Object Model (POM)  
- Apply data-driven testing using Excel with Apache POI  

### 🛠️ Technologies & Tools Used

| Technology              | Purpose                                    |
|-------------------------|--------------------------------------------|
| Java                    | Programming language                       |
| Selenium WebDriver      | Web UI Automation                          |
| TestNG                  | Test framework                             |
| Cucumber (BDD)          | Behavior-driven development                |
| Apache POI              | Excel integration for data-driven tests    |
| Maven                   | Build and dependency management            |
| Extent Reports / Allure | Advanced test reporting                    |
| Jenkins                 | CI/CD automation                           |
| Git & GitHub            | Version control and repository hosting     |
| Eclipse IDE             | Development environment                    |

### 🧱 Project Structure

CapstoneProject/
│
├── base_Works/                    # Core utilities
│   ├── ChooseBrowser.java
│   ├── ExtentReports_1.java
│   ├── data.properties
│   └── Shipping_Details.xlsx
│
├── pageFactory/                   # POM-based page classes
├── operations_PF/                 # Operations using PageFactory
├── cucumber_Signin_work/         # BDD scenarios and steps
├── operations_pom/               # POM without PageFactory
│
├── screenshots/                  # Screenshots for reporting/debugging
├── testng/                       # TestNG XML files for execution
├── JPetExtent-report.html        # HTML Test report (Extent)
├── pom.xml                       # Maven configuration
└── README.md                     # Project documentation


### 🚀 How to Run the Project

**1. Clone the repository**
```bash
git clone https://github.com/kuduteerimouli/JPetStore.git
cd JPetStore

2. Import into Eclipse

    * Open Eclipse
    * Go to File > Import > Existing Maven Project
    * Select the JPetStore folder
    * Finish the import

3. Configure data.properties

    * Update the application URL and test credentials in base_Works/data.properties

4. Execute Test Cases

    * Run using testng_PF.xml for PageFactory
    * Run using testng_POM.xml for POM
    * Or use Signin_Runner.java for BDD scenarios

5. View Reports

    * Open JPetExtent-report.html for Extent Reports
    * View Allure Reports from /target/allure-results/ (if configured)

6. CI Integration (Optional)

    * Trigger tests using Jenkins and generate automated reports

### 📝 Features
✅ Robust and maintainable hybrid automation framework
✅ Supports both Page Object Model and PageFactory
✅ BDD with Cucumber for human-readable test cases
✅ Data-driven testing using Apache POI
✅ Screenshot capture on failures
✅ Cross-browser execution
✅ CI/CD friendly using Jenkins
✅ Real-world simulation of SDET tasks

### 📸 Sample Screenshots

| Feature              | Screenshot Name            |
|----------------------|----------------------------|
| Registration         | pic-Registration.png       |
| Sign-in              | pic-Sign-in Page.png       |
| Home Page            | pic-Jpet Home Page.png     |
| Add to Cart          | pic-Items added.png        |
| Update Cart          | pic-Update Cart.png        |
| Payment              | pic-Payment Method.png     |
| Shipping             | pic-Shipping Details.png   |
| Order Confirmation   | pic-Confirming order.png   |
| Sign-Out             | pic-Sign-out.png           |

### 📑 Conclusion
This capstone project successfully demonstrates a real-world automation solution tailored for the JPetStore e-commerce application. It emphasizes:

    * Scalable automation practices using POM
    * Maintainable test design
    * Integration of multiple tools and frameworks
    * Effective reporting and CI pipeline readiness

This repository serves as a portfolio project for showcasing your skills in test automation and framework design.

### 👨‍💻 Author
Kuduteeri Mouli
Electronics and Communication Engineer | Aspiring SDET
Hyderabad, Telangana, India
📧 [GMail](mailto:kuduteerimouli@gmail.com)  
🌐 [GitHub Profile](https://github.com/kuduteerimouli)
