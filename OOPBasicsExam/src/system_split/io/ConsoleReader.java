package system_split.io;

import system_split.interfaces.Reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader implements Reader{
    private BufferedReader reader;

    public ConsoleReader(){
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String readLine(){
        String line = null;
        try {
            line = this.reader.readLine();
        } catch (IOException e) {
            System.out.println("Problem with the Reader");
            System.exit(0);
        }

        return line;
    }
}
