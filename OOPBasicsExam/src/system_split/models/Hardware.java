package system_split.models;

import java.util.List;

public abstract class Hardware extends Component{
    protected int maximumCapacity;
    protected int maximumMemory;
    protected List<Software> softwareComponents;
    protected int capacityUsed = 0;
    protected int memoryUsed = 0;

    public int getMaximumCapacity() {
        return this.maximumCapacity;
    }

    public int getMaximumMemory() {
        return this.maximumMemory;
    }

    public int getCapacityUsed(){ return this.capacityUsed; }

    public int getMemoryUsed() { return this.memoryUsed; }


    public void setSoftwareComponent(Software softwareComponent){
        int freeMemory = this.maximumMemory - memoryUsed;
        int freeCapacity = this.maximumCapacity - capacityUsed;
        if (freeMemory >= softwareComponent.getMemoryConsumption()
                && freeCapacity >= softwareComponent.getCapacityConsumption()){
            this.softwareComponents.add(softwareComponent);
            this.capacityUsed += softwareComponent.getCapacityConsumption();
            this.memoryUsed += softwareComponent.getMemoryConsumption();
        }
    }

    public void releaseSoftwareComponent(String softwareComponentName){
        int indexOfTheSoftwareToRemove = -1;
        for (int index = 0; index < this.softwareComponents.size(); index++) {
            if (this.softwareComponents.get(index).getName().equals(softwareComponentName)) {
                indexOfTheSoftwareToRemove = index;
            }
        }

        if (indexOfTheSoftwareToRemove != -1){
           Software removedSoftware = this.softwareComponents.remove(indexOfTheSoftwareToRemove);
            this.capacityUsed -= removedSoftware.getCapacityConsumption();
            this.memoryUsed -= removedSoftware.getMemoryConsumption();
        }
    }

    public Integer getSoftwareComponentsCount(){
        return this.softwareComponents.size();
    }

    public long getSpecificSoftwareCounts(Class type){
        return this.softwareComponents
                .stream()
                .filter(software -> type.isInstance(software))
                .count();
    }

    protected final void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder toPrint = new StringBuilder();
        toPrint.append("Hardware Component - ");
        toPrint.append(this.getName());
        toPrint.append(System.lineSeparator());
        toPrint.append("Express Software Components - ");
        Integer [] softwareComponentsCount = this.getSoftwareComponentsCount(this.softwareComponents);
        int expressSoftwaresCount = softwareComponentsCount[0];
        int lightSoftwaresCount = softwareComponentsCount[1];
        toPrint.append(expressSoftwaresCount);
        toPrint.append(System.lineSeparator());
        toPrint.append("Light Software Components - ");
        toPrint.append(lightSoftwaresCount);
        toPrint.append(System.lineSeparator());
        toPrint.append("Memory Usage: ");
        toPrint.append(this.memoryUsed).append(" / ").append(this.maximumMemory);
        toPrint.append(System.lineSeparator());
        toPrint.append("Capacity Usage: ").append(this.capacityUsed).append(" / ").append(this.maximumCapacity);
        toPrint.append(System.lineSeparator());
        String type = getClass().getSimpleName().replace("Hardware", "");
        toPrint.append("Type: ").append(type);
        toPrint.append(System.lineSeparator());
        toPrint.append("Software Components: ")
                .append((softwareComponents.size() == 0) ? "None" : this.joinSoftwareComponents(softwareComponents, ", "));
        return toPrint.toString();
    }

    private String joinSoftwareComponents(List<Software> softwareComponents, String delimiter) {
        StringBuilder builder = new StringBuilder(softwareComponents.size() + softwareComponents.size() -1);
        for (Software software : softwareComponents) {
            builder.append(software.toString()).append(delimiter);
        }

        builder.replace(builder.length() - delimiter.length(), builder.length(), "");
        return builder.toString();
    }

    private Integer [] getSoftwareComponentsCount(List<Software> softwareComponents){
        int expressSoftwaresCount = 0;
        int lightSoftwaresCount = 0;
        for (Software software : softwareComponents) {
            if (software instanceof ExpressSoftware){
                expressSoftwaresCount ++;
            }
            else if (software instanceof LightSoftware){
                lightSoftwaresCount ++;
            }
        }

        Integer [] result = {expressSoftwaresCount, lightSoftwaresCount};
        return result;
    }
}
