# Login Application

This is a test project for a simple login web application that makes use of stored user information in a database to authenticate and provide users access to restricted webpages depending on their roles.

![Example image of the application](img/demo.png)

## Built with
* [Spring Boot](https://spring.io/projects/spring-boot)
* [Thymeleaf](https://www.thymeleaf.org/)
* [Bootstrap 5](https://getbootstrap.com/)
* [MySQL](https://www.mysql.com/)

## Running the application

The project is a standard Maven project. To run it from the command line,
type `mvnw` (Windows), or `./mvnw` (Mac & Linux), then open
http://localhost:8080 in your browser.

You can also import the project to your IDE of choice and run LoginApplication.java under src/main/java.

## Usage

1. After cloning the project and opening it in your IDE of choice, make sure to set the environment variables for the application. 

  For example, in Intellij and using MySQL for database, search for `Edit Configurations` action and key in the following: `DB_HOST=jdbc:mysql://localhost;DB_PORT=3306;DB_USERNAME={};DB_PASSWORD={};DB_NAME={}`. Replace curly brackets in the code with your own MySQL database name and credentials.
3. Run the application via the methods mentioned above.
4. The following users are created:
- User
  - Username: user
  - Password: user1
  - Roles: ROLE_USER
- Manager
  - Username: manager
  - Password: manager1
  - Roles: ROLE_MANAGER, ROLE_USER
- Admin
  - Username: admin
  - Password: admin1
  - Roles: ROLE_ADMIN, ROLE_MANAGER, ROLE_USER

Users with the role ROLE_USER can access `/welcome` after logging in.
Users with the role ROLE_MANAGER can access `/welcome-manager` after logging in.
Users with the role ROLE_ADMIN can access `/users` after logging in.

## Project structure

- `SetupDataLoader.java` in `src/main/java` contains the initial setup with default users created for the application to work.
- `services` package in `src/main/java` contains the classes UserDetailsService that Spring Security uses to retrieve the user's information.
- `config` package in `src/main/java` contains the configurations necessary for the html files to work, as well as the filters and authentication configurations for the login information to be authorized.
- `entity` package in `src/main/java` contains the entities and repositries used to save and retrieve the data of the grocery list application.
- `templates` folder in `src/main/resources` contains the html pages used for the login application.
- `static` folder in `src/main/resources` contains the css styles and images used for the login application.