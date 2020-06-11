package main;

public class MultirolePlaneFactory implements PlaneFactory{
    @Override
    public Plane createPlane(Engine engine) {
        return new Plane(PlaneType.MULTIROLE, engine);
    }
}
