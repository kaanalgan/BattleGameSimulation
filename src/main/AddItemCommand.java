package main;

import java.util.List;

public class AddItemCommand extends AbstractCommand{

    private int playerNo;

    public AddItemCommand(IGameEngine gameEngine, int playerNo) {
        super(gameEngine);
        this.playerNo = playerNo;
    }

    @Override
    public void execute() {

    }
}
