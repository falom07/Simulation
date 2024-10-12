package Objects;

public class Rock extends Entity {


    public Rock(int positionX, int positionY) {
        super(positionX, positionY);
    }

    @Override
    public int getSpeed() {
        return 0;
    }

}
