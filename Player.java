import javafx.scene.Node;
import javafx.scene.shape.Circle;

public class Player{

    HandlePlayerMovement playerM;

    private Node playerNode;

    private double currX;
    private double currY;

    public double getCurrX(){return currX;}
    public double getCurrY(){return currY;}



    public void setLocation(double x,double y){
        currX = x;
        currY = y;
        playerNode.relocate(x,y);
    }


    public Node getPlayerNode(){return  playerNode;}

    public Player(){
        playerNode = new Circle(15);
        playerNode.relocate(200,300);
        currX = playerNode.getLayoutX();
        currY = playerNode.getLayoutY();
        playerM = new HandlePlayerMovement(currX,currY);

    }
    public void movePlayer(){
        playerM.movePlayer();
    }

}

