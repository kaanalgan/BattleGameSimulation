package commands;

import io.IDisplay;
import gameengine.IGameEngine;
import io.Input;

import java.util.HashMap;

public class PlayerOperationsCommand extends AbstractMenuCommand{

    public PlayerOperationsCommand(IGameEngine gameEngine, Input inputHandler, IDisplay displayHandler) {
        super(gameEngine, displayHandler, inputHandler);
        initiateMenu();
    }

    @Override
    public void execute() {

        //TODO: Let the user choose which player to customize
        //TODO: Get the input as to which player object to customize
        int operationId;
        while(true){
            getDisplayHandler().displayMenu(getMenuText(), "Choose a command: ");
            operationId = getInputHandler().readInt();
            if(operationId == 4){
                break;
            }
            try{
                getCommandContainer().execute(operationId);

            }catch(UnsupportedOperationException e){
                e.printStackTrace();
            }
        }

    }


    public String toString(){
        return "Player Operations";
    }


    protected void initiateCommands(){
        setCommandContainer(new CommandContainer(new HashMap<>()));

        ICommand displayLoadoutsCommand = new DisplayLoadoutsCommand(getGameEngine(), getDisplayHandler());
        ICommand player1Command = new PlayerCommand(getGameEngine(), 1, getInputHandler(), getDisplayHandler());
        ICommand player2Command = new PlayerCommand(getGameEngine(), 2, getInputHandler(), getDisplayHandler());

        getCommandContainer().register(1, player1Command);
        getCommandContainer().register(2, player2Command);
        getCommandContainer().register(3, displayLoadoutsCommand);
    }

}
