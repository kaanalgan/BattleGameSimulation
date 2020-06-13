package main;

public abstract class AbstractCommand implements ICommand{

    private IGameEngine gameEngine;

    protected AbstractCommand(IGameEngine gameEngine){
        this.gameEngine = gameEngine;
    }

    protected IGameEngine getGameEngine(){ return gameEngine; }

}
