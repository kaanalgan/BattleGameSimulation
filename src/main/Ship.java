package main;

public class Ship extends AbstractWarcraft{
    ShipType type;

    public Ship(ShipType type){
        super();
        setShipType(type);
    }

    @Override
    public int getPoint() {
        return type.getPoint();
    }


    private void setShipType(ShipType shipType){
        this.type = shipType;
    }
}
