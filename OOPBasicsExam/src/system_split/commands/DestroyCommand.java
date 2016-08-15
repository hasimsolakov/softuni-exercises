package system_split.commands;

import system_split.data.TheSystem;
import system_split.interfaces.Dump;
import system_split.models.Hardware;

import java.util.Map;

public class DestroyCommand extends DumpAnalysisCommand {

    public DestroyCommand(Dump dump, String hardwareName) {
        super(null, dump, hardwareName);
    }

    @Override
    public void execute() {
        this.dump.removeHardware(this.hardwareName);
    }
}
