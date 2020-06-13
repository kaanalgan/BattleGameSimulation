package main;

public class AddPartCommand extends AbstractCommand{

    private int playerNo;

    public AddPartCommand(IGameEngine gameEngine, int playerNo) {
        super(gameEngine);
        this.playerNo = playerNo;
    }

    @Override
    public void execute() {

    }
}
