package commands;

import main.IDisplay;
import main.IGameEngine;
import main.Input;
import main.Warcraft;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerCommand extends AbstractCommand{

    private int playerNo;
    private IDisplay displayHandler;
    private Input inputHandler;
    private CommandContainer playerSpecificOperations;
    private String menuText;

    public PlayerCommand(IGameEngine gameEngine, int playerNo, Input inputHandler, IDisplay displayHandler) {
        super(gameEngine);
        this.playerNo = playerNo;
        this.displayHandler = displayHandler;
        this.inputHandler = inputHandler;
        initiateCommands();
        initiateMenuText();
    }

    @Override
    public void execute() {
        /*List<Warcraft> playersLoadout = getGameEngine().getPlayerLoadout(playerNo);
        StringBuilder playerLoadoutBuilder = new StringBuilder();
        int loadoutNumber = 1;
        for(Warcraft w : playersLoadout){
            playerLoadoutBuilder.append(loadoutNumber + ". " + w.toString());
        }*/
        displayHandler.displayMenu(menuText, "Choose an operation: ");
        int operationId = inputHandler.readInt();
        playerSpecificOperations.execute(operationId);

    }

    public String toString(){ return "Player" + playerNo; }

    private void initiateCommands(){
        playerSpecificOperations = new CommandContainer(new HashMap<>());

        ICommand addItemCommand = new AddItemCommand(getGameEngine(), playerNo, displayHandler, inputHandler);
        ICommand addPartCommand = new AddPartCommand(getGameEngine(),getGameEngine().getPlayerLoadout(playerNo), displayHandler, inputHandler, playerNo);

        playerSpecificOperations.register(1, addItemCommand);
        playerSpecificOperations.register(2, addPartCommand);
    }

    private void initiateMenuText(){
        StringBuilder menu = new StringBuilder();
        Map<Integer, ICommand> commandMap = playerSpecificOperations.getCommands();
        int count = 0;
        for(Integer i : commandMap.keySet()){
            menu.append(i + ". " + commandMap.get(i));
            count++;
            if(count < commandMap.keySet().size()){
                menu.append("\n");
            }
        }
        menuText = menu.toString();
    }
}
