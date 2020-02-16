package map;

import java.util.Random;

import pits.pit;
import player.player;
import wumpus.wumpus;

public class map{
    protected Random rander = new Random();
    final protected String [][] map_grid;

    public map ()
     {
        map_grid = new String [5] [5];
     }

    public void setRandomPosition(wumpus wumpus)
    {   
        while (true)
        {
            
            int xpos = rander.nextInt(map_grid.length);
            int ypos = rander.nextInt(map_grid[0].length); 
            if (map_grid[xpos][ypos] == null)
            {
            map_grid[xpos][ypos] = ("wumpus");
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
        
        while (true)
        {
            
            int xpos = rander.nextInt(map_grid.length);
            int ypos = rander.nextInt(map_grid[0].length); 
            if (map_grid[xpos][ypos] == null)
            {
            map_grid[xpos][ypos] = ("player");
            break;
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
            
            int xpos = rander.nextInt(map_grid.length);
            int ypos = rander.nextInt(map_grid[0].length); 
            if (map_grid[xpos][ypos] == null)
            {
            map_grid[xpos][ypos] = ("pit");
            break;
            }

            else 
             {
                continue;
             }
        }
    }


   

    public String getCurrentLocation(String regex)
    {
        String loc = "";
        for (int x = 0; x < map_grid.length; x++)
        {
            for (int y = 0; y < map_grid[0].length; y++)
            {
                if (map_grid[x][y] == regex)
                {
                    loc = (x + "," + y);
                    
                } 
            }
        }
        return loc;
    }

    public void setCurrentLocation(String regex, int x_pos, int y_pos)
    {
        String curr_loc = getCurrentLocation(regex);
        String[] c_pos = curr_loc.split(",");
        map_grid[Integer.parseInt(c_pos[0])][Integer.parseInt(c_pos[1])] = null;
        map_grid[Integer.parseInt(c_pos[0]+x_pos)][Integer.parseInt(c_pos[1]+y_pos)] = regex;
        
    }
    
    public void move(String direction, String current_location, String moved_obj)
    {
        String [] cords = current_location.split(",");
        System.out.println(cords);

        if (direction == "up")
        {
            if (cords[1] == "4") 
            {
                System.out.println("Already at the top of the map");
            }

            else
            {
                setCurrentLocation(moved_obj, 0, 1);
            }
        }
        if (direction == "down")
        {
            if (cords[1] == "0") 
            {
                System.out.println("Already at the bottom of the map");
            }

            else
            {
                setCurrentLocation(moved_obj, 0, -1);
            }
        }
        if (direction == "left")
        {
            if (cords[0] == "0") 
            {
                System.out.println("Already at the far west of the map");
            }

            else
            {
                setCurrentLocation(moved_obj, -1, 0);
            }
        }
        if (direction == "right")
        {
            if (cords[0] == "4") 
            {
                System.out.println("Already at the far east of the map");
            }

            else
            {
                setCurrentLocation(moved_obj, 1, 0);
            }
        }
    }

}
