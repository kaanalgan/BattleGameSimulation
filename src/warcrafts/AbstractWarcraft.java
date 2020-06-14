package warcrafts;

import addables.Addable;
import exceptions.PartAlreadyExistException;
import warcrafts.Warcraft;
import warcrafts.WarcraftType;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class AbstractWarcraft implements Warcraft {

    Set<Addable> addables;
    WarcraftType type;

    public AbstractWarcraft() {
        this.addables = new HashSet<>();
    }

    public boolean addAddables(Addable addable) throws PartAlreadyExistException {
        if(addables.add(addable)){
            return true;
        }else{
            throw new PartAlreadyExistException("Part that you trying to add already mounted to the warcraft");
        }
    }

    public List<Addable> getAddables(){ return new ArrayList<>(addables); }

    @Override
    public WarcraftType getType() {
        return type;
    }
}
