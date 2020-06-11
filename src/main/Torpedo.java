package main;

public class Torpedo extends WarcraftDecorator{

    public Torpedo(Warcraft warcraft) {
        super(warcraft);
        //warcraft.addAddables(Addable.TORPEDO);
    }

    @Override
    public int getPoint() {
        return warcraft.getPoint();// + Addable.TORPEDO.getMaxPoint();
    }
}
