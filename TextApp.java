import java.util.Scanner;

/**
TextApp controls and loads the whole game. I will write comments and a skeleton that calls methods and creates 
instances of other classes (player, enemy, weapon etc.)


*/
public class TextApp{
	// instance variables are the player and the map.
	// player will have the weapon, and location.
	//Location will have enemy. (see class diagram on d2l)
	private Map map;
	private Location location;
	
	
	// no constructors currently.
	// only default one created by java.
	
	
	/**
	This is the method unique to demo1 that will call all methods,
	and classes to play the game. Methods called here are in the class diagram on d2l.
	*/
	public void play(){
		
		//displays the empty map by calling map's instance variable.
		//The map should load with one player and zombie in reasonable positions (not next to each other)
		map.print();
		map.placePlayer();
		map.placeEnemy();
		
		//calls the player class's method for a movement.
		location.getX();
		location.getY();
		
		//while the move is valid, update the map, and ask for another move.
		while (location.isValidMove(char key)){
			map.move(currentLocation, direction);
			//map.getElement checks if potion, weapon or zombie is within one block
			//zombie AI move toward player
			
			player.getDirection();
		}
		
	}
	public static void main(String[] args){
		TextApp.play();
		
	}
	
	
}