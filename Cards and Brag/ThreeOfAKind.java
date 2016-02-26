
/**
 * Write a description of class Pair here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
*/

public class ThreeOfAKind extends HandRank
{
    public String name(){ return "Three of a kind";}
    public int numericRank() {return 5;}
    public ThreeOfAKind(BragHand hand){ super(hand);}
    public boolean isValid(){
        int targetVal = hand.myCards.get(0).myValue;
        return hand.myCards.get(1).myValue == targetVal &&
               hand.myCards.get(2).myValue == targetVal;
    }
}

