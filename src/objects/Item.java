package objects;

public class Item {
    public String name;
    public int quantity;

    // Constructor
    public Item(String name, int quantity) {
        // Disallow empty names
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Item name cannot be null or blank.");
        }
        this.name = name;
        this.quantity = quantity;
    }

    // Getters
    public String getName() {
        return this.name;
    }

    public int getQuantity() {
        return this.quantity;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    // Used for typo-fixing; use addQuantity() and removeQuantity() for usual editing
    public void setQuantity(int quantity) {
        // Disallow negative quantities
        if (quantity < 0) {
            System.out.println("Invalid input. Please enter a non-negative integer as the quantity.");
            return;
        }
        this.quantity = quantity;
    }

    public void addQuantity(int quantity) {
        // Disallow negative quantities
        if (quantity < 0) {
            System.out.println("Invalid input. Please enter a non-negative integer as the quantity.");
            return;
        }
        this.quantity += quantity;
    }

    public void removeQuantity(int quantity) {
        // Disallow negative quantities and ensure amount to remove is less than current quantity
        if (quantity < 0 || quantity > this.quantity) {
            System.out.println("Invalid input. Please enter a non-negative integer, less than the current quantity, as the quantity.");
            return;
        }
        this.quantity -= quantity;
    }

    // Prints Item info in form "[name] x[quantity]"
    @Override
    public String toString() {
        return (this.getName() + " x" + this.getQuantity());
    }
}

