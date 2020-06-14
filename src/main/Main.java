package main;

import addables.Missile;
import addables.Rocket;
import addables.Torpedo;
import exceptions.IllegalWarcraftTypeException;
import players.Player;
import warcrafts.*;
import warcrafts.plane.Engine;
import warcrafts.plane.FighterPlaneFactory;
import warcrafts.plane.MultirolePlaneFactory;
import warcrafts.plane.PlaneFactory;
import warcrafts.ship.DestroyerShipFactory;
import warcrafts.ship.FrigateShipFactory;
import warcrafts.ship.ShipFactory;

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

        System.out.println(player1.addWarcraft(ship1));
        System.out.println(player1.addWarcraft(ship2));
        System.out.println(player1.addWarcraft(ship3));
        System.out.println(player1.addWarcraft(ship4));

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

        System.out.println(player1.addWarcraft(plane1));
        System.out.println(player1.addWarcraft(plane2));
        System.out.println(player1.addWarcraft(plane3));
        System.out.println(player1.addWarcraft(plane4));


    }
}
