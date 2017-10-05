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
        String test="a";
        System.out.println(Integer.parseInt(test)/1);
        System.out.println(validateNumber("123-456-7890"));
        System.out.println(validateNumber("a23-456-7890"));
        System.out.println(validateNumber("123a456-7890"));
        menu(phoneBook,contactList);


    }

    public static void menu(ArrayList<String> phoneBook, ArrayList<Contact> contactList) throws IOException {
        Input input = new Input();
        FileHandler fileHandler = new FileHandler("Contacts","contacts.txt");
        List<String> aList = fileHandler.retrieveFileContents();

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
                    addContact(aList, fileHandler);
                    break;
                case 3:
                    System.out.println("Enter a contact name:");
                    String userName = input.getString();

                    System.out.println(searchContact(aList, userName));
                    break;
                case 4:
                    System.out.println("Enter a contact name:");
                    String deleteUserName = input.getString();
                    deleteContact(aList, deleteUserName, fileHandler);
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

    public static void addContact(List<String> contactList, FileHandler fileHandler) throws IOException{
        Input input = new Input();
        ArrayList<String> aTemp = new ArrayList<>();

        System.out.println("Enter name of contact:");
        System.out.print("> ");
        String name = input.getString().trim();

        System.out.println("Enter number of contact:");
        System.out.print("> ");
        String number = input.getString().trim();
//        number=validateNumber(number);


        // Add a string to String ArrayList
        aTemp.add(name +", "+number);
        String contactListLine;


        Boolean id = true;

        for (int i = 0; i < contactList.size(); i++) {
            contactListLine = contactList.toArray()[i].toString().substring(0, name.length());

            if (contactListLine.equals(name)) {

                System.out.println("This item already exists. Please enter a unique entry.");

                id = false;

                break;
            }

        }

        if (id) {

            fileHandler.writeToFile(aTemp, "append");

        } else {

            System.out.println("This is a duplicated item.");

        }



//        // Add an object to Contact ArrayList
//        Contact temp = new Contact(name, number);
//        contactList.add(temp);
    }
    public static String validateNumber(String phoneNumber){
//        use a try catch to divide by 1 in order to catch the problem.
//        char test='1';
//        if(test==(int)test){
//            System.out.println("it works");
//        }
        String aNum;
            if(phoneNumber.length()==12){
                for(int i=0;i<phoneNumber.length();i++){
//                    System.out.println(aNum);

                    if(i==0 || i==1 || i==2 || i==4 || i==5 || i==6 || i==8 || i==9 || i==10 || i==11){
                        aNum= String.valueOf(phoneNumber.charAt(i));
                        System.out.println(aNum);
                        System.out.println((Integer.valueOf(aNum)));
                        if(!aNum.equals(Integer.parseInt(aNum))){
                            return "The phone number can only use numbers";
                        }

                    }

                    if(i==3 || i==7){
                        if(phoneNumber.charAt(i)!='-'){
                            return "format your number with dashes";
                        }
                    }
                }
             return phoneNumber;
            }
        return "The phone number is not 7 or 10 digits";
    }

    public static String searchContact(List<String> list, String userInput){

        for (String contact : list) {
            if (contact.substring(0, userInput.length()).equals(userInput)) {
                return "Number: " + contact.substring(userInput.length() + 2);
            }
        }

        return null;

    }

    public static void deleteContact(List<String> list, String userInput, FileHandler filehandler) {

        List<String> newList = new ArrayList<>();

        for (String contact : list) {
            if (contact.substring(0, userInput.length()).equals(userInput)) {
                continue;
            }

            newList.add(contact);
        }

        filehandler.writeToFile(newList, "");


    }
}
