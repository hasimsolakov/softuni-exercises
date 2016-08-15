package system_split.commands;

import system_split.interfaces.Command;
import system_split.interfaces.Dump;
import system_split.interfaces.SystemData;
import system_split.models.Hardware;

public class RestoreCommand extends DumpAnalysisCommand implements Command {

    public RestoreCommand(SystemData theSystem, Dump dump, String hardwareName) {
        super(theSystem, dump, hardwareName);
    }

    @Override
    public void execute() {
        Hardware restoredHardware = this.dump.removeHardware(this.hardwareName);
        if (restoredHardware == null){
            return;
        }

        this.theSystem.put(this.hardwareName, restoredHardware);
    }
}
