package Main;

import java.util.Scanner;

public class Problem12_MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        String [][] matrix = new String[rows][cols];
        for (int row = 0, letterValue = 'a'; row < rows; row++, letterValue++) {
            for (int col = 0, middleLetterValue = letterValue; col < cols; col++, middleLetterValue++) {
                matrix [row][col] = String.valueOf(new char [] {(char)letterValue, (char)middleLetterValue, (char)letterValue});
            }
        }

        for (int toPrintRow = 0; toPrintRow < rows; toPrintRow++) {
            for (int toPrintCol = 0; toPrintCol < cols; toPrintCol++) {
                System.out.print(matrix[toPrintRow][toPrintCol] + " ");
            }

            System.out.println();
        }
    }
}
