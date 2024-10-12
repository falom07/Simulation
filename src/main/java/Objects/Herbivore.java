package Objects;

public class Herbivore extends Creature{

    public Herbivore(int positionX, int positionY,int health,int speed) {
        super(positionX, positionY,health,speed);
    }

    @Override
    public void makeMove() {
    }
    @Override
    public void addHealth(int health){
        super.setHealth(super.getHealth()+ health);
    }
    public boolean loseHealth(int damage){
        if (damage >= super.getHealth()){
            super.setHealth(0);
            return false;
        }else{
            super.setHealth(super.getHealth()-damage);
            return true;
        }
    }

    @Override
    public int getSpeed() {
        return super.getSpeed();
    }
}
