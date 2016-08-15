package system_split.factories;

import system_split.commands.*;
import system_split.interfaces.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SystemCommandFactory implements CommandFactory {
    private static final String REGEX = "(?<action>[A-Z][a-z]+)(|(?<type>[A-Z][a-z]+)(?<component>[A-Z][a-z]+))\\((?<parameters>.*)\\)";
    private SystemData hardwares;
    private Dump dumpedHardwares;
    private Writer writer;

    public SystemCommandFactory(SystemData hardwares, Dump dumpedHardwares, Writer writer){
        this.hardwares = hardwares;
        this.dumpedHardwares = dumpedHardwares;
        this.writer = writer;
    }

    @Override
    public Command createCommand(String inputLine) {
        Pattern registerPattern = Pattern.compile(REGEX);
        Matcher matcher = registerPattern.matcher(inputLine);
        Command command = null;
        if (matcher.find()){
            String action = matcher.group("action");
            if (action.equals("Analyze") && inputLine.length() > 9) {
                action = "DumpAnalyze";     // TODO: fix regex;
            }
            try {
                String methodName = "create" + action + "Command";
               Method createCommand = this.getClass().getDeclaredMethod(methodName, Matcher.class);
                createCommand.setAccessible(true);
                command = (Command) createCommand.invoke(this, matcher);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        else{
            command = new SystemSplit(this.hardwares, this.writer);
        }

        if (command == null){
            throw new InputMismatchException("Couldn't create command");
        }

        return command;
    }

    private Command createDumpCommand(Matcher matcher){
        String hardwareName = matcher.group("parameters");
        return new DumpCommand(this.hardwares, this.dumpedHardwares, hardwareName);
    }

    private Command createAnalyzeCommand(Matcher matcher){
        return new AnalyzeCommand(this.hardwares, this.writer);
    }

    private Command createDumpAnalyzeCommand(Matcher matcher){
        return new DumpAnalyzeCommand(this.dumpedHardwares, this.writer);
    }

    private Command createReleaseCommand(Matcher matcher){
        String params = matcher.group("parameters");
        String[]  parameters = params.split(", ");
        String hardwareName = parameters[0];
        String softwareName = parameters[1];
        return new ReleaseSoftware(hardwareName, softwareName, this.hardwares);
    }

    private Command createRegisterCommand(Matcher matcher){
        Command command = null;
        String component = matcher.group("component");
        String type = matcher.group("type");
        String params = matcher.group("parameters");
        String parameters[] = params.split(", ");
        if (component.equals("Hardware")) {
            String name = parameters[0];
            int capacity = Integer.parseInt(parameters[1]);
            int memory = Integer.parseInt(parameters[2]);
            command = new RegisterHardwareCommand(name, type, capacity, memory, this.hardwares);
        } else if (component.equals("Software")) {
            String hardwareName = parameters[0];
            String name = parameters[1];
            int capacity = Integer.parseInt(parameters[2]);
            int memory = Integer.parseInt(parameters[3]);
            command = new RegisterSoftwareCommand(hardwareName, name, type, capacity, memory, this.hardwares);
        }

        return command;
    }
}
