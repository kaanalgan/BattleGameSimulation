package main;

public enum Engine {
    PULSEJET(2,4),
    TURBOJET(5,7);

    private final int minPoint;
    private final int maxPoint;

    Engine(int minPoint, int maxPoint){
        this.minPoint = minPoint;
        this.maxPoint = maxPoint;
    }

    public int getPoint() {
        return maxPoint;
    }
}
