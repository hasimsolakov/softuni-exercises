package system_split.models;

public class ExpressSoftware extends Software {

    public ExpressSoftware(String name, int capacityConsumption, int memoryConsumption){
        this.setName(name);
        this.setCapacityConsumption(capacityConsumption);
        this.setMemoryConsumption(memoryConsumption);
    }

    @Override
    protected void setMemoryConsumption(int memoryConsumption) {
        this.memoryConsumption = memoryConsumption * 2;
    }
}
