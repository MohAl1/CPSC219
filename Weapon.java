public class Weapon{

  private int xcordinate ;
  private int ycordinate;
  private int statIncrease = 25;

/*Constructor **/
 public Weapon(int xpos, int ypos){
   xcordinate = xpos;
   ycordinate = ypos;
 }
 /*Mutators **/
 public int addStat(){
  return statIncrease;
 }
}
