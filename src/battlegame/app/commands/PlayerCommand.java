package battlegame.app.commands;

import io.IDisplay;
import battlegame.IGameEngine;
import io.Input;

import java.util.HashMap;

public class PlayerCommand extends AbstractMenuCommand{

    private int playerNo;

    public PlayerCommand(IGameEngine gameEngine, int playerNo, Input inputHandler, IDisplay displayHandler) {
        super(gameEngine, displayHandler, inputHandler);
        this.playerNo = playerNo;
        initiateMenu();
    }

    public String toString(){ return "Player" + playerNo; }

    protected void initiateCommands(){
        setCommandContainer(new CommandContainer(new HashMap<>()));

        ICommand addItemCommand = new AddItemCommand(getGameEngine(), playerNo, getDisplayHandler(), getInputHandler());
        ICommand addPartCommand = new AddPartCommand(getGameEngine(), getDisplayHandler(), getInputHandler(), playerNo);

        getCommandContainer().register(1, addItemCommand);
        getCommandContainer().register(2, addPartCommand);
    }
}