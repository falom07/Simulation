package Objects;

public class Grass extends Entity {


    public Grass(int positionX, int positionY) {
        super(positionX, positionY);
    }

    @Override
    public int getSpeed() {
        return 0;
    }

}
