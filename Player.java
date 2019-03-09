import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;

public class Player extends GameObject {

    private double speed = 15;
    private int health = 100;
    private HandlePlayerMovement playerM;
    private Map map;

    public Player(Map aMap){
        super(200,300,new Circle(30), true);
        playerM = new HandlePlayerMovement();
        map = aMap;
    }
    @Override
    int getCurrX() {return currX;}

    @Override
    int getCurrY() {return currY;}

    @Override
    Node getNode() {return node;}

    @Override
    boolean getIsAlive() {return isAlive;}

    public void update(){
        if (isAlive) {
            playerM.movePlayer();
        }
    }


    public class HandlePlayerMovement implements EventHandler<KeyEvent> {

        private boolean goUP = false, goDOWN = false, goLEFT = false, goRIGHT = false;

        public void handle(KeyEvent event) {
        }

        public void movePlayer() {
            map.getScene().setOnKeyPressed(new EventHandler<KeyEvent>() {
                public void handle(KeyEvent event) {
                    switch (event.getCode()) {
                        case UP:
                            goUP = true;
                            break;
                        case DOWN:
                            goDOWN = true;
                            break;
                        case LEFT:
                            goLEFT = true;
                            break;
                        case RIGHT:
                            goRIGHT = true;
                            break;
                    }
                }

            });

            map.getScene().setOnKeyReleased(new EventHandler<KeyEvent>() {
                public void handle(KeyEvent event) {
                    switch (event.getCode()) {
                        case UP:
                            goUP = false;
                            break;
                        case DOWN:
                            goDOWN = false;
                            break;
                        case LEFT:
                            goLEFT = false;
                            break;
                        case RIGHT:
                            goRIGHT = false;
                            break;
                    }
                }
            });

            AnimationTimer moveTimer = new AnimationTimer() {
                public void handle(long arg) {
                    if (goUP) currY -= speed;
                    if (goDOWN) currY += speed;
                    if (goLEFT) currX -= speed;
                    if (goRIGHT) currX += speed;
                    node.relocate(currX, currY);
                }

            };
            moveTimer.start();
        }
    }
}
