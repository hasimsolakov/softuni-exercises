package Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Problem16_BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        ArrayList<Integer> sequence = Arrays.stream(line.split(" "))
                .map(number -> Integer.parseInt(number))
                .collect(Collectors
                        .toCollection(ArrayList<Integer>::new));
        int bombNumber = scanner.nextInt();
        int power = scanner.nextInt();
        int index;
        while ((index = sequence.indexOf(bombNumber)) != -1){
            int startRemoveIndex = 0;
            int leftSideRangeToDestroy = index - power;
            if (startRemoveIndex < leftSideRangeToDestroy){
                startRemoveIndex = leftSideRangeToDestroy;
            }

            int endIndex = sequence.size() - 1;
            int rightSideRangeToDestroy = index + power;
            if (endIndex > rightSideRangeToDestroy){
                endIndex = rightSideRangeToDestroy;
            }

            for (int i = startRemoveIndex; i <= endIndex; i++) {
                sequence.set(i, null);
            }
        }

        int sum = 0;
        for (int i = 0; i < sequence.size(); i++) {
            Integer num;
            if ((num = sequence.get(i)) != null){
                sum += num;
            }
        }

        System.out.println(sum);
    }
}
