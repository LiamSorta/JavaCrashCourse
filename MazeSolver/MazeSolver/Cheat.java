import java.awt.*;
import javax.swing.JPanel;

/**
 * Write a description of class Cheat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cheat extends Solver
{
    Cheat(Maze newMaze){ super(newMaze);}
    Move move(){
        draw();
        return new MoveResign();
    }
    
    @Override
    void draw(Graphics g, int drawX, int drawY) {
        super.draw(g,drawX,drawY);
        for(int x = 0; x < maze.width; x++) {
            for(int y = 0; y < maze.height; y++) {
                maze.cellAt(x,y).draw(
                    g,
                    x*GridCell.pixelWidth,
                    y*GridCell.pixelWidth
                );
            }
        }
    }
    
}
