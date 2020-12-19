package ioprintwriter.talentshow;

import java.util.ArrayList;
import java.util.List;

public class Production {
    private final int Id;
    private final String name;

    public Production(int id, String name) {
        Id = id;
        this.name = name;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return Integer.toString(Id) + " " + name;
    }
}
