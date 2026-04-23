import java.util.Stack;

public class EmployeeStackDemo {

    public static void main(String[] args) {

        Stack<String> employeeActions = new Stack<>();

        employeeActions.push("Employee 101 signed in");
        employeeActions.push("Employee 105 started a new task");
        employeeActions.push("Employee 102 updated a report");
        employeeActions.push("Employee 112 joined a meeting");
        employeeActions.push("Employee 105 finished the task");

        System.out.println("Current Stack: " + employeeActions);

        employeeActions.push("Employee 101 signed out");
        System.out.println("Updated Stack: " + employeeActions);
    }
}


