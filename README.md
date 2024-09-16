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

