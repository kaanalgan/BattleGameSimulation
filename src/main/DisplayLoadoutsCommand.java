package main;

import com.sun.xml.internal.bind.v2.model.core.ID;

public class DisplayLoadoutsCommand extends AbstractCommand{

    private IDisplay displayHandler;

    public DisplayLoadoutsCommand(IGameEngine gameEngine, IDisplay displayHandler) {
        super(gameEngine);
        this.displayHandler = displayHandler;
    }

    @Override
    public void execute() {
        //TODO: Get both players' loadouts and display
    }
}
