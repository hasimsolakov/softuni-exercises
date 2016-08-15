package solutions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bunker {
    private static LinkedList<String> bunkersNames = new LinkedList<>();
    private static String firstBunkerName;

    private static boolean tryAddWeapon(int weapon, int capacity, LinkedList<Integer> weapons){
        if (capacity < weapon){
            return false;
        }

        if (weapons.size() == 0){
            weapons.addFirst(weapon);
        }
        else{
            int currentFullness = weapons.getFirst();
            Integer freeSpaceLeft = capacity - currentFullness;
            if (freeSpaceLeft < weapon){
                return false;
            }

            weapons.set(0, currentFullness + weapon);
        }

        weapons.add(weapon);
        return true;
    }

    private static void freeSpaceForWeapon(int weapon, int freeSpace, LinkedList<Integer> weapons){
        while (weapons.size() != 1){
            int removedWeapon = weapons.remove(1);
            weapons.set(0, weapons.getFirst() - removedWeapon);
            freeSpace += removedWeapon;
            if (freeSpace >= weapon){
               return;
            }
        }
    }

    public static void main(String[] args)  throws IOException{
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        int bunkerMaxCapacity = Integer.parseInt(scanner.readLine());
        Map<String, LinkedList<Integer>> bunkers = new HashMap<>();
        String input;
        while (!(input = scanner.readLine()).equals("Bunker Revision")) {
            String [] inputs = input.split(" ");
            fillInputs(bunkers, inputs, bunkerMaxCapacity);
        }
    }
    private static void fillInputs(Map<String, LinkedList<Integer>> bunkers, String[] inputs, int capacity) {
        for (String input : inputs) {
            if (Character.isAlphabetic(input.toCharArray()[0])){
                bunkersNames.add(input);
                if (bunkersNames.size() == 1){
                    firstBunkerName = bunkersNames.getFirst();
                }

                bunkers.put(input, new LinkedList<>());
            }
            else{
                fitInWeapon(Integer.parseInt(input), capacity, bunkers);
            }
        }
    }

    private static void fitInWeapon(int weapon, int capacity, Map<String, LinkedList<Integer>> bunkers){
        LinkedList<Integer> bunkerWeapons;
        if (bunkers.size() > 0){
            bunkerWeapons = bunkers.get(firstBunkerName);
        }
        else {
            return;
        }

        boolean result = tryAddWeapon(weapon, capacity, bunkerWeapons);
        if (!result){
            if (bunkers.size() == 1){
                if (capacity >= weapon){
                    int bunkerFreeSpace = capacity - bunkerWeapons.getFirst();
                    freeSpaceForWeapon(weapon, bunkerFreeSpace, bunkerWeapons);
                    tryAddWeapon(weapon, capacity, bunkerWeapons);
                }
            }
            else {
                LinkedList<Integer> removedBunkerWeapons = bunkers.remove(firstBunkerName);
                bunkersNames.removeFirst();
                print(firstBunkerName, removedBunkerWeapons);
                firstBunkerName = bunkersNames.getFirst();
                fitInWeapon(weapon, capacity, bunkers);
            }
        }
    }

    private static void print(String bunkerName, LinkedList<Integer> weapons){
        String weaponsAsString = "Empty";
        if (weapons.size() != 0){
            StringBuilder builder = new StringBuilder(weapons.size());
            for (int i = 1; i <weapons.size(); i++) {
                builder.append(weapons.get(i));
                if (i == weapons.size() - 1){
                    break;
                }

                builder.append(", ");
            }
            weaponsAsString = builder.toString();
        }

        System.out.println(bunkerName + " -> " + weaponsAsString);
    }
}
