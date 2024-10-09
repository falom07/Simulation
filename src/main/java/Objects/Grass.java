package Objects;

public class Grass extends Entity {
    private static final String GRASS_MODEL = "\u001B[107m" + " \uD83C\uDF3F " + "\u001B[0m";    //It how will be view my model of grass

    public Grass(int positionX, int positionY) {
        super(positionX, positionY);
    }
    public String getModel() {
        return GRASS_MODEL;
    }
}
