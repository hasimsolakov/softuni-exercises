package Main;

import java.util.*;
import java.util.stream.Collectors;

public class Problem17_ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        List<Character> lineAsChars = line
                .chars()
                .mapToObj(character -> (char)character)
                .collect(Collectors
                        .toList());

        Collections.reverse(lineAsChars);
        for (int i = 0; i < lineAsChars.size(); i++) {
            System.out.print(lineAsChars.get(i));
        }

        System.out.println();
    }
}
