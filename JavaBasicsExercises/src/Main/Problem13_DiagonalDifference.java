package Main;

import java.util.Scanner;

public class Problem13_DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [][] matrix = new int[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }

        int primaryDiagonalSum = 0;
        for (int i = 0; i < n; i++) {
            primaryDiagonalSum += matrix[i][i];
        }

        int secondaryDiagonalSum = 0;
        for (int j = 0; j < n; j++) {
            secondaryDiagonalSum += matrix[j][n - j - 1];
        }

        int difference = Math.abs(primaryDiagonalSum - secondaryDiagonalSum);
        System.out.println(difference);
    }
}
