package main;

public class Missile extends WarcraftDecorator{

    public Missile(Warcraft warcraft) {
        super(warcraft);
        //warcraft.addAddables(Addable.MISSILE);
    }

    @Override
    public int getPoint() {
        return warcraft.getPoint();// + Addable.MISSILE.getMaxPoint();
    }
}
