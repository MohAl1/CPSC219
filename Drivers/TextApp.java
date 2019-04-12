package Drivers;

import Logic.Game;
import Logic.Player;
import Logic.Zombie;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class that runs the text based, console version of game.
 *
 * Overall char map is based off of Dr. Verwaal's TicTacToe game on d2l.
 */
public class TextApp {

    private Game game;
    // 2d array of chars representing list,
    private char[][] grid;
    // Number or rows and columns in map.
    private int rows = 9;
    private int columns = 16;

    // Chars on map representing different objects
    private char playerChar = 'O';
    private char zombieChar= 'z';
    private char potionChar='p';

    // When TextApp is created, the grid is filled with '.' representing empty spaces.
    private TextApp(){
        grid = new char[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column <columns; column++) {
                grid[row][column] = '.';
            }
        }
    }

    /**
     * Places the specified object on the grid.
     * @param x: x coordinate
     * @param y: y coordinate
     * @param object: char representing object to be placed.
     */
    private void placeObject(int x, int y, char object){
        grid[y][x] = object;
    }

    /**
     * Remove the object at specific coordinates by replacing it with '.'.
     * @param x: x coordinate
     * @param y: y coordinate
     */
    private void removeObject(int x, int y){
        grid[y][x] = '.';
    }

    /**
     * Nested for loop that prints every char in the grid.
     */
    private void printMap(){
        for (int row = 0; row < rows; row++){
            for (int column = 0; column < columns; column++){
                System.out.print(grid[row][column]);
            }
            System.out.println();
        }
    }

    /**
     * Moves the player using 'wasd' input read from scanner.
     * Removes the player char, updates its coordinates, then places the char on the grid.
     */
    private void handleKeyboardInput(){
        Player player = game.getPlayer();
        Scanner keyboard = new Scanner(System.in);
        char inputKey = keyboard.next().charAt(0);

        if(inputKey == 'w'){
            removeObject(player.getCurrX(),player.getCurrY());
            player.moveUp();
            placeObject(player.getCurrX(),player.getCurrY(),playerChar);
        }
        else if(inputKey == 's'){
            removeObject(player.getCurrX(),player.getCurrY());
            player.moveDown();
            placeObject(player.getCurrX(),player.getCurrY(),playerChar);
        }
        else if(inputKey == 'd'){
            removeObject(player.getCurrX(),player.getCurrY());
            player.moveRight();
            placeObject(player.getCurrX(),player.getCurrY(),playerChar);
        }
        else if(inputKey == 'a'){
            removeObject(player.getCurrX(),player.getCurrY());
            player.moveLeft();
            placeObject(player.getCurrX(),player.getCurrY(),playerChar);

        }else if(inputKey == 'k'){
            player.performAttack();
        }
    }

    /**
     * For every zombie, fi the zombie is alive, move it by removing its char
     * and placing it in a new position after calling its move method.
     */
    private void updateZombie(){
        ArrayList<Zombie> zombies = game.getAllZombies().getZombies();
        for(Zombie zombie: zombies){
            if(zombie.isAlive()) {
                removeObject(zombie.getCurrX(), zombie.getCurrY());
                zombie.moveZombie();
                placeObject(zombie.getCurrX(), zombie.getCurrY(), zombieChar);
            }
        }
    }

    /**
     * For every zombie, if it is dead, remove it from the grid.
     */
    private void removeDeadZombies(){
        for(Zombie zombie: game.getAllZombies().getZombies()){
            if(!zombie.isAlive()){
                removeObject(zombie.getCurrX(),zombie.getCurrY());
            }
        }
    }

    /**
     * Uses game class zombieTracker mechanic to spawn new zombies and place them on the grid.
     * When zombieTracker evaluates to true, spawn new zombies and place them on the grid.
     *
     * Info about zombieTracker() and resetZombieTracker() can be found in Game class.
     */
    private void spawnNewZombies(){
        if(game.zombieTracker()){
            Zombie zombie = game.getAllZombies().createZombies();
            placeObject(zombie.getCurrX(),zombie.getCurrY(),zombieChar);
            game.resetZombieTracker();
        }
    }

    /**
     * Prints the players score to the console.
     */
    private void showScore(){
        System.out.println("Score: "+game.getPlayer().getScore());
    }

    /**
     * Places the potion on the grid and calls potion heal method.
     */
    private void updatePotion(){
        placeObject(game.getPotion().getCurrX(),game.getPotion().getCurrY(),potionChar);
        game.getPotion().healPlayer();
    }

    /**
     * Instantiate a new instance of game, set it up and play it.
     * Update game state after every input while the player is alive.
     */
    private void play(){
        // Create a new instance of game and set it up with "Text" values.
        game = new Game();
        game.setUp("Text");

        // Print the map with player on it for the first time
        placeObject(game.getPlayer().getCurrX(),game.getPlayer().getCurrY(),playerChar);
        printMap();
        // While the player is alive, update all components of map.
        while(game.getPlayer().isAlive()){
            handleKeyboardInput();
            spawnNewZombies();
            removeDeadZombies();
            updateZombie();
            updatePotion();
            printMap();
            showScore();
        }
    }

    /**
     * Main method that calls play.
     * @param args: system arguments.
     */
    public static void main(String[] args){
        TextApp textApp = new TextApp();
        textApp.play();
    }
}
