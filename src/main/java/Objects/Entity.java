package Objects;

public abstract class Entity {
    private int positionX;   //position on x for any entity
    private int positionY;   //position on x for any entity

    public Entity(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public int getPositionX() {
        return positionX;
    }
    public void addHealth(int health) {}
    public boolean loseHealth(int damage){
        return false;
    }
    public abstract int getSpeed() ;




    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
}
