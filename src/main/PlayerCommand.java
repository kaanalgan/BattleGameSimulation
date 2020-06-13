package main;

import java.util.HashMap;
import java.util.Map;

public class PlayerCommand extends AbstractCommand{

    private int playerNo;
    private IDisplay displayHandler;
    private Input inputHandler;
    private CommandContainer playerSpecificOperations;
    private String menuText;

    public PlayerCommand(IGameEngine gameEngine, int playerNo, Input inputHandler, IDisplay displayHandler) {
        super(gameEngine);
        initiateCommands();
        initiateMenuText();
        this.displayHandler = displayHandler;
        this.inputHandler = inputHandler;
    }

    @Override
    public void execute() {
        displayHandler.displayMenu(menuText, "Choose an operation: ");
        int operationId = inputHandler.readInt();
        playerSpecificOperations.execute(operationId);
    }

    private void initiateCommands(){
        playerSpecificOperations = new CommandContainer(new HashMap<>());

        ICommand addItemCommand = new AddItemCommand(getGameEngine(), playerNo);
        ICommand addPartCommand = new AddPartCommand(getGameEngine());

        playerSpecificOperations.register(1, addItemCommand);
        playerSpecificOperations.register(2, addPartCommand);
    }

    private void initiateMenuText(){
        StringBuilder menu = new StringBuilder();
        Map<Integer, ICommand> commandMap = playerSpecificOperations.getCommands();
        for(Integer i : commandMap.keySet()){
            menu.append(i + ". " + commandMap.get(i) + "\n");
        }
        menuText = menu.toString();
    }
}
