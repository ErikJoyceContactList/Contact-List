package contact;
import util.Input;
//import util.FileHandlerOld;
import util.FileHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import static com.sun.deploy.perf.DeployPerfUtil.write;

public class ContactApplication {
    Input input = new Input();

    public static void main(String[] args) throws IOException {
        ArrayList<Contact> contactList = new ArrayList<>();
        ArrayList<String> phoneBook = new ArrayList<>();

        menu(phoneBook,contactList);


    }

    public static void menu(ArrayList<String> phoneBook, ArrayList<Contact> contactList) throws IOException {
        Input input = new Input();
        FileHandler fileHandler = new FileHandler("Contacts","contacts.txt");
        int userInput;
        do {
            System.out.println("\nPhone Application\n");
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
                    displayContacts(fileHandler);
                    break;
                case 2:
                    buildList(phoneBook, contactList, fileHandler);
                    break;
                case 3:
//                    System.out.println(filehandler.findNumber());
                    break;
                case 4:
//                    filehandler.deleteContact();
                    break;
                case 5:
                    System.out.println("You have quit the application.");
                    break;
            }
        } while(userInput!=5);

    }
    public static void displayContacts(FileHandler fileHandler){
        List<String> aList=fileHandler.retrieveFileContents();
        String aName, aNumber;
        int commaIndex;
        System.out.println("Name | Phone Number");

        System.out.println("-------------------");

        for (int i = 0; i < aList.size(); i++) {
            commaIndex = aList.get(i).indexOf(",");
            aName = aList.get(i).substring(0, commaIndex);
            aNumber = aList.get(i).substring(commaIndex + 2);
            System.out.println(aName + " | " + aNumber);
        }
    }
    public static void buildList(ArrayList<String> phoneBook, ArrayList<Contact> contactList, FileHandler fileHandler) throws IOException{
        Input input = new Input();
        ArrayList<String> aTemp=new ArrayList<>();

        System.out.println("Enter name of contact:");
        System.out.print("> ");
        String name = input.getString().trim();

        System.out.println("Enter number of contact:");
        System.out.print("> ");
        String number = input.getString().trim();


        // Add a string to String ArrayList
        phoneBook.add(name + ", " + number);
        aTemp.add(name +", "+number);
        fileHandler.writeToFile(aTemp);

        // Add an object to Contact ArrayList
        Contact temp = new Contact(name, number);
        contactList.add(temp);
    }
}
