package ActionAndMap;

import Objects.Entity;
import Objects.Herbivore;
import Objects.Predator;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private Entity[][] map = new Entity[10][10];
    private List<Entity> entities = new ArrayList<>();
    public Map() {}
    public void createEntityForMap(){
        Herbivore herbivore = new Herbivore(1,3,4,5); //CREATE ENTITY
        Herbivore herbivore2 = new Herbivore(3,5,6,7); //todo positions and health,speed
        Herbivore herbivore3 = new Herbivore(3,5,6,7); //todo add tree,gress,rocks
        Herbivore herbivore4 = new Herbivore(3,5,6,7);
        Herbivore herbivore5 = new Herbivore(3,5,6,7);

        Predator predator = new Predator(3,5,6,7);
        Predator predator2 = new Predator(3,5,6,7);
        Predator predator3 = new Predator(3,5,6,7);
        Predator predator4 = new Predator(3,5,6,7);
        entities.add(herbivore);
        entities.add(herbivore2);
        entities.add(herbivore3);
        entities.add(herbivore4);
        entities.add(herbivore5);
        entities.add(predator);
        entities.add(predator2);
        entities.add(predator3);
        entities.add(predator4);
        addEntityToMatrix(entities);
    }
    public void addEntityToMatrix(List<Entity> entity){
        int positionX;
        int positionY;
        for(int i = 0; entity.size() > i; i++){
            while (true){
                positionX = (int) (Math.random() * 10);
                positionY = (int) (Math.random() * 10);
                if(map[positionX][positionY] == null){
                    map[positionX][positionY] = entity.get(i);
                    break;
                }
            }
        }
    }


    public void showMap(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (map[i][j] != null) {
                    System.out.print(map[i][j].getModel());
                }else {
                    System.out.print("\u001B[47m" + "  _|" + "\u001B[0m");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

}
