package gameengine;

import addables.Addable;
import exceptions.IllegalWarcraftTypeException;
import exceptions.PartAlreadyExistException;
import exceptions.UnknownWarcraftTypeException;
import players.Player;
import utilities.GameReport;
import warcrafts.*;
import warcrafts.plane.*;
import warcrafts.ship.*;

import java.util.ArrayList;
import java.util.List;

public class GameEngine implements IGameEngine {

    private final Player[] players;

    public GameEngine(int playerNum){
        players = new Player[playerNum];

        for(int i=0; i<playerNum; i++){
            players[i] = new Player();
        }
    }

    @Override
    public boolean addWarcraft(int playerNo, WarcraftType warcraftType) throws UnknownWarcraftTypeException {
        Player player = players[playerNo];
        Warcraft warcraft = createWarcraft(warcraftType, null);
        return player.addWarcraft(warcraft);
    }

    @Override
    public boolean addWarcraft(int playerNo, WarcraftType warcraftType, Engine engine) throws UnknownWarcraftTypeException {
        Player player = players[playerNo-1];
        Warcraft warcraft = createWarcraft(warcraftType, engine);
        return player.addWarcraft(warcraft);
    }

    @Override
    public boolean addPart(int playerNo, int warcraftNo, Addable part) throws IllegalWarcraftTypeException, PartAlreadyExistException {
        Player player = players[playerNo-1];
        return player.addPartToWarcraft(warcraftNo-1, part);
    }

    @Override
    public List<Warcraft> getPlayerLoadout(int playerNo) {
        Player player = players[playerNo-1];
        return player.getWarcrafts();
    }

    @Override
    public GameReport runSimulation() {
        List<Integer> simulationScores = new ArrayList<>(players.length);

        for (Player player : players) {
            simulationScores.add(player.simulateAttack());
        }

        return new GameReport(simulationScores);
        
    }

    @Override
    public void resetItems() {
        for (Player player : players) {
            player.resetItems();
        }
    }

    private Warcraft createWarcraft(WarcraftType type, Engine engine) throws UnknownWarcraftTypeException {
        if(type.getClass() == PlaneType.class){
            PlaneType planeType = (PlaneType) type;
            PlaneFactory planeFactory;
            switch (planeType){
                case BOMBER: planeFactory = new BomberPlaneFactory();
                             break;
                case FIGHTER: planeFactory = new FighterPlaneFactory();
                              break;
                case MULTIROLE: planeFactory = new MultirolePlaneFactory();
                                break;
                default: planeFactory = new BomberPlaneFactory();
                         break;
            }

            return planeFactory.createPlane(engine);

        }else if(type.getClass() == ShipType.class){
            ShipType shipType = (ShipType) type;
            ShipFactory shipFactory;
            switch (shipType){
                case CRUISER: shipFactory = new CruiserShipFactory();
                              break;
                case FRIGATE: shipFactory = new FrigateShipFactory();
                              break;
                case DESTROYER: shipFactory = new DestroyerShipFactory();
                                break;
                default: shipFactory = new CruiserShipFactory();
                         break;
            }
            return shipFactory.createShip();
         }else{
            throw new UnknownWarcraftTypeException("Warcraft could not be created, type is unknown.");
        }
    }
}
