//Test the Player class 
//and the functions the Player class inherits from the abstract GameObject class.

package Logic;

import static org.junit.Assert.*;
import org.junit.Test;


public class LogicTest{

    //Test the methods in the Player class.
    
    @Test
    public void test_heal(){
        Player p = new Player(100, 200, 15, 100);

        p.setHealth(1000);
        p.heal(50);

        assertEquals("Expected the health to be 1050 after increased by 50", 1050, p.getHealth(), 0.00001);
    }

    @Test
    public void test_takeDamage(){
        Player p = new Player(100, 200, 15, 100);

        p.setHealth(2000);
        p.takeDamage(300);

        assertEquals("Expected the health to be 1700 after increased by 300", 1700, p.getHealth(), 0.00001);
    }


    //Test the methods in the GameObject class.
    @Test
    public void test_isInRangeTrue(){
        Player p = new Player(100, 200, 15, 100);

        assertEquals("Range does not exceed the attack range (100)", true, p.isInRange(95, 194));
    }

    @Test
    public void test_isInRangeFalse(){
        Player p = new Player(100, 200, 15, 100);

        assertEquals("Range exceeds the attack range (100)", false, p.isInRange(30, 100));
    }
   
    @Test 
    public void test_moveUp(){
        Player p = new Player(100, 200, 15, 20);

        p.moveUp();

        assertEquals("Moving up from 200 with a speed of 15", 185, p.getCurrY(), 0.00001);
    }

    @Test 
    public void test_moveDown(){
        Player p = new Player(100, 210, 20, 20);

        p.moveDown();

        assertEquals("Moving down from 210 with a speed of 20", 230, p.getCurrY(), 0.00001);
    }

    @Test 
    public void test_moveLeft(){
        Player p = new Player(100, 200, 15, 20);

        p.moveLeft();

        assertEquals("Moving left from 100 with a speed of 15", 85, p.getCurrX(), 0.00001);
    }

    @Test 
    public void test_moveRight(){
        Player p = new Player(150, 200, 30, 20);

        p.moveRight();

        assertEquals("Moving right from 150 with a speed of 30", 180, p.getCurrX(), 0.00001);
    }
}