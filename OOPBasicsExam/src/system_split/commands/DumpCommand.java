package system_split.commands;

import system_split.data.TheSystem;
import system_split.interfaces.Command;
import system_split.interfaces.Dump;
import system_split.interfaces.SystemData;
import system_split.models.Hardware;

public class DumpCommand extends DumpAnalysisCommand implements Command {

    public DumpCommand(SystemData theSystem, Dump dump, String hardwareName) {
        super(theSystem, dump, hardwareName);
    }

    @Override
    public void execute() {
        Hardware hardwareToDump = this.theSystem.remove(hardwareName);
        if (hardwareToDump == null){
            return;
        }

        this.dump.addHardware(hardwareToDump);
    }
}
