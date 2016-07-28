package Main;

import java.util.Scanner;

public class Problem10_IndexOfLetters {
    public static void main(String[] args) {

        char [] lettersArray = new char[26];
        for (int i = 0, letterValue = 'a'; i < 26; i++, letterValue++) {
            lettersArray[i] = (char)letterValue;
        }

        Scanner scanner = new Scanner(System.in);
        char [] wordAsCharArray = scanner.nextLine().toCharArray();
        for (char letter:
             wordAsCharArray) {
            int index = new String(lettersArray).indexOf(letter);
            System.out.println(letter + " -> " + index);
        }
    }
}
