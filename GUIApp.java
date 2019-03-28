import com.sun.glass.ui.Accessible.EventHandler;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUIApp extends Application {

    private Group root;
    private Scene scene;
    private Map map;
    private Player player;
    public Text x = new Text("0");
    private AllZombies allZombies;
    public Button btn = new Button("Start");
    
    public GUIApp() {
        root = new Group();
        scene = new Scene(root, 1280, 720);
        map = new Map(root,scene);
        player = new Player(map,x);

        allZombies = new AllZombies(4, map, player);
    }

    @Override
    public void start(Stage primaryStage){
        //background
        Image image = new Image("Map720.png");
        ImageView imgV = new ImageView(image);
        root.getChildren().add(imgV);
        x.setX(50);
        x.setY(70);
        x.setFill(Color.WHITE);
        x.setFont(Font.font("Verdana",FontWeight.BOLD,70));
        root.getChildren().add(x);
        //player and zombies
        root.getChildren().add(player.getNode());
        btn.setFont(Font.font("Verdana",FontWeight.BOLD,70));
        btn.setLayoutX(475);
        btn.setLayoutY(280);
        root.getChildren().add(btn);
        primaryStage.setTitle("Demo2 Zombie Zurvival");
        primaryStage.setScene(scene);
        primaryStage.show();
        btn.setOnMouseClicked(event->{
        	btn.setVisible(false);
        	allZombies.createZombies();
            player.movePlayer();
        });
        //allZombies.zombieCollision();
        //allZombies.update();
    }
    public static  void main(String[] args) {
    	Application.launch(args);
    }
}
