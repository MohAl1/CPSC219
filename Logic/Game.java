package Logic;

/**
 * Class used to instantiate logic classes based on game version (GUI or Text),
 * and perform game mechanic of spawning new zombies.
 */
public class Game {

    // Instances of objects that have different values based on game version
    private Player player;
    private AllZombies allZombies;
    private Potion potion;

    // Variables used for spawning new zombies.
    private int zombieTracker = 0;
    private int spawnZombieIndicator;


    /**
     * Constant values used for game setup.
     * Values include: x bounds, y bounds, player and zombie speed and range,
     * potion range, player spawn point and time indicators for spawning new zombies.
     */
    // Text
    private final int playerSpawnXText=3, playerSpawnYText=2, playerTextSpeed=1,textRange=1,
                textMapX=16,textMapY=9,zombieTextSpeed=1,spawnZombieIndicatorText=10;
    // GUI
    private final int playerSpawnXGUI=300,playerSpawnYGUI=200,playerSpeedGUI=15,playerRangeGUI=100,
            GUIMapX=1280,GUIMapY=720,zombieSpeedGUI=6,zombieRangeGUI=5,potionRangeGUI=50,spawnZombieIndicatorGUI=100;


    public Player getPlayer(){
        return player;
    }
    public AllZombies getAllZombies() {
        return allZombies;
    }
    public Potion getPotion(){
        return potion;
    }

    /**
     * Instantiate the logic objects for Text version, or GUI version.
     * @param gameVersion: String that defines whether the objects should use larger values
     *                   for the 1280x720 GUI screen, or 16x9 char map for the Text version.
     */
    public void setUp(String gameVersion){
        if(gameVersion.equals("Text")){
            player = new Player(playerSpawnXText,playerSpawnYText,playerTextSpeed,textRange);
            allZombies = new AllZombies(textMapX,textMapY,zombieTextSpeed,textRange,player);
            player.setAllZombies(allZombies);
            spawnZombieIndicator=spawnZombieIndicatorText;
            potion = new Potion(textMapX,textMapY,0,textRange,player);

        }else if(gameVersion.equals("GUI")){
            player = new Player(playerSpawnXGUI,playerSpawnYGUI,playerSpeedGUI,playerRangeGUI);
            allZombies = new AllZombies(GUIMapX,GUIMapY,zombieSpeedGUI,zombieRangeGUI,player);
            player.setAllZombies(allZombies);
            spawnZombieIndicator=spawnZombieIndicatorGUI;
            potion = new Potion(GUIMapX,GUIMapY,0,potionRangeGUI,player);
        }
    }

    /**
     * Game mechanic that mimics keeping track of time by
     * increasing an integer variable 'zombieTracker' upon every call.
     *
     * Returns true after zombieTracker has increased enough/an amount of time has passed.
     *
     * @return: boolean result determining whether zombieTracker is big enough/enough time has passed.
     */
    public boolean zombieTracker(){
        boolean spawnZombie = false;
        if(zombieTracker>=spawnZombieIndicator){
            spawnZombie = true;
        }
        zombieTracker+=5;
        return spawnZombie;
    }

    /**
     * Resets zombieTracker back to zero, to use zombieTracker again.
     */
    public void resetZombieTracker(){
        zombieTracker =0;
    }

}
