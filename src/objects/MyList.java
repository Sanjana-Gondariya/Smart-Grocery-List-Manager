package objects;

import java.util.ArrayList;

public class MyList {
    private ArrayList<Item> items;

    public MyList() {
        this.items = new ArrayList<>();
    }

    public MyList(ArrayList<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }

    public void removeItem(Item item) {
        this.items.remove(item);
    }

    public void updateList(ArrayList<Item> updatedItems) {
        this.items = new ArrayList<>(updatedItems);
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}

