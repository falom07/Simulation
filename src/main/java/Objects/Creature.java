package Objects;

public abstract class Creature extends Entity {
    private int health;
    private int speed;
    public Creature(int positionX, int positionY, int health, int speed) {
        super(positionX, positionY);
        this.health = health;
        this.speed = speed;
    }
    public abstract void makeMove();

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
