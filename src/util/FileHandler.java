package util;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileHandler {
//        Private values
    private String directory, fileName;
    private Path directoryPath, filePath;
//Getters
    public String getDirectory() {
        return directory;
    }

    public String getFileName() {
        return fileName;
    }
//    Filehandler constructor
    public FileHandler(String directory, String fileName){
        this.directory=directory;
        this.fileName=fileName;

        this.directoryPath=Paths.get(directory);
        this.createDirectoryIfNotExist();

        this.filePath=Paths.get(directory, fileName);
        this.createFileIfNotExist();
    }
    public FileHandler(String fileName){
        this.fileName=fileName;
        this.createFileIfNotExist();
        this.filePath=Paths.get(fileName);
    }
    //    1. Create a method to create the file if it does not exist.
    private boolean createFileIfNotExist(){
        try{
            if(!Files.exists(this.filePath)){
                Files.createFile(this.filePath);

            }
        }catch (IOException e){
            return false;
        }
        return true;
    }

//    2. Create a method to create the directory if it does not exist.
    private boolean createDirectoryIfNotExist(){
        try{
            if(!Files.exists(this.directoryPath)){
                Files.createDirectory(this.directoryPath);
            }
        }catch (IOException e){
            return false;
        }
                return true;
    }

//    3. Create a method for retrieving file contents as a List of Strings.
    public List<String> retrieveFileContents(){
        try{
            List<String> contents = Files.readAllLines(Paths.get(directory,fileName));
            return contents;
        }catch (IOException e){
            return null;
        }

    }

// 4. Create a method to write (append) new contents to a file. This method could have an optional parameter to choose
//       between appending the contents of the file or not.
    public boolean writeToFile(List<String> contents, String option){
        try{
            if(option.equalsIgnoreCase("append")){
                Files.write(Paths.get(directory,fileName), contents, StandardOpenOption.APPEND);
            }else{
                Files.write(Paths.get(directory,fileName), contents);
            }
        }catch (IOException e){
            return false;
        }
        return true;
    }
}