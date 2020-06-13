package main;

import exceptions.IllegalWarcraftTypeException;

public class Torpedo extends WarcraftDecorator{

    public Torpedo(Warcraft warcraft) throws IllegalWarcraftTypeException {
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
