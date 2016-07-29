package Main;

import java.util.Arrays;
import java.util.Scanner;

public class Problem18_FitStringIn20Chars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String result;
        if (line.length() < 20){
           char [] array = Arrays.copyOfRange(line.toCharArray(), 0, line.length());
            char [] arrayToPrint = Arrays.copyOf(array, 20);
            Arrays.fill(arrayToPrint,line.length(), 20, '*');
           result = new String(arrayToPrint);
        }
        else{
            result = line.substring(0, 20);
        }

        System.out.println(result);
    }
}
