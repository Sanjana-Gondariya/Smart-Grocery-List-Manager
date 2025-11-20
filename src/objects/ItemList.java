package objects;

import java.util.ArrayList;

// Behaves as an ArrayList
public class ItemList extends ArrayList<Item> {
    // Overloaded remove method to enable partial removal of an Item
    public void remove(Item item, int quantity) {
        for (Item it : this) {
            if (it.getName().equalsIgnoreCase(item.getName())) {
                it.removeQuantity(quantity);
                break;
            }
        }
    }
    // Search ItemList for an Item name and return a copy if it exists
    public Item search(String name) {
        Item target = null;
        for (Item it : this) {
            if ((it.getName()).equalsIgnoreCase(name)) {
                target = it;
            }
        }
        return target;
    }
}

