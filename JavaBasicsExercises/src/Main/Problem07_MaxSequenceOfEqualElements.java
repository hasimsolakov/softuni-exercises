package Main;


import java.util.Arrays;
import java.util.Scanner;

public class Problem07_MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Integer [] sequenceOfNumbers = Arrays
                .stream(line.split(" "))
                .map(number -> Integer.parseInt(number))
                .toArray(Integer[]::new);
        int bestStart = 0;
        int bestLen = 1;
        for (int i = 1, start = 0, len = 1; i < sequenceOfNumbers.length; i++) {
            if (sequenceOfNumbers[i - 1] == sequenceOfNumbers[i]){
                ++len;
            }
            else{
                start = i;
                len = 1;
            }

            if (bestLen < len){
                bestStart = start;
                bestLen = len;
            }
        }

        Integer [] arrayToPrint = Arrays.copyOfRange(sequenceOfNumbers, bestStart, bestStart + bestLen);
        for (Integer number :
                arrayToPrint) {
            System.out.print(number + " ");
        }

        System.out.println();
    }
}
