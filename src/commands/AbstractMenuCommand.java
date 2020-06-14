package commands;

import io.IDisplay;
import gameengine.IGameEngine;
import io.Input;

import java.util.Map;


/* AbstractMenuCommand.java
 * Any command class that will serve as a menu in the program may extend this since it provides most of the needed functionality, attributes.
 * Any client that will inherit from this, will have to use initiateMenu() method in their constructor method, otherwise menu text will be null.
 * initiateCommands() method has to be implemented in order for initiateMenu() to properly work. */
public abstract class AbstractMenuCommand extends AbstractCommand{

    private IDisplay displayHandler;
    private Input inputHandler;
    private CommandContainer commandContainer;
    private String menuText;

    protected AbstractMenuCommand(IGameEngine gameEngine, IDisplay displayHandler, Input inputHandler) {
        super(gameEngine);
        setInputHandler(inputHandler);
        setDisplayHandler(displayHandler);
    }

    protected abstract void initiateCommands();

    protected void initiateMenu(){
        initiateCommands();
        StringBuilder menu = new StringBuilder();
        Map<Integer, ICommand> commandMap = commandContainer.getCommands();
        int count = 0;
        for(Integer i : commandMap.keySet()){
            menu.append(i + ". " + commandMap.get(i));
            count++;
            if(count < commandMap.keySet().size()){
                menu.append("\n");
            }
        }
        menuText = menu.toString();
    }

    protected void setCommandContainer(CommandContainer commandContainer){
        this.commandContainer = commandContainer;
    }

    protected CommandContainer getCommandContainer(){ return commandContainer; }

    protected String getMenuText() { return this.menuText; }

    public IDisplay getDisplayHandler() { return this.displayHandler; }

    public Input getInputHandler(){ return this.inputHandler; }

    private void setDisplayHandler(IDisplay displayHandler){
        if(displayHandler == null){
            throw new IllegalArgumentException("IDisplay object cannot be null");
        }
        this.displayHandler = displayHandler;
    }

    private void setInputHandler(Input inputHandler){
        if(inputHandler == null){
            throw new IllegalArgumentException("IDisplay object cannot be null");
        }
        this.inputHandler = inputHandler;
    }

    @Override
    public abstract void execute();

    @Override
    public abstract String toString();
}
