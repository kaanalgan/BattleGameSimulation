package main;

public class GameEngine implements IGameEngine {


    @Override
    public boolean addWarcraft(int playerNo, WarcraftType warcraftType) {
        return false;
    }

    @Override
    public boolean addPart(int playerNo, int warcraftNo, Addable part) {
        return false;
    }

    @Override
    public void runSimulation() {

    }

    @Override
    public void resetItems() {

    }
}
