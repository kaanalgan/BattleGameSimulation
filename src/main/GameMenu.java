package main;

public class GameMenu {

    private Input inputHandler;
    private IDisplay displayHandler;
    private IGameEngine gameEngine;
    private CommandContainer commands;

    public GameMenu(Input inputHandler, IDisplay displayHandler, IGameEngine gameEngine, CommandContainer commands){
        setDisplayHandler(displayHandler);
        setGameEngine(gameEngine);
        setInputHandler(inputHandler);
        setCommands(commands);
    }

    public void startGame(){
        displayHandler.displayMenu();
        int command = inputHandler.readInt();
        commands.execute(command);
    }


    private void setCommands(CommandContainer commands){
        this.commands = commands;
    }

    private void setInputHandler(Input inputHandler){
        if(inputHandler == null){
            throw new IllegalArgumentException("Input handler argument cannot be null.");
        }
        this.inputHandler = inputHandler;
    }

    private void setDisplayHandler(IDisplay displayHandler){
        if(displayHandler == null){
            throw new IllegalArgumentException("Display handler argument cannot be null");
        }
        this.displayHandler = displayHandler;
    }

    private void setGameEngine(IGameEngine gameEngine){
        if(gameEngine == null){
            throw new IllegalArgumentException("Game engine argument cannot be null");
        }
    }
}
