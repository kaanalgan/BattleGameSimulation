package commands;

import io.IDisplay;
import gameengine.IGameEngine;

public class ExitGameCommand extends AbstractCommand{

    private IDisplay displayHandler;

    public ExitGameCommand(IGameEngine gameEngine, IDisplay displayHandler) {
        super(gameEngine);
        this.displayHandler = displayHandler;
    }

    @Override
    public void execute() {
        displayHandler.displayWarning("Quitting game....");
        System.exit(0);
    }

    @Override
    public String toString() {
        return "Quit Game";
    }
}
