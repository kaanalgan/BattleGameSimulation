package main;

import java.util.Scanner;

public class BattleGame {

    public void start(){

        //Game engine
        IGameEngine gameEngine = new GameEngine(2);

        //Input and display handlers
        Input inputHandler = new ConsoleInput(new Scanner(System.in));
        IDisplay displayHandler = new ConsoleDisplay();


        //Create game menu and start game
        GameMenu mainMenu = new GameMenu(gameEngine, inputHandler, displayHandler);
        while(true) { mainMenu.execute(); }
    }
}
