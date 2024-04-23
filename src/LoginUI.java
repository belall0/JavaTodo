
import java.util.Scanner;

public class LoginUI {
  private UserController userController;
  private Scanner scanner;

  public LoginUI(Scanner scanner, UserController userController) {
    this.userController = userController;
    this.scanner = scanner;
  }

  public int start() {
    int choice;

    while (true) {
      choice = getMainMenuChoice();

      if (choice == 1) {
        int id = logIn();

        System.out.println("Welcome back, " + userController.getUserFullName(id) + "!");
        return id;

      } else {
        signUp();
      }
    }

  }

  private int logIn() {

    while (true) {
      System.out.print("Enter your username: ");
      String userName = scanner.nextLine();

      System.out.print("Enter your password: ");
      String password = scanner.nextLine();

      int userId = userController.isUserExist(userName, password);
      if (userId != -1) {
        return userId;
      } else {
        System.out.println("Invalid username or password. Try again.\n");
      }

    }
  }

  private void signUp() {
    String fullName = getFullName();
    String email = getEmail();
    String userName = getUserName();
    String password = getPassword();

    userController.addUser(fullName, email, userName, password);
  }

  // ****************************************************
  // Helper methods
  // ****************************************************

  // Get the choice from the main menu
  private int getMainMenuChoice() {
    System.out.println("Menu: ");
    System.out.println("\t1- Login");
    System.out.println("\t2- Sign up");

    String choice;
    while (true) {
      System.out.print("Enter your choice: ");
      choice = scanner.nextLine();

      if (choice.matches("[1-2]")) {
        break;
      } else {
        System.out.println("Invalid choice. Try again.\n");
      }
    }

    return Integer.valueOf(choice);
  }

  // Get the email from the user
  private String getEmail() {

    String email;
    while (true) {
      System.out.print("Enter your email: ");
      email = scanner.nextLine();

      if (userController.isEmailTaken(email)) {
        System.out.println("Already taken. Try again.\n");
      } else {
        break;
      }
    }

    return email;
  }

  // Get the full name from the user
  private String getFullName() {
    System.out.print("Enter your name: ");
    String fullName = scanner.nextLine();
    return fullName;
  }

  // Get the username from the user
  private String getUserName() {

    String userName;
    while (true) {
      System.out.print("Enter your username: ");
      userName = scanner.nextLine();

      if (userController.isUserNameTaken(userName)) {
        System.out.println("Already taken. Try again.\n");
      } else {
        break;
      }
    }

    return userName;

  }

  // Get the password from the user
  private String getPassword() {

    String password;
    while (true) {
      System.out.print("Enter your password: ");
      password = scanner.nextLine();

      if (password.length() < 8) {
        System.out.println("Password must be at least 8 characters long. Try again.\n");
      } else {
        break;
      }
    }

    return password;
  }

}
