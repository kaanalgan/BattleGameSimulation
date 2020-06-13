package main;


import java.util.List;

public interface IGameEngine {

    public boolean addWarcraft(int playerNo, WarcraftType warcraftType);

    public boolean addWarcraft(int playerNo, WarcraftType warcraftType, Engine engine);

    public boolean addPart(int playerNo, int warcraftNo, Addable part) throws IllegalWarcraftTypeException;

    public List<Warcraft> getPlayerLoadout(int playerNo);

    public GameReport runSimulation();

    public void resetItems();

}
