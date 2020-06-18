package battlegame.app.commands;

import battlegame.IGameEngine;

public abstract class AbstractCommand implements ICommand{

    private IGameEngine gameEngine;

    protected AbstractCommand(IGameEngine gameEngine){
        this.gameEngine = gameEngine;
    }

    protected IGameEngine getGameEngine(){ return gameEngine; }

    public abstract String toString();

}
