import java.util.*;

/**
 * Day 2 - BragHand Class, allows for cards to be added to a hand by means of a list, includes exeption
 *         handling if not given exactly 3 cards.
 *       
 * 
 * @LiamSorta || liamsorta.co.uk || https://github.com/LiamSorta/
 * 
 * Part of a Java Crash Course hosted by Andrew Kay (http://www.andrewkay.name)
 */
public class BragHand
{
    BragHand(List<Card> newCards){
        myCards = new ArrayList<Card>();
        if(newCards.size() != 3){
            throw new IllegalArgumentException("Error: Must have exactly 3 cards.");
        }
        myCards = newCards;
    }
    
    public void printHand(){
        for(int i = 0; i < myCards.size(); i++){
            System.out.println(myCards.get(i).toString());
        }
    }

    public List<Card> myCards;
}
