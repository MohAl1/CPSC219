package Logic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * Saves the score of the player after death.
 */
public class ScoreSaver {

    // Score of player after most recent run
    private int score;
    // Initialize high score to save to 0
    private int highest=0;

    public ScoreSaver(Player player){
        score = player.getScore();
    }

    public int getHighest() {
        return highest;
    }
    public int getScore() {
        return score;
    }

    /**
     * Save the score of the player to a file.
     * If most recent score is higher than saved highscore,
     * set that as the new high score.
     */
    public void saveScore(){
        // Try to create new file and read from it
        try {
            File file = new File("score.txt");
            file.createNewFile();
            Scanner scanner = new Scanner(file);
            // If the file has a past highscore, set that as the highest score.
            if(scanner.hasNextLine()) {
                highest = Integer.parseInt(scanner.nextLine());
            }
            // If the new score is higher than past highscore, set the new score
            // as the high score.
            if(score > highest) {
                highest = score;
                file = new File("score.txt");
                file.createNewFile();
                // Write the new highscore to the file
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                writer.write(String.valueOf(highest));
                writer.close();
            }
        // Catch any exceptions.
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
