package Objects;

public class Herbivore extends Creature{
    private static final String HERBIVORE_MODEL = "\u001B[107m" + " \uD83D\uDC07 " + "\u001B[0m";
    public Herbivore(int positionX, int positionY,int speed,int health) {
        super(positionX, positionY,health,speed);
    }
    public String getModel() {
        return HERBIVORE_MODEL;
    }


    @Override
    public void makeMove() {

    }
}
