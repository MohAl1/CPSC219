public class Map{
	char[][] grid;
	


	public static void main(String[] args) {
		char[][] startConfiguration = new char[6][6];
		for (int row = 0; row < 6; row++) {
			for (int column = 0; column < 6; column++) {
				startConfiguration[row][column] = args[row*6 + column].charAt(0);
			}
        }
    }
    
    public Map(char[][] startConfiguration){
		grid = startConfiguration;
	}
	
	public Map(Map toCopy) {
		grid = toCopy.grid;
	}
	
	public Map(){
		grid = new char[6][6];
		for (int row = 0; row < 6; row++) {
			for (int column = 0; column < 6; column++) {
				grid[row][column] = '.';
			}
		}
	}
    public void placePlayer(char player, int y, int x){
		grid[y][x] = player;
	}  

	public void placeEmpty(char empty, int y, int x){
		grid[y][x] = empty;
	}

    public void print(){
		for (int row = 0; row < 6; row++){
			for (int column = 0; column < 6; column++){
				System.out.print(grid[row][column]);
			}
			System.out.println();
		}
	}
}