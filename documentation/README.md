# DEMO QA Test Automation Project
Demo QA is a practice website for learning and practice manual and automated testing. 

## Project Description
The goal of the project was to test functionalities and cover critical components (forms, tables, slider, date picker, alerts...)
in order to practise and develop more precise assertions and cleaner code. It is done in POM, using Page Factory.

### Dependencies
* Run on OS Microsoft Windows 11 Pro.
* IDE for this project is IntelliJ Idea Community Edition 2025.2.6
* Required browser is Chrome, but can be easily adapted for Firefox and Edge.

### Installation
Open terminal in IDE and git clone the repository:
```bash
    Git clone https://github.com/Dragana07B/DemoQaAutomationProject.git
 ```
* Java version 8.04710.9
* Apache Maven version 3.9.9

### Executing program
Run all tests from terminal with:
mvn test

### Framework Walkthrough
Packages:
* Base - Contains classes used through the app, driver initialization, and teardown process
* Pages - Contains classes for each page with elements and methods
* Tests - Contains test classes, tests grouped by functionalities

Files:
Documentation/[TestCasesDemoQAProject.ods](https://github.com/Dragana07B/DemoQaAutomationProject/blob/73357905d6e85619a2cd50b2168590fe19a1bdb8/documentation/TestCasesDemoQAProject.ods)

### Features
* Dynamic waits (implemented WebDriverWait)
* Smart navigation (reduce code duplication)
* JavaScript executor (scroll)
* Negative testing

### Credits
[IT Bootcamp](https://itbootcamp.rs/)
* Instructor Dragoljub Boranijasevic, https://github.com/DragoljubQA
* Assistant Dejan Grujic

### Author
Dragana Banjanin