import sofia.micro.*;

//-------------------------------------------------------------------------
/**
 *  The ThrowerAnt class creates ThrowerAnts 
 *  which defend the colony.
 *  The ThrowerAnt is an actor class which is a subclass
 *  to parent class Ant. This subclass creates a ThrowerAnt
 *  actor which has a health of 1 and a cost of 4.
 *  This actor throws leaves every 120 times act is called
 *  The leaves are created in the Leaf actor class.
 *
 *  @author Sarah Marcus (stmarcus)
 *  @version (2016.10.26)
 */
public class ThrowerAnt extends Ant
{
    //~ Fields ................................................................

    private int numberOfAct;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new ThrowerAnt object.
     */
    public ThrowerAnt()
    {
        super(4, 1);
        numberOfAct = 0;
    }

    //~ Methods ...............................................................
    /**
     * Creates a new act() method to be called
     * on every time the program acts.
     */
    public void act()
    {               
        numberOfAct++ ;

        if (numberOfAct % 120 == 0)
        {
            Leaf leaf = new Leaf();
            this.getWorld().add(leaf, this.getGridX(), this.getGridY());

        }
    }

}
