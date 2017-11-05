import sofia.micro.*;

//-------------------------------------------------------------------------
/**
 *  The HungryAnt class creates HungryAnts
 *  which eat bees that fly on top of it.
 *  The HungryAnt is an actor class which
 *  is a subclass to parent class Ant. This
 *  subclass creates a HungryAnt which has a 
 *  health of 1 and a cost of 5. This actor
 *  can eat bees and remove them from the world
 *  but it takes 240 turns to digest a bee
 *  and is vulnerable to stinging during those
 *  240 turns.
 *
 *  @author Sarah Marcus (stmarcus)
 *  @version (2016.10.26)
 */
public class HungryAnt extends Ant
{
    //~ Fields ................................................................

    private int numberOfAct;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new HungryAnt object.
     */
    public HungryAnt()
    {
        super(5, 1);
        numberOfAct = 240;
    }


    //~ Methods ...............................................................

    /**
     * Creates a new act() method which
     * removes a bee from the world if one
     * intersects with it.
     */
    public void act()
    {                    
        
        if (numberOfAct < 240)
        {
            numberOfAct++ ;
        }
       
        else if (this.getOneIntersectingObject(Bee.class) != null)
        {             
            this.getWorld().remove(getOneIntersectingObject(Bee.class));
            numberOfAct = 0;            
        }  
        
    }


}
