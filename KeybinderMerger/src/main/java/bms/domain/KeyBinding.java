package bms.domain;

import java.util.List;

public class KeyBinding {

    private String filePath;
    private List<String> lines;

    public KeyBinding(){}

    public KeyBinding(String filePath, List<String> lines) {
        this.filePath = filePath;
        this.lines = lines;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public List<String> getLines() {
        return lines;
    }

    public void setLines(List<String> lines) {
        this.lines = lines;
    }
}
