import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class HandlePlayerMovement implements EventHandler<KeyEvent> {

    private double xx;
    private double yy;

    public HandlePlayerMovement(double x, double y) {
        xx = x;
        yy= y;
    }

    public void handle(KeyEvent event) {
    }



    private boolean goUP=false,goDOWN=false,goLEFT=false,goRIGHT=false;

        public void movePlayer() {
            AppDriver.gApp.getScene().setOnKeyPressed(new EventHandler<KeyEvent>() {
                public void handle(KeyEvent event){
                    switch(event.getCode()){
                        case UP: goUP=true;break;
                        case DOWN: goDOWN=true;break;
                        case LEFT: goLEFT=true;break;
                        case RIGHT: goRIGHT=true;break;
                    }
                }

            });

            AppDriver.gApp.getScene().setOnKeyReleased(new EventHandler<KeyEvent>() {
                public void handle(KeyEvent event){
                    switch(event.getCode()){
                        case UP: goUP=false;break;
                        case DOWN: goDOWN=false;break;
                        case LEFT: goLEFT=false;break;
                        case RIGHT: goRIGHT=false;break;
                    }
                }
            });

            AnimationTimer timer = new AnimationTimer(){
                public void handle (long arg){
                    double delta = 15;

                    if(goUP) yy -= delta;
                    if(goDOWN) yy += delta;
                    if(goLEFT) xx -= delta;
                    if(goRIGHT) xx += delta;
                    AppDriver.gApp.getPlayer().setLocation(xx,yy);
                }

            };
            timer.start();
        }

}
