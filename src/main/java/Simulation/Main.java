package Simulation;

import ActionAndMap.Map;
import Objects.Entity;
import Objects.Herbivore;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//        Map map = new Map();
//        map.createEntityForMap();
//        map.showMap();

        Herbivore herbivore =new Herbivore(1,2,2,3);
        Entity[][] i = new Entity[2][2];
        i[0][0] = herbivore;
        i[1][0] = herbivore;
        i[0][0] = null;

        for(int j=0;j<2;j++){
            for(int k=0;k<2;k++){
                System.out.print(i[k][j] + " ");
            }
            System.out.println();
        }

    }
    public void nextTurn(){};
    public void startSimullation(){};
    public void endSimulation(){};
}
