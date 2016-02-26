
/**
 * Write a description of class LatinSquare here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LatinSquare
{
    public int size;
    
    private int known[][];
    private int possible[][];
    private boolean hasChanged = true;
    LatinSquare(int boardSize){
        size = boardSize;
        
        known = new int[size][size];
        possible = new int[size][size];
        for(int i = 0; i < boardSize; ++i){
            for(int b = 0; b < boardSize; ++b){
                known[i][b] = 0;
                possible[i][b] = (1<<boardSize)-1;
                if(boardSize == 32){
                possible[i][b] = ~0;
                }
            }
        }
    }
    
    LatinSquare(LatinSquare copy){
        copyFrom(copy);
    }
    
    void copyFrom(LatinSquare other){
        size = other.size;
        hasChanged = other.hasChanged;
        known = new int[other.known.length][];
        for(int i = 0; i < other.known.length; i++){
            known[i] = other.known[i].clone();
        }
    }
    
    static public int symbolToPossibility(int x) {
        return 1<<(x-1);
    }
    
    static public int possibilityToSymbol(int x){
        if(x==0){return 0;}
        return Integer.numberOfTrailingZeros(x)+1;
    }
    
    int get(int x, int y) {
        return known[x][y];
    }
    
    boolean isKnown(int x, int y){
        return get(x,y) != 0;
    }
    
    void print(){
        for(int i = 0; i < size; ++i){
            for(int b = 0; b < size; ++b){
                if(isKnown(i,b)){
                    System.out.print(known[i][b] + "\t");
                }
                else{
                    System.out.print(".\t");
                }
            }
            System.out.println();
        }
    }
    
    boolean isPossible(int x, int y, int s){
        int p = possible[x][y];
        return (p & symbolToPossibility(s)) != 0;
    }
    
    void markImpossible(int x, int y, int s){
        if(!isKnown(x,y)){
            possible[x][y] &= ~symbolToPossibility(s);
        }
    }
    
    int numOfPossibilities(int x, int y){
        return Integer.bitCount(possible[x][y]);
    }
    
    void insertSymbol(int x, int y, int s){
        if(isKnown(x,y)){
            throw new IllegalArgumentException("Tried to insert at " + x + "," + y + " but "
                + " the symbol " + get(x,y) + " was already there");
        }
        known[x][y] = s;
        for(int i = 0; i <size; ++i){
            if(i!=x){markImpossible(i,y,s);}
            if(i!=y){markImpossible(x,i,s);}
        }
    }
    
    void insertIfOnePossibility(int x, int y) throws NotSolvableException{
        if(numOfPossibilities(x,y) == 0){
            throw new NotSolvableException();           
        } else if(!isKnown(x,y) && numOfPossibilities(x,y) == 1){
            int s = possibilityToSymbol(possible[x][y]);
            insertSymbol(x,y,s);
            hasChanged = true;
        }
    }
    
    void propagate() throws NotSolvableException{
        for(int y = 0; y < size; ++y){
            for(int x = 0; x < size; ++x){
                insertIfOnePossibility(x,y);
            }
        }
    }
    
    void solve() throws NotSolvableException{
        while(hasChanged){
            hasChanged = false;
            propagate();
        }
        int unsolvedX = -1; 
        int unsolvedY = -1;
        
        searchForUnknown:
       
        for(int y = 0; y < size; ++y){
            for(int x = 0; x < size; ++x){
                if(!isKnown(x,y)){
                    unsolvedX = x; unsolvedY = y;
                    break searchForUnknown;
                }
            }
        }
        
        if(unsolvedX != -1 && unsolvedY != -1){
            int guessSymbol = possibilityToSymbol(possible[unsolvedX][unsolvedY]);
            insertSymbol(unsolvedX,unsolvedY, guessSymbol);
            solve();
        }
        

    }
          
}





