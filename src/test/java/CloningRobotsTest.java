import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CloningRobotsTest {

    CloningRobots robots = new CloningRobots();

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
        robots.setNumberOfRobots(1);
        robots.setNumberOfCrops(0);
    }

    /*
    ENDSTATE TESTS
     */

    @Test
    public void findFewestDays_with_10_crops(){
        Integer expected = 5;
        Integer actual = robots.findFewestDays(10);
        assertEquals(expected,actual);
    }

    /*
    SUPPORTING METHODS
     */

    @Test
    public void goForthAndMultiply_first_generation_test(){
        Integer expected = 2;
        robots.goForthAndMultiply();
        Integer actual = robots.getNumberOfRobots();
        assertEquals(expected, actual);
    }

    @Test
    public void goForthAndMultiply_bigger_number_test(){
        Integer expected = 128;
        robots.setNumberOfRobots(64);
        robots.goForthAndMultiply();
        Integer actual = robots.getNumberOfRobots();
        assertEquals(expected, actual);
    }

    @Test
    public void sowTheSeeds_early_Test(){
        Integer expected = 1;
        robots.sowTheSeeds();
        Integer actual = robots.getNumberOfCrops();
        assertEquals(expected,actual);
    }

    @Test
    public void sowTheSeeds_later_generation_Test(){
        Integer expected = 128;
        robots.setNumberOfRobots(128);
        robots.sowTheSeeds();
        Integer actual = robots.getNumberOfCrops();
        assertEquals(expected,actual);
    }

    /*
    BASIC PROCESSES (getters & setters)
     */

    @Test
    public void getNumberOfRobots_Test(){
        Integer expected = 1;
        assertEquals(expected, robots.getNumberOfRobots());
    }

    @Test
    public void setNumberOfRobots_Test(){
        Integer expected = 5;
        robots.setNumberOfRobots(5);
        Integer actual = robots.getNumberOfRobots();
        assertEquals(expected,actual);
    }

    @Test
    public void getNumberOfCrops_Test() {
        Integer expected = 0;
        assertEquals(expected, robots.getNumberOfCrops());
    }

    @Test
    public void setNumberOfCrops_Test() {
        Integer expected = 5;
        robots.setNumberOfCrops(5);
        Integer actual = robots.getNumberOfCrops();
        assertEquals(expected,actual);
    }

}
