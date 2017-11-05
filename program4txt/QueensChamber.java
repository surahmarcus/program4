import sofia.micro.*;

//-------------------------------------------------------------------------
/**
 *  The QueensChamber class creates a queen
 *  chamber which the ants must protect and 
 *  is the target area for the bees to go.
 *  This is an Actor subclass. This subclass
 *  has a method beesInChamber() which checks
 *  to see whether there are any bees in the chamber.
 *
 *  @author Sarah Marcus (stmarcus)
 *  @version (2016.10.26)
 */
public class QueensChamber extends Actor
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new QueensChamber object.
     */
    public QueensChamber()
    {
        /*# Do any work to initialize your class here. */
    }


    //~ Methods ...............................................................

    /**
     * Creates a new beesInChamber() method which
     * checks to see if any Bees are currently
     * in the queens chamber.
     * @return the size of the insecting objects list.
     */
    public boolean beesInChamber()
    {
        
        return (this.getIntersectingObjects(Bee.class).size() > 0);
        
    }

}
