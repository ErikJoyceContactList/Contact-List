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
        public void getContacts() throws IOException{
            Path printList= Paths.get("Contacts","contacts.txt");
            List<String> printedList=Files.readAllLines(printList);
            for(int i=0 ; i < printedList.size() ; i++){
                System.out.println(i+ ": "+printedList.get(i));
            }

        }
//    Create a method to write(append) new contents to a file. Optional parameter choose to append or overwrite
        public void writeFile(List<String> list, String rewrite) throws IOException {
            if(rewrite.equalsIgnoreCase("y")){
                Files.write(path, list);
            }else {
                Files.write(path, list, StandardOpenOption.APPEND);
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
            List<String> numbers = Files.readAllLines(Paths.get("Contacts", "contacts.txt"));
            List<String> newList = new ArrayList<>();

            System.out.println("Enter a contact name:");
            String userInput = input.getString();

            for (String number : numbers) {
                System.out.println(number);
                System.out.println(number.substring(0,2));
                if (number.substring(0, userInput.length()).equals(userInput)) {
                    continue;
                }

                newList.add(number);
            }

            writeFile(newList,"y");

        }
}
