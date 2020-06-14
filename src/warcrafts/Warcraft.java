package warcrafts;

import addables.Addable;
import exceptions.PartAlreadyExistException;

import java.util.List;

public interface Warcraft {

    public int getPoint();

    public boolean addAddables(Addable addable) throws PartAlreadyExistException;

    public WarcraftType getType();

    public List<Addable> getAddables();

    public String toString();
}
