package Main;

import java.util.Arrays;
import java.util.Scanner;

public class Problem15_MaxPlatform3x3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        int [][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            Integer[] line = Arrays
                    .stream(scanner.nextLine()
                                    .split(" "))
                    .map(number -> Integer.parseInt(number))
                    .toArray(Integer[]::new);

            for (int col = 0; col < cols; col++) {
                matrix[row][col] = line[col];
            }
        }

        long maxSum = Long.MIN_VALUE;
        int startRow = 0;
        int startCol = 0;
        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                long currentSum = getSumOfThe3x3Square(row, col, matrix);
                if (maxSum < currentSum){
                    maxSum = currentSum;
                    startRow = row;
                    startCol = col;
                }
            }
        }

        System.out.println(maxSum);
        for (int row = startRow; row < startRow + 3; row++) {
            for (int col = startCol; col < startCol + 3; col++) {
                System.out.print(matrix[row][col] + " ");
            }

            System.out.println();
        }
    }

    private static long getSumOfThe3x3Square(int startRow, int startCol, int [][] matrix){
        long sum = 0;
        for (int row = startRow; row < startRow + 3; row++) {
            for (int col = startCol; col < startCol + 3; col++) {
                sum += matrix[row][col];
            }
        }

        return sum;
    }
}
