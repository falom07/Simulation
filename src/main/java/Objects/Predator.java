package Objects;

public class Predator extends Creature {
    private static final String PREDATOR_MODEL = "\u001B[107m" + " \uD83D\uDC05 " + "\u001B[0m";

    public Predator(int positionX, int positionY, int health, int speed) {
        super(positionX, positionY, health, speed);
    }
    public void attack(){}

    public String getModel() {
        return PREDATOR_MODEL;
    }

    @Override
    public void makeMove() {

    }
}
