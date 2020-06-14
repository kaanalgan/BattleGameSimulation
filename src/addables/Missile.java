package addables;

import exceptions.IllegalWarcraftTypeException;
import exceptions.PartAlreadyExistException;
import warcrafts.plane.Plane;
import warcrafts.Warcraft;

public class Missile extends WarcraftDecorator{

    public Missile(Warcraft warcraft) throws IllegalWarcraftTypeException, PartAlreadyExistException {
        super(warcraft);
        if(!getOgType().equals(Plane.class)){
            throw new IllegalWarcraftTypeException("This warcraft cannot equip Missile.");
        }
        warcraft.addAddables(Addable.MISSILE);
    }

    @Override
    public int getPoint() {
        return Addable.MISSILE.getPoint() + getWarcraft().getPoint();
    }
}
