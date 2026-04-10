import java.util.ArrayList;
import java.util.Scanner;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() { return username; }
    public boolean check(String p) { return this.password.equals(p); }
    
    public void showRoleInfo() {
        System.out.println("Login Success! Role: Standard User");
    }
}

class AdminUser extends User {
    public AdminUser(String username, String password) {
        super(username, password);
    }
    @Override
    public void showRoleInfo() {
        System.out.println("Login Success! Role: Administrator");
    }
}

public class LoginApp {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("admin", "1234"));
        users.add(new AdminUser("boss", "999"));

        Scanner sc = new Scanner(System.in);
        
        try {
            System.out.println("=== Terminal Login System ===");
            System.out.print("Username: ");
            String u = sc.nextLine();
            System.out.print("Password: ");
            String p = sc.nextLine();

            boolean found = false;
            for (User user : users) {
                if (user.getUsername().equals(u) && user.check(p)) {
                    user.showRoleInfo();
                    found = true;
                    break;
                }
            }

            if (!found) {
                throw new Exception("Error: Invalid Login.");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("System Finished.");
            sc.close();
        }
    }
}