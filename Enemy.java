public class Enemy {
/*
the location is x n y
*/
private int xcordinate ;
private int ycordinate;
private int Health;
private int Damage;
private boolean alive;

/* Constructor **/
public Enemy(int xpos, int ypos){
  xcordinate=xpos;
  ycordinate=ypos;
  Health = 100;
  alive = true;
}
/* Mutators       **/
/* MOVEMENT BLOCK **/
public void Goleft(){
xcordinate -=;
}
public void Goright(){
xcordinate +=;
}
public void Goup(){
ycordinate +=;
}
public void Godown(){
ycordinate -=;
}
/* Health & Damage**/
public void takeDamage(){
Health -=;
}
public boolean dead(){
if ( Health = 0){
  alive = false;
  return alive;
}else{
  return alive;
}
}
/* Do damage ???????**/
public void attackMove (){

}


}
