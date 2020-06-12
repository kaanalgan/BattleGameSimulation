package main;

public class Plane extends AbstractWarcraft {

    private Engine engine;
    private WarcraftType type;

    public Plane(PlaneType planeType, Engine engine) {
        super();
        setPlaneType(planeType);
        setEngine(engine);
    }

    @Override
    public int getPoint() {
        return type.getPoint() + engine.getPoint();
    }

    public WarcraftType getType() {
        return type;
    }

    private void setPlaneType(PlaneType planeType) {
        this.type = planeType;
    }

    private void setEngine(Engine engine) {
        this.engine = engine;
    }

}
