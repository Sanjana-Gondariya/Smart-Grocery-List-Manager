public class Item{
    public String Name;
    public int quantity;

    public Item(String name, int quantity) {
        this.Name = name;
        this.quantity = quantity;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getName() {
        return this.Name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return this.quantity;
    }
}