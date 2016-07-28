package Main;

import java.util.Scanner;

public class Problem2_BooleanVariable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        boolean bool = Boolean.parseBoolean(input);
        System.out.println(bool ? "Yes" : "No");
    }
}
