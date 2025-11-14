package objects;

public class Item {
    public String Name;
    public int quantity;

    public Item(String name, int quantity) {
        this.Name = name;
        this.quantity = quantity;
    }

    // Getters are used by the Main class
    public String getName() {
        return this.Name;
    }

    public int getQuantity() {
        return this.quantity;
    }
    
    // Setters are available but not used in the Main class logic
    public void setName(String name) {
        this.Name = name;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

