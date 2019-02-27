public class Potion extends Map{

  private int xcordinate ;
  private int ycordinate;
  private double healthRegen = 25.0;

  /* Constructor **/
  public Potion(){
  }

  //public int getCords(){
  //}

  //public void placePotion(char potion, int y, int x){
	//	grid[y][x] = potion;
  //}
  
  
  /*Setter **/
  public void setPosition(int xpos, int ypos){
    xcordinate = xpos;
    ycordinate = ypos;
  }
  
  /*Mutators **/
  public double regenerate(){
    return healthRegen;
  }
}