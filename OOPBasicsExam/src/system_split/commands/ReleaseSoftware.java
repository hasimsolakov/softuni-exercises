package system_split.commands;

import system_split.interfaces.Command;
import system_split.interfaces.SystemData;
import system_split.models.Hardware;

import java.util.Map;

public class ReleaseSoftware implements Command {
    private String softwareName;
    private Hardware hardware;

    public ReleaseSoftware(String hardwareName, String softwareName, SystemData hardwares){
        this.softwareName = softwareName;
        this.hardware = hardwares.get(hardwareName);
    }

    @Override
    public void execute() {
        if (this.hardware == null){
            return;
        }

        this.hardware.releaseSoftwareComponent(this.softwareName);
    }
}
