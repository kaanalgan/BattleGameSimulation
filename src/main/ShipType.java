package main;

public enum ShipType implements WarcraftType {
    CRUISER(15, 30),
    DESTROYER(20, 40),
    FRIGATE(10, 45);

    private final int minPoint;
    private final int maxPoint;

    ShipType(int minPoint, int maxPoint) {
        this.minPoint = minPoint;
        this.maxPoint = maxPoint;
    }

    public int getPoint() {
        return maxPoint;
    }
}
