package tools;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class PasswordHasher {

    public static String hashPassword(String password) {
        try {
            // Generate random salt
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[16];
            random.nextBytes(salt);

            // Instantiate SHA-256 algorithm w/ salt
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);

            // Hash password
            byte[] hashedPassword = md.digest(password.getBytes());

            // Combine salt and hashed password
            byte[] combined = new byte[salt.length + hashedPassword.length];
            System.arraycopy(salt, 0, combined, 0, salt.length);
            System.arraycopy(hashedPassword, 0, combined, salt.length, hashedPassword.length);

            // Convert to Base64
            return Base64.getEncoder().encodeToString(combined);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean verifyPassword(String password, String storedHash) {
        try {
            // Retrieve Base64 hashed password
            byte[] combined = Base64.getDecoder().decode(storedHash);

            // Extract the salt and the stored hashed password
            byte[] salt = new byte[16];
            System.arraycopy(combined, 0, salt, 0, salt.length);
            byte[] storedHashedPassword = new byte[combined.length - salt.length];
            System.arraycopy(combined, salt.length, storedHashedPassword, 0, storedHashedPassword.length);

            // Hash password to verify w/ salt
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] providedHashedPassword = md.digest(password.getBytes());

            // Compare the newly generated hash with the stored hash
            return MessageDigest.isEqual(providedHashedPassword, storedHashedPassword);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }
    }
}
