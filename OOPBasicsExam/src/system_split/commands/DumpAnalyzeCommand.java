package system_split.commands;

import system_split.interfaces.Dump;
import system_split.interfaces.Writer;

public class DumpAnalyzeCommand extends DumpAnalysisCommand {
    private Writer writer;

    public DumpAnalyzeCommand(Dump dump, Writer writer) {
        super(null, dump, null);
        this.writer = writer;
    }

    @Override
    public void execute() {
        this.writer.printLine(this.dump.toString());
    }
}
