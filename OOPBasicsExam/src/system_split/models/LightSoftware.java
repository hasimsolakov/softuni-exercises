package system_split.models;

public class LightSoftware extends Software {

    public LightSoftware(String name, int capacityConsumption, int memoryConsumption){
        this.setName(name);
        this.setCapacityConsumption(capacityConsumption);
        this.setMemoryConsumption(memoryConsumption);
    }

    @Override
    protected void setCapacityConsumption(int capacityConsumption) {
        this.capacityConsumption = capacityConsumption + (capacityConsumption / 2);
    }

    @Override
    protected void setMemoryConsumption(int memoryConsumption) {
        this.memoryConsumption = memoryConsumption - (memoryConsumption / 2);
    }
}
