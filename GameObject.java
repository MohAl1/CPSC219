import javafx.scene.Node;

public abstract class GameObject {
    int currX;
    int currY;
    Node node;
    boolean isAlive;

    public GameObject(int x, int y, Node aNode, boolean alive){
        currX = x;
        currY = y;
        node = aNode;
        isAlive = alive;
    }
    abstract int getCurrX();
    abstract int getCurrY();
    abstract Node getNode();
    abstract boolean getIsAlive();

}
