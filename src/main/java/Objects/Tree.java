package Objects;

import org.w3c.dom.Node;

public class Tree extends Entity{


    public Tree(int positionX, int positionY) {
        super(positionX, positionY);
    }

    @Override
    public int getSpeed() {
        return 0;
    }


}
