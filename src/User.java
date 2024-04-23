public class User {
  private String fullName;
  private String email;
  private String userName;
  private String password;
  private String id;

  public User(String fullName, String email, String userName, String password, String id) {
    this.fullName = fullName;
    this.email = email;
    this.userName = userName;
    this.password = password;
    this.id = id;
  }

  public String getFullName() {
    return fullName;
  }

  public String getUserName() {
    return userName;
  }

  public String getPassword() {
    return password;
  }

  public String getId() {
    return id;
  }

  @Override
  public String toString() {
    return this.fullName + "," + this.email + "," + this.userName + "," + this.password + "," + this.id;
  }

}
