package ActionAndMap;

import AlgoritmForFindWay.AlgoritmForFindingWay;

public class Action {
    private Map map = new Map();
    private AlgoritmForFindingWay algoritmForFindingWay = new AlgoritmForFindingWay(map.getMap());
    public void initAction(){
        map.createEntityForMap();
    }
    public void turnAction(){
        map.showMap();
        System.out.println(algoritmForFindingWay.passInWidth(45,3) + " hi");
    }


}
