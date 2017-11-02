import sofia.micro.*;

//-------------------------------------------------------------------------
/**
 *  The WallAnt class creates WallAnts which defend
 *  the colony.
 *  The WallAnt is an actor class which is a subclass
 *  to parent class Ant. This subclass creates a WallAnt
 *  actor which has a health of 4 and a cost of 4.
 *  This actor simply stands in the way of bees and
 *  since it has a higher health, can survive longer
 *  than the other Ant classes.
 *
 *  @author Sarah Marcus (stmarcus)
 *  @version (2016.10.26)
 */
public class WallAnt extends Ant
{
    //~ Fields ................................................................

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new WallAnt object.
     */
    public WallAnt()
    {
        super(4, 4);

    }


    //~ Methods ...............................................................

}
