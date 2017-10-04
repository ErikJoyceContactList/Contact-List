package contact;

import contact.Contact;
import util.Input;
import util.FileHandler;

import java.io.IOException;
import java.util.ArrayList;


import static com.sun.deploy.perf.DeployPerfUtil.write;

public class ContactApplication {
    public static void main(String[] args) throws IOException {
        ArrayList<Contact> contactList =new ArrayList<>(); //This needs to be a string list to write to a file
        FileHandler filehandler = new FileHandler();

        Contact bill= new Contact("Bill","215-435-2198");

        System.out.println(bill.getName()+" "+bill.getPhone());
        contactList.add(bill);
        System.out.println(contactList);
        System.out.println(contactList.get(0).getName());
        filehandler.makeFile(); //This does not work since it is a new object?
        filehandler.writeFile(contactList);

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
