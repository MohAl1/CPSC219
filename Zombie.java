import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Zombie extends GameObject {

    private double speed;
    private int health = 100;
    private ZombieMovement zombieM;
    private Map map;
    private Player player;
    public boolean isAlive = true;

    private static Image img = new Image("Zombie_Left0000.png");

    public Zombie(Map aMap, Player aPlayer, int x, int y, double aSpeed){
        super(x, y, new ImageView(img),true);
        speed = aSpeed;
        map = aMap;
        player = aPlayer;
        node.relocate(currX,currY);

        zombieM = new ZombieMovement();
        zombieM.moveZombie();
        //zombieM.checkPlayerCollision();
    }

    
    @Override
    int getCurrX() {return currX; }

    @Override
    int getCurrY() {return currY;}

    @Override
    Node getNode() {return node;}

    @Override
    boolean getIsAlive() {return isAlive;}

    public class ZombieMovement{

        private boolean goUP = false, goDOWN = false, goLEFT = false, goRIGHT = false;
        private AnimationTimer moveTimer;

        private void search() {
            AnimationTimer searchForPlayer = new AnimationTimer() {
                @Override
                public void handle(long now){
                    //north west
                    if (player.getCurrX() < currX
                            && player.getCurrY() < currY) {
                        goLEFT = true;
                        goUP = true;
                        goRIGHT = false;
                        goDOWN = false;
                    }
                    //north east
                    if (player.getCurrX() > currX
                            && player.getCurrY() < currY) {
                        goRIGHT = true;
                        goUP = true;
                        goDOWN = false;
                        goLEFT = false;
                    }
                    //north
                    if (player.getCurrY() < currY
                            && player.getCurrX() == currX) {
                        goUP = true;
                        goDOWN = false;
                        goLEFT = false;
                        goRIGHT = false;
                    }
                    //south
                    if (player.getCurrY() > currY
                            && player.getCurrX() == currX) {
                        goDOWN = true;
                        goRIGHT = false;
                        goLEFT = false;
                        goUP = false;
                    }
                    //south west
                    if (player.getCurrX() < currX
                            && player.getCurrY() > currY) {
                        goDOWN = true;
                        goLEFT = true;
                        goUP = false;
                        goRIGHT = false;
                    }
                    //south east
                    if (player.getCurrX() > currX
                            && player.getCurrY() > currY) {
                        goRIGHT = true;
                        goDOWN = true;
                        goUP = false;
                        goLEFT = false;
                    }
                    //west
                    if (player.getCurrX() < currX
                            && player.getCurrY() == currY) {
                        goLEFT = true;
                        goRIGHT = false;
                        goDOWN = false;
                        goUP = false;
                    }
                    //east
                    if (player.getCurrX() > currX
                            && player.getCurrY() == currY) {
                        goRIGHT = true;
                        goLEFT = false;
                        goUP = false;
                        goDOWN = false;
                    }
                }
            };
            searchForPlayer.start();
        }

        private void checkPlayerCollision(){
            AnimationTimer collisionTimer = new AnimationTimer() {
                @Override
                public void handle(long now) {
                   if(node.getBoundsInParent().intersects(player.getNode().getBoundsInParent()) &&
                   player.getIsAlive()){
//                       System.out.println("hit");
                       player.getHit(5);
//                       player.printHealth();
                       moveTimer.stop();

                       player.isHitByZombie(true);

                   }else if(!node.getBoundsInParent().intersects(player.getNode().getBoundsInParent()) &&
                           player.getIsAlive()){
                       moveTimer.start();

                       player.isHitByZombie(false);
                   }
                   else{
                       moveTimer.stop();
                   }

                }
            };
            collisionTimer.start();
        }


        public void moveZombie(){
            checkPlayerCollision();
            search();
            moveTimer = new AnimationTimer() {
                @Override
                public void handle(long now) {
                    if (isAlive) {
                        if (goUP) currY -= speed;
                        if (goDOWN) currY += speed;
                        if (goLEFT) currX -= speed;
                        if (goRIGHT) currX += speed;
                        node.relocate(currX, currY);
                    }
                }
            };
            moveTimer.start();
            //checkZombieCollision();
        }
    }

//    private void removeZombie() {
//        map.getRoot().getChildren().remove(node);
//        node.relocate(-1000,-1000);
//    }
}
