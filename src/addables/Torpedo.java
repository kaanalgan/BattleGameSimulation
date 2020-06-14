package addables;

import exceptions.IllegalWarcraftTypeException;
import exceptions.PartAlreadyExistException;
import warcrafts.ship.Ship;
import warcrafts.Warcraft;

public class Torpedo extends WarcraftDecorator{

    public Torpedo(Warcraft warcraft) throws IllegalWarcraftTypeException, PartAlreadyExistException {
        super(warcraft);
        if(!getOgType().equals(Ship.class)){
            throw new IllegalWarcraftTypeException("This warcraft cannot equip Torpedo.");
        }
        warcraft.addAddables(Addable.TORPEDO);
    }

    @Override
    public int getPoint() {
        return Addable.TORPEDO.getPoint() + getWarcraft().getPoint();
    }
}
