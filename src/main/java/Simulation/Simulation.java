package Simulation;

import ActionAndMap.Action;

public class Simulation {
    Action action = new Action();
    int countOfSteps = 0;
    public void nextTurn(){
        action.turnAction();
        countOfSteps++;
    }
    public void startSimulation(){
        action.initAction();
        for(int i = 1; i <= 20; i++){
            nextTurn();
        }
        endSimulation();
    }
    public void endSimulation(){
        System.out.println("Ending Simulation...");
        System.out.println("Count of steps: " + countOfSteps);
    }
}
