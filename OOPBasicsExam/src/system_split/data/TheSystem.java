package system_split.data;

import system_split.interfaces.SystemData;
import system_split.models.Hardware;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class TheSystem implements SystemData {
    private Map<String, Hardware> theSystem;

    @Override
    public Collection<Hardware> values() {
        return this.theSystem.values();
    }

    @Override
    public int size() {
        return this.theSystem.size();
    }

    public TheSystem(){
        this.theSystem = new LinkedHashMap<>();
    }

    @Override
    public void put(String hardwareName, Hardware hardware) {
        this.theSystem.put(hardwareName, hardware);
    }

    @Override
    public Hardware remove(String hardwareName) {
        return this.theSystem.remove(hardwareName);
    }

    @Override
    public Hardware get(String hardwareName) {
        return this.theSystem.get(hardwareName);
    }
}
