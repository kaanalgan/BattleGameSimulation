package main;

public enum Addable {
    ROCKET(2,8),
    MISSILE(3,6),
    MACHINE_GUN(1,3),
    BOMB(0,10),
    TORPEDO(3,5),
    CANNON(3,7);

    private final int minPoint;
    private final int maxPoint;

    Addable(int minPoint, int maxPoint){
        this.minPoint = minPoint;
        this.maxPoint = maxPoint;
    }

    public int getPoint(){
        return maxPoint;
    }
}