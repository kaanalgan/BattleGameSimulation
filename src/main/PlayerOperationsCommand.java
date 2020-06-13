package main;

import java.util.HashMap;
import java.util.Map;

public class PlayerOperationsCommand extends AbstractCommand{

    private Input inputHandler;
    private CommandContainer commandContainer;
    private IDisplay displayHandler;
    private String playerMenuText;
    private CommandContainer commands;

    public PlayerOperationsCommand(IGameEngine gameEngine, Input inputHandler, IDisplay displayHandler) {
        super(gameEngine);
        initiatePlayerMenu();
        initiateCommands();
    }

    @Override
    public void execute() {

        //TODO: Let the user choose which player to customize
        //TODO: Get the input as to which player object to customize
        displayHandler.displayMenu(playerMenuText, "Choose ar command: ");
        int operationId = inputHandler.readInt();
        commands.execute(operationId);



        //TODO: Display another menu in which there will be: add or show parts options
        //TODO: Get the input as to which operation to perform



        //TODO: Maybe additional commands are required? (AddPartCommand, RemovePartCommand)
        //TODO: Another CommandContainer object as attribute for this class?

        //TODO: If show loadout is chosen -> display loadout and go back to main menu?How?
        /*TODO: */

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
            availableCommands.append(i + ". " + commandMap.get(i) + "\n");
        }
        playerMenuText = availableCommands.toString();
    }


}
