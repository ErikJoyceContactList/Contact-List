import util.Input;

import java.util.ArrayList;

public class ContactApplication {
    public static void main(String[] args) {
        ArrayList<Contact> contactList =new ArrayList<>();
        Contact bill= new Contact("Bill","215-435-2198");
        System.out.println(bill.getName()+" "+bill.getPhone());
        contactList.add(bill);
        System.out.println(contactList);
        System.out.println(contactList.get(0).getName());
        menu();
    }
    public static void menu() {
        Input input = new Input();
        int userInput;
        do {
            System.out.println("Phone Application\n");
            System.out.println("-----------------\n");
            System.out.println("1. View contacts.");
            System.out.println("2. Add a new contact.");
            System.out.println("3. Search a contact by name.");
            System.out.println("4. Delete an existing contact.");
            System.out.println("5. Exit.");
            System.out.println("Enter an option (1, 2, 3, 4, or 5)");
            System.out.print("> ");
            userInput = input.getInt(1, 5);
            switch (userInput) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("You have quit the application.");
                    break;
            }
        }while(userInput!=5);
    }
}
