package system_split.commands;

import system_split.interfaces.Command;
import system_split.interfaces.Dump;
import system_split.interfaces.SystemData;

public abstract class DumpAnalysisCommand implements Command {
    protected SystemData theSystem;
    protected Dump dump;
    protected String hardwareName;

    protected DumpAnalysisCommand(SystemData theSystem, Dump dump, String hardwareName){
        this.theSystem = theSystem;
        this.dump = dump;
        this.hardwareName = hardwareName;
    }


    @Override
    public abstract void execute();
}
