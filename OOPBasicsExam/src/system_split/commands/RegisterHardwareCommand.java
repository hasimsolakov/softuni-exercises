package system_split.commands;

import system_split.interfaces.Command;
import system_split.interfaces.SystemData;
import system_split.models.Hardware;
import system_split.models.HeavyHardware;
import system_split.models.PowerHardware;

import java.util.Map;

public class RegisterHardwareCommand implements Command {
    private String name;
    private String type;
    private int capacity;
    private int memory;
    private SystemData hardwares;

    public RegisterHardwareCommand(String name, String type, int capacity, int memory, SystemData hardwares){
        this.name = name;
        this.type = type;
        this.capacity = capacity;
        this.memory = memory;
        this.hardwares = hardwares;
    }

    @Override
    public void execute() {
        Hardware hardware = null;
        if (this.type.equals("Power")) {
            hardware = this.registerPowerHardware();
        } else if (this.type.equals("Heavy")) {
            hardware = this.registerHeavyHardware();
        }

        if (hardware == null){
            throw new IllegalArgumentException("Hardware type is not recognized");
        }

        this.hardwares.put(hardware.getName(), hardware);
    }

    private Hardware registerHeavyHardware(){
        Hardware heavyHardware = new HeavyHardware(this.name, this.capacity, this.memory);
        return heavyHardware;
    }

    private Hardware registerPowerHardware(){
        Hardware powerHardware = new PowerHardware(this.name, this.capacity, this.memory);
        return powerHardware;
    }
}
