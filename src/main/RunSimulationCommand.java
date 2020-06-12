package main;

public class RunSimulationCommand extends AbstractCommand{

    public RunSimulationCommand(IGameEngine gameEngine) {
        super(gameEngine);
    }

    @Override
    public void execute() {
        getGameEngine().runSimulation();
    }
}
