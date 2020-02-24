package player;

import map.map;


import control.control;
public class player extends control{

    private boolean life = true;
    private static Integer id_num = 0;
    private Integer x = null;
    private Integer y = null;
    private map pm;
    public player(map spawn_map) {
        id_num++;
        pm = spawn_map;
        pm.setRandomPosition("player");
        x = Integer.parseInt(String.valueOf(pm.getCurrentLocation("player").charAt(0)));
        y = Integer.parseInt(String.valueOf(pm.getCurrentLocation("player").charAt(2)));
        System.out.print("Player spawned at " + pm.getCurrentLocation("player") + "\n");
    }

    public void take_turn()
    {
        move();
        shoot();
    }


    public void move()
    {   
        System.out.println("Which direction would like to move:\n\t* North\n\t* South\n\t* East\n\t* West");
        String input = user_input.nextLine();
        input = input.toLowerCase();
        input = String.valueOf(input.charAt(0));
        detect(input);
        pm.move(input, (x + "," + y), "player");
        x = Integer.parseInt(String.valueOf(pm.getCurrentLocation("player").charAt(0)));
        y = Integer.parseInt(String.valueOf(pm.getCurrentLocation("player").charAt(2)));
    }

    public void shoot()
    {
        System.out.println("Pick a directions to shoot:\n\t*North\n\t*South\n\t*East\n\t*West");
        String shot = user_input.nextLine();
        shot = shot.toLowerCase();
        shot = String.valueOf(shot.charAt(0));
       // int wumpus_loc_x = Integer.parseInt(String.valueOf(pm.getCurrentLocation("wumpus").charAt(0)));
       // int wumpus_loc_y = Integer.parseInt(String.valueOf(pm.getCurrentLocation("wumpus").charAt(2)));
        if (shot == "n")
            {
                for (int i = 0; i < 2; i++)
                {
                    if (i+x > 4)
                    {
                        continue;
                    }
                    if (pm.map_grid[x+i][y] == "wumpus")
                    {
                        System.out.println("You have killed the wumpus\nYou win!!! :3");
                        System.exit(0);
                    }
                }
            }
        
            if (shot.equals("s") == true)
            {
                for (int i = 0; i > -2; i--)
                {
                    if (i+x < 0)
                    {
                        break;

                    }
                    if (pm.map_grid[x+i][y] == "wumpus")
                    {
                        System.out.println("You have killed the wumpus\nYou win!!! :3");
                        System.exit(0);
                    }
                }
            }

            if (shot.equals("w") == true)
            {
                for (int i = 0; i > -2; i--)
                {
                    if (i+y < 0)
                    {
                        continue;
                    }
                    if (pm.map_grid[x][y+i] == "wumpus")
                    {
                        System.out.println("You have killed the wumpus\nYou win!!! :3");
                        System.exit(0);
                    }
                }
            }

            if (shot.equals("e") == true)
            {
                for (int i = 0; i < 2; i++)
                {
                    if (i+y > 4)
                    {
                        break;
                    }
                    if (pm.map_grid[x][y+i] == "wumpus")
                    {
                        System.out.println("You have killed the wumpus\nYou win!!! :3");
                        System.exit(0);
                    }
                }
            }
            else {
                System.out.println("Choosing not to shoot.\n");
            }
    }
    public void kill (String cause)
    {

        
        life = false;
        System.out.println("You died via " + cause+"\n");
        System.exit(0);
    }
    public void detect(String input)
    {

        //death detections
        switch (input)
        {
            case "n":
                if (x < 4)
                {
                    if (pm.map_grid[x+1][y] == "wumpus" || pm.map_grid[x+1][y] == "pit")
                    {
                        this.kill(pm.map_grid[x+1][y]);
                    }
                }    
                break;

            case "s":
                if (x > 0 )
                {
                    if (pm.map_grid[x-1][y] == "wumpus" || pm.map_grid[x-1][y] == "pit")
                    {
                        this.kill(pm.map_grid[x-1][y]);
                    }
                }
                break;
            
            case "e":
                if (y < 4)
                {
                    if (pm.map_grid[x][y+1] == "wumpus" || pm.map_grid[x][y+1] == "pit")
                    {
                        this.kill(pm.map_grid[x][y+1]);
                    }
                }    
                break;
            
            case "w":
                if (y > 0)
                {
                    if (pm.map_grid[x][y-1] == "wumpus" || pm.map_grid[x][y-1] == "pit")
                    {
                        this.kill(pm.map_grid[x][y-1]);
                    }
                }    
                break;
                    




        

        }

        //bat detections
        switch (input)
        {
            case "n":
                if (x < 4)
                {
                    if (pm.map_grid[x+1][y] == "bat")
                    {
                        System.out.println("Woosh, you have run into a bat and it takes you away\n");
                        pm.map_grid[this.x][this.y] = null;
                        pm.setRandomPosition("player");
                        this.x = Integer.parseInt(String.valueOf(pm.getCurrentLocation("player").charAt(0)));
                        this.y = Integer.parseInt(String.valueOf(pm.getCurrentLocation("player").charAt(2)));
                    }
                }    
                break;

            case "s":
                if (x > 0 )
                {
                    if (pm.map_grid[x-1][y] == "bat")
                    {
                        System.out.println("Woosh, you have run into a bat and it takes you away\n");
                        pm.map_grid[this.x][this.y] = null;
                        pm.setRandomPosition("player");
                        this.x = Integer.parseInt(String.valueOf(pm.getCurrentLocation("player").charAt(0)));
                        this.y = Integer.parseInt(String.valueOf(pm.getCurrentLocation("player").charAt(2)));
                    }
                }
                break;
            
            case "e":
                if (y < 4)
                {
                    if (pm.map_grid[x][y+1] == "bat")
                    {
                        System.out.println("Woosh, you have run into a bat and it takes you away\n");
                        pm.map_grid[this.x][this.y] = null;
                        pm.setRandomPosition("player");
                        this.x = Integer.parseInt(String.valueOf(pm.getCurrentLocation("player").charAt(0)));
                        this.y = Integer.parseInt(String.valueOf(pm.getCurrentLocation("player").charAt(2)));
                    }
                }    
                break;
            
            case "w":
                if (y > 0)
                {
                    if (pm.map_grid[x][y-1] == "bat")
                    {
                        System.out.println("Woosh, you have run into a bat and it takes you away\n");
                        pm.map_grid[this.x][this.y] = null;
                        pm.setRandomPosition("player");
                        this.x = Integer.parseInt(String.valueOf(pm.getCurrentLocation("player").charAt(0)));
                        this.y = Integer.parseInt(String.valueOf(pm.getCurrentLocation("player").charAt(2)));
                    }
                }    
                break; 
            
        }
    }
}