package addables;

import exceptions.IllegalWarcraftTypeException;
import exceptions.PartAlreadyExistException;
import warcrafts.plane.Plane;
import warcrafts.Warcraft;

public class Bomb extends WarcraftDecorator{

    public Bomb(Warcraft warcraft) throws IllegalWarcraftTypeException, PartAlreadyExistException {
        super(warcraft);
        if(!getOgType().equals(Plane.class)){
            throw new IllegalWarcraftTypeException("This warcraft cannot equip Torpedo.");
        }
        warcraft.addAddables(Addable.BOMB);
    }

    @Override
    public int getPoint() {
        return Addable.BOMB.getPoint() + getWarcraft().getPoint();
    }
}
