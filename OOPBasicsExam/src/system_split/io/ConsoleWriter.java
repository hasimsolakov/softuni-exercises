package system_split.io;

import system_split.interfaces.Writer;

public class ConsoleWriter implements Writer{

    public void printLine(String line){
        System.out.println(line);
    }
}
