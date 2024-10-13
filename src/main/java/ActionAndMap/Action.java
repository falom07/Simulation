package ActionAndMap;

import AlgoritmForFindWay.AlgoritmForFindingWay;
import Objects.Herbivore;
import Objects.Predator;

public class Action {
    private Map map = new Map();
    private AlgoritmForFindingWay algoritmForFindingWay = new AlgoritmForFindingWay();
    public void initAction(){
        map.createAndAddEntityForMap();
        map.addEntityToMatrix();
    }
    public void turnAction(){
        map.showMap();
        for(int i = 0;i < map.getEntities().size();++i){
            boolean isMoved = false;

            if (map.getEntities().get(i) instanceof Predator){
                for(int j = 0;j < map.getEntities().get(i).getSpeed();++j){
                int position = convertPosition(i); //take position for algorithm
                int result = algoritmForFindingWay.passInWidth(position,3,map.getMap());//here decide what we do? Eat or Move

                if(result == 100){ //it run if we have not move and can not eat
                    break;
                }
                if (result != 0){ //here we move
                    map.updatePositionOnMap(position,result,2); //change position on matrix that we see
                    updatePositionForEntity(i,result); // here we update position in entity
                    isMoved = true; //here we say that on this step we can only move,even if we will be close to sacrifice
                } else{ //here we eat
                    if(isMoved){ // if we already move we can not attack
                        break;
                    }
                    int positionSacrifice = algoritmForFindingWay.getPositionSacrificeForEat(); // take position of sacrifice
                    int positionSacrificeInList = map.findPositionEntity(positionSacrifice);  // take position of sacrifice  in list
                    if(map.getEntities().get(positionSacrificeInList).loseHealth(((Predator) map.getEntities().get(i)).attack())){ //do damage,and if sacrifice die we respawn under
                    }else{
                        map.updatePositionOnMap(positionSacrifice,positionSacrifice,0); //clean field where was sacrifice
                        map.respawn(positionSacrificeInList,3); //respawn
                    }
                    break;

                }}

            } else if (map.getEntities().get(i) instanceof Herbivore){

                for(int j = 0; j < (map.getEntities().get(i).getSpeed()); ++j) {
                    int position = convertPosition(i);//take position for algorithm
                    int result = algoritmForFindingWay.passInWidth(position, 1, map.getMap());//here decide what we do? Eat or Move

                    if(result == 100){//it run if we have not move and can not eat
                        break;
                    }
                    if (result != 0) {
                        map.updatePositionOnMap(position, result, 3);
                        updatePositionForEntity(i, result);
                        isMoved = true;
                    } else{//here we eat
                        if(isMoved){// if we already move we can not attack
                            break;
                        }
                        int positionSacrifice = algoritmForFindingWay.getPositionSacrificeForEat();// take position of sacrifice
                        map.getEntities().get(i).addHealth(1); //add health
                        map.updatePositionOnMap(positionSacrifice, positionSacrifice, 0); // take position of sacrifice  in list

                        map.respawn(map.findPositionEntity(positionSacrifice), 1); //respawn
                        break;
                    }
                }
            }
        }
    }
    private void updatePositionForEntity(int posInMap,int result){ //update position for entity in listEntity
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
    private int convertPosition(int posInList){ //take position for algorithm
        return Integer.parseInt(map.getEntities().get(posInList).getPositionX() + "" + map.getEntities().get(posInList).getPositionY());
    }


}
