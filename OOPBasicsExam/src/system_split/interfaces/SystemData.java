package system_split.interfaces;

import system_split.models.Hardware;

import java.util.Collection;

public interface SystemData {
    void put(String hardwareName, Hardware hardware);
    Hardware remove(String hardwareName);
    Hardware get(String hardwareName);
    Collection<Hardware> values();
    int size();
}
