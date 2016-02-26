import java.util.*;
/**
 * Write a description of class Pair here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
*/

public class StraightFlush extends HandRank
{
    public String name(){ return "Straight Flush";}
    public int numericRank() {return 5;}
    public StraightFlush(BragHand hand){ super(hand);}
    public boolean isValid(){
        Collections.sort(hand.myCards);
        return (
             (
             hand.myCards.get(0).myValue +1 == hand.myCards.get(1).myValue && 
             hand.myCards.get(1).myValue +1 == hand.myCards.get(2).myValue
             ) || (
             hand.myCards.get(0).myValue == 2 &&
             hand.myCards.get(0).myValue == 3 &&
             hand.myCards.get(0).myValue == 14
             )
         && suitCheck());
        
    }
    
    private boolean suitCheck(){
        char suitTarget = hand.myCards.get(0).mySuit;
        return (hand.myCards.get(1).mySuit == suitTarget &&
                hand.myCards.get(2).mySuit == suitTarget);
    }
}