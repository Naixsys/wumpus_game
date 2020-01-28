package map;

import java.util.Random;

import player.player;
import wumpus.wumpus;

public class map{
    protected Random rander = new Random();
    protected String [][] map_grid;

    public map ()
     {
    
        int x_size = rander.nextInt(5);
        int y_size = rander.nextInt(5);
        map_grid = new String [x_size] [y_size];

    }

    public void setRandomPosition(wumpus wumpus)
    {   
        while (true)
        {
            String position_of[][];
            position_of = map_grid;
            int xpos = rander.nextInt(map_grid.length);
            int ypos = rander.nextInt(map_grid[0].length); 
            if (position_of[xpos][ypos] == null)
            {
            position_of[xpos][ypos] = ("Wumpus");
            break;
            }

            else 
             {
                continue;
             }
        }
    }

    public void setRandomPosition(player player)
    {
        boolean runner = true;
        while (runner)
        {
            String position_of[][];
            position_of = map_grid;
            int xpos = rander.nextInt(map_grid.length);
            int ypos = rander.nextInt(map_grid[0].length);
            if (position_of[xpos][ypos] == null)
            {
            position_of[xpos][ypos] = "Player";
            runner = false;
            }

            else 
             {
                continue;
             }
        }
    }
    /*public int getXSize()
    {   
        System.out.println(map_grid.length);
        return map_grid.length;
    } */
}