import javafx.application.Application;
import javafx.stage.Stage;

/**
 * AppDriver is the main class that creates all instances of objects and runs their methods.
 */
public class AppDriver extends Application {

    //gApp is the only instance of GUIApp and is referenced in ZombieMovement so must static
    public static GUIApp gApp = new GUIApp();

    @Override
    public void start(Stage primaryStage) {
        //add the player to the scene
        gApp.root.getChildren().add(gApp.getPlayer().getPlayerNode());
        //display the scene
        primaryStage.setTitle("Demo2 Zombie Zurvival");
        primaryStage.setScene(gApp.getScene());
        primaryStage.show();
        //move the player
        gApp.getPlayer().movePlayer();

        //add all zombies to the scene
        gApp.getZombies().addZombiesToScene();

    }
}
