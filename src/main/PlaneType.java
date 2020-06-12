package main;

public enum PlaneType {
    FIGHTER(10,12),
    BOMBER(15,20),
    MULTIROLE(10,25);

    private final int minPoint;
    private final int maxPoint;

    PlaneType(int minPoint, int maxPoint){
        this.minPoint = minPoint;
        this.maxPoint = maxPoint;
    }

    public int getPoint() {
        return maxPoint;
    }
}
