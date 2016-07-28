package Main;


import java.util.Arrays;
import java.util.Scanner;

public class Problem6_CompareCharArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String  firstLine= scanner.nextLine().replaceAll(" ","");
        String secondLine = scanner.nextLine().replaceAll(" ", "");
        String [] array = new String [] {firstLine, secondLine};
        Arrays.sort(array);
        for (String line :
                array) {
            System.out.println(line);
        }
    }
}
