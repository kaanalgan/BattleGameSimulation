package main;

public class ConsoleDisplay implements IDisplay{

    @Override
    public void displayMenu(String menuText, String requestMessage) {

        String barrierText = "**********************************";
        System.out.println(barrierText);
        System.out.println(menuText);
        System.out.println(barrierText);
        System.out.print(requestMessage);
    }

    //TODO: Change this
    @Override
    public void displayLoadouts(String player1Loadout, String player2Loadout) {

        System.out.println("-----------------");
        System.out.println("Player1's loadout");
        System.out.println("-----------------");

        System.out.println(player1Loadout + "\n");

        System.out.println("-----------------");
        System.out.println("Player2's loadout");
        System.out.println("-----------------");

        System.out.println(player2Loadout);


    }

    @Override
    public void displayAddPart(String parts) {

    }

    @Override
    public void displayGameReport(String simulationResults) {
        System.out.println("\n*******************");
        System.out.println("Simulation Results");
        System.out.println("*******************");
        System.out.println(simulationResults);
    }
}
