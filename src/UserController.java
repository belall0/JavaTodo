import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class UserController {
  private List<User> users;
  private Set<String> emails;
  private Set<String> userNames;
  private int idCounter;

  public UserController() {
    this.users = new ArrayList<>();
    this.emails = new HashSet<>();
    this.userNames = new HashSet<>();
    this.loadUsers();

    this.idCounter = users.size() + 1;
  }

  public void addUser(String fullName, String email, String userName, String password) {
    String id = String.valueOf(idCounter++);
    this.emails.add(email);
    this.userNames.add(userName);

    this.addUser(fullName, email, userName, password, id);
  }

  public void addUser(String fullName, String email, String userName, String password, String id) {
    users.add(new User(fullName, email, userName, password, id));
  }

  public void printUsers() {
    for (User user : users) {
      System.out.println(user);
    }
  }

  // This method is used to check if the email is taken or not
  public boolean isEmailTaken(String email) {
    return this.emails.contains(email);
  }

  // This method is used to check if the user name is taken or not
  public boolean isUserNameTaken(String userName) {
    return this.userNames.contains(userName);
  }

  // This method is used to check if the user exists in the system, if it does, it
  // returns the user id, otherwise it returns -1
  public int isUserExist(String userName, String password) {
    for (User user : users) {
      if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
        return Integer.valueOf(user.getId());
      }
    }

    return -1;
  }

  public String getUserFullName(int id) {
    for (User user : users) {
      if (Integer.valueOf(user.getId()) == id) {
        return user.getFullName();
      }
    }

    return "";
  }

  // This method is used to save the users to a file
  public void saveUsers() {
    try (PrintWriter writer = new PrintWriter("users.txt")) {
      System.out.println("Saving users...");
      for (User user : users) {
        // fullName,email,userName,password,id
        writer.println(user);
      }
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }

  }

  // This method is used to load the users from a file
  public void loadUsers() {
    try (Scanner scanner = new Scanner(new File("users.txt"))) {
      while (scanner.hasNextLine()) {
        String[] data = scanner.nextLine().split(",");
        // fullName,email,userName,password,id
        this.addUser(data[0], data[1], data[2], data[3], data[4]);
      }
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
