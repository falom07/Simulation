package ActionAndMap;

import Objects.*;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private int[][] map = new int[10][10];
    private List<Entity> entities = new ArrayList<>();
    private static final String HERBIVORE_MODEL = "\u001B[107m" + " \uD83D\uDC07 " + "\u001B[0m";
    private static final String PREDATOR_MODEL = "\u001B[107m" + " \uD83D\uDC05 " + "\u001B[0m";
    private static final String GRASS_MODEL = "\u001B[107m" + " \uD83C\uDF3F " + "\u001B[0m";
    private static final String ROCK_MODEL = "\u001B[107m" + " \uD83D\uDD32 " + "\u001B[0m";
    private static final String TREE_MODEL = "\u001B[107m" + " \uD83C\uDF33 " + "\u001B[0m";




    public void createEntityForMap(){
        Herbivore herbivore = new Herbivore(0,0,2,1);
        Herbivore herbivore2 = new Herbivore(0,0,3,1);
        Herbivore herbivore3 = new Herbivore(0,0,1,2);
        Herbivore herbivore4 = new Herbivore(0,0,1,2);

        Predator predator1 = new Predator(0,0,2,2);
        Predator predator2 = new Predator(0,0,2,3);

        Rock rock1 = new Rock(0,0);
        Rock rock2 = new Rock(0,0);
        Rock rock3 = new Rock(0,0);
        Tree tree1 = new Tree(0,0);
        Tree tree2 = new Tree(0,0);
        Tree tree3 = new Tree(0,0);
        Tree tree4 = new Tree(0,0);
        Grass grass1 = new Grass(0,0);
        Grass grass2 = new Grass(0,0);
        Grass grass3 = new Grass(0,0);
        Grass grass4 = new Grass(0,0);
        Grass grass5 = new Grass(0,0);
        map[0][0] = 5;//this will save for me 1000 years

        entities.add(predator1);
        entities.add(predator2);
        entities.add(herbivore);
        entities.add(herbivore4);
        entities.add(herbivore2);
        entities.add(herbivore3);
        entities.add(rock1);
        entities.add(rock2);
        entities.add(rock3);
        entities.add(tree1);
        entities.add(tree2);
        entities.add(tree3);
        entities.add(tree4);
        entities.add(grass1);
        entities.add(grass2);
        entities.add(grass3);
        entities.add(grass4);
        entities.add(grass5);
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
                    }else if(this.entities.get(i) instanceof Herbivore){    //add herbivore
                        map[positionX][positionY] = 3;
                    }else if(this.entities.get(i) instanceof Rock){
                        map[positionX][positionY] = 4;
                    }else if(this.entities.get(i) instanceof Tree){
                        map[positionX][positionY] = 5;
                    }else if(this.entities.get(i) instanceof Grass){
                        map[positionX][positionY] = 1;
                    }

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
                    } else if (map[i][j] == 4){
                        System.out.print(ROCK_MODEL);
                    }else if (map[i][j] == 5){
                        System.out.print(TREE_MODEL);
                    } else if (map[i][j] == 1){
                        System.out.print(GRASS_MODEL);
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
    public List<Entity> getEntities() {
        return entities;
    }
    public void updatePositionOnMap(int from, int to, int who){
        int[] pos = takePositions(from,to);
        int xFrom = pos[0];
        int yFrom = pos[1];
        int xTo = pos[2];
        int yTo = pos[3];
        map[xFrom][yFrom] = 0;
        map[xTo][yTo] = who;

    }
    public int[] takePositions(int from,int to){
        int [] pos = new int[4];
        int [] wheare = new int[2];
        wheare[0] = from;
        wheare[1] = to;
        int positionArr = -1;
        for(int i = 0;i < 2;++i){
            int postion = wheare[i];
            if (postion <= 9) {
                pos[++positionArr] = 0;
                pos[++positionArr] = postion;

            } else {
                int y = postion % 10;
                pos[++positionArr] = (int) ((postion - y) * 0.1);
                pos[++positionArr] = y;
            }}

        return pos;
    }
    public void respawn(int positionInList,int who){
        while(true){
        int positionX = (int) (Math.random() * 10);
        int positionY = (int) (Math.random() * 10);
        if(map[positionX][positionY] == 0) {
            if(entities.get(positionInList) instanceof Herbivore){
                entities.get(positionInList).addHealth((int) (1 + (Math.random() * 3)));
            }
            entities.get(positionInList).setPositionX(positionX);
            entities.get(positionInList).setPositionY(positionY);
            map[positionX][positionY] = who;
            break;
        }
        }

    }
    public int findPositionEntity(int positionOnMap){
        int[] pos = takePositions(positionOnMap,0);
        for(int i = 0;i < entities.size();++i){
            if(pos[0] == entities.get(i).getPositionX() && pos[1] == entities.get(i).getPositionY()){
                return i;
            }
        }
        return 0;
    }

}
