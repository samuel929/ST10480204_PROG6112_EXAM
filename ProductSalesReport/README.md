# Product Sales Report - Java Console App

A simple Java console application that generates a product sales report for a retail company using 2D arrays.

---

## 📦 Features
- Uses **interfaces** and **classes** for modular design
- Calculates:
  - Total Sales
  - Average Sales
  - Maximum Sales
  - Minimum Sales
- Includes **JUnit 5 unit tests**

---

## 🧰 Technologies
- Java 17+
- JUnit 5
- Visual Studio Code

---

## ⚙️ How to Run (on VS Code)

1. **Clone or Create Folder**
   ```bash
   mkdir ProductSalesReport
   cd ProductSalesReport

3. Open in Visual Studio Code

4. Set Up Java

Install the Java Extension Pack in VS Code.

Ensure Java SDK (17+) is installed:

```
java -version

```

5. Compile and Run the Program For question 1

```
cd src/main/java
javac com/company/*.java
java com.company.Main

```

6. Expected Output

```
PRODUCT SALES REPORT - 2025
----------------------------------
Total sales: 2200
Average sales: 367
Maximum sales: 700
Minimum sales: 150
----------------------------------

```

7. 🧪 Running Tests

Add JUnit 5 Library

Download JUnit 5 jar files or use Maven/Gradle.

Example (manual run):

```
javac -cp .;junit-platform-console-standalone-1.10.0.jar com/company/*.java
java -jar junit-platform-console-standalone-1.10.0.jar --class-path . --scan-class-path

```


8. Expected Test Output

```
All tests passed successfully!

```