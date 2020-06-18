package gameengine;


import exceptions.IllegalPlayerOperationException;
import warcrafts.addables.Addable;
import exceptions.UnknownWarcraftTypeException;
import utilities.GameReport;
import warcrafts.plane.Engine;
import warcrafts.Warcraft;
import warcrafts.WarcraftType;

import java.util.List;

public interface IGameEngine {

    public boolean addWarcraft(int playerNo, WarcraftType warcraftType) throws UnknownWarcraftTypeException, IllegalPlayerOperationException;

    public boolean addWarcraft(int playerNo, WarcraftType warcraftType, Engine engine) throws UnknownWarcraftTypeException, IllegalPlayerOperationException;

    public boolean addPart(int playerNo, int warcraftNo, Addable part);

    public List<Warcraft> getPlayerLoadout(int playerNo);

    public GameReport runSimulation();

    public void resetItems();

}
