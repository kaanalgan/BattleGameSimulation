package main;

import java.util.Map;

public class GameMenu {

    private Input inputHandler;
    private IDisplay displayHandler;
    private CommandContainer commands;
    private String menuText;

    public GameMenu(Input inputHandler, IDisplay displayHandler, CommandContainer commands){
        setDisplayHandler(displayHandler);
        setInputHandler(inputHandler);
        setCommands(commands);
        initiateMenuText();
    }

    public void mainMenu(){
        displayHandler.displayMenu(menuText, "\nChoose a command: ");
        int commandId = inputHandler.readInt();
        commands.execute(commandId);
    }


    private void initiateMenuText(){
        StringBuilder menuText = new StringBuilder("\n");
        Map<Integer, ICommand> commandMap = commands.getCommands();
        for(Integer i : commandMap.keySet()){
            menuText.append(i + "." + commandMap.get(i).toString() + "\n");
        }
        this.menuText = menuText.toString();
    }

    private void setCommands(CommandContainer commands){
        if(commands == null){
            throw new IllegalArgumentException("Command container cannot be null.");
        }
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

}
