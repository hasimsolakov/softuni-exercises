package Main;


import java.util.Arrays;
import java.util.Scanner;

public class Problem8_MaxSequenceOfIncreasingElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Integer [] sequence = Arrays
                .stream(line.split(" "))
                .map(number -> Integer.parseInt(number))
                .toArray(Integer[]::new);
        int bestStart = 0;
        int bestLen = 1;
        for (int i = 1, start = 0, len = 1; i < sequence.length; i++) {
            if (sequence[i - 1] < sequence[i]){
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

        Integer[] maxSequence = Arrays.copyOfRange(sequence, bestStart, bestLen + bestStart);
        for (int number :
                maxSequence) {
            System.out.print(number + " ");
        }

        System.out.println();
    }
}
