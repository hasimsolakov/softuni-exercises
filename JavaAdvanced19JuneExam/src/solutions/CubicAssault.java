package solutions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CubicAssault {
    private static final int METEORS_TRANSFORMATION_THRESHOLD = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        Map<String, Map<MeteorType, Long>> statistics = new HashMap<>();
        while (!(line = reader.readLine()).equals("Count em all")){
            String [] data = line.split(" -> ");
            String regionName = data[0];
            String meteorType = data[1];
            long meteorsCount = Long.parseLong(data[2]);
            if (!statistics.containsKey(regionName)){
                addRegionAndMeteors(statistics, regionName, meteorType, meteorsCount);
            }
            else {
                addMeteors(statistics, regionName, meteorType, meteorsCount);
            }
        }

        List<Map.Entry<String, Map<MeteorType, Long>>> sortedResultToPrint = orderOutput(statistics);
        printResult(sortedResultToPrint);
    }

    private static void printResult(List<Map.Entry<String, Map<MeteorType, Long>>> sortedResultToPrint){
        for (Map.Entry<String, Map<MeteorType, Long>> region : sortedResultToPrint) {
            System.out.println(region.getKey());
            List<Map.Entry<MeteorType, Long>> meteorTypesOrdered = sortMeteorTypes(region);
            for (Map.Entry<MeteorType, Long> meteorType : meteorTypesOrdered) {
                System.out.println(" -> " + meteorType.getKey() + " : " + meteorType.getValue());
            }
        }
    }

    private static List<Map.Entry<MeteorType, Long>> sortMeteorTypes(Map.Entry<String, Map<MeteorType, Long>> region){
        List<Map.Entry<MeteorType, Long>> meteorTypesOrdered = region
                .getValue()
                .entrySet()
                .stream()
                .sorted(Comparator.comparing((Function<Map.Entry<MeteorType, Long>, Long>) Map.Entry::getValue).reversed()
                .thenComparing(Comparator.comparing((Map.Entry<MeteorType, Long> t) -> t.getKey().toString())))
                .collect(Collectors.toList());
        return meteorTypesOrdered;
    }

    private static List<Map.Entry<String, Map<MeteorType, Long>>> orderOutput(Map<String, Map<MeteorType, Long>> statistics){
        List<Map.Entry<String, Map<MeteorType, Long>>> sortedResult = statistics.entrySet()
                .stream()
                .sorted(Comparator.comparing((Map.Entry<String, Map<MeteorType, Long>> stringMapEntry)-> stringMapEntry
                                .getValue()
                                .get(MeteorType.Black))
                        .reversed()
                        .thenComparing(Comparator.comparing((Map.Entry<String, Map<MeteorType, Long>> result) -> result.getKey().length()))
                        .thenComparing(Comparator.comparing(Map.Entry::getKey)))
                .collect(Collectors.toList());
        return sortedResult;
    }

    private enum MeteorType{
        Black, Red, Green
    }

    private static void addMeteors(Map<String, Map<MeteorType, Long>> statistics, String regionName, String meteorType, long meteorsCount){
        Long currentMeteors;
        if (meteorType.equals("Red")) {
            currentMeteors = statistics.get(regionName).get(MeteorType.Red);
            currentMeteors += meteorsCount;
            statistics.get(regionName).replace(MeteorType.Red, currentMeteors);
        }
        else if (meteorType.equals("Black")) {
            currentMeteors = statistics.get(regionName).get(MeteorType.Black);
            currentMeteors += meteorsCount;
            statistics.get(regionName).replace(MeteorType.Black, currentMeteors);
        }
        else if (meteorType.equals("Green")) {
            currentMeteors = statistics.get(regionName).get(MeteorType.Green);
            currentMeteors += meteorsCount;
            statistics.get(regionName).replace(MeteorType.Green, currentMeteors);
        }

        gatherMeteorsIfNeeded(statistics, regionName, meteorType);
    }

    private static void addRegionAndMeteors(Map<String,Map<MeteorType, Long>> statistics , String regionName, String meteorType, long meteorsCount){

        Map<MeteorType, Long> regionMeteors = new HashMap<>();
        if (meteorType.equals("Red")) {
            regionMeteors.put(MeteorType.Red, meteorsCount);
            regionMeteors.put(MeteorType.Black, 0L);
            regionMeteors.put(MeteorType.Green, 0L);
        }
        if (meteorType.equals("Black")) {
            regionMeteors.put(MeteorType.Black, meteorsCount);
            regionMeteors.put(MeteorType.Green, 0L);
            regionMeteors.put(MeteorType.Red, 0L);
        }
        if (meteorType.equals("Green")) {
            regionMeteors.put(MeteorType.Green, meteorsCount);
            regionMeteors.put(MeteorType.Black, 0L);
            regionMeteors.put(MeteorType.Red, 0L);
        }

        statistics.put(regionName, regionMeteors);

        gatherMeteorsIfNeeded(statistics, regionName, meteorType);
    }

    private static void gatherMeteorsIfNeeded(Map<String,Map<MeteorType,Long>> statistics, String regionName, String meteorType){
        if (meteorType.equals("Black")) {
            return;
        }

        Long createdRedMeteors = 0L;
        if (meteorType.equals("Green")) {
            Long currentCount = statistics.get(regionName).get(MeteorType.Green);
            if (currentCount >= METEORS_TRANSFORMATION_THRESHOLD){
                createdRedMeteors = currentCount / METEORS_TRANSFORMATION_THRESHOLD;
                Long leftGreenMeteors = currentCount - (createdRedMeteors * METEORS_TRANSFORMATION_THRESHOLD);
                statistics.get(regionName).replace(MeteorType.Green, leftGreenMeteors);
                meteorType = "Red";
            }
        }

        if (meteorType.equals("Red")) {
            Long currentRedMeteorsCount = statistics.get(regionName).get(MeteorType.Red);
            if (createdRedMeteors != 0L){
                currentRedMeteorsCount += createdRedMeteors;
            }

            if (currentRedMeteorsCount >= METEORS_TRANSFORMATION_THRESHOLD){
                Long createdBlackMeteors = currentRedMeteorsCount / METEORS_TRANSFORMATION_THRESHOLD;
                currentRedMeteorsCount = currentRedMeteorsCount - (createdBlackMeteors * METEORS_TRANSFORMATION_THRESHOLD);
                Long blackMeteorsCount = statistics.get(regionName).get(MeteorType.Black);
                statistics.get(regionName).replace(MeteorType.Black, blackMeteorsCount + createdBlackMeteors);
            }

            statistics.get(regionName).replace(MeteorType.Red, currentRedMeteorsCount);
        }
    }
}
