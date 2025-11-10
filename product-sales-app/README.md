# Product Sales App (Java Swing)

A simple Java Swing application that processes product sales data for a local sound equipment retailer.

Features:
- Loads in-memory product sales data (two years) when "Load Product Data" is pressed.
- Calculates total sales, average sales, count of sales over/under the sales limit (limit = 500).
- Displays the number of years processed (read-only label).
- Allows saving the displayed text area content to `data.txt`.
- Menu system with `File -> Exit` and `Tools -> Load Product Data / Save Product Data / Clear`.
- Unit tests (JUnit 5) covering over/under limit counting.

## Project layout

```
product-sales-app/
├─ pom.xml
├─ README.md
├─ src/


## Requirements
- Java 11 or newer
- Maven
- (Optional) Visual Studio Code with Java extensions for editing/debugging

## How to build

From the project root (where `pom.xml` is):

```bash
mvn clean package

This will compile the code and run unit tests.

How to run
From Maven (recommended)

Run the GUI app with:

mvn exec:java -Dexec.mainClass="com.example.productsales.ProductSalesApp"
Or run the jar
After mvn package, run:
java -cp target/product-sales-app-1.0.0.jar com.example.productsales.ProductSalesApp

(Ensure the jar is built; if you used dependencies that require packaging you may need a fat jar — we kept dependencies minimal so above should work.)
Running tests
mvn test

You should see tests pass for:


GetSalesOverLimit_ReturnsNumberOfSales


GetSalesUnderLimit_ReturnNumbersOfSales


Behavior details


Load Product Data: Uses the hardcoded data:


Year 1: Microphone 300, Speakers 150, Mixing Desk 700


Year 2: Microphone 250, Speakers 200, Mixing Desk 600
It calculates:


Total (sum of all entries)


Average (mean per product entry)


Sales over limit (count of product sales strictly > 500)


Sales under or equal to limit (count of product sales <= 500)


Years processed (2 in this sample)




Save Product Data: Saves the current content of the text area to data.txt in the working directory.


Clear: Clears the text area and resets the years processed label to 0.


Notes


The UI uses Swing for simplicity and portability.


ProductSales implements IProductSales. Methods are fully implemented.


Unit tests are in src/test/java/... and use JUnit 5.



If you want:


A Gradle version instead of Maven


Packaging as an executable/fat jar


A more advanced UI (JavaFX)
tell me which and I will provide it. 🔨🤖🔧



---

### Final notes / quick checklist
- All logic required by your task is implemented.
- Buttons and menu items share the same logic (load/save/clear).
- Save writes to `data.txt`.
- `ProductSales` implements `IProductSales` with required methods.
- Tests verify over/under limit counts for the provided sample.

If you'd like, I can:
- Convert this to a Gradle build,
- Create a runnable fat-jar,
- Add more unit tests (total, average, and products processed),
- Or give you a VS Code `launch.json` and `settings.json` for debugging.

Which (if any) would you like me to add? ✔️
```