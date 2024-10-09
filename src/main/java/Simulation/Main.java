package Simulation;

import ActionAndMap.Map;
import Objects.Herbivore;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Map map = new Map();
        map.createEntityForMap();
        map.showMap();


    }
    public void nextTurn(){};
    public void startSimullation(){};
    public void endSimulation(){};
}
