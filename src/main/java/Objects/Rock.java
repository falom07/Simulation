package Objects;

public class Rock extends Entity {
    private static final String ROCK_MODEL = "\u001B[107m" + " \uD83D\uDD32 " + "\u001B[0m";

    public Rock(int positionX, int positionY) {
        super(positionX, positionY);
    }

    public String getModel(){
        return ROCK_MODEL;
    }
}
