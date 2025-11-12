import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List list = new List();
        Scanner sc = new Scanner(System.in);
        System.out.println("Demo: add <name> <qty> | list | remove <name> | quit");
        while (true) {
            System.out.print("> ");
            String cmd = sc.next();
            if (cmd.equalsIgnoreCase("add")) {
                String name = sc.next();
                int q = sc.nextInt();
                list.addItem(new Item(name, q));
                System.out.println("added: " + name);
            } else if (cmd.equalsIgnoreCase("list")) {
                for (Item it : list.getItems()) {
                    System.out.println(it.getName() + " x" + it.getQuantity());
                }
            } else if (cmd.equalsIgnoreCase("remove")) {
                String name = sc.next();
                Item target = null;
                for (Item it : list.getItems()) {
                    if (it.getName().equalsIgnoreCase(name)) {
                        target = it;
                        break;
                    }
                }
                if (target != null) {
                    list.removeItem(target);
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
