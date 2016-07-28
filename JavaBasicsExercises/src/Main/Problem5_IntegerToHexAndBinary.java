package Main;

import java.util.Scanner;

public class Problem5_IntegerToHexAndBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberInDecimal = scanner.nextInt();
        String numberInHex = Integer.toHexString(numberInDecimal);
        String numberInBinary = Integer.toBinaryString(numberInDecimal);
        System.out.println(numberInHex.toUpperCase());
        System.out.println(numberInBinary);
    }
}

