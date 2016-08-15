package system_split.commands;

import system_split.interfaces.SystemData;
import system_split.interfaces.Writer;
import system_split.models.Hardware;
import system_split.models.HeavyHardware;
import system_split.models.PowerHardware;

import java.util.List;
import java.util.stream.Collectors;

public class SystemSplit extends PrintOutputCommand {


    public SystemSplit(SystemData hardwares, Writer writer) {
        super(hardwares, writer);
    }

    @Override
    public void execute() {

        List<Hardware> powerHardwareComponents = this.hardwares.values()
                .stream()
                .filter(hardware -> hardware instanceof PowerHardware)
                .collect(Collectors.toList());
        List<Hardware> heavyHardwareComponents = this.hardwares
                .values()
                .stream()
                .filter(hardware -> hardware instanceof HeavyHardware)
                .collect(Collectors.toList());

        for (Hardware hardware : powerHardwareComponents) {
            writer.printLine(hardware.toString());
        }

        for (Hardware hardware: heavyHardwareComponents) {
            writer.printLine(hardware.toString());
        }

    }
}
