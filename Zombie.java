import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Zombie{

    private Node zombieNode;
    private double currX;
    private double currY;
    private ZombieMovement zombM;

    public Zombie(int startX,int startY){
        zombieNode = new Circle(15, Color.GREEN);

        zombieNode.relocate(startX,startY);

        currX = zombieNode.getLayoutX();
        currY = zombieNode.getLayoutY();

        zombM = new ZombieMovement();

        zombM.moveZombie();
    }

    public Node getZombieNode(){return zombieNode;}


    public class ZombieMovement{

        private boolean goUP = false, goDOWN = false, goLEFT = false, goRIGHT = false;

        private void search() {
            AnimationTimer checkLocation = new AnimationTimer() {
                @Override
                public void handle(long now){
                    //north west
                    if (AppDriver.gApp.getPlayer().getCurrX() < currX
                            && AppDriver.gApp.getPlayer().getCurrY() < currY) {
                        goLEFT = true;
                        goUP = true;
                        goRIGHT = false;
                        goDOWN = false;
                    }
                    //north east
                    if (AppDriver.gApp.getPlayer().getCurrX() > currX
                            && AppDriver.gApp.getPlayer().getCurrY() < currY) {
                        goRIGHT = true;
                        goUP = true;
                        goDOWN = false;
                        goLEFT = false;
                    }
                    //north
                    if (AppDriver.gApp.getPlayer().getCurrY() < currY
                            && AppDriver.gApp.getPlayer().getCurrX() == currX) {
                        goUP = true;
                        goDOWN = false;
                        goLEFT = false;
                        goRIGHT = false;
                    }
                    //south
                    if (AppDriver.gApp.getPlayer().getCurrY() > currY
                            && AppDriver.gApp.getPlayer().getCurrX() == currX) {
                        goDOWN = true;
                        goRIGHT = false;
                        goLEFT = false;
                        goUP = false;
                    }
                    //south west
                    if (AppDriver.gApp.getPlayer().getCurrX() < currX
                            && AppDriver.gApp.getPlayer().getCurrY() > currY) {
                        goDOWN = true;
                        goLEFT = true;
                        goUP = false;
                        goRIGHT = false;
                    }
                    //south east
                    if (AppDriver.gApp.getPlayer().getCurrX() > currX
                            && AppDriver.gApp.getPlayer().getCurrY() > currY) {
                        goRIGHT = true;
                        goDOWN = true;
                        goUP = false;
                        goLEFT = false;
                    }
                    //west
                    if (AppDriver.gApp.getPlayer().getCurrX() < currX
                            && AppDriver.gApp.getPlayer().getCurrY() == currY) {
                        goLEFT = true;
                        goRIGHT = false;
                        goDOWN = false;
                        goUP = false;
                    }
                    //east
                    if (AppDriver.gApp.getPlayer().getCurrX() > currX
                            && AppDriver.gApp.getPlayer().getCurrY() == currY) {
                        goRIGHT = true;
                        goLEFT = false;
                        goUP = false;
                        goDOWN = false;
                    }
                }
            };
            checkLocation.start();
        }


        public void moveZombie() {
            search();
            AnimationTimer moveTimer = new AnimationTimer() {
                double delta = 5;

                @Override
                public void handle(long now) {
                    if (goUP) currY -= delta;
                    if (goDOWN) currY += delta;
                    if (goLEFT) currX -= delta;
                    if (goRIGHT) currX += delta;
                    zombieNode.relocate(currX,currY);
                }

            };
            moveTimer.start();
        }
    }
}
