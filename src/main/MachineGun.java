package main;

import exceptions.IllegalWarcraftTypeException;

public class MachineGun extends WarcraftDecorator{

    public MachineGun(Warcraft warcraft) throws IllegalWarcraftTypeException {
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
