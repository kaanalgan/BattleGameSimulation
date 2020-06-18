package commands;

import exceptions.IllegalPlayerOperationException;
import exceptions.UnknownWarcraftTypeException;
import gameengine.IGameEngine;
import io.IDisplay;
import io.Input;
import warcrafts.*;
import warcrafts.plane.Engine;
import warcrafts.plane.PlaneType;
import warcrafts.ship.Ship;
import warcrafts.ship.ShipType;

public class AddItemCommand extends AbstractCommand{

    private int playerNo;
    private IDisplay displayHandler;
    private Input inputHandler;

    public AddItemCommand(IGameEngine gameEngine, int playerNo, IDisplay displayHandler, Input inputHandler) {
        super(gameEngine);
        this.playerNo = playerNo;
        this.displayHandler = displayHandler;
        this.inputHandler = inputHandler;
    }

    @Override
    public void execute() {

        /* Max five items */
        String menuText = " 1. Plane \n 2. Ship";
        displayHandler.displayMenu(menuText, "Choose a warcraft: ");
        int warcraftNo = inputHandler.readInt();
        WarcraftType warcraftType;
        int typeNo;
        Warcraft newWarcraft;

        switch(warcraftNo){
            case 1:
                menuText = "1. Fighter plane\n2. Bomber Plane\n3. Multirole Plane.";
                displayHandler.displayMenu(menuText, "Choose a plane type: ");
                typeNo = inputHandler.readInt();
                switch(typeNo){
                    case 1:
                        warcraftType = PlaneType.FIGHTER;
                        break;

                    case 2:
                        warcraftType = PlaneType.BOMBER;
                        break;

                    case 3:
                        warcraftType = PlaneType.MULTIROLE;
                        break;

                    default:
                        //TODO: Change this later on.
                        warcraftType = PlaneType.FIGHTER;
                        break;
                }

                menuText = "1. Pulsejet.\n2. Turbojet.";
                displayHandler.displayMenu(menuText, "Choose an engine type: ");
                int engineNo = inputHandler.readInt();
                Engine engine;

                switch(engineNo){
                    case 1:
                        engine = Engine.PULSEJET;
                        break;

                    case 2:
                        engine = Engine.TURBOJET;
                        break;

                    default:
                        engine = Engine.PULSEJET;
                        break;
                }
                try{
                    getGameEngine().addWarcraft(playerNo, warcraftType, engine);
                }catch(UnknownWarcraftTypeException | IllegalPlayerOperationException e){
                    displayHandler.displayErrorMessage(e.getMessage());
                }
                break;

            case 2:
                menuText = "1. Cruiser ship\n2. Destroyer ship\n3. Frigate ship.";
                displayHandler.displayMenu(menuText, "Choose a ship type: ");
                typeNo = inputHandler.readInt();
                switch(typeNo){
                    case 1:
                        warcraftType = ShipType.CRUISER;
                        break;

                    case 2:
                        warcraftType = ShipType.DESTROYER;
                        break;

                    case 3:
                        warcraftType = ShipType.FRIGATE;
                        break;

                    default:
                        warcraftType = ShipType.CRUISER;
                        break;
                }
                newWarcraft = new Ship((ShipType)warcraftType);
                try {
                    getGameEngine().addWarcraft(playerNo, warcraftType, null);
                } catch (UnknownWarcraftTypeException | IllegalPlayerOperationException e) {
                    displayHandler.displayErrorMessage(e.getMessage());
                }
                break;

            default:
                break;
        }
    }

    public String toString() { return "Add item"; }
}
