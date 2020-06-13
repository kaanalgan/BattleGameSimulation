package main;

import java.util.List;

public interface Warcraft {

    public int getPoint();

    public boolean addAddables(Addable addable);

    public WarcraftType getType();

    public List<Addable> getAddables();
}
