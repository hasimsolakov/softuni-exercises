package system_split.interfaces;


import system_split.models.Hardware;

public interface Dump {
    void addHardware(Hardware hardware);
    Hardware removeHardware(String hardwareName);
}
