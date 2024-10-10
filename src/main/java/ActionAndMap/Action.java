package ActionAndMap;

public class Action {
    private Map map = new Map();
    public void initAction(){
        map.createEntityForMap();
    }
    public void turnAction(){
        map.showMap();
    }

}
