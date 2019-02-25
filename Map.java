public class Map{
	//6x6 grid
	char[][] grid = {
			{'.','.','.','.','.','.'},
			{'.','.','.','.','.','.'},
			{'.','.','.','.','.','.'}, 
			{'.','.','.','.','.','.'},
			{'.','.','.','.','.','.'},
			{'.','.','.','.','.','.'}};
		
	
	public void placeToken(char token, int row, int column){
		grid[row][column] = token;
	
		//map.enemy.movementGoLeft()
		//update map, place new token and remove old location
		
	public boolean isValidMove(Location currentLocation, Direction direction) {
		
		return false;
	}
	
	public void move(Location currentLocation, Direction direction) {
		// switch case on direction
		switch (direction) {
			case Direction.UP:
				// set this -> grid[currentLocation.getX()][currentLocation.getY()+1];
				break;
			case 
			
		}
	}
	
	public char getElement(Location location) {
		return grid[location.getX()][location.getY()];
	}
	
	public static void print(){
		for (int row = 0; row < 6; row++){
			for (int column = 0; column < 6; column++){
				System.out.print(grid[row][column]);
			}
			System.out.println();
		}
	}
	
	//--------------------------------- COPYPASTE - IGNORE 
	public void placeToken(char token, int row, int column){
		grid[row][column] = token;
			
	}
		
	public boolean isEmpty(int row, int column){
		return grid[row][column] == '.';
	}
		
	public boolean hasWon(char token) {
