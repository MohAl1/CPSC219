import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GUIApp extends Application {

    private Group root;
    private Scene scene;
    private Map map;
    private Player player;

    public GUIApp() {
        root = new Group();
        scene = new Scene(root, 1280, 720, Color.CYAN);
        map = new Map(root,scene);
        player = new Player(map);

    }

    @Override
    public void start(Stage primaryStage){

        root.getChildren().add(player.getNode());

        primaryStage.setTitle("Demo2 Zombie Zurvival");
        primaryStage.setScene(scene);
        primaryStage.show();

        player.update();

    }
}
