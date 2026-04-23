import java.util.Stack;
import java.util.logging.MemoryHandler;

public class EmployeeStackSearch {
    public static void main(String[] args) {

        Stack<String> employeeActions = new Stack<>();

        employeeActions.push("Login - User 1");
        employeeActions.push("Update Profile - User 2");
        employeeActions.push("Delete File - User 3");
        employeeActions.push("Upload Document - User 4");
        employeeActions.push("Logout - User 1");
        employeeActions.push("Change Password - User 5");

        int pos1 = employeeActions.search("Delete File - User 3");
        int pos2 = employeeActions.search("Login - User 1");

        System.out.println("Position of 'Delete File - User 3': " + pos1);
        System.out.println("Position of 'Login - User 1': " + pos2);


        System.out.println("Exists 'Logout - User 1': " + employeeActions.contains("Logout - User 1"));

        System.out.println("All Actions (Bottom to Top):");
        for (String action : employeeActions) {
            System.out.println(action);
        }

        System.out.println("All Actions (Top to Bottom):");
        for (int i = employeeActions.size() - 1; i >= 0; i--) {
            System.out.println(employeeActions.get(i));
        }


    }
}

