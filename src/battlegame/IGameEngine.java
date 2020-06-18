package battlegame;


import exceptions.IllegalPlayerOperationException;
import battlegame.warcrafts.Addable;
import exceptions.PartNotCompatibleException;
import exceptions.UnknownWarcraftTypeException;
import battlegame.utilities.GameReport;
import battlegame.warcrafts.plane.Engine;
import battlegame.warcrafts.Warcraft;
import battlegame.warcrafts.WarcraftType;

import java.util.List;

public interface IGameEngine {

    public boolean addWarcraft(int playerNo, WarcraftType warcraftType) throws UnknownWarcraftTypeException, IllegalPlayerOperationException;

    public boolean addWarcraft(int playerNo, WarcraftType warcraftType, Engine engine) throws UnknownWarcraftTypeException, IllegalPlayerOperationException;

    public boolean addPart(int playerNo, int warcraftNo, Addable part) throws PartNotCompatibleException;

    public List<Warcraft> getPlayerLoadout(int playerNo);

    public GameReport runSimulation();

    public void resetItems();

}
