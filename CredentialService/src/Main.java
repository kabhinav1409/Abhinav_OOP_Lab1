import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the department from the following:");
        System.out.println("1. Technical");
        System.out.println("2. Admin");
        System.out.println("3. Human Resource");
        System.out.println("4. Legal");

        int departmentChoice = scanner.nextInt();
        String department;

        switch (departmentChoice) {
            case 1:
                department = "Technical";
                break;
            case 2:
                department = "Admin";
                break;
            case 3:
                department = "Human Resource";
                break;
            case 4:
                department = "Legal";
                break;
            default:
                System.out.println("Invalid choice. Exiting...");
                return;
        }

        System.out.print("Please enter the first name: ");
        String firstName = scanner.next();

        System.out.print("Please enter the last name: ");
        String lastName = scanner.next();

        Employee employee = new Employee(firstName, lastName, department);
        CredentialService credentialService = new CredentialService();
        credentialService.showCredentials(employee);
    }
}