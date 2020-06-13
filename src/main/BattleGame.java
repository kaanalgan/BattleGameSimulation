package main;

import commands.*;

import java.util.HashMap;
import java.util.Scanner;

public class BattleGame {

    public void start(){

        //Game engine
        IGameEngine gameEngine = new GameEngine(2);

        //Available commands' container
        CommandContainer commandContainer = new CommandContainer(new HashMap<Integer, ICommand>());

        //Input and display handlers
        Input inputHandler = new ConsoleInput(new Scanner(System.in));
        IDisplay displayHandler = new ConsoleDisplay();

        //Initiate commands
        ICommand resetGameCommand = new ResetCommand(gameEngine);
        ICommand runSimulationCommand = new RunSimulationCommand(gameEngine, displayHandler);
        ICommand playerOperationsCommand = new PlayerOperationsCommand(gameEngine, inputHandler, displayHandler);

        //Add created commands
        commandContainer.register(1, playerOperationsCommand);
        commandContainer.register(2, runSimulationCommand);
        commandContainer.register(3, resetGameCommand);


        //Create game menu and start game
        GameMenu gameMenu = new GameMenu(inputHandler, displayHandler, commandContainer);
        while(true) { gameMenu.mainMenu(); }
    }
}
