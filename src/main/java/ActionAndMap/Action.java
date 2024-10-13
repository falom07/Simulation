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
            boolean isMoved = false;

            if (map.getEntities().get(i) instanceof Predator){
                for(int j = 0;j < map.getEntities().get(i).getSpeed();++j){
                int position = convertPosition(i);
                int result = algoritmForFindingWay.passInWidth(position,3,map.getMap());

                if(result == 100){
                    break;
                }
                if (result != 0){
                    map.updatePositionOnMap(position,result,2);
                    updatePositionForEntity(i,result);
                    isMoved = true;
                } else{
                    if(isMoved){
                        break;
                    }
                    int positionSacrifice = algoritmForFindingWay.getPositionSacrificeForEat();
                    int positionSacrificeInList = map.findPositionEntity(positionSacrifice);
                    if(map.getEntities().get(positionSacrificeInList).loseHealth(((Predator) map.getEntities().get(i)).attack())){
                    }else{
                        map.updatePositionOnMap(positionSacrifice,positionSacrifice,0);
                        map.respawn(positionSacrificeInList,3);
                    }
                    break;

                }}

            } else if (map.getEntities().get(i) instanceof Herbivore){

                for(int j = 0; j < (map.getEntities().get(i).getSpeed()); ++j) {
                    int position = convertPosition(i);
                    int result = algoritmForFindingWay.passInWidth(position, 1, map.getMap());

                    if(result == 100){
                        break;
                    }
                    if (result != 0) {
                        map.updatePositionOnMap(position, result, 3);
                        updatePositionForEntity(i, result);
                        isMoved = true;
                    } else{
                        if(isMoved){
                            break;
                        }
                        int positionSacrifice = algoritmForFindingWay.getPositionSacrificeForEat();
                        map.getEntities().get(i).addHealth(1);
                        map.updatePositionOnMap(positionSacrifice, positionSacrifice, 0);

                        map.respawn(map.findPositionEntity(positionSacrifice), 1);
                        break;
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
