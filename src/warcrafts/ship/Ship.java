package warcrafts.ship;

import warcrafts.Warcraft;
import warcrafts.WarcraftType;

public class Ship implements Warcraft {
    WarcraftType type;

    public Ship(ShipType type) {
        super();
        setShipType(type);
    }

    @Override
    public int getPoint() {
        return type.getPoint();
    }

    public WarcraftType getType() {
        return type;
    }

    @Override
    public String toString() {
        String str = type.toString() + " [" + type.getMinPoint() + ", " + type.getMaxPoint() + "] ";

        return str;
    }

    private void setShipType(ShipType shipType) {
        this.type = shipType;
    }


}
