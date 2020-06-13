package commands;

import main.IGameEngine;

public class ResetCommand extends AbstractCommand{

    public ResetCommand(IGameEngine gameEngine) {
        super(gameEngine);
    }

    @Override
    public void execute() {
        getGameEngine().resetItems();
    }

    public String toString(){
        return "Reset Items";
    }
}
