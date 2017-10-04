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
            for(int i=0; i<printedList.size();i++){
                System.out.println(i+ ": "+printedList.get(i));
            }

        }
//    Create a method to write(append) new contents to a file. Optional parameter choose to append or overwrite
        public void writeFile(ArrayList<String> list) throws IOException {
            Files.write(path, list, StandardOpenOption.APPEND);
        }

}
