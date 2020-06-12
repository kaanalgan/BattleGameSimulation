package main;

public class Bomb extends WarcraftDecorator{

    public Bomb(Warcraft warcraft) throws IllegalWarcraftTypeException {
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
