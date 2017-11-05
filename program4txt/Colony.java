import sofia.micro.*;

//-------------------------------------------------------------------------
/**
 *  The Colony class creates a world for
 *  the ants and bees to act on.
 *  This world extends HomeBase and inherits
 *  HomeBase act(). Colony adds a hive and a
 *  chamber to the world. It also adds
 *  an ant selecting panel to allow
 *  the user to select a specific ant to place
 *  in the world. Colony also had a method
 *  onTouchDown() to place the ants in its
 *  world. Colony also has methods to keep
 *  track of how much food is avaliable
 *  for the user to use.
 *
 *  @author Sarah Marcus (stmarcus)
 *  @version (2016.10.26)
 */
public class Colony extends HomeBase
{
    //~ Fields ................................................................

    private int food;
    private QueensChamber chamber;
    private Hive hive ;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Colony object.
     */
    public Colony()
    {
        super();

        hive = new Hive();
        this.add(hive, 9, 3);
        chamber = new QueensChamber();
        this.add(chamber, 0, 3);

        food = 10;

        setActorChoices(
            HarvesterAnt.class,
            ThrowerAnt.class,
            WallAnt.class,
            FireAnt.class,
            HungryAnt.class);
    }

    //~ Methods ...............................................................
    // ----------------------------------------------------------
    /**
     * Add an ant to the screen when a specific location is clicked.
     * This method is automatically called while the simulation is
     * running, whenever the user clicks on (or taps on) a location
     * in the colony (one that isn't covered by an actor already).
     * 
     * @param x The x-coordinate of the click
     * @param y The y-coordinate of the click
     */
    public void onTouchDown(int x, int y)
    {

        Ant selectedAnt = (Ant) newActorOfSelectedType();

        if (selectedAnt.getFoodCost() <= food && ((x <= 8) && (y <= 5)))
        {   
            this.add(selectedAnt, x, y);
            this.consumeFood(selectedAnt.getFoodCost());         

        }
    }

    /**
     * Returns the ants stomach contents
     * @return The stomach contents of the ants
     */

    public int getFood()
    {
        return food;
    }

    /**
     * This method increases the amount of food
     * the user has to use by int a.
     * @param a adds int food
     */
    public void addFood(int a)
    {
        food = food + a;
    }

    /**
     * This method decreases the amount of food
     * the user has to use by int b.
     * @param b subtracts int food
     */
    public void consumeFood(int b)
    {
        food = food - b;     
    }

    @Override    
    public void act()
    {
        super.act();

        if ((this.getObjects(Bee.class).size() == 0) && (hive.getBees() == 0))
        {
            this.win();
        }

        if (chamber.beesInChamber())
        {
            this.lose();
        }

    }
}
