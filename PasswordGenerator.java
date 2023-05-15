package trashing;

import java.security.SecureRandom;

public class PasswordGenerator {
    private static final String LOWERCASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMERIC_CHARACTERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}<>.,:;?/~";

    public static String generatePassword(int length, boolean includeLowercase, boolean includeUppercase, boolean includeNumeric, boolean includeSpecial) {
        if (!(includeLowercase || includeUppercase || includeNumeric || includeSpecial)) {
            throw new IllegalArgumentException("At least one character set must be included.");
        }

        StringBuilder passwordBuilder = new StringBuilder(length);
        SecureRandom random = new SecureRandom();

        String characters = "";
        if (includeLowercase) {
            characters += LOWERCASE_CHARACTERS;
        }
        if (includeUppercase) {
            characters += UPPERCASE_CHARACTERS;
        }
        if (includeNumeric) {
            characters += NUMERIC_CHARACTERS;
        }
        if (includeSpecial) {
            characters += SPECIAL_CHARACTERS;
        }

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            passwordBuilder.append(randomChar);
        }

        return passwordBuilder.toString();
    }

    public static void main(String[] args) {
        // Example usage: Generate a password with length 10, including lowercase, uppercase, and numeric characters.
        String password = generatePassword(10, true, true, true, false);
        System.out.println("Generated password: " + password);
    }
}
