package io;

public interface IDisplay {

    void displayMenu(String menuText, String requestMessage);

    void displayLoadouts(String player1Loadout, String player2Loadout);

    void displayWarning(String warningText);

    void displayGameReport(int player1Score, int player2Score);

    void displayErrorMessage(String errorMessage);
}
