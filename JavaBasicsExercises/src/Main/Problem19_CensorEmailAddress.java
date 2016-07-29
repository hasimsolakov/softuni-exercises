package Main;


import java.util.Scanner;

public class Problem19_CensorEmailAddress {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String email = scanner.nextLine().trim();
        String[] splittedEmail = email.split("@");
        String username = splittedEmail[0];
        String domain = splittedEmail[1];
        String text = scanner.nextLine().trim();
        String censoredEmail = new String(new char[username.length()])
                .replace('\0', '*');
        censoredEmail += "@" + domain;
        String censoredText = text.replaceAll(email, censoredEmail).trim();
        System.out.println(censoredText);
    }
}
