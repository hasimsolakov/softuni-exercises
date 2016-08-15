package solutions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CubicsMessages {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        String regex = "(\\d+)([a-zA-Z]+)([^a-zA-Z]*)";
        Pattern pattern = Pattern.compile(regex);
        while (!(line = reader.readLine().trim()).equals("Over!")) {
            int length = Integer.parseInt(reader.readLine());
            Matcher matcher = pattern.matcher(line);
            boolean isValidInput = matcher.matches();
            if (!isValidInput){
                continue;
            }
            String message = matcher.group(2);
            if (message.length() != length){
                continue;
            }

            String afterMessageMatch = matcher.group(3);

            String firstDigits = matcher.group(1);
            List<Integer> digits = new ArrayList<>();
            for (char digit : firstDigits.toCharArray()) {
                digits.add(Character.digit(digit, 10));
            }

            for (char symbol : afterMessageMatch.toCharArray()) {
                if (Character.isDigit(symbol)) {
                    digits.add(Character.digit(symbol, 10));
                }

            }

            String verificationCode = formVerificationCode(digits, message);
            System.out.println(message + " == " + verificationCode);

        }
    }

    private static String formVerificationCode(List<Integer> indexes, String message){
        StringBuilder verificationCode = new StringBuilder();
        for (Integer index : indexes) {
            if (index >= 0 && index < message.length()) {
                verificationCode.append(message.substring(index, index + 1));
            }
            else{
                verificationCode.append(" ");
            }
        }

        return verificationCode.toString();
    }
}
