package main;

public class Ship extends AbstractWarcraft{
    ShipType type;

    public Ship(ShipType type){
        setShipType(type);
    }

    @Override
    public int getPoint() {
        return 0;
    }


    private void setShipType(ShipType shipType){
        this.type = shipType;
    }
}
