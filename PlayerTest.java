import static org.junit.Assert.*;
import org.junit.Test;

public class PlayerTest{

    private Map map;

    //Testing the health point using getHit and heal methods.
    @Test
    public void test_getHit_correctMath(){
        Player p = new Player(map);
        p.setHealth(1000);
        p.getHit(120);
        assertEquals("Expected health after decreased 120 from 1000", 880, p.getHealth(), 0.00001);

    }

    @Test
    public void test_getHit_alive(){
        Player p = new Player(map);
        p.setHealth(1000);
        p.getHit(300); 
        assertEquals("Expected to be alive after health decreased 120 from 1000", true, p.getIsAlive());
    }

    @Test 
     public void test_getHit_dead(){
        Player p = new Player(map);
        p.setHealth(200);
        p.getHit(300); 
        assertEquals("Expected to be dead after health decreased 300 from 200", false, p.getIsAlive());
    }

    @Test
    public void test_heal(){
        Player p = new Player(map);
        p.setHealth(5600);
        p.heal(400);
        assertEquals("Expected to heal after 400 health is added to the original health", 6000, p.getHealth());
    }

    @Test 
    public void test_heal_invaild(){
        Player p = new Player(map);
        p.setHealth(5600);
        p.heal(-1000);
        assertEquals("Expected the health to stay unchanged when adding a negative heal amount", 5600, p.getHealth());
    }
}