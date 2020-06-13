package main;

public class ConsoleDisplay implements IDisplay{

    @Override
    public void displayMenu(String menuText, String requestMessage) {
        StringBuilder barrierText = new StringBuilder("*");
        for(int i=0; i<=menuText.length(); i++){
            barrierText.append("*");
        }
        System.out.println(barrierText.toString());
        System.out.println(menuText);
        System.out.println(barrierText.toString());
        System.out.print(requestMessage);
    }

    //TODO: Change this
    @Override
    public void displayLoadouts(String player1Loadout, String player2Loadout) {

        System.out.println("-----------------");
        System.out.println("Player1's loadout");
        System.out.println("-----------------");

        System.out.println(player1Loadout + "\n\n\n");

        System.out.println("-----------------");
        System.out.println("Player2's loadout");
        System.out.println("-----------------");

        System.out.println(player2Loadout + "\n\n\n");


    }

    @Override
    public void displayAddPart(String parts) {

    }

    @Override
    public void displayGameReport(String simulationResults) {
        System.out.println("\n\n\n*******************");
        System.out.println("Simulation Results");
        System.out.println("*******************");
        System.out.println(simulationResults);
    }
}
