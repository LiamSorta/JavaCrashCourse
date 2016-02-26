
/**
 * Write a description of class ThreeThrees here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ThreeThrees extends HandRank
{
    public String name(){ return "Three Threes";}
    public int numericRank() {return 6;}
    public ThreeThrees(BragHand hand){ super(hand);}
    public boolean isValid(){
        return hand.myCards.get(0).myValue == 3 &&
               hand.myCards.get(1).myValue == 3 &&
               hand.myCards.get(2).myValue == 3;
    }
}
