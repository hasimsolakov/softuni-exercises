package system_split.commands;

import system_split.interfaces.Command;
import system_split.interfaces.SystemData;
import system_split.interfaces.Writer;
import system_split.models.Hardware;

import java.util.Map;

public class AnalyzeCommand extends PrintOutputCommand{

    public AnalyzeCommand(SystemData hardwares, Writer writer){
        super(hardwares, writer);
    }

    @Override
    public void execute() {
        writer.printLine("System Analysis");
        writer.printLine("Hardware Components: " + hardwares.size());
        writer.printLine("Software Components: " + hardwares
                .values()
                .stream()
                .mapToInt(Hardware::getSoftwareComponentsCount)
                .sum());
        int totalOperationalMemoryInUse = this.getTotalOperationalMemoryInUse();

        int totalMaximumMemory = this.getTotalMaximumMemory();

        writer.printLine("Total Operational Memory: " + totalOperationalMemoryInUse + " / " + totalMaximumMemory);
        int totalCapacityTaken = this.getTotalCapacityTake();

        int totalMaximumCapacity = this.getTotalMaximumCapacity();

        writer.printLine("Total Capacity Taken: " + totalCapacityTaken + " / " + totalMaximumCapacity);

    }
}
