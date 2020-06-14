package commands;

import main.IDisplay;
import main.IGameEngine;
import main.Input;
import main.Warcraft;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerCommand extends AbstractMenuCommand{

    private int playerNo;

    public PlayerCommand(IGameEngine gameEngine, int playerNo, Input inputHandler, IDisplay displayHandler) {
        super(gameEngine, displayHandler, inputHandler);
        this.playerNo = playerNo;
        initiateMenu();
    }

    @Override
    public void execute() {
        getDisplayHandler().displayMenu(getMenuText(), "Choose an operation: ");
        int operationId = getInputHandler().readInt();
        getCommandContainer().execute(operationId);

    }

    public String toString(){ return "Player" + playerNo; }

    protected void initiateCommands(){
        setCommandContainer(new CommandContainer(new HashMap<>()));

        ICommand addItemCommand = new AddItemCommand(getGameEngine(), playerNo, getDisplayHandler(), getInputHandler());
        ICommand addPartCommand = new AddPartCommand(getGameEngine(),getGameEngine().getPlayerLoadout(playerNo), getDisplayHandler(), getInputHandler(), playerNo);

        getCommandContainer().register(1, addItemCommand);
        getCommandContainer().register(2, addPartCommand);
    }
}
