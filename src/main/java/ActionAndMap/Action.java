package ActionAndMap;

import AlgoritmForFindWay.AlgoritmForFindingWay;
import Objects.Creature;
import Objects.Herbivore;
import Objects.Predator;

public class Action {
    private Map map = new Map();
    private AlgoritmForFindingWay algoritmForFindingWay = new AlgoritmForFindingWay();
    public void initAction(){
        map.createEntityForMap();
        map.addEntityToMatrix();
    }
    public void turnAction(){
        map.showMap();

        for(int i = 0;i < map.getEntities().size();++i){
            if (map.getEntities().get(i) instanceof Predator){
                for(int j = 0;j < map.getEntities().get(i).getSpeed();++j){
                int position = convertPosition(i);
                int result = algoritmForFindingWay.passInWidth(position,3,map.getMap());
                    System.out.println(result);
                if (result != 0){
                    map.updatePositionOnMap(position,result,2);
                    updatePositionForEntity(i,result);
                } else{
                    int positionSacrifice = algoritmForFindingWay.getPositionSacrificeForEat();
                    int positionSacrificeInList = map.findPositionEntity(positionSacrifice);
                    if(map.getEntities().get(positionSacrificeInList).loseHealth(((Predator) map.getEntities().get(i)).attack())){
                    }else{
                        map.updatePositionOnMap(positionSacrifice,positionSacrifice,0);
                        map.respawn(positionSacrificeInList,3);
                    }

                }}

            } else if (map.getEntities().get(i) instanceof Herbivore){
                for(int j = 0; j < (map.getEntities().get(i).getSpeed()); ++j) {
                    int position = convertPosition(i);
                    int result = algoritmForFindingWay.passInWidth(position, 1, map.getMap());
                    System.out.println(result);
                    if (result != 0) {
                        map.updatePositionOnMap(position, result, 3);
                        updatePositionForEntity(i, result);
                    } else {
                        int positionSacrifice = algoritmForFindingWay.getPositionSacrificeForEat();
                        map.getEntities().get(i).addHealth(1);
                        map.updatePositionOnMap(positionSacrifice, positionSacrifice, 0);

                        map.respawn(map.findPositionEntity(positionSacrifice), 1);
                    }
                }
            }
        }
    }
    private void updatePositionForEntity(int posInMap,int result){
        int res = result;
        int x;
        int y;
        if (res <= 9) {
            y = res;
            x = 0;
        } else {
            y = res % 10;
            x = (int) ((res - y) * 0.1);
        }
        map.getEntities().get(posInMap).setPositionX(x);
        map.getEntities().get(posInMap).setPositionY(y);
    }
    private int convertPosition(int posInList){
        return Integer.parseInt(map.getEntities().get(posInList).getPositionX() + "" + map.getEntities().get(posInList).getPositionY());
    }


}
//int first = algoritmForFindingWay.passInWidth(45,1,map.getMap());
//        System.out.println(first + "first");
//        int second = algoritmForFindingWay.passInWidth(first,1,map.getMap());
//        System.out.println(second + "second");
//        int third = algoritmForFindingWay.passInWidth(second,1,map.getMap());
//        System.out.println(third + "third");
//        int fourth = algoritmForFindingWay.passInWidth(third,1,map.getMap());
//        System.out.println(fourth + "fourth");
//        int five = algoritmForFindingWay.passInWidth(fourth,1,map.getMap());
//        System.out.println(five + "five");