package map;

import java.util.Random;

import player.player;
import wumpus.wumpus;

public class map{
    protected Random rander = new Random();
    protected String [][] map_grid;

    public map ()
     {
        map_grid = new String [5] [5];
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
            position_of[xpos][ypos] = ("wumpus");
            break;
            }

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

    public void setRandomPosition(player player)
    {
        
        while (true)
        {
            String position_of[][];
            position_of = map_grid;
            int xpos = rander.nextInt(map_grid.length);
            int ypos = rander.nextInt(map_grid[0].length);
            if (position_of[xpos][ypos] == null)
            {
            position_of[xpos][ypos] = "player";
            runner = false;
            }

            else 
             {
                continue;
             }
        }
    }

    public void setRandomPosition(pit pit)
    {
        while (true)
        {
            String position_of[][];
            position_of = map_grid;
            int xpos = rander.nextInt(map_grid.length);
            int ypos = rander.nextInt(map_grid[0].length);
            if (position_of[xpos][ypos] == null)
            {
            position_of[xpos][ypos] = "pit";
            runner = false;
            }

            else 
             {
                continue;
             }
        }
    }

    public String getCurrentLocation(String regex)
    {

        for (int x = 0; x < map_grid.length; x++)
        {
            for (int y = 0; y < map_grid.length; y++)
            {
                if (map_grid[x][y] == regex)
                {
                    return (x + "," + y);
                } 
            }
        }
    }

    public void move(String direction, String current_location, String moved_obj)
    {
        int x, y = current_location.split(",");
        System.out.println(mapping.length "and" mapping[0].length);

        if (direction == "up")
        {
            if (y == 4) 
            {
                System.out.println("Already at the top of the map");
            }

        }
        if (direction == "down")
        {
            if (y == 0) 
            {
                System.out.println("Already at the bottom of the map");
            }
        }
        if (direction == "left")
        {
            if (x == 0) 
            {
                System.out.println("Already at the far west of the map");
            }
        }
        if (direction == "right")
        {
            if (x == 4) 
            {
                System.out.println("Already at the far east of the map");
            }
        }
    }
    /*public int getXSize()
    {   
        System.out.println(map_grid.length);
        return map_grid.length;
    } */
}
