package addables;

import exceptions.PartAlreadyExistException;
import warcrafts.AbstractWarcraft;
import warcrafts.plane.Plane;
import warcrafts.ship.Ship;
import warcrafts.Warcraft;
import warcrafts.WarcraftType;

public abstract class WarcraftDecorator extends AbstractWarcraft {

    private Warcraft warcraft;
    private Class ogType;
    private WarcraftType type;

    public WarcraftDecorator(Warcraft warcraft) {
        if (warcraft instanceof Plane) {
            ogType = Plane.class;
        } else if (warcraft instanceof Ship) {
            ogType = Ship.class;
        } else if (warcraft instanceof WarcraftDecorator) {
            ogType = ((WarcraftDecorator) warcraft).getOgType();
        }
        this.warcraft = warcraft;
    }
    
    public String toString(){
        return warcraft.toString();
    }
    
    public Class getOgType() {
        return ogType;
    }

    public Warcraft getWarcraft() {
        return warcraft;
    }

    public WarcraftType getType() {
        return warcraft.getType();
    }

    @Override
    public boolean addAddables(Addable addable) throws PartAlreadyExistException {
        return warcraft.addAddables(addable);
    }
}
