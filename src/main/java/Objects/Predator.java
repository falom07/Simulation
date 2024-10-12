package Objects;

public class Predator extends Creature {


    public Predator(int positionX, int positionY, int health, int speed) {

        super(positionX, positionY, health, speed);
    }
    public int attack(){
        return (int) ( 1 +(Math.random() * 3));
    }
    @Override
    public void makeMove() {

    }
    @Override
    public int getSpeed() {
        return super.getSpeed();
    }
}
