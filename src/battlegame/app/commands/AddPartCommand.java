package battlegame.app.commands;

import battlegame.warcrafts.Addable;
import battlegame.IGameEngine;
import exceptions.PartAlreadyExistsException;
import exceptions.PartNotCompatibleException;
import io.IDisplay;
import io.Input;
import battlegame.warcrafts.*;
import battlegame.warcrafts.plane.Plane;
import battlegame.warcrafts.plane.PlaneType;
import battlegame.warcrafts.ship.Ship;
import battlegame.warcrafts.ship.ShipType;

import java.util.List;

public class AddPartCommand extends AbstractCommand {

    private List<Warcraft> warcrafts;
    private IDisplay displayHandler;
    private Input inputHandler;
    private String menuItems;
    private int playerNo;

    public AddPartCommand(IGameEngine gameEngine, IDisplay displayHandler, Input inputHandler, int playerNo) {
        super(gameEngine);
        setWarcrafts(getGameEngine().getPlayerLoadout(playerNo));
        setInputHandler(inputHandler);
        setDisplayHandler(displayHandler);
        setPlayerNo(playerNo);
        initiateMenuText();
    }


    private void initiateMenuText(){
        StringBuilder warcrafts = new StringBuilder();
        int menuItemIndex = 1;
        for(Warcraft w : this.warcrafts){
            warcrafts.append(menuItemIndex + ". " + w.toString() + "\n");
            menuItemIndex++;
        }
        menuItems = warcrafts.toString();
    }

    private void setWarcrafts(List<Warcraft> warcrafts){
        if(warcrafts == null){
            throw new IllegalArgumentException("Player's list of battlegame.warcrafts cannot be null");
        }
        this.warcrafts = warcrafts;
    }

    private void setDisplayHandler(IDisplay displayHandler){
        if(displayHandler == null){
            throw new IllegalArgumentException("IDisplay object cannot be null");
        }
        this.displayHandler = displayHandler;
    }

    private void setInputHandler(Input inputHandler){
        if(inputHandler == null){
            throw new IllegalArgumentException("IDisplay object cannot be null");
        }
        this.inputHandler = inputHandler;
    }

    private void setPlayerNo(int playerNo) {
        if(playerNo <= 0){
            throw new IllegalArgumentException("Given player number must be greater than 0");
        }
        this.playerNo = playerNo;
    }

    public String toString(){ return "Add part"; }

    @Override
    public void execute() {

        if(warcrafts.size() == 0){
            displayHandler.displayWarning("No warcraft to select!");
            return;
        }

        /* Get the most up-to-date loadout of the player. */
        initiateMenuText();

        displayHandler.displayMenu(menuItems, "Choose a warcraft: ");
        int id = inputHandler.readInt();

        if(id-1 >= warcrafts.size()){
            displayHandler.displayErrorMessage("No item with given number");
            return;
        }

        Warcraft selectedWarcraft = warcrafts.get(id-1);
        System.out.println("selected warcraft : " + selectedWarcraft.getType());
        int partId;
        Addable partToAdd;

        if(selectedWarcraft.getClass() == Ship.class ||
            selectedWarcraft.getType() instanceof ShipType){
            menuItems = "1. Rocket\n" +
                        "2. Torpedo\n" +
                        "3. Cannon";

            displayHandler.displayMenu(menuItems, "Choose a part to add: ");
            partId = inputHandler.readInt();
            switch (partId){
                case 1:
                    partToAdd = Addable.ROCKET;
                    break;

                case 2:
                    partToAdd = Addable.TORPEDO;
                    break;

                case 3:
                    partToAdd = Addable.CANNON;
                    break;

                default:
                    //TODO
                    partToAdd = Addable.ROCKET;
                    break;
            }


        }else if(selectedWarcraft.getClass() == Plane.class ||
                selectedWarcraft.getType() instanceof PlaneType){

            menuItems = "1. Rocket\n" +
                        "2. Missile\n" +
                        "3. Machine gun\n" +
                        "4. Bomb";

            displayHandler.displayMenu(menuItems, "Choose a part to add: ");
            partId = inputHandler.readInt();

            switch (partId){
                case 1:
                    partToAdd = Addable.ROCKET;
                    break;

                case 2:
                    partToAdd = Addable.MISSILE;
                    break;

                case 3:
                    partToAdd = Addable.MACHINE_GUN;
                    break;

                case 4:
                    partToAdd = Addable.BOMB;
                    break;

                default:
                    //TODO
                    partToAdd = Addable.ROCKET;
                    break;
            }

        }else{
            return;
        }


        try {
            getGameEngine().addPart(playerNo, id, partToAdd);
        } catch (PartNotCompatibleException | PartAlreadyExistsException e) {
            displayHandler.displayErrorMessage(e.getMessage());
        }

    }
}
