package system_split.commands;

import system_split.interfaces.Command;
import system_split.interfaces.SystemData;
import system_split.models.ExpressSoftware;
import system_split.models.Hardware;
import system_split.models.LightSoftware;
import system_split.models.Software;

import java.util.Map;

public class RegisterSoftwareCommand implements Command {
    private String name;
    private String type;
    private int capacity;
    private int memory;
    private Hardware hardware;

    public RegisterSoftwareCommand(String hardwareName, String name,String type, int capacity, int memory, SystemData hardwares){
        this.hardware = hardwares.get(hardwareName);
        this.name = name;
        this.type = type;
        this.capacity = capacity;
        this.memory = memory;
    }

    @Override
    public void execute() {
        if (this.hardware == null){
            return;
        }

        Software software = null;
        if (this.type.equals("Express")) {
            software = this.registerExpressSoftware();
        } else if (this.type.equals("Light")) {
            software = this.registerLightSoftware();
        }

        this.hardware.setSoftwareComponent(software);
    }

    private Software registerExpressSoftware(){
        return new ExpressSoftware(this.name, this.capacity, this.memory);
    }

    private Software registerLightSoftware(){
        return new LightSoftware(this.name, this.capacity, this.memory);
    }

}
