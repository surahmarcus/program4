import sofia.micro.*;

//-------------------------------------------------------------------------
/**
 *  The Leaf class creates a Leaf actor which
 *  is used to hurt the bees.
 *  The Leaf Actor is a subclass to Actor and
 *  is used by ThrowerAnt to throw leaves
 *  at the bees which in turn hurt the bees. The act()
 *  method decreases the bee's health by one if it
 *  hits a bee, then removes the leaf from the colony.
 *
 *  @author Sarah Marcus (stmarcus)
 *  @version (2016.10.26)
 */
public class Leaf extends Actor
{
    //~ Fields ................................................................


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Leaf object.
     */
    public Leaf()
    {
        /*# Do any work to initialize your class here. */
    }

    //~ Methods ...............................................................
    /**
     * Creates a new act() method which injures bees
     * if a leaf touches the bee, or removes the leaf
     * from the colony if the leaf reaches the end of
     * the colony.
     */
    public void act()
    {
        if (this.getOneIntersectingObject(Bee.class) != null )
        {
            this.getOneIntersectingObject(Bee.class).injure(1);
            this.remove();
        }
        this.move(.025);

        if (this.getGridX() == 9)
        {
            this.remove();
        }

    }

}
