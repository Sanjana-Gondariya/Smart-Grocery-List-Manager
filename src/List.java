import java.util.ArrayList;

public class List {
    private ArrayList<Item> items;

    public List() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item){
        this.items.add(item);
    }

    public ArrayList<Item> getItems(){
        return this.items;
    }

    public void removeItem(Item item){
        items.remove(item);
    }

    public void updateList(ArrayList<Item> updatedItems){
        this.items = new ArrayList<>(updatedItems);
    }
}
