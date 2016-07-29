package Main;

import java.util.Scanner;

public class Problem14_SquaresInMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        String [][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            String [] line = scanner.nextLine().split(" ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = line[col];
            }
        }

        int countOfEqual2by2Squares = 0;
        for (int row = 0; row < rows - 1; row++) {
            for (int col = 0; col < cols - 1; col++) {
                String currentLetter = matrix[row][col];
                String rightLetter = matrix[row][col + 1];
                String downLeftLetter = matrix[row + 1][col];
                String downRightLetter = matrix[row + 1][col + 1];
                if (currentLetter.equals(rightLetter) && currentLetter.equals(downLeftLetter) && currentLetter.equals(downRightLetter))
                    countOfEqual2by2Squares ++;
            }
        }

        System.out.println(countOfEqual2by2Squares);
    }
}
