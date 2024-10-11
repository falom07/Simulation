package ActionAndMap;

import Objects.Creature;
import Objects.Entity;
import Objects.Herbivore;
import Objects.Predator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Map {
    private int[][] map = new int[10][10];
    private List<Entity> entities = new ArrayList<>();
    private static final String HERBIVORE_MODEL = "\u001B[107m" + " \uD83D\uDC07 " + "\u001B[0m";
    private static final String PREDATOR_MODEL = "\u001B[107m" + " \uD83D\uDC05 " + "\u001B[0m";




    public void createEntityForMap(){
        Herbivore herbivore = new Herbivore(0,0,0,2); //CREATE ENTITY
         //todo positions and health,speed
         //todo add tree,gress,rocks

        Predator predator4 = new Predator(0,0,0,2);

        entities.add(herbivore);
        entities.add(predator4);
        addEntityToMatrix();
    }
    public void addEntityToMatrix(){
        int positionX;
        int positionY;

        for(int i = 0; entities.size() > i; i++){
            while (true){
                positionX = (int) (Math.random() * 10);
                positionY = (int) (Math.random() * 10);
                if(map[positionX][positionY] == 0){
                    this.entities.get(i).setPositionX(positionX);    //add position to objects - X and Y
                    this.entities.get(i).setPositionY(positionY);
                    if(this.entities.get(i) instanceof Predator){   //add predator
                        map[positionX][positionY] = 2;
                        System.out.println(positionX + " " + positionY );
                    }else if(this.entities.get(i) instanceof Herbivore){    //add herbivore
                        map[positionX][positionY] = 3;
                        System.out.println(positionX + " " + positionY );
                    }//todo add grass and rocks
                    break;
                }
            }
        }
    }


    public void showMap(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (map[i][j] != 0) {
                    if(map[i][j] == 2) {
                        System.out.print(PREDATOR_MODEL);
                    } else if (map[i][j] == 3) {
                        System.out.print(HERBIVORE_MODEL);
                    }
                }else {
                    System.out.print("\u001B[47m" + "  _|" + "\u001B[0m");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    public int[][] getMap() {
        return map;
    }

}
