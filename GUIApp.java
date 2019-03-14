import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class GUIApp extends Application {

    private Group root;
    private Scene scene;
    private Map map;
    private Player player;
    private AllZombies allZombies;
    private Potion potion;

    public GUIApp() {
        root = new Group();
        scene = new Scene(root, 1280, 720);
        map = new Map(root,scene);
        player = new Player(map);
        allZombies = new AllZombies(map, player);
        potion = new Potion(map,player);
    }

    @Override
    public void start(Stage primaryStage){
        //background
        Image image = new Image("Map720.png");
        ImageView imgV = new ImageView(image);
        root.getChildren().add(imgV);

        //player, zombies and potion
        root.getChildren().add(player.getNode());
        allZombies.createZombies(4);
        root.getChildren().add(potion.getNode());

        primaryStage.setTitle("Demo2 Zombie Zurvival");
        primaryStage.setScene(scene);
        primaryStage.show();

        player.movePlayer();
    }
    public static  void main(String[] args) {
    	Application.launch(args);
    }
}
