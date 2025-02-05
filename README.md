# Online Expense Tracker

This is a web-based **Online Expense Tracker** application built using **Servlets**, **JSP**, **Hibernate 5.6.9**, **MySQL**, and **Maven** for dependency management. The application allows users to register, log in, and track their expenses with features to add, view, edit, and delete expense records. The system utilizes Hibernate for database interaction and uses a custom `HibernateUtil` class for configuration.

## Features

- **User Authentication**:
  - **Sign Up**: Users can create an account with their email and password.
  - **Login**: Users can log in with their credentials to access the expense tracking system.
  - **Logout**: After logging in, users can log out of their account.

- **Expense Management**:
  - **Add Expense**: Users can add new expense records, including details such as amount, description, and date.
  - **View Expense**: Users can view a list of all their expenses.
  - **Edit Expense**: Users can edit existing expense records.
  - **Delete Expense**: Users can delete expense records from their list.

- **Navigation**:
  - The app includes a **responsive navbar** with links to **Home**, **Registration**, **Login**, and **Logout** after successful login.

## Technologies Used

- **Java** (Servlets)
- **JSP** (for frontend pages)
- **Hibernate 5.6.9** (for ORM and database interaction)
- **MySQL** (for the database)
- **Maven** (for dependency management)
- **Bootstrap** (for responsive design)

## Project Structure

### **`webapp/`**

- **`component/`**: 
  - **`navbar.jsp`**: Contains the HTML structure and logic for the navigation bar. This file is included in other JSP pages to avoid repetition.
  - **`footer.jsp`**: Contains the footer section of the page, also included in other pages to reduce repeated code.
  - **`head.jsp`**: Contains the meta tags, link to CSS files, and the head section. Included in other pages to avoid duplicating the head content across pages.

- **`User/`**: 
  - **`view_expense.jsp`**: Displays a list of all expenses for the logged-in user. It also allows users to edit or delete expense records.
  - **`add_expense.jsp`**: Page for adding a new expense. Includes fields to enter details such as amount, description, and date.
  - **`edit_expense.jsp`**: Page for editing an existing expense. It displays the expense details and allows users to modify them.
  - **`home.jsp`**: Home page for the logged-in user. It typically displays an overview or dashboard of the user's expenses and includes links to add, view, or edit expenses.

- **`login.jsp`**: The page where users can log in with their credentials (username/email and password).
- **`register.jsp`**: The page where users can create a new account by providing their email, password, and other required details.
- **`index.jsp`**: The landing page for the application. It provides links to the **Login** and **Register** pages for the user to access.

### **`src/`**

- **`db/`**:
  - `HibernateUtil.java`: Contains the Hibernate configuration logic and provides a session factory to connect to the database using properties for connection.
  
- **`entity/`**:
  - `User.java`: Entity class representing the `users` table in the database.
  - `Expense.java`: Entity class representing the `expenses` table in the database.

- **`dao/`**:
  - `UserDao.java`: Data Access Object for user-related database operations.
  - `ExpenseDao.java`: Data Access Object for expense-related database operations.
  
- **`servlet/`**:
  - `Login.java`: Handles user login functionality and redirects the user to the appropriate page.
  - `Register.java`: Handles user registration and validation.
  - `Logout.java`: Handles user logout functionality and invalidates the session.
  - `SaveExpense.java`: Handles adding new expenses to the database.
  - `UpdateExpense.java`: Handles editing of an existing expense record
  - `DeleteExpense.java`: Handles the deletion of an expense from the user's record.

### **`WEB-INF/`**

- **`web.xml`**: The web.xml file configures the basic application settings and mappings. However, servlet mappings are primarily handled through the `@WebServlet` annotation in the respective servlet classes.

## Servlet Configuration with `@WebServlet` Annotation
In this project, we have used the **`@WebServlet`** annotation to map the servlets to their respective URLs, instead of using `web.xml` for servlet mapping.

### Prerequisites

- JDK (Java Development Kit) 8 or higher
- MySQL database
- Apache Tomcat 9.0 or any Servlet container
- Hibernate library
- IDE (like Eclipse, IntelliJ, etc.) with Java support

### Steps to Run the Application

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/Sarwan-Projects/Online-Expense-Tracker.git
