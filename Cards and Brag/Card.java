
/**
 * Day 2 - Card Class, has custom comparator to allow for checks of card values with .equals / other
 *         forms of comparison. Also includes a next generation algorithm that rivals everything we
 *         know about modern day cryptography.
 *       
 * 
 * @LiamSorta || liamsorta.co.uk || https://github.com/LiamSorta/
 * 
 * Part of a Java Crash Course hosted by Andrew Kay (http://www.andrewkay.name)
 */
public class Card implements Comparable<Card>
{
    Card(int value, char suit){
        myValue = allValues[value-2];
        mySuit = suit;
    }
    
    @Override
    public int compareTo(Card other){
        return this.myValue - other.myValue;
        
//         if(other.myValue > this.myValue ){
//             System.out.println("false");
//             return -1;
//         }
//         else if(other.myValue  < this.myValue ){
//             System.out.println("true");
//             return 1;
//         }
//         else{
//             System.out.println("==");
//             return 0;
//         }
    }
    
    @Override
    public int hashCode(){
        double greatAlgorithm = 90210;
        greatAlgorithm /= myValue+5;
        greatAlgorithm += (int)mySuit*(int)mySuit*(int)mySuit;
        greatAlgorithm += ((int)mySuit + (myValue * 36) + 42 + 2016 * (int)mySuit*3) / myValue;
        greatAlgorithm /= myValue;
        greatAlgorithm += 1;
        return (int)greatAlgorithm;
    }
    
    @Override
    public boolean equals(Object card){
        //System.out.println("is " + value + " = " + myValue+mySuit);
        return card.toString().equals(toString());
    }
    
    @Override
    public String toString(){
        char charVal;
        switch(myValue){
            case 11:
                charVal = 'J';
                break;
            case 12:
                charVal = 'Q';
                break;
            case 13:
                charVal = 'K';
                break;
            case 14:
                charVal = 'A';
                break;
            default:
                charVal = String.valueOf(myValue).charAt(0);
        }
        return ("" + charVal + mySuit);
    }
    
    public int myValue = 0;
    public char mySuit = 'x';
    private int[] allValues = new int[]{2,3,4,5,6,7,8,9,10,11,12,13,14};
    //private char[] allSuits = new char[] {'♠', '♥', '♦', '♣'};
    //private char[] allSuits = new char[] {'s', 'h', 'd', 'c'};
}
