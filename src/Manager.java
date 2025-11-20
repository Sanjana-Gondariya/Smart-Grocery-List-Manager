import java.util.InputMismatchException;
import java.util.Scanner;
import objects.*;

public class Manager {

    public static void main(String[] args) {
        // Creates List of type ItemList, which behaves as an ArrayList
        ItemList itemsList = new ItemList();

        // Try-catch to make sure resources properly close in the event of an error
        try(Scanner sc = new Scanner(System.in)) {
            // Demo menu navigation
            System.out.println("Demo: add <name> <qty> | list | remove <name> | edit <name> | quit");

            // User input loop; exits upon "quit"
            while (true) {
                System.out.print("> ");
                // Checking that Scanner has more input
                String cmd;
                if (sc.hasNext()) {
                    cmd = sc.next();
                }
                else {
                    break;
                }

                String itemName;
                // ADD command
                if (cmd.equalsIgnoreCase("add")) {
                    // Checking that Scanner has more input
                    if (sc.hasNext()) {
                        itemName = sc.next();
                    }
                    else {
                        break;
                    }
                    int quantity;
                    try {
                        // Checking that Scanner has more input
                        if (sc.hasNext()) {
                            quantity = sc.nextInt();
                        } else {
                            break;
                        }
                    }
                    // If input was not an integer, catch exception and reset loop
                    catch(InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a non-negative integer as the quantity.");
                        // Clearing Scanner
                        sc.nextLine();
                        continue;
                    }

                    // If ItemList is empty, add item
                    if (itemsList.isEmpty()) {
                        itemsList.add(new Item(itemName, quantity));
                    }
                    // If ItemList is not empty, check if item already exists and add accordingly
                    else {
                        for (Item it : itemsList) {
                            if (it.getName().equalsIgnoreCase(itemName)) {
                                it.addQuantity(quantity);
                                break;
                            }
                        }
                    }
                    System.out.println("Added: " + itemName + " x" + quantity);

                }
                // LIST command
                else if (cmd.equalsIgnoreCase("list")) {
                    // If ItemList has Items, iterate and display
                    if (!itemsList.isEmpty()) {
                        for (Item it : itemsList) {
                            System.out.println(it);
                        }
                    }
                    // If ItemList lacks items, print message saying so
                    else {
                        System.out.println("Your list is empty. Add some items!");
                    }

                }
                // REMOVE command
                else if (cmd.equalsIgnoreCase("remove")) {
                    // Checking that Scanner has more input
                    if (sc.hasNext()) {
                        itemName = sc.next();
                    }
                    else {
                        break;
                    }

                    // Search for Item to remove in ItemList
                    Item target = itemsList.search(itemName);
                    // If Item exists, prompt for amount to remove
                    if (target != null) {
                        System.out.println(target + " found in list. How many would you like to remove?");
                        int quantity;
                        try {
                            // Checking that Scanner has more input
                            if (sc.hasNext()) {
                                quantity = sc.nextInt();
                            } else {
                                break;
                            }
                        }
                        // If input was not an integer, catch exception and reset loop
                        catch(InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a non-negative integer as the quantity.");
                            // Clearing Scanner
                            sc.nextLine();
                            continue;
                        }

                        // Remove amount of Item requested; if quantity reaches zero, remove Item
                        System.out.println("Removing x" + quantity + " from " + target);
                        itemsList.remove(target, quantity);
                        if (quantity == target.getQuantity()) {
                            itemsList.remove(target);
                        }

                    }
                    // If Item doesn't exist, print message saying so
                    else {
                        System.out.println(itemName + " not found.");
                    }

                }
                // EDIT command
                else if (cmd.equalsIgnoreCase("edit")) {
                    String newName;
                    int newAmount;
                    // Checking that Scanner has more input
                    if (sc.hasNext()) {
                        itemName = sc.next();
                    }
                    else {
                        break;
                    }
                    // Accept new name or new quantity
                    System.out.println("Enter 'name <new name>' or 'amount <new amount>'");
                    // Checking that Scanner has more input
                    if (sc.hasNext()) {
                        cmd = sc.next();
                    }
                    else {
                        break;
                    }
                    // EDIT: NAME command
                    if (cmd.equalsIgnoreCase("name")) {
                        // Checking that Scanner has more input
                        if (sc.hasNext()) {
                             newName = sc.next();
                        }
                        else {
                            break;
                        }
                        // Find Item and rename it
                        for (Item it : itemsList) {
                            if (it.getName().equalsIgnoreCase(itemName)) {
                                it.setName(newName);
                                break;
                            }
                        }
                    }
                    // EDIT: AMOUNT command
                    else if (cmd.equalsIgnoreCase("amount")) {
                        try {
                            // Checking that Scanner has more input
                            if (sc.hasNext()) {
                                newAmount = sc.nextInt();
                            } else {
                                break;
                            }
                        }
                        // If input was not an integer, catch exception and reset loop
                        catch(InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a non-negative integer as the quantity.");
                            // Clearing Scanner
                            sc.nextLine();
                            continue;
                        }
                        // Find Item and set new quantity
                        for (Item it : itemsList) {
                            if (it.getName().equalsIgnoreCase(itemName)) {
                                it.setQuantity(newAmount);
                                break;
                            }
                        }
                    }
                    // Unrecognized command
                    else {
                        System.out.println("Invalid input.");
                    }
                }
                // QUIT command
                else if (cmd.equalsIgnoreCase("quit")) {
                    break;
                }
                // Unrecognized command
                else {
                    System.out.println("Unknown command.");
                }
            }
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }
}


