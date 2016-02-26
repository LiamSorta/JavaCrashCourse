
/**
 * Abstract class HandRank - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class HandRank
{ 
    
    BragHand hand;
    
    abstract public String name();
    abstract public boolean isValid();
    abstract public int numericRank();
    
    HandRank(BragHand newHand){
        hand = newHand;

    }
   
}
