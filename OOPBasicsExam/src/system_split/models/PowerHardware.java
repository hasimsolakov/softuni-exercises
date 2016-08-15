package system_split.models;

import java.util.ArrayList;

public class PowerHardware extends Hardware {
    private static final int PERCENTAGE_NOMINATOR = 3;
    private static final int PERCENTAGE_DENOMINATOR = 4;

    public PowerHardware(String name, int maximumCapacity, int maximumMemory) {
        this.setName(name);
        this.setMaximumCapacity(maximumCapacity);
        this.setMaximumMemory(maximumMemory);
        this.softwareComponents = new ArrayList<>();
    }

    protected void setMaximumCapacity(int maximumCapacity) {
       this.maximumCapacity = maximumCapacity - (maximumCapacity * PERCENTAGE_NOMINATOR)/ PERCENTAGE_DENOMINATOR;
    }

    protected void setMaximumMemory(int maximumMemory) {
        this.maximumMemory = maximumMemory + (maximumMemory * PERCENTAGE_NOMINATOR) / PERCENTAGE_DENOMINATOR;
    }
}
