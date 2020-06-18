package warcrafts.addables;

import warcrafts.plane.Plane;
import warcrafts.ship.Ship;
import warcrafts.Warcraft;
import warcrafts.WarcraftType;

public abstract class WarcraftDecorator implements Warcraft {

    private Warcraft warcraft;
    private Class originalType;

    public WarcraftDecorator(Warcraft warcraft) {
        this.warcraft = warcraft;

        if (warcraft instanceof Plane) {
            originalType = Plane.class;
        } else if (warcraft instanceof Ship) {
            originalType = Ship.class;
        } else if (warcraft instanceof WarcraftDecorator) {
            originalType = ((WarcraftDecorator) warcraft).getOriginalType();
        }
    }
    
    public String toString(){
        return warcraft.toString();
    }
    
    public Class getOriginalType() {
        return originalType;
    }

    public Warcraft getWarcraft() {
        return warcraft;
    }

    public WarcraftType getType() {
        return warcraft.getType();
    }

}
