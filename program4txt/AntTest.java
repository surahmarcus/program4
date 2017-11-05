import sofia.micro.*;
import sofia.util.Random;


// -------------------------------------------------------------------------
/**
 *  This test class tests all methods in all
 *  classes within this program.
 *  The objectives of my tests are to test
 *  all methods and all possibilities within
 *  those methods to assure that all methods
 *  work as intended.
 *
 *  @author Sarah Marcus (stmarcus)
 *  @version (2016.10.26)
 */
public class AntTest extends TestCase
{
    //~ Fields ................................................................

    private ThrowerAnt tant;
    private FireAnt fant;
    private HarvesterAnt harant;
    private HungryAnt hurant;
    private Bee bee1;
    private QueensChamber chamber;
    private Hive hive;
    private Colony colony;
    
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new AntTest test object.
     */
    public AntTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        colony = new Colony();
        chamber = new QueensChamber();
        hive = new Hive();
        bee1 = new Bee();    
        colony.add(chamber, 0, 3);
        colony.add(hive, 9, 3);
    }


    // ----------------------------------------------------------
    /**
     * Tests the class Colony's act() method.
     */
        //     public void testColonyAct1()
        //     {        
        //         hive.setBees(0);
        //         hive.getBees();
        //         tant = new ThrowerAnt();
        //         colony.add(tant, 5, 5);
        //         run(colony, 10);
        //         colony.act();
        //         
        //         assertTrue(colony.isGameWon());
        //      
        //     }
    
    /**
     * Tests the class Colony's act() method.
     */
    public void testColonyAct2()
    {
        run(colony, 2000);
        colony.act();
        
        assertTrue(colony.isGameOver());
         
    }
    
    /**
     * Tests the class Colony's onTouchDown() method.
     */
    public void testOnTouchDown()
    {
        colony.setSelectedActor(HarvesterAnt.class);
        colony.onTouchDown(2, 2);
        
        assertEquals(1, colony.getObjects(HarvesterAnt.class).size());

        
    }
    
    /**
     * Tests the class Colony's onTouchDown() method.
     */
    public void testOnTouchDown2()
    {
        colony.setSelectedActor(HarvesterAnt.class);
        colony.onTouchDown(9, 6);
        
        assertEquals(0, colony.getObjects(HarvesterAnt.class).size());

        
    }
    
    /**
     * Tests the class Colony's onTouchDown() method.
     */
    public void testOnTouchDown3()
    {
        colony.consumeFood(10);
        colony.setSelectedActor(HarvesterAnt.class);
        colony.onTouchDown(2, 2);
        
        
        assertEquals(0, colony.getObjects(HarvesterAnt.class).size());

        
    }
    
    /**
     * Tests the class Colony's onTouchDown() method.
     */
    public void testOnTouchDown4()
    {
        colony.setSelectedActor(HarvesterAnt.class);
        colony.onTouchDown(10, 4);
        
        assertEquals(0, colony.getObjects(HarvesterAnt.class).size());

        
    }
    
    /**
     * Tests the class Colony's onTouchDown() method.
     */
    public void testOnTouchDown5()
    {
        colony.setSelectedActor(HarvesterAnt.class);
        colony.onTouchDown(7, 8);
        
        assertEquals(0, colony.getObjects(HarvesterAnt.class).size());

        
    }
    
    /**
     * Tests the class Colony's addFood() method.
     */
    public void testAddFood()
    {
        colony.addFood(1);
        
        assertEquals(11, colony.getFood());        
        
    }
    
    /**
     * Tests the class Colony's consumeFood() method.
     */
    public void testConsumeFood()
    {
        colony.consumeFood(1);
        
        assertEquals(9, colony.getFood());        
        
    }
    
    /**
     * Tests the class Colony's getFood() method.
     */
    public void testGetFood()
    {        
        colony.getFood();
        assertEquals(10, colony.getFood());    
        
    }
    
    /**
     * Tests the class Ant's injure() method.
     */
    public void testInjureAnt()
    {        
        harant = new HarvesterAnt();
        colony.add(harant, 5, 5);
        harant.injure(1);
        assertEquals(0, harant.getHealth());  
        assertEquals(0, colony.getObjects(Ant.class).size());
        
    }
    
    /**
     * Tests the class Bee's injure() method.
     */
    public void testInjureBee()
    {        
        bee1 = new Bee();
        colony.add(bee1, 5, 5);
        bee1.injure(3);
        assertEquals(0, bee1.getHealth());  
        assertEquals(0, colony.getObjects(Bee.class).size());
        
    }
    
    /**
     * Tests the class ThrowerAnt's act() method.
     */
    public void testThrowerAntAct()
    {        
        tant = new ThrowerAnt();
        colony.add(tant, 5, 5);
        run(colony, 120);
        tant.act();
        assertEquals(1, colony.getObjects(Leaf.class).size());      
        
    }
    
    /**
     * Tests the class FireAnt's act() method to assure
     * that FireAnt removes all neighboring bees.
     */
    public void testFireAntAct()
    {        
        fant = new FireAnt();
        bee1 = new Bee();
        colony.add(fant, 5, 5);
        colony.add(bee1, 5, 4);
        
        fant.injure(1);
        colony.act();
        assertEquals(0, colony.getObjects(Bee.class).size());      
        
    }
    
    /**
     * Tests the class FireAnt's act() method to assure
     * that FireAnt removes all neighboring bees.
     */
    public void testFireAntAct2()
    {        
        fant = new FireAnt();
        bee1 = new Bee();
        colony.add(fant, 5, 5);
        colony.add(bee1, 5, 5);
        
        fant.injure(1);
        fant.act();
        assertEquals(0, colony.getObjects(Bee.class).size());
        assertEquals(0, colony.getObjects(Ant.class).size());
        assertEquals(0, fant.getHealth());
        
    }
    
    /**
     * Tests the class FireAnt's act() method to assure
     * that FireAnt removes all neighboring bees.
     */
    public void testFireAntAct3()
    {        
        fant = new FireAnt();
        bee1 = new Bee();
        colony.add(fant, 5, 5);
        colony.add(bee1, 4, 5);
        

        fant.act();
        assertEquals(1, colony.getObjects(Bee.class).size());
        assertEquals(1, fant.getHealth());
        
    }
    
    /**
     * Tests the class HarvesterAnt's act() method.
     */
    public void testHarvesterAntAct()
    {        
        harant = new HarvesterAnt();
        colony.add(harant, 5, 5);
        colony.add(bee1, 5, 4);
        run(colony, 40);
        harant.act();
        assertEquals(11, colony.getFood());      
        
    }
    
    /**
     * Tests the class HungryAnt's act() method.
     */
    public void testHungryAntAct()
    {        
        hurant = new HungryAnt();
        bee1 = new Bee();
        colony.add(hurant, 5, 5);
        colony.add(bee1, 8, 5);
        run(colony, 260);
        hurant.act();
        assertEquals(0, colony.getObjects(Bee.class).size());    
        
    }

    /**
     * Tests the class QueensChamber's beesFar() method.
     */
    public void testBeesFar1()
    {        

        colony.add(bee1, 1, 3);
        run(colony, 260);
        bee1.act();
        chamber.beesInChamber();
        assertEquals(true, chamber.beesInChamber());    
        
    }
    
    /**
     * Tests the class QueensChamber's beesFar() method.
     */
    public void testBeesFar2()
    {        
        chamber.beesInChamber();
        assertEquals(false, chamber.beesInChamber());    
        
    }
    
    /**
     * Tests the class Ant's getHealth() method.
     */
    public void testGetHealthAnts()
    {        
        hurant = new HungryAnt();
        colony.add(hurant, 5, 5);
        hurant.getHealth();
        assertEquals(1, hurant.getHealth());    
        
    }
    
    /**
     * Tests the class Bee's getHealth() method.
     */
    public void testGetHealthBees()
    {        
        bee1 = new Bee();
        colony.add(bee1, 5, 5);
        bee1.getHealth();
        assertEquals(3, bee1.getHealth());    
        
    }
    
    /**
     * Tests the class Ant's getFoodCost() method.
     */
    public void testGetFoodCost()
    {        
        hurant = new HungryAnt();
        colony.add(hurant, 5, 5);
        hurant.getFoodCost();
        assertEquals(5, hurant.getFoodCost());    
        
    }
    
    /**
     * Tests the class Bee's sting() method.
     */
    public void testSting()
    {        
        bee1 = new Bee();
        colony.add(bee1, 5, 4);
        harant = new HarvesterAnt();
        colony.add(harant, 4, 4);
        run(colony, 260);
        bee1.act();
        assertEquals(0, harant.getHealth());   
        assertEquals(3, bee1.getHealth());    
        
    }
    
    /**
     * Tests the class Leaf's Act() method.
     */
    public void testLeafAct()
    {        
        tant = new ThrowerAnt();
        bee1 = new Bee();
        colony.add(tant, 5, 5);
        colony.add(bee1, 7, 5);
        run(colony, 200);
        tant.act();
        assertEquals(2, bee1.getHealth());  
        assertEquals(0, colony.getObjects(Leaf.class).size());   
        
    }
    
    /**
     * Tests the class Leaf's Act() method.
     */
    public void testLeafAct2()
    {        
        tant = new ThrowerAnt();
        colony.add(tant, 8, 5);
        run(colony, 300);
        tant.act(); 
        assertEquals(0, colony.getObjects(Leaf.class).size());   
        
    }
    
    /**
     * Tests the class Hive's addBees() method.
     */
    public void testAddBees()
    {        
        hive.addBee();
        assertEquals(1, colony.getObjects(Bee.class).size());    
        
    }
    
    /**
     * Tests the class Colony's getBees() method.
     */
    public void testGetBees()
    {        
        hive.getBees();
        assertEquals(30, hive.getBees());    
        
    }
    
    /**
     * Tests the class Hive's act() method.
     */
    public void testHiveAct()
    {        
        run(colony, 400);       
        hive.act();
        hive.getBees();
        assertEquals(29, hive.getBees());    
        
    }
    
    /**
     * Tests the class Hive's act() method.
     */
    public void testHiveAct2()
    {        
        run(colony, 490); 
        Random.setNextInts(80);
        hive.act();
        hive.setBees(0);
        hive.act();
        assertEquals(0, hive.getBees());    
        
    }
    
    /**
     * Tests the class Ant's injure() method.
     */
    public void testAntInjure()
    {                
        WallAnt want = new WallAnt();
        colony.add(want, 5, 5);
        colony.add(bee1, 6, 5);
        run(colony, 100);
        bee1.act();
        assertEquals(3, want.getHealth());     
        
    }
    
}
