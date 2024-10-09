package Objects;

import org.w3c.dom.Node;

public class Tree extends Entity{
    private static final String TREE_MODEL = "\u001B[107m" + " \uD83C\uDF33 " + "\u001B[0m";

    public Tree(int positionX, int positionY) {
        super(positionX, positionY);
    }

    public String getModel(){
        return TREE_MODEL;
    }
}
