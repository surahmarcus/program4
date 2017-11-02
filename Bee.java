import sofia.micro.*;

//-------------------------------------------------------------------------
/**
 *  The Bee class creates bees which are
 *  trying to reach the Queen Chamber in
 *  this program. 
 *  The Bee class extends the Actor class.
 *  The Bee class creates bees which can
 *  injure the ants and can also be injured
 *  by the ants. This class, like the Ant
 *  class keeps track of the bees health
 *  and uses the Injure() method to decrease the
 *  health. 
 *
 *  @author Sarah Marcus (stmarcus)
 *  @version (2016.10.26)
 */
public class Bee extends Actor
{
    //~ Fields ................................................................

    private int numberOfAct;
    private int health;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Bee object.
     */
    public Bee()
    {
        super();
        this.turn(180);
        health = 3;
        numberOfAct = 0;
    }

    /**
     * Creates a new sting() method which 
     * decreases the ants health every 40 turns
     * by 1.
     */
    public void sting()
    {
        numberOfAct++ ;

        if (numberOfAct % 40 == 0)
        {
            this.getOneIntersectingObject(Ant.class).injure(1);
        }
    }

    //~ Methods ...............................................................
    /**
     * Creates a new getHealth() method that
     * returns the health of the bee.
     * @return the health of the bee.
     */
    public int getHealth()
    {
        return health;
    }

    /**
     * Creates a new injure() method that
     * decreases the bees health and removes it
     * if the health reaches 0.
     * @param n the number of times the 
     * bees health should decrease.
     */
    public void injure(int n)
    {        
        health = health - n ;
        if (health <= 0)
        {
            this.remove();
        }

    }

    /**
     * Creates a new act() method to be called
     * on every time the program acts. This act()
     * method stings ants if it intersects with one.
     */
    public void act()
    {

        if (getOneIntersectingObject(Ant.class) != null)
        {
            this.sting();
        }
        else
        {
            this.move(.0125);
        }
    }

}
