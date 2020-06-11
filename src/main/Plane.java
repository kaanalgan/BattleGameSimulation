package main;

public class Plane extends AbstractWarcraft {

    private Engine engine;
    private PlaneType type;

    public Plane(PlaneType planeType, Engine engine){
        setPlaneType(planeType);
        setEngine(engine);
    }

    @Override
    public int getPoint() {
        return 0;
    }


    private void setPlaneType(PlaneType planeType){
        this.type = planeType;
    }

    private void setEngine(Engine engine){
        this.engine = engine;
    }

}
