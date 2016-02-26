
/**
 * Write a description of class GreedyBreadcrumbSolver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BreadcrumbSolver extends Solver
{
    BreadcrumbSolver(Maze newMaze) { super(newMaze);}
    Move move(){
        
        if(x == 10 && y == 23) {
            System.out.println("lol");
        }
        int bestOffer = -1;
        Move bestMove = new MoveResign();
        int avaliableWalls = 0;
        
        if(!maze.cellAt(x,y+1).passable || maze.cellAt(x,y+1).breadcrumbs >= 2){
            avaliableWalls++;
        }
        if(!maze.cellAt(x,y-1).passable || maze.cellAt(x,y-1).breadcrumbs >= 2){
            avaliableWalls++;
        }
        if(!maze.cellAt(x-1,y).passable || maze.cellAt(x-1,y).breadcrumbs >= 2){
            avaliableWalls++;
        }
        if(!maze.cellAt(x+1,y).passable || maze.cellAt(x+1,y).breadcrumbs >= 2){
            avaliableWalls++;
        }

         if((bestOffer == -1 || maze.cellAt(x+1,y).breadcrumbs < bestOffer) && maze.cellAt(x+1,y).breadcrumbs < 2 && maze.cellAt(x+1,y).passable){
            bestOffer = maze.cellAt(x+1,y).breadcrumbs;
            bestMove = new MoveEast();
        }
        if((bestOffer == -1 || maze.cellAt(x,y+1).breadcrumbs < bestOffer) && maze.cellAt(x,y+1).breadcrumbs < 2 && maze.cellAt(x,y+1).passable){
            bestOffer = maze.cellAt(x,y+1).breadcrumbs;
            bestMove = new MoveSouth();
        }
  
        if((bestOffer == -1 || maze.cellAt(x-1,y).breadcrumbs < bestOffer) && maze.cellAt(x-1,y).breadcrumbs < 2 && maze.cellAt(x-1,y).passable){
            bestOffer = maze.cellAt(x-1,y).breadcrumbs;
            bestMove = new MoveWest();
        }
        if((bestOffer == -1 || maze.cellAt(x,y-1).breadcrumbs < bestOffer) && maze.cellAt(x,y-1).breadcrumbs < 2 && maze.cellAt(x,y-1).passable){
            bestOffer = maze.cellAt(x,y-1).breadcrumbs;
            bestMove = new MoveNorth();
        }
        
        if(maze.cellAt(x,y).breadcrumbs == 0){
            bestMove.breadcrumbs = 1;
        }
        System.out.println(x + " " + y);
        if(avaliableWalls >= 3){
            bestMove.breadcrumbs = 2;
        }
        
        
        return bestMove;
    }
}
