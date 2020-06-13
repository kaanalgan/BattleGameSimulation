package main;

import exceptions.IllegalWarcraftTypeException;

public class Cannon extends WarcraftDecorator{

    public Cannon(Warcraft warcraft) throws IllegalWarcraftTypeException {
        super(warcraft);
        if(!getOgType().equals(Ship.class)){
            throw new IllegalWarcraftTypeException("This warcraft cannot equip Cannon.");
        }
        warcraft.addAddables(Addable.CANNON);
    }

    @Override
    public int getPoint() {
        return Addable.CANNON.getPoint() + getWarcraft().getPoint();
    }
}
