package Main;


import java.util.*;

public class Problem9_MostFrequentNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Integer[] sequence = Arrays
                .stream(line.split(" "))
                .map(number -> Integer.parseInt(number))
                .toArray(Integer[]::new);

        List<Integer> searchedNumbers = new ArrayList<>(sequence.length);
        int mostFrequentNum = sequence[0];
        int mostCounts = 0;
        for (int i = 0, count = 1, currentNum; i < sequence.length; i++) {
            currentNum = sequence[i];
            if (!searchedNumbers.contains(currentNum)){
                for (int j = i + 1; j < sequence.length; j++) {
                    if (sequence[j] == currentNum){
                        count++;
                    }
                }

                if (mostCounts < count){
                    mostCounts = count;
                    mostFrequentNum = currentNum;
                }
            }

            count = 1;
            searchedNumbers.add(currentNum);
        }

        System.out.println(mostFrequentNum);
    }
}
