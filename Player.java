import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

public class Player extends GameObject {

    private double speed = 15;
    private int health = 10000;
    private HandlePlayerMovement playerM;
    private Map map;
    private AllZombies az = new AllZombies();
    private int zombienum;
    private int score = 0;
    public Text x;
    
    private static Image img = new Image("Player_Idle0000.png");

    public Player(Map aMap,Text x){
        super(200,300,new ImageView(img), true);

        playerM = new HandlePlayerMovement();
        map = aMap;
        this.x = x;
        
    }
    @Override
    int getCurrX() {return currX;}

    @Override
    int getCurrY() {return currY;}

    @Override
    Node getNode() {return node;}

    @Override
    boolean getIsAlive() {return isAlive;}

    public void movePlayer(){
        playerM.handlePlayer();
    }
    
    public void setHealth(int hp){
        health = hp;
    }
    public int getHealth(){
        return health;
    }

    public void printHealth(){System.out.println(health);}
    public void getHit(int dmgAmount) {
        health -= dmgAmount;
        if(health <= 0) isAlive = false;
    }
    private void removePlayer() {
        map.getRoot().getChildren().remove(node);
    }
    
    public void heal(int healAmount){
        if(healAmount > 0){
            health += healAmount;
        }
    }


    private boolean zombHit = false, killZomb = false;
    public void isHitByZombie(boolean truth){
        zombHit = truth;
    }

    public void performAttack() {
        killZomb = true;
        System.out.println("OOOOOOOOOOOOOOO");

    }


    public class HandlePlayerMovement implements EventHandler<KeyEvent> {
        private boolean goUP = false, goDOWN = false, goLEFT = false, goRIGHT = false, attack = false;

        public void handle(KeyEvent event) { }

        public void handlePlayer() {
            map.getScene().setOnKeyPressed(event -> {
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

                    case SPACE:
                        attack = true;
                        break;
                }
            });

            map.getScene().setOnKeyReleased(event -> {
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

                    case SPACE:
                        attack = false;
                        break;
                }
            });

            AnimationTimer playerTimer = new AnimationTimer() {
                public void handle(long arg) {
                    if (isAlive) {
                    	zombienum += 5;
                        if (goUP) currY -= speed;
                        if (goDOWN) currY += speed;
                        if (goLEFT) currX -= speed;
                        if (goRIGHT) currX += speed;

                        if (attack) performAttack();
                        
                        if(zombienum >= 50) {
                        	az.addZobile();
                        	zombienum=0;
                        }
              
                        node.relocate(currX, currY);
                    } else {
                        removePlayer();
                    }
                }
                public void performAttack() {
                	for (int i = 0 ; i < az.zombies.size(); i++) {
                		int x = az.zombies.get(i).getCurrX();
                		int y = az.zombies.get(i).getCurrY();
                		if(Math.sqrt((currX-x)*(currX-x)+(currY-y)*(currY-y)) <= 120) {
                			az.zombies.get(i).isAlive=false;
                			az.ZobileDie(az.zombies.get(i));
     
                			score++;
                		
                			zombienum+=50;
                		}
                	}
                	x.setText(String.valueOf(score));
                }
                
            }; 
            playerTimer.start();
        }


    }
}
