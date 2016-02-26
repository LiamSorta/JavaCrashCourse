import java.util.*;
/**
 * Write a description of class Straight here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Straight extends HandRank
{
    public String name(){ return "Straight";}
    public int numericRank() {return 5;}
    public Straight(BragHand hand){ super(hand);}
    public boolean isValid(){
        Collections.sort(hand.myCards);
        return (
         hand.myCards.get(0).myValue +1 == hand.myCards.get(1).myValue&& 
         hand.myCards.get(1).myValue +1 == hand.myCards.get(2).myValue
         ) || (
         hand.myCards.get(0).myValue == 2 &&
         hand.myCards.get(0).myValue == 3 &&
         hand.myCards.get(0).myValue == 14
         );
        
    }
}