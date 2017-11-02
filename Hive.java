import sofia.micro.*;
import sofia.util.Random;

//-------------------------------------------------------------------------
/**
 *  The Hive class creates a hive actor which
 *  stores bees inside of it.
 *  The Hive Actor s a subclass to Actor
 *  and is added to the colony in the Colony class.
 *  The Hive randomly adds bees to the world
 *  using the addBee() method. The hive also 
 *  keeps track of the number of bees within itself,
 *  The hive also has a method to set the 
 *  number of bees called setBees(). The act() method
 *  waits 400 turns to add a bee to the colony and then
 *  adds a bee, and after adding the first bee, waits 
 *  a random amount from 80-400 to add another bee.
 *
 *  @author Sarah Marcus (stmarcus)
 *  @version (2016.10.26)
 */
public class Hive extends Actor
{
    //~ Fields ................................................................

    private int numberOfBees;
    private int numberOfAct;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Hive object.
     */
    public Hive()
    {
        super();        
        numberOfAct = 400;
        numberOfBees = 30;
    }

    //~ Methods ...............................................................
    /**
     * Creates a new addBee() method which adds
     * bees to the world at x = 5 and a random y
     * coordinate.
     */
    public void addBee()
    {
        Bee bee = new Bee();
        int x = 9;
        int y = Random.generator().nextInt(1, 5);
        this.getWorld().add(bee, x, y);

    }

    /**
     * Creates a getBees() method which 
     * returns the current number of bees in
     * the hive.
     * @return the number of bees in the hive.
     */
    public int getBees()
    {
        return numberOfBees;
    }

    /**
     * Creates a new setBees() method which
     * takes an int n to add a certain number
     * of bees to the hive.
     * @param n The number of bees to create.
     */
    public void setBees(int n)
    {
        numberOfBees = n;
    }

    /**
     * Creates a new act() method which adds
     * a bee to the colony after the first 400 
     * acts and then adds one randomly after
     * 80-400 acts.
     */
    public void act()
    {
        numberOfAct--;

        if (numberOfAct < 1)
        {
            if (numberOfBees > 0 )
            {
                this.addBee();
                numberOfBees = numberOfBees - 1;
            }

            numberOfAct = Random.generator().nextInt(80, 400);
        }

    }

}
