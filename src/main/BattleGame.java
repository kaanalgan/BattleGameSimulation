package main;

import java.util.HashMap;

public class BattleGame {

    public void start(){

        //Game engine
        IGameEngine gameEngine = new GameEngine(2);

        CommandContainer commandContainer = new CommandContainer(new HashMap<Integer, ICommand>());

        //Create commands
        ICommand resetGameCommand = new ResetCommand(gameEngine);
        ICommand runSimulationCommand = new RunSimulationCommand(gameEngine);
        ICommand playerOperationsCommand = new PlayerOperationsCommand(gameEngine);

        //Add created commands
        commandContainer.register(3, resetGameCommand);
        commandContainer.register(2, runSimulationCommand);
        commandContainer.register(1, playerOperationsCommand);

        //Create game menu and start game
        GameMenu gameMenu = new GameMenu( new ConsoleInput(), new ConsoleDisplay(), gameEngine ,commandContainer);
        gameMenu.startGame();
    }
}
