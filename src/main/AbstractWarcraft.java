package main;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWarcraft implements Warcraft{

    List<Addable> addables;

    public AbstractWarcraft() {
        this.addables = new ArrayList<>();
    }

    public boolean addAddables(Addable addable) {
        return addables.add(addable);
    }
}
