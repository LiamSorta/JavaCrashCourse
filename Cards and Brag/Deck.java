import java.util.*;

/**
 * Day 2 - Deck Class, initializes itself within the constructor
 *       
 * 
 * @LiamSorta || liamsorta.co.uk || https://github.com/LiamSorta/
 * 
 * Part of a Java Crash Course hosted by Andrew Kay (http://www.andrewkay.name)
 */
public class Deck
{

    
    Deck(){
         cardsInDeck = new ArrayList<Card>();
         for(int value = 2; value <= 14; value++){
             for(char suit : new char[]{'c','d','h','s'}){
                 cardsInDeck.add(new Card(value,suit));
             }
         }
    }
    
    public void printDeck(){
        for(int i = 0; i < 52; i++){
             System.out.println(cardsInDeck.get(i).toString());
         }        
    }
    
    public BragHand drawHand(){
        Card temp;
        Random rand = new Random();
        List<Card> hand = new ArrayList<Card>();
        for(int i = 0; i < 3; i++){
            temp = returnCard(rand.nextInt(cardsInDeck.size()-0+1)+0);
            hand.add(temp);
            cardsInDeck.remove(temp);
        }
        return new BragHand(hand);
    }
       
    public Card returnCard(int index){
        return cardsInDeck.get(index);
    }
    
    public String getCard(int index){
        return cardsInDeck.get(index).toString();
    }
    
    public boolean contains(Card card){
        return cardsInDeck.contains(card);
    }
    
   
    private List<Card> cardsInDeck;
}
