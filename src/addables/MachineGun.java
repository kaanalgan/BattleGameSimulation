package addables;

import exceptions.IllegalWarcraftTypeException;
import exceptions.PartAlreadyExistException;
import warcrafts.plane.Plane;
import warcrafts.Warcraft;

public class MachineGun extends WarcraftDecorator{

    public MachineGun(Warcraft warcraft) throws IllegalWarcraftTypeException, PartAlreadyExistException {
        super(warcraft);
        if(!getOgType().equals(Plane.class)){
            throw new IllegalWarcraftTypeException("This warcraft cannot equip Machine Gun.");
        }
        warcraft.addAddables(Addable.MACHINE_GUN);
    }

    @Override
    public int getPoint() {
        return Addable.MACHINE_GUN.getPoint() + getWarcraft().getPoint();
    }
}
