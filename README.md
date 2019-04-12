How to run Zombie Zurvival:

1. Download all files from master branch and place in same folder:
  -Root folder should contain four png's  with their name unchanged and three packages:
  - Logic package containing files:
      AllZombies.java
      Game.java
      GameObject.java
      LogicTest.java (only needed for testing)
      Player.java
      Potion.java
      ScoreSaver.java
      Zombie.java
  - Gui package containing 
      GameOverScene.java
      HealthBar.java
      PlayerKeyHandler.java
      PotionGUI.java
      ScoreText.java
      StartButtonHandler.java
      ZombieGUIManager.java
      ZombieMovement.java
   - Drivers package:
      TextApp.java
      GUIApp.java
      
2. Navigate to root folder from console all compile all files, then run them.
    For GUI version: 
       "javac Drivers/GUIApp.java"
       "java Drivers.GUIApp"
    For Text version:
        "javac Drivers/TextApp.java"
        "java Drivers.TextApp"


PLAYING THE GAME

Player is a yellow triangle controlled with the arrow keys to move, and space to attack.
The player must kill as many zombies as he can before the zombies kill him.
Health is represented by red bar on lower left corner of screen. 
Being touched by zombies will lower health, walking over monster drinks will heal the player.
The players score is displayed in top right corner and represents the number of zombies killed.
Upon death, the player will see his score, and the current high score. If the players score is better
than the high score (initially zero), his score will be saved as the new best.
Click start button to begin.

How to run tests:

1. Place "junit-4.12.jar" and "hamcrest-core-1.3.jar" in the root folder.
2. On console navigate to root folder.
3. Compile logic package using "javac -cp .;junit-4.12.jar;hamcrest-core-1.3.jar Logic/*.java"
4. Run test using "java -cp .;junit-4.12.jar;hamcrest-core-1.3.jar org.junit.runner.JUnitCore Logic.LogicTest"


