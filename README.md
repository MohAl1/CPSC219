# CPSC219

if anyone wants to work on this, go ahead.

I think the next step is to add collision detection in two places:
  - zombies touching player
  - zombies touching each other
  
Perhaps both should be done in their own inner class inside ZombieMovement.

If you feel you don't understand how to implement classes (took me whole weekend)
seperate classes for potion and weapon can be made. 

For weapon I think the easier design would be to make it like potion:
  when the player walks on an "attackUp" icon, his attack stat increases.
  
The next hard part will be to add attacks to zombie and player:
  when collision is detected between zombie and player,  Player health stat
  decreases.
  
  when collision is detected between zombie and player, AND player presses space, 
  zombie health decreases.
