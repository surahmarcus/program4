import sofia.micro.*;
import java.util.List;

//-------------------------------------------------------------------------
/**
 *  The FireAnt class creates FireAnts 
 *  which defend the colony.
 *  The FireAnt is an actor class which is a subclass
 *  to parent class Ant. This subclass creates a FireAnt
 *  actor which has a health of 1 and a cost of 4. This
 *  actor explodes when it's health = 0 and removes
 *  any neighboring bees when it explodes.
 *
 *  @author Sarah Marcus (stmarcus)
 *  @version (2016.10.26)
 */
public class FireAnt extends Ant
{
    //~ Fields ................................................................

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new FireAnt object.
     */
    public FireAnt()
    {
        super(4, 1);
    }

    //~ Methods ...............................................................
    @Override    
    public void injure(int n)
    {

        if (this.getHealth() - n <= 0)
        {
            List<Bee> neighbors;
            neighbors = this.getNeighbors(1, true, Bee.class);
            for (Bee bee : neighbors)
            {                
                bee.injure(3);
            }

            if (this.getOneIntersectingObject(Bee.class) != null)
            {
                this.getWorld().remove(getOneIntersectingObject(Bee.class));
            }

        }
        super.injure(n);
    }

}
