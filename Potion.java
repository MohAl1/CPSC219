import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Potion extends GameObject {

    private int HPValue = 100;
    private Map map;
    private Player player;
    private static Image image = new Image("Monster_Drink0000.png");

    public Potion(Map aMap, Player aPlayer){
        super(0,0, new ImageView(image), true);
        map = aMap;
        player = aPlayer;
        update();
    }

    @Override
    int getCurrX() {
        return currX;
    }
    @Override
    int getCurrY() {
        return currY;
    }
    @Override
    Node getNode() {
        return node;
    }
    @Override
    boolean getIsAlive() {
        return isAlive;
    }

    public void update(){
        AnimationTimer potionTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(player.getNode().getBoundsInParent().intersects(node.getBoundsInParent())){
                    player.heal(HPValue);
                    player.printHealth();
                    relocate();
                }
            }
        };
        potionTimer.start();
    }

    private void relocate() {
        currX = (int) (Math.random() * 1000);
        currY = (int) (Math.random() * 600);
        node.relocate(currX,currY);
    }
}
