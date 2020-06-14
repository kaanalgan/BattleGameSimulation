package addables;

import warcrafts.Warcraft;

public class Rocket extends WarcraftDecorator{

    public Rocket(Warcraft warcraft) {
        super(warcraft);
        warcraft.addAddables(Addable.ROCKET);
    }

    @Override
    public int getPoint() {
        return Addable.ROCKET.getPoint() + getWarcraft().getPoint();
    }
}
