package Main;

import java.util.Scanner;

public class Problem21_ChangeToUppercase {
    private static final String UPCASE_TAG = "<upcase>";
    private static final String UPCASE_CLOSE_TAG = "</upcase>";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int tagIndex;
        while((tagIndex = input.indexOf(UPCASE_TAG)) != -1){
            int startIndex = tagIndex + UPCASE_TAG.length();
            int endIndex = input.indexOf(UPCASE_CLOSE_TAG);
            String partToUp = input.substring(startIndex, endIndex);
            String forReplacement = UPCASE_TAG + partToUp + UPCASE_CLOSE_TAG;
            input = input.replace(forReplacement, partToUp.toUpperCase());
        }

        System.out.println(input);
    }
}
