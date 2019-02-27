public class Potion(){
  private int xcordinate ;
  private int ycordinate;
  private int healthRegen = 25.0;

/* Constructor **/
public Potion(int xpos, int ypos){
  xcordinate = xpos;
  ycordinate = ypos;
}
/*Setter **/
public void setPosition(int xpos, int ypos){
  xcordinate = xpos;
  ycordinate = ypos;
}
/*Mutators **/
public int regenerate(){
  return healthRegen;
}

}
