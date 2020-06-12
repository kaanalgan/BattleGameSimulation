package main;

public class Torpedo extends WarcraftDecorator{

    public Torpedo(Warcraft warcraft) {
        super(warcraft);
        warcraft.addAddables(Addable.TORPEDO);
    }

    @Override
    public int getPoint() {
        return Addable.TORPEDO.getPoint() + warcraft.getPoint();
    }
}
