package main;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player();

        ShipFactory destroyerShipFactory = new DestroyerShipFactory();
        ShipFactory frigateShipFactory = new FrigateShipFactory();

        Warcraft ship1 = frigateShipFactory.createShip();
        Warcraft ship2 = frigateShipFactory.createShip();

        Warcraft ship3 = frigateShipFactory.createShip();
        ship3 = new Rocket(ship3);

        Warcraft ship4 = destroyerShipFactory.createShip();
        ship4 = new Rocket(ship4);
        try {
            ship4 = new Missile(ship4);
        } catch (IllegalWarcraftTypeException e) {
            e.printStackTrace();
        }
        try {
            ship4 = new Torpedo(ship4);
        } catch (IllegalWarcraftTypeException e) {
            e.printStackTrace();
        }

        System.out.println(player1.addWarcrafts(ship1));
        System.out.println(player1.addWarcrafts(ship2));
        System.out.println(player1.addWarcrafts(ship3));
        System.out.println(player1.addWarcrafts(ship4));

        PlaneFactory multirolePlaneFactory = new MultirolePlaneFactory();
        PlaneFactory fighterPlaneFactory = new FighterPlaneFactory();

        Warcraft plane1 = multirolePlaneFactory.createPlane(Engine.TURBOJET);
        Warcraft plane2 = multirolePlaneFactory.createPlane(Engine.PULSEJET);

        Warcraft plane3 = multirolePlaneFactory.createPlane(Engine.TURBOJET);
        plane3 = new Rocket(plane3);

        Warcraft plane4 = fighterPlaneFactory.createPlane(Engine.PULSEJET);
        plane4 = new Rocket(plane4);
        try {
            plane4 = new Missile(plane4);
        } catch (IllegalWarcraftTypeException e) {
            e.printStackTrace();
        }
        try {
            plane4 = new Torpedo(plane4);
        } catch (IllegalWarcraftTypeException e) {
            e.printStackTrace();
        }

        System.out.println(player1.addWarcrafts(plane1));
        System.out.println(player1.addWarcrafts(plane2));
        System.out.println(player1.addWarcrafts(plane3));
        System.out.println(player1.addWarcrafts(plane4));


    }
}