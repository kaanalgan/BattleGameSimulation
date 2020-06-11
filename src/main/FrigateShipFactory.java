package main;

public class FrigateShipFactory implements ShipFactory{
    @Override
    public Ship createShip() {
        return new Ship(ShipType.FRIGATE);
    }
}
