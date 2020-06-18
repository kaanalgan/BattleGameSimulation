package battlegame.warcrafts;

import battlegame.warcrafts.plane.Engine;
import battlegame.warcrafts.plane.Plane;
import battlegame.warcrafts.plane.PlaneType;
import battlegame.warcrafts.ship.Ship;
import exceptions.PartNotCompatibleException;

public class PartDecorator extends WarcraftDecorator {

    private Addable addable;

    public PartDecorator(Warcraft warcraft, Addable addable) throws PartNotCompatibleException {
        super(warcraft);
        this.addable = addable;
        if (getOriginalType() == Plane.class) {
            if (!(addable.equals(Addable.ROCKET) || addable.equals(Addable.MISSILE) || addable.equals(Addable.MACHINE_GUN) || addable.equals(Addable.BOMB))) {
                throw new PartNotCompatibleException("Wrong part");
            }
        } else if (getOriginalType() == Ship.class) {
            if (!(addable.equals(Addable.ROCKET) || addable.equals(Addable.TORPEDO) || addable.equals(Addable.CANNON))) {
                throw new PartNotCompatibleException("Wrong part");
            }
        }
    }

    @Override
    public int getPoint() {
        return getWarcraft().getPoint() + addable.getPoint();
    }

    @Override
    public String toString() {
        return super.toString() + " (" + addable.toString() + ")";
    }

}
