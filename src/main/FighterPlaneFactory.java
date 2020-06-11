package main;

public class FighterPlaneFactory implements PlaneFactory{
    @Override
    public Plane createPlane(Engine engine) {
        return new Plane(PlaneType.FIGHTER, engine);
    }
}
