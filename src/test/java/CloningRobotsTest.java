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

    @Test
    public void findFewestRobots_with_10_crops(){
        Integer[] expected = {4, 5};
        Integer[] actual = robots.findFewestRobots(10);
        assertArrayEquals(expected,actual);
    }

    @Test
    public void findFewestDays_with_20_crops(){
        Integer expected = 6;
        Integer actual = robots.findFewestDays(20);
        assertEquals(expected,actual);
    }

    @Test
    public void findFewestRobots_with_20_crops(){
        Integer[] expected = {8, 6};
        Integer[] actual = robots.findFewestRobots(20);
        assertArrayEquals(expected,actual);
    }

    @Test
    public void findFewestDays_with_30_crops(){
        Integer expected = 6;
        Integer actual = robots.findFewestDays(30);
        assertEquals(expected,actual);
    }

    @Test
    public void findFewestRobots_with_30_crops(){
        Integer[] expected = {16, 6};
        Integer[] actual = robots.findFewestRobots(30);
        assertArrayEquals(expected,actual);
    }

    @Test
    public void findFewestDays_with_50_crops(){
        Integer expected = 7;
        Integer actual = robots.findFewestDays(50);
        assertEquals(expected,actual);
    }

    @Test
    public void findFewestRobots_with_50_crops(){
        Integer[] expected = {32, 7};
        Integer[] actual = robots.findFewestRobots(50);
        assertArrayEquals(expected,actual);
    }

    @Test
    public void findFewestDays_with_127_crops(){
        Integer expected = 8;
        Integer actual = robots.findFewestDays(127);
        assertEquals(expected,actual);
    }

    @Test
    public void findFewestDays_with_128_crops(){
        Integer expected = 8;
        Integer actual = robots.findFewestDays(128);
        assertEquals(expected,actual);
    }

    @Test
    public void findFewestDays_with_129_crops(){
        Integer expected = 9;
        Integer actual = robots.findFewestDays(129);
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
