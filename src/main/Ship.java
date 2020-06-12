package main;

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

    private void setShipType(ShipType shipType) {
        this.type = shipType;
    }
}
