package main;

public class Main {
    public static void main(String[] args) {
        PlaneFactory planeFactory = new MultirolePlaneFactory();
        Warcraft plane1 = planeFactory.createPlane(Engine.TURBOJET);
        System.out.println(plane1.getPoint());
        plane1 = new Rocket(plane1);
        System.out.println(plane1.getPoint());
        plane1 = new Torpedo(plane1);
        System.out.println(plane1.getPoint());

    }
}
