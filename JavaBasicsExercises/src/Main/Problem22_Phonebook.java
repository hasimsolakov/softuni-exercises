package Main;

import java.util.HashMap;
import java.util.Scanner;

public class Problem22_Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> phonebook = new HashMap<>();
        String command;
        while(!(command = scanner.nextLine()).equals("END")){
            String [] commandSplitted = command.split(" ");
            String action = commandSplitted[0];
            String name = commandSplitted[1];
            if (action.equals("A")){
                String number = commandSplitted[2];
                if (phonebook.containsKey(name)){
                    phonebook.replace(name,number);
                }
                else {
                    phonebook.put(name, number);
                }
            }
            else{
                String contactNumber = phonebook.get(name);
                if (contactNumber == null){
                    System.out.println("Contact " + name + " does not exist.");
                }
                else{
                    System.out.println(name + " -> " + contactNumber);
                }
            }
        }
    }
}

