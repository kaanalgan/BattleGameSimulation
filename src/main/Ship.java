package main;

import java.util.List;

public class Ship extends AbstractWarcraft {
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
        List<Addable> addables = getAddables();
        StringBuilder warcraftStrBuilder = new StringBuilder();
        warcraftStrBuilder.append(type.toString() + " [" + type.getPoint() + "] " + " (");
        for(Addable a : addables){
            warcraftStrBuilder.append(a.toString());
        }
        return warcraftStrBuilder.toString();
    }

    private void setShipType(ShipType shipType) {
        this.type = shipType;
    }


}
