package warcrafts;

import addables.Addable;

import java.util.List;

public interface Warcraft {

    public int getPoint();

    public boolean addAddables(Addable addable);

    public WarcraftType getType();

    public List<Addable> getAddables();

    public String toString();
}
