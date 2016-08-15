package system_split.models;

import java.util.ArrayList;

public class HeavyHardware extends Hardware {

    public HeavyHardware(String name, int maximumCapacity, int maximumMemory){
        this.setName(name);
        this.setMaximumCapacity(maximumCapacity);
        this.setMaximumMemory(maximumMemory);
        this.softwareComponents = new ArrayList<>();
    }

    protected void setMaximumCapacity(int maximumCapacity){
        this.maximumCapacity = maximumCapacity * 2;
    }

    protected void setMaximumMemory(int maximumMemory) {
        this.maximumMemory = maximumMemory - (maximumMemory / 4);
    }
}
