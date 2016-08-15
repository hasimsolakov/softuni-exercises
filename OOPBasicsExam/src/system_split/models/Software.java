package system_split.models;

public abstract class Software  extends Component{
    protected int capacityConsumption;
    protected int memoryConsumption;


    public int getCapacityConsumption() {
        return capacityConsumption;
    }

    public int getMemoryConsumption() {
        return memoryConsumption;
    }

    protected void setCapacityConsumption(int capacityConsumption) {
        this.capacityConsumption = capacityConsumption;
    }

    protected void setMemoryConsumption(int memoryConsumption) {
        this.memoryConsumption = memoryConsumption;
    }

    protected void setName(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return this.getName();
    }
}
