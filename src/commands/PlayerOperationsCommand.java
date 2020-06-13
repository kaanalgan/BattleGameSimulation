package commands;

import main.IDisplay;
import main.IGameEngine;
import main.Input;

import java.util.HashMap;
import java.util.Map;

public class PlayerOperationsCommand extends AbstractCommand{

    private Input inputHandler;
    private IDisplay displayHandler;
    private String playerMenuText;
    private CommandContainer commands;

    public PlayerOperationsCommand(IGameEngine gameEngine, Input inputHandler, IDisplay displayHandler) {
        super(gameEngine);
        this.inputHandler = inputHandler;
        this.displayHandler = displayHandler;
        initiateCommands();
        initiatePlayerMenu();
    }

    @Override
    public void execute() {

        //TODO: Let the user choose which player to customize
        //TODO: Get the input as to which player object to customize
        displayHandler.displayMenu(playerMenuText, "Choose a command: ");
        int operationId = inputHandler.readInt();
        try{
            commands.execute(operationId);

        }catch(UnsupportedOperationException e){
            e.printStackTrace();
        }
    }


    public String toString(){
        return "Player Operations";
    }


    private void initiateCommands(){
        commands = new CommandContainer(new HashMap<>());

        ICommand displayLoadoutsCommand = new DisplayLoadoutsCommand(getGameEngine(), displayHandler);
        ICommand player1Command = new PlayerCommand(getGameEngine(), 1, inputHandler, displayHandler);
        ICommand player2Command = new PlayerCommand(getGameEngine(), 2, inputHandler, displayHandler);

        commands.register(1, player1Command);
        commands.register(2, player2Command);
        commands.register(3, displayLoadoutsCommand);
    }


    private void initiatePlayerMenu(){
        StringBuilder availableCommands = new StringBuilder();
        Map<Integer, ICommand> commandMap = commands.getCommands();
        for(Integer i : commandMap.keySet()){
            availableCommands.append(i + ". " + commandMap.get(i).toString() + "\n");
        }
        playerMenuText = availableCommands.toString();
    }


}
