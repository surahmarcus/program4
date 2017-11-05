import sofia.micro.*;

//-------------------------------------------------------------------------
/**
 *  The HarvesterAnt class creates HarvesterAnts
 *  which add food to the colony.
 *  The HarvesterAnt is an actor which is a subclass
 *  to parent class Ant. This subclass creates
 *  a HarvesterAnt actor which has a health of 1 and
 *  a cost of 2. This actor adds 1 food to the colony
 *  every 40 turns. The food added to the colony
 *  can then be used to place other ants.
 *
 *  @author Sarah Marcus (stmarcus)
 *  @version (2016.10.26)
 */
public class HarvesterAnt extends Ant

{
    //~ Fields ................................................................

    private int numberOfAct;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new HarvesterAnt object.
     */
    public HarvesterAnt()
    {
        super(2, 1);
        numberOfAct = 0;
    }

    //~ Methods ...............................................................
    /**
     * Creates a new act() method to be called
     * on every time the program acts. This act()
     * method adds 1 food every turn.
     */
    public void act()
    {
        numberOfAct++ ;

        if (numberOfAct % 40 == 0)
        {
            ((Colony)this.getWorld()).addFood(1);
        }

    }

}
