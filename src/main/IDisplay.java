package main;

public interface IDisplay {

    void displayMenu(String menuText, String requestMessage);

    void displayLoadouts(String player1Loadout, String player2Loadout);

    //TODO: ???
    void displayAddPart(String parts);


    void displayGameReport(String simulationResults);
}
