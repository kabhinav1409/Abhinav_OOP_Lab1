import java.util.Random;

public class CredentialService {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+";

    public String generatePassword() {
        int passwordLength = 8;
        StringBuilder password = new StringBuilder();
        Random random = new Random();

        password.append(generateRandomChar(CHARACTERS, random));  // Capital letter
        password.append(generateRandomChar(CHARACTERS.toLowerCase(), random));  // Small letter
        password.append(generateRandomChar("0123456789", random));  // Number
        password.append(generateRandomChar("!@#$%^&*()_+", random));  // Special character

        for (int i = 4; i < passwordLength; i++) {
            int index = random.nextInt(CHARACTERS.length());
            password.append(CHARACTERS.charAt(index));
        }

        return password.toString();
    }

    private char generateRandomChar(String characters, Random random) {
        int index = random.nextInt(characters.length());
        return characters.charAt(index);
    }

    public String generateEmailAddress(Employee employee) {
        String email = employee.getFirstName().toLowerCase() + employee.getLastName().toLowerCase() +
                "@" + employee.getDepartment().toLowerCase() + ".company.com";
        return email;
    }

    public void showCredentials(Employee employee) {
        String email = generateEmailAddress(employee);
        String password = generatePassword();

        System.out.println("Dear " + employee.getFirstName() + " your generated credentials are as follows");
        System.out.println("Email ---> " + email);
        System.out.println("Password ---> " + password);
    }
}