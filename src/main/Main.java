package main;

import java.util.ArrayList; 
import java.util.List;      
import java.util.Scanner;
import objects.*;

public class Main {

    public static void main(String[] args) {
        // Use ArrayList to store objects of type Item
        List<Item> itemsList = new ArrayList<>(); 
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Demo: add <name> <qty> | list | remove <name> | quit");
        
        while (true) {
            System.out.print("> ");
            
            // Read the command
            String cmd = sc.next(); 

            if (cmd.equalsIgnoreCase("add")) {
                String name = sc.next();
                int q = sc.nextInt();
                
                // Use the standard 'add' method of ArrayList
                itemsList.add(new Item(name, q)); 
                System.out.println("added: " + name);

            } else if (cmd.equalsIgnoreCase("list")) {
                // Iterate directly over the itemsList
                for (Item it : itemsList) { 
                    System.out.println(it.getName() + " x" + it.getQuantity());
                }

            } else if (cmd.equalsIgnoreCase("remove")) {
                String name = sc.next();
                Item target = null;
                
                // Iterate over the list to find the target item
                for (Item it : itemsList) { 
                    if (it.getName().equalsIgnoreCase(name)) {
                        target = it;
                        break; // Found it, exit loop
                    }
                }
                
                if (target != null) {
                    // Use the standard 'remove' method of ArrayList
                    itemsList.remove(target); 
                    System.out.println("removed");
                } else {
                    System.out.println("not found");
                }

            } else if (cmd.equalsIgnoreCase("quit")) {
                break;
            } else {
                System.out.println("unknown command");
            }
        }
        sc.close();
    }
}

