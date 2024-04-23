import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        UserController userController = new UserController();

        LoginUI ui = new LoginUI(scanner, userController);

        int currentUser = ui.start();

        // save the users to the file before exiting
        userController.saveUsers();
    }
}
