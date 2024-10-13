package Simulation;

import ActionAndMap.Action;

public class Simulation {
    Action action = new Action();
    int countOfSteps = 0;
    public void nextTurn(){
        action.turnAction();
        countOfSteps++;
    }
    public void startSimulation() throws InterruptedException {
        action.initAction();
        for(int i = 1; i <= 1000; i++){
            System.out.println("\ncount of steps" + countOfSteps);
            nextTurn();
            Thread.sleep(3000);
        }
        endSimulation();
    }
    public void endSimulation(){
        System.out.println("Ending Simulation...");
        System.out.println("Count of steps: " + countOfSteps);
    }
}
