package commands;

import gameengine.IGameEngine;

public class BackCommand /*extends AbstractCommand*/{

    protected BackCommand(IGameEngine gameEngine) {
        /*super(gameEngine);*/
    }

    //@Override
    public static void execute() {
        StackTraceElement[] cleanedUpStackTrace = new StackTraceElement[Thread.currentThread().getStackTrace().length -1];
        System.arraycopy(Thread.currentThread().getStackTrace(), 1, cleanedUpStackTrace, 0, cleanedUpStackTrace.length);
        Thread.currentThread().start();
    }


    @Override
    public String toString() {
        return "Back";
    }


    public static void main(String[] args) {
        execute();
    }
}
