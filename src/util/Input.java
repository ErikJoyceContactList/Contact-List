package util;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Input extends Exception {

//    scanner property
    private Scanner scanner;

//    Constructor
    public Input(){
        scanner=new Scanner(System.in);
    }

//    methods of Input class
    public String getString(){
        return scanner.nextLine();
    }

    public boolean yesNo(){
        String userChoice=scanner.nextLine();
        if(userChoice.equalsIgnoreCase("y") ||userChoice.equalsIgnoreCase("yes")){
            return true;
        }else{
            return false;
        }
    }

    public int getInt(int min, int max){
        try{
            int userInt=Integer.valueOf(getString());
            if (userInt>=min && userInt<=max){
                return userInt;
            }else{return getInt(min,max);}

        }catch(NumberFormatException e){
            return getInt(min, max);
        }
    }

    public int getInt(){
        try{
            return Integer.valueOf(getString());
        }catch (NumberFormatException e){
            System.out.println("Please input an integer");
            return getInt();
        }
    }

    public double getDouble(double min, double max){
        try{
            double userDouble=Double.valueOf(getString());
            if (userDouble>=min && userDouble<=max){
                return userDouble;
            }else{return getDouble(min,max);}

        }catch(NumberFormatException e){
            return getDouble(min, max);
        }
    }

    public double getDouble(){
        try{
            return Double.valueOf(getString());
        }catch (NumberFormatException e){
            System.out.println("Please input a double");
            return getDouble();
        }
    }

    public int getBinary(){
        try{
            return Integer.valueOf(getString(),2);
        }catch(NumberFormatException e){
            System.out.println("Please give us an integer to convert");
            return getBinary();
        }
    }
    public int getHexidecimal(){
        try{
            return Integer.valueOf(getString(),16);
        }catch(NumberFormatException e){
            System.out.println("Please give us an integer to convert");
            return getHexidecimal();
        }
    }
}
