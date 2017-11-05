import sofia.micro.*;

//-------------------------------------------------------------------------
/**
 *  The Ant class creayes ants which are
 *  trying to protect the Queen Chamber from 
 *  the evil bees.
 *  The Ant class extends the Actor class.
 *  The ant class is also a parent class to many
 *  subclasses of ants which have more specific 
 *  functions. This class keeps track of the ants
 *  cost and health. It also has a method
 *  to decrease the ants health for the event in 
 *  which they are stung by a bee.
 *
 *  @author Sarah Marcus (stmarcus)
 *  @version (2016.10.26)
 */
public class Ant extends Actor
{
    //~ Fields ................................................................

    private int health;  
    private int cost;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Ant object.
     * @param cost1 stores the cost of ant.
     * @param health1 stores the health of ant.
     */
    public Ant(int cost1, int health1)
    {
        cost = cost1;
        health = health1;
    }

    //~ Methods ...............................................................
    /**
     * Stores ant's health value.
     * @return the health of the ant.
     */
    public int getHealth()
    {
        return health;
    }

    /**
     * Creates a new injure() method that
     * decreases the ants health and removes it
     * if the health reaches 0.
     * @param n the number of times the 
     * ants health should decrease.
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
     * Stores ant's cost value.
     * @return the cost of the ant.
     */
    public int getFoodCost()
    {
        return cost;
    }

}
