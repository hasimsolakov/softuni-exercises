package Main;


import java.util.*;

public class Problem3_ReverseCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<String>(3);
        for (int i = 0; i < 3; i++) {
            list.add(scanner.nextLine());
        }

        Collections.reverse(list);

        for (String symbol:
             list) {
            System.out.print(symbol);
        }

        System.out.println();
    }
}
