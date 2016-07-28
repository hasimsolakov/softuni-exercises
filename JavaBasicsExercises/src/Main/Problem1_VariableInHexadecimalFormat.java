package Main;

import java.util.Scanner;


public class Problem1_VariableInHexadecimalFormat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numberToParse = scanner.nextLine();
        int number = Integer.parseInt(numberToParse, 16);
        System.out.println(number);
    }
}
