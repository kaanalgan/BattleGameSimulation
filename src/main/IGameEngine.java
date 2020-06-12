package main;


public interface IGameEngine {

    public boolean addWarcraft(int playerNo, WarcraftType warcraftType);

    public boolean addPart(int playerNo, int warcraftNo, Addable part);

    public void runSimulation();

    public void resetItems();

}
