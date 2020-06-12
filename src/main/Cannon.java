package main;

public class Cannon extends WarcraftDecorator{

    public Cannon(Warcraft warcraft) {
        super(warcraft);
        warcraft.addAddables(Addable.CANNON);
    }

    @Override
    public int getPoint() {
        return Addable.CANNON.getPoint() + warcraft.getPoint();
    }
}
