package system_split.commands;

import system_split.interfaces.Command;
import system_split.interfaces.SystemData;
import system_split.interfaces.Writer;
import system_split.models.Hardware;

import java.util.Map;

public abstract class PrintOutputCommand implements Command {
    protected SystemData hardwares;
    protected Writer writer;

    protected PrintOutputCommand(SystemData hardwares, Writer writer){
        this.hardwares = hardwares;
        this.writer = writer;
    }

    protected int getTotalMaximumCapacity(){
        return this.hardwares
                .values()
                .stream()
                .mapToInt(Hardware::getMaximumCapacity)
                .sum();
    }

    protected int getTotalCapacityTake(){
        return this.hardwares
                .values()
                .stream()
                .mapToInt(Hardware::getCapacityUsed)
                .sum();
    }

    protected int getTotalMaximumMemory(){
        return this.hardwares
                .values()
                .stream()
                .mapToInt(Hardware::getMaximumMemory)
                .sum();
    }

    protected int getTotalOperationalMemoryInUse(){
        return this.hardwares.values()
                .stream()
                .mapToInt(Hardware::getMemoryUsed)
                .sum();
    }

    @Override
    public abstract void execute();
}
