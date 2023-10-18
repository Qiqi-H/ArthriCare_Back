# Introduction
The **Rheumatism Management Tool** is an application designed specifically for patients with rheumatism. Our core philosophy is to assist and motivate patients to take their medication regularly through gamified methods, thereby better managing their condition.

## Features
- **Reward System**: Incentives for users to stick to their daily medication routine.
- **Built-in Community**: A gathering place for patients with rheumatism, providing them a platform to discuss their condition and share treatment experiences.
- **Private Chat**: Allows users to communicate one-on-one with other patients or experts.
- **Puzzle Tasks**: Users receive puzzle pieces upon completing daily tasks. When accumulated to a certain amount, they can be combined into a full puzzle, offering a sense of accomplishment.

## Tech Stack
- Java 17
- MySQL
- Spring Boot 3.1.0
  - Spring JDBC
  - Spring Web
  - MyBatis Spring Boot Starter 3.0.2
  - MySQL Connector/J (Runtime)
  - Jackson Databind 2.13.0
  - Spring Websocket
  - Spring Boot Test (Test scope)

## Installation & Usage
### Installing Java 17
1. Visit the [official Oracle download page](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html).
2. Choose the version suitable for your operating system and download.
3. Double-click the downloaded installer and follow the prompts.
4. Verify the installation: Open a terminal or command prompt and type `java -version`. You should see the version info for `java 17`.

### Installing MySQL
1. Visit the [official MySQL download page](https://dev.mysql.com/downloads/mysql/).
2. Choose the version suitable for your operating system and download.
3. Double-click the downloaded installer and follow the on-screen instructions.
4. Once installed, ensure the MySQL service has started.
5. Verify the installation: Connect to the database either through the MySQL command-line client or other tools like MySQL Workbench.

### Setting up Spring Boot Application
1. Clone the repository to your local machine.
2. Navigate to the project root and run `mvn clean install` to download dependencies and build the project.
3. To start the Spring Boot application, you can either:
   - Run `mvn spring-boot:run` from the command line.
   - Or run the main application class from your favorite IDE.
4. Access the application on `http://localhost:8080`.
