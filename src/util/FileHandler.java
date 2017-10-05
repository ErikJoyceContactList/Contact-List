package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import contact.Contact;

public class FileHandler{
    private String directory, fileName;
    private Path path = Paths.get("Contacts", "contacts.txt");

    public static void main (String[] args) throws IOException {
        FileHandler filehandler = new FileHandler();
        filehandler.makeFile();
    }

//    method to create a file if it does not exist
//    method to create a directory if it does not exist
        public void makeFile()throws IOException{
            if (!Files.exists(path.getParent())) {
                Files.createDirectory(path.getParent());
            } if (!Files.exists(path)) {
                Files.createFile(path);
            }
        }

//    method for retrieving file contents as a List of Strings
        public void getContacts() throws IOException {
            Path printList = Paths.get("Contacts","contacts.txt");
            List<String> printedList = Files.readAllLines(printList);
            String aName, aNumber;
            int commaIndex;
            System.out.println("Name | Phone Number");

            System.out.println("-------------------");

            for(int i=0 ; i < printedList.size() ; i++){
                commaIndex=printedList.get(i).indexOf(",");
                aName=printedList.get(i).substring(0,commaIndex);
                aNumber=printedList.get(i).substring(commaIndex+2);
                System.out.println(aName+" | "+aNumber);
            }

        }
//    Create a method to write(append) new contents to a file. Optional parameter choose to append or overwrite
        public void writeFile(List<String> list, String rewrite) throws IOException {
            List<String> contactList = Files.readAllLines(Paths.get("Contacts", "contacts.txt"));

            Boolean id = true;

            for (int i = 0; i < contactList.size(); i++) {

                if (contactList.toArray()[i].equals(list.toArray()[0])) {

                    System.out.println("This item already exists. Please enter a unique entry.");

                    id = false;

                    break;
                }

            }


            if (id) {
                if (rewrite.equalsIgnoreCase("y")) {
                    Files.write(path, list);
                } else {
                    Files.write(path, list, StandardOpenOption.APPEND);
                }
            }
        }

//    Create a method to find and retrieve a phone number using a name

        public String findNumber() throws IOException {
            Input input = new Input();
            List<String> numbers = Files.readAllLines(Paths.get("Contacts", "contacts.txt"));

            System.out.println("Enter a contact name:");
            String userInput = input.getString();

            for (String number : numbers) {
                if (number.substring(0, userInput.length()).equals(userInput)) {
                    return number.substring(userInput.length() + 2);
                }
            }

            return "Contact not found";
        }

//      Create a method to find and delete a phone number using a name

        public void deleteContact() throws IOException {
            Input input = new Input();
            List<String> contactList = Files.readAllLines(Paths.get("Contacts", "contacts.txt"));
            List<String> newList = new ArrayList<>();

            System.out.println("Enter a contact name:");
            String userInput = input.getString();

            for (String contact : contactList) {
                if (contact.substring(0, userInput.length()).equals(userInput)) {
                    continue;
                }

                newList.add(contact);
            }

            writeFile(newList,"y");

        }
}
