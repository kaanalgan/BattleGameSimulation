package warcrafts.plane;

import addables.Addable;
import warcrafts.AbstractWarcraft;
import warcrafts.WarcraftType;

import java.util.List;

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

    @Override
    public String toString() {
        List<Addable> addables = getAddables();
        StringBuilder warcraftStrBuilder = new StringBuilder();
        warcraftStrBuilder.append(type.toString() + " [" + type.getMinPoint()+ ", " + type.getMaxPoint()
                + "] " + " with " + engine.name() + " [" + engine.getMinPoint() + ", " + engine.getMaxPoint() + "]");
        System.out.println("addables' length: " + addables.size());
        for(Addable a : addables){
            warcraftStrBuilder.append("(" + a.toString() + ") ");
        }
        return warcraftStrBuilder.toString();
    }

    private void setPlaneType(PlaneType planeType) {
        this.type = planeType;
    }

    private void setEngine(Engine engine) {
        this.engine = engine;
    }

}
