package main;

public class MachineGun extends WarcraftDecorator{

    public MachineGun(Warcraft warcraft) {
        super(warcraft);
        warcraft.addAddables(Addable.MACHINE_GUN);
    }

    @Override
    public int getPoint() {
        return Addable.MACHINE_GUN.getPoint() + warcraft.getPoint();
    }
}
