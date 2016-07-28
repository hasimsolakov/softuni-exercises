package Main;

import java.util.Scanner;

public class Problem4_VowelOrDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        char symbol = line.charAt(0);
        boolean isDigit = Character.isDigit(symbol);
        if (isDigit){
            System.out.println("digit");
            return;
        }

        boolean isVowel = isVowel(symbol);
        if (isVowel){
            System.out.println("vowel");
            return;
        }

        System.out.println("other");
    }

    private static boolean isVowel(char character){
        return "aieuo".indexOf(
                Character.toLowerCase(character)) >= 0;
    }
}
