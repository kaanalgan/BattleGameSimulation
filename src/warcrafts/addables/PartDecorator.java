package warcrafts.addables;

import warcrafts.Warcraft;

public class PartDecorator extends WarcraftDecorator{

    Addable addable;

    public PartDecorator(Warcraft warcraft, Addable addable) {
        super(warcraft);
        this.addable = addable;
    }

    @Override
    public int getPoint() {
        return getWarcraft().getPoint() + addable.getPoint();
    }

    @Override
    public String toString() {
        return super.toString() + " (" + addable.toString() + ")";
    }
}
