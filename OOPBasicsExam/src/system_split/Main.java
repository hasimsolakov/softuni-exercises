package system_split;

import system_split.interfaces.Reader;
import system_split.interfaces.Runnable;
import system_split.interfaces.Writer;
import system_split.io.ConsoleReader;
import system_split.io.ConsoleWriter;

public class Main {

    public static void main(String[] args) {
        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        Runnable engine = new Engine(reader, writer);
        engine.run();
    }
}
