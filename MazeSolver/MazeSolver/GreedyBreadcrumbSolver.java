
/**
 * Write a description of class GreedyBreadcrumbSolver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GreedyBreadcrumbSolver extends Solver
{
    GreedyBreadcrumbSolver(Maze newMaze) { super(newMaze);}
    Move move(){
        int bestOffer = -1;
        Move bestMove = new MoveResign();
        if((bestOffer == -1 || maze.cellAt(x,y+1).breadcrumbs < bestOffer) && maze.cellAt(x,y+1).passable){
            bestOffer = maze.cellAt(x,y+1).breadcrumbs;
            bestMove = new MoveSouth();
        }
        if((bestOffer == -1 || maze.cellAt(x+1,y).breadcrumbs < bestOffer) && maze.cellAt(x+1,y).passable){
            bestOffer = maze.cellAt(x+1,y).breadcrumbs;
            bestMove = new MoveEast();
        }
        if((bestOffer == -1 || maze.cellAt(x-1,y).breadcrumbs < bestOffer) && maze.cellAt(x-1,y).passable){
            bestOffer = maze.cellAt(x-1,y).breadcrumbs;
            bestMove = new MoveWest();
        }
        if((bestOffer == -1 || maze.cellAt(x,y-1).breadcrumbs < bestOffer) && maze.cellAt(x,y-1).passable){
            bestOffer = maze.cellAt(x,y-1).breadcrumbs;
            bestMove = new MoveNorth();
        }
        bestMove.breadcrumbs = 1; 
        return bestMove;
    }
}
