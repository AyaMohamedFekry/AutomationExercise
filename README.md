# Automation Exercise

This project contains end-to-end test automation using Selenium WebDriver and TestNG.

## 📌 Project Scope
- Sign Up
- Login
- Add products to cart
- Checkout process
- Payment validation

## 🛠 Tools & Technologies
- Java
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)

## 📂 Framework Design
- Page Object Model (POM)
- TestNG for test execution
- Maven for dependency management

## ▶️ How to Run
1. Clone the project
2. Open in IntelliJ
3. Run TestNG test classes in the following order to ensure proper execution:
    1. SignUp ✅
        - Run this class first to create a new account.
        - Other tests depend on this account.
    2. Shopping 🛒
       - Executes end-to-end scenario: login → add products to cart → checkout → place order.
       - Requires the account created by SignUp.
    3. Payment 💳
       - Contains test cases for validating payment functionality.
       - Can run independently but running after Shopping ensures a complete workflow.
    4. Login 🔑
       - Contains login-related test cases, including the final test that deletes the account.
       - Run last to ensure deletion doesn’t affect other tests.
Note: Always run the classes in the above order to prevent dependency issues and ensure smooth end-to-end execution.

## 👩‍💻 Author
Aya Mohamed Fekry