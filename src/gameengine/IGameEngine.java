package gameengine;


import addables.Addable;
import exceptions.IllegalWarcraftTypeException;
import exceptions.UnknownWarcraftTypeException;
import utilities.GameReport;
import warcrafts.plane.Engine;
import warcrafts.Warcraft;
import warcrafts.WarcraftType;

import java.util.List;

public interface IGameEngine {

    public boolean addWarcraft(int playerNo, WarcraftType warcraftType) throws UnknownWarcraftTypeException;

    public boolean addWarcraft(int playerNo, WarcraftType warcraftType, Engine engine) throws UnknownWarcraftTypeException;

    public boolean addPart(int playerNo, int warcraftNo, Addable part) throws IllegalWarcraftTypeException;

    public List<Warcraft> getPlayerLoadout(int playerNo);

    public GameReport runSimulation();

    public void resetItems();

}
