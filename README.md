# Application Setup and Execution

### General Instructions

- Ensure that you are in the root directory of the project where `run_application.bat` and `run_application.sh` are located.

### For Windows Users

1. Open a command prompt.
2. Run the batch file by typing:
   ```
   run_application.bat
   ```

### For Mac/Linux Users

1. Open a terminal.
2. Run:
   ```bash
   chmod +x run_application.sh
   ```
3. Run:
   ```bash
   ./run_application.sh
   ```

## Application Access

- Once the application starts, it will be accessible in your web browser at: [http://localhost:8080/](http://localhost:8080/)
- Make sure port **8080** is not in use by another application.

## What the Scripts Do

Both scripts perform the following steps:

1. Clean and build the project using Maven:
   ```
   mvn clean install
   ```
2. Navigate to the `target` directory where the built JAR file is located.
3. Run the application JAR file:
   ```
   java -jar test-assignment-0.0.1-SNAPSHOT.jar
   ```

## Additional Notes

- The project was developed using:
    - **Maven**
    - **Java Version**: 17
    - **Spring Boot Version**: 3.3.3
    - **Angular CLI Version**: 18.2.3
    - **IntelliJ IDEA**

## Taks

Create an application which has a button to create new filter and representation of already created filters.
Homepage consist of “Add Filter” button and representation of saved filters. If user clicks “Add Filter” button a filter dialog will appear. Representation ofsaved filters can be a table, dashboard or any other way to represent overview.

**Modal dialog functional requirements:**
- (+) button creates new line of filtering criteria
- (-) button deletes criteria
- Filter should contain at least one criteria
****
-There can be 3 types of criteria: 
- Amount with number comparing conditions
- Title with text comparing conditions
- Date with date comparing conditions, date choice can be represented by date picker or 3 combo boxes
****
- Each added criteria default as “Amount” type
- Comparing conditions should correspond to selected criteria type
- Filter dialog should have fixed size and be configurable to operate in modal/non-modal mode
- Let the user resize only the height
- If there are more rows than dialog can fit, scrolling should appear
- In non-modal mode user by clicking “Add Filter” button sees filter dialog as part of page


**Architecture constraints**
- Application backend should be implemented using Spring Boot (3+) and Java 17+
- Application frontend should be implement using any modern JS framework or library (e.g. Angular)
- Application frontend and backend should communicate using REST services and use JSON protocol for data transfer
- Application data should be kept in SQL database (it is “OK” to use H2)
- Application should create all required database schemas, tables and test-data on startup
- Test data should contain at least 2 filters
