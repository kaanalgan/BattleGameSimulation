package main;

import java.util.List;

public class AddPartCommand extends AbstractCommand {

    private List<Warcraft> warcrafts;
    private IDisplay displayHandler;
    private Input inputHandler;
    private String menuItems;
    private int playerNo;

    public AddPartCommand(IGameEngine gameEngine, List<Warcraft> warcrafts, IDisplay displayHandler, Input inputHandler, int playerNo) {
        super(gameEngine);
        initiateMenuText();
        this.warcrafts = warcrafts;
        this.inputHandler = inputHandler;
        this.displayHandler = displayHandler;
        this.playerNo = playerNo;
    }


    private void initiateMenuText(){
        StringBuilder warcrafts = new StringBuilder();
        int menuItemIndex = 1;
        for(Warcraft w : this.warcrafts){
            warcrafts.append(menuItemIndex + ". " + w.toString());
            for(Addable a : w.getAddables()){
                warcrafts.append("( " + a.toString() + " )\n");
            }
        }
        menuItems = warcrafts.toString();
    }

    @Override
    public void execute() {
        displayHandler.displayMenu(menuItems, "Choose a warcraft: ");
        int id = inputHandler.readInt();
    
    }
}
