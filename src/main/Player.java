package main;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Warcraft> warcrafts;

    public Player() {
        this.warcrafts = new ArrayList<>();
    }

    public boolean addWarcrafts(Warcraft warcraft) {
        if (warcrafts.size() < 5) {
            if (warcraft instanceof Plane) {
                return addPlane(warcraft);
            } else if (warcraft instanceof Ship) {
                return addShip(warcraft);
            } else if (warcraft instanceof WarcraftDecorator) {
                if (((WarcraftDecorator) warcraft).getOgType().equals(Plane.class)) {
                    return addPlane(warcraft);
                } else if (((WarcraftDecorator) warcraft).getOgType().equals(Ship.class)) {
                    return addShip(warcraft);
                } else System.out.println("Unknown type");
            } else System.out.println("Unknown type");
        } else {
            System.out.println("Cannot add more than 5 warcraft");
        }
        return false;
    }

    private boolean addShip(Warcraft ship) {
        boolean result = false;
        if (getShipCount() < 3) {
            if (getTypeCount(ship.getType()) < 2) {
                result = warcrafts.add(ship);
            } else {
                System.out.println("Cannot add more than 2 same type ship");
            }
        } else {
            System.out.println("Cannot add more than 3 ship");
        }
        return result;
    }

    private boolean addPlane(Warcraft plane) {
        boolean result = false;
        if (getPlaneCount() < 3) {
            if (getTypeCount(plane.getType()) < 2) {
                result = warcrafts.add(plane);
            } else {
                System.out.println("Cannot add more than 2 same type plane");
            }
        } else {
            System.out.println("Cannot add more than 3 plane");
        }
        return result;
    }

    public int getPlaneCount() {
        int count = 0;
        for (Warcraft warcraft : warcrafts) {
            if (warcraft instanceof Plane) {
                count++;
            } else if (warcraft instanceof WarcraftDecorator) {
                if (((WarcraftDecorator) warcraft).getOgType().equals(Plane.class)) {
                    count++;
                }
            }
        }
        return count;
    }

    public int getShipCount() {
        int count = 0;
        for (Warcraft warcraft : warcrafts) {
            if (warcraft instanceof Ship) {
                count++;
            } else if (warcraft instanceof WarcraftDecorator) {
                if (((WarcraftDecorator) warcraft).getOgType().equals(Ship.class)) {
                    count++;
                }
            }
        }
        return count;
    }

    public int getTypeCount(WarcraftType type) {
        int count = 0;
        for (Warcraft warcraft : warcrafts) {
            if (warcraft.getType().equals(type)) {
                count++;
            }
        }
        return count;
    }

    public List<Warcraft> getWarcrafts() {
        return warcrafts;
    }

    public void setWarcrafts(List<Warcraft> warcrafts) {
        this.warcrafts = warcrafts;
    }
}
