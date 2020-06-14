package main;

import commands.*;

import java.util.HashMap;
import java.util.Map;

public class GameMenu extends AbstractMenuCommand {

    public GameMenu(IGameEngine gameEngine, Input inputHandler, IDisplay displayHandler){
        super(gameEngine, displayHandler, inputHandler);
        initiateMenu();
    }

    @Override
    protected void initiateCommands() {

        //Available commands' container
        setCommandContainer(new CommandContainer(new HashMap<Integer, ICommand>()));

        //Initiate commands
        ICommand resetGameCommand = new ResetCommand(getGameEngine());
        ICommand runSimulationCommand = new RunSimulationCommand(getGameEngine(), getDisplayHandler());
        ICommand playerOperationsCommand = new PlayerOperationsCommand(getGameEngine(), getInputHandler(), getDisplayHandler());
        ICommand exitGameCommand = new ExitGameCommand(getGameEngine(), getDisplayHandler());

        //Add created commands
        getCommandContainer().register(1, playerOperationsCommand);
        getCommandContainer().register(2, runSimulationCommand);
        getCommandContainer().register(3, resetGameCommand);
        getCommandContainer().register(4, exitGameCommand);
    }


    @Override
    public void execute() {
        getDisplayHandler().displayMenu(getMenuText(), "Choose a command: ");
        int commandId = getInputHandler().readInt();

        try{
            getCommandContainer().execute(commandId);

        }catch(UnsupportedOperationException e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Main Menu";
    }


}
