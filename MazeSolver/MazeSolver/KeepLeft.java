/**
 * Write a description of class GreedyBreadcrumbSolver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KeepLeft extends Solver
{
    int currentDir = 1;
    KeepLeft(Maze newMaze) { super(newMaze);}
    Move move(){
        System.out.println(currentDir);
        if(maze.cellAt(x+1,y).passable && currentDir == 1){
            Move test = new MoveDir(currentDir);
            return new MoveEast();
        }
        else if(maze.cellAt(x,y+1).passable && currentDir == 2){
            Move test = new MoveDir(currentDir);
            return new MoveSouth();
        }
        else if(maze.cellAt(x-1,y).passable && currentDir == 3){
            Move test = new MoveDir(currentDir);
            return new MoveWest();
        }
        else if(maze.cellAt(x,y-1).passable && currentDir == 4){
            Move test = new MoveDir(currentDir);
            return new MoveNorth();
        }
        else{
            if(currentDir >= 4){
                currentDir = 1;
            }
            else{
               currentDir++;
            }
        }
        
        
        return new MoveDropBreadcrumb();
    }
}
