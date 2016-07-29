package Main;

import java.util.Random;
import java.util.Scanner;

public class Problem25_AdvertisementMessage {
    public static void main(String[] args) {
        final String[] phrases = new String[]{
                    "Excellent product",
                    "Such a great product",
                    "I always use that product",
                    "Best product of its category",
                    "Exceptional product",
                    "I can't live without this product"};

        final String [] events = new String [] {
                "Now I feel good",
                "I have succeeded with this product",
                "Makes miracles. I am happy of the results!",
                "I cannot believe but now I feel awesome.",
                "Try it yourself, I am very satisfied.",
                "I feel great!"
        };

        final String [] authors = new String[] {
                "Diana",
                "Petya",
                "Stella",
                "Elena",
                "Katya",
                "Iva",
                "Annie",
                "Eva"
        };

        final String [] cities = new String[]{
                "Burgas",
                "Sofia",
                "Plovdiv",
                "Varna",
                "Ruse"
        };

        Scanner scanner = new Scanner(System.in);
        int numberOfMessages = scanner.nextInt();
        Random random = new Random();
        for (int i = 0; i < numberOfMessages; i++) {
            StringBuilder messageBuilder = new StringBuilder(4);
            int randomPhraseIndex =random.nextInt(phrases.length - 1);
            int randomEventIndex = random.nextInt(events.length - 1);
            int randomAuthorIndex = random.nextInt(authors.length - 1);
            int randomCityIndex = random.nextInt(cities.length - 1);
            messageBuilder.append(phrases[randomPhraseIndex]);
            messageBuilder.append(" ");
            messageBuilder.append(events[randomEventIndex]);
            messageBuilder.append(" ");
            messageBuilder.append(authors[randomAuthorIndex]);
            messageBuilder.append(" - ");
            messageBuilder.append(cities[randomCityIndex]);
            System.out.println(messageBuilder);
        }

    }
}
