package objects;

import tools.EmailValidator;
import tools.PasswordHasher;
import java.util.UUID;

public class UserAccount {
    // UUID should never change for a user
    private final UUID userID;
    private String email;
    private String name;
    private String passwordHash;

    public UserAccount(UUID userID, String name, String email, String password) {
        // Disallow empty values and validate email format via regex
        if (!EmailValidator.isValidEmail(email) || (name == null || name.isBlank())
        || (password == null || password.isBlank()) || (userID == null)) {
            throw new IllegalArgumentException("Invalid arguments.");
        }
        // Generate UUID (8-4-4-4-12 hexadecimal digits)
        this.userID = UUID.randomUUID();
        this.name = name;
        this.email = email;
        // Hash password instead of storing directly
        this.passwordHash = PasswordHasher.hashPassword(password);
    }

    // Check if entered password matches stored hash
    private void checkPassword(String password) {
        if (PasswordHasher.verifyPassword(password, this.passwordHash)) {
            System.out.println("Correct password.");
        }
        else {
            System.out.println("Incorrect password.");
        }
    }

    // Getters
    private UUID getUserID() {
        return userID;
    }

    private String getEmail() {
        return email;
    }

    private String getName() {
        return name;
    }

    private String getPasswordHash() {
        return passwordHash;
    }

    // Setters
    private void setEmail(String email) {
        this.email = email;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

}

