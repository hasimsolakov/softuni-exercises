package system_split.data;

import system_split.interfaces.Dump;
import system_split.models.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class TheDump implements Dump{
    private Map<String, Hardware> dump;

    public TheDump(){
        dump = new LinkedHashMap<>();
    }

    public void addHardware(Hardware hardware){
      dump.put(hardware.getName(), hardware);
    }

    @Override
    public Hardware removeHardware(String hardwareName) {
        return this.dump.remove(hardwareName);
    }

    @Override
    public String toString() {
        StringBuilder dumpAnalysis = new StringBuilder();
        dumpAnalysis.append("Dump Analysis").append(System.lineSeparator());
        long powerHardwaresCount = this.getHardwaresCount(PowerHardware.class);
        dumpAnalysis.append("Power Hardware Components: ").append(powerHardwaresCount).append(System.lineSeparator());
        long heavyHardwaresCount = this.getHardwaresCount(HeavyHardware.class);
        dumpAnalysis.append("Heavy Hardware Components: ").append(heavyHardwaresCount).append(System.lineSeparator());
        long expressSoftwareComponentsCount = this.getSoftwareComponentsCount(ExpressSoftware.class);
        dumpAnalysis.append("Express Software Components: ").append(expressSoftwareComponentsCount).append(System.lineSeparator());
        long lightSoftwareComponentsCount = this.getSoftwareComponentsCount(LightSoftware.class);
        dumpAnalysis.append("Light Software Components: ").append(lightSoftwareComponentsCount).append(System.lineSeparator());
        dumpAnalysis.append("Total Dumped Memory: ").append(this.getTotalDumpedMemory()).append(System.lineSeparator());
        dumpAnalysis.append("Total Dumped Capacity: ").append(this.getTotalDumpedCapacity()).append(System.lineSeparator());
        return dumpAnalysis.toString();
    }

    private int getTotalDumpedMemory(){
        return this.dump
                .values()
                .stream()
                .mapToInt(Hardware::getMemoryUsed)
                .sum();
    }

    private int getTotalDumpedCapacity(){
        return this.dump
                .values()
                .stream()
                .mapToInt(Hardware::getCapacityUsed)
                .sum();
    }

    private long getHardwaresCount(Class type){
        return this.dump.values().stream().filter(hardware -> type.isInstance(hardware)).count();
    }

    private long getSoftwareComponentsCount(Class type){
        return this.dump
                .values()
                .stream()
                .mapToLong(hardware -> hardware.getSpecificSoftwareCounts(type))
                .sum();
    }
}
