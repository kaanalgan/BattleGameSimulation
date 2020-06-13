package main;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.List;

public class DisplayLoadoutsCommand extends AbstractCommand{

    private IDisplay displayHandler;

    public DisplayLoadoutsCommand(IGameEngine gameEngine, IDisplay displayHandler) {
        super(gameEngine);
        this.displayHandler = displayHandler;
    }

    @Override
    public void execute() {
        //TODO: Get both players' loadouts and display
        List<Warcraft> player1Loadouts = getGameEngine().getPlayerLoadout(1);
        List<Warcraft> player2Loadouts = getGameEngine().getPlayerLoadout(2);

        StringBuilder player1Loadout = new StringBuilder();

        for(Warcraft w : player1Loadouts){
            player1Loadout.append(w.toString());
            for(Addable a : w.getAddables()){
                player1Loadout.append("( " + a.toString() + " )");
            }
        }

        StringBuilder player2Loadout = new StringBuilder();

        for(Warcraft w : player2Loadouts){
            player2Loadout.append(w.toString());
            for(Addable a : w.getAddables()){
                player2Loadout.append("( " + a.toString() + " )");
            }
        }

        displayHandler.displayLoadouts(player1Loadout.toString(), player2Loadout.toString());
    }
}
