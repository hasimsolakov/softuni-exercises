package Main;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Problem23_PhonebookUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, String> phonebook = new TreeMap<>();
        String command;
        while(!(command = scanner.nextLine()).equals("END")){
            String [] commandSplitted = command.split(" ");
            String action = commandSplitted[0];
            String name = null;
            if (commandSplitted.length > 1){
                name = commandSplitted[1];
            }
            if (action.equals("A")){
                String number = commandSplitted[2];
                if (phonebook.containsKey(name)){
                    phonebook.replace(name,number);
                }
                else{
                    phonebook.put(name, number);
                }

            }
            else if(action.equals("ListAll")){
                for (String key : phonebook.keySet()) {
                    System.out.println(key + " -> " + phonebook.get(key));
                }
            }
            else if(action.equals("S")){
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
