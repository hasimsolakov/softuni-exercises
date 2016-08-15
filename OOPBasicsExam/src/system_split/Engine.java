package system_split;

import system_split.commands.SystemSplit;
import system_split.data.TheDump;
import system_split.data.TheSystem;
import system_split.factories.SystemCommandFactory;
import system_split.interfaces.*;
import system_split.interfaces.Runnable;
import system_split.models.Hardware;

import java.util.LinkedHashMap;
import java.util.Map;

public class Engine implements Runnable {
    private Reader reader;
    private Writer writer;
    private SystemData hardwares;
    private Dump dumpedHardwares;
    private CommandFactory commandFactory;

    public Engine(Reader reader, Writer writer){
        this.reader = reader;
        this.writer = writer;
        this.hardwares = new TheSystem();
        this.dumpedHardwares = new TheDump();
        this.commandFactory = new SystemCommandFactory(this.hardwares, this.dumpedHardwares, this.writer);
    }

    public void run(){
        String inputLine;
        while (true){
            inputLine = reader.readLine();
            Command command = this.commandFactory.createCommand(inputLine);
            command.execute();

            if (command instanceof SystemSplit){
                return;
            }
        }
    }
}
