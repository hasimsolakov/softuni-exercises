package Main;


import java.util.Arrays;
import java.util.Scanner;

public class Problem11_EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Integer [] sequence = Arrays
                .stream(line.split(" "))
                .map(number -> Integer.parseInt(number))
                .toArray(Integer[]::new);
        int desiredIndex = -1;  // Index where its left side sum equals its left side sum
        for (int index = 0; index < sequence.length; index++) {
            int leftSideSum = 0;
            int rightSideSum = 0;
            for (int toLeftSideIndex = index - 1; toLeftSideIndex >= 0; toLeftSideIndex--) {
                leftSideSum+= sequence[toLeftSideIndex];
            }

            for (int toRightSideIndex = index + 1; toRightSideIndex < sequence.length; toRightSideIndex++) {
                rightSideSum += sequence[toRightSideIndex];
            }

            if (rightSideSum == leftSideSum){
                desiredIndex = index;
            }
        }

        System.out.println((desiredIndex == -1) ? "no" : desiredIndex);
    }
}
