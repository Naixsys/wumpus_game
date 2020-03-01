package player;

import map.map;


import control.control;
public class player extends control{

    private int arrows = 3;
    private static Integer id_num = 0;
    private Integer x = null;
    private Integer y = null;
    private String input = null;
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
        boolean looper = true;
        while(looper)
        {
            System.out.println("What do you want to do?\n\t*Move (M)\n\t*Shoot (S)\n\t*Skip (Press any other key)");
            input = user_input.nextLine();
            input = input.toLowerCase();
            switch(input)
            {
                case "m":
                    move();
                    break;
                case "s":
                    shoot();
                    looper = false;
                    break;
                default:
                    System.out.println("Your turn is over now");
                    break;
            }
            break;
        }

    }


    public void move()
    {   
        System.out.println("Which direction would like to move:\n\t* North\n\t* South\n\t* East\n\t* West");
        input = user_input.nextLine();
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
        input = user_input.nextLine();
        String win_message = "You have killed the wumpus\nYou win!!! :3";
        String invalid_choice = "Invalid input, skipping shooting";
        String no_arrow_message = "You seem to have no more arrows...and you smell something purtrid and rotting";
        input = input.toLowerCase();
        input = String.valueOf(input.charAt(0));
       // int wumpus_loc_x = Integer.parseInt(String.valueOf(pm.getCurrentLocation("wumpus").charAt(0)));
       // int wumpus_loc_y = Integer.parseInt(String.valueOf(pm.getCurrentLocation("wumpus").charAt(2)));
        if (arrows == 0)
        {
            System.out.println(no_arrow_message);
            kill("wumpus");
        }
        switch(input)
        {
            case "n":
                for (int i = 0; i < 3; i++)
                {
                    if (i+x > 4)
                    {
                        continue;
                    }
                    if (pm.map_grid[x+i][y] == "wumpus")
                    {
                        System.out.println(win_message);
                        System.exit(0);
                    }
                }
                break;
            case "s":
                for (int i = 0; i < 3; i++)
                {
                    if (x-i < 0)
                    {
                        break;

                    }
                    if (pm.map_grid[x-i][y] == "wumpus")
                    {
                        System.out.println(win_message);
                        System.exit(0);
                    }
                }
                break;
            case "w":
                for (int i = 0; i < 3; i++)
                {
                    if (y-i < 0)
                    {
                        continue;
                    }
                    if (pm.map_grid[x][y-i] == "wumpus")
                    {
                        System.out.println(win_message);
                        System.exit(0);
                    }
                }
                break;
            case "e":
                for (int i = 0; i < 3; i++)
                    {
                        if (y+i > 4)
                        {
                            break;
                        }
                        if (pm.map_grid[x][y+i] == "wumpus")
                        {
                            System.out.println(win_message);
                            System.exit(0);
                        }
                    }
                break;    
            default:
            System.out.println(invalid_choice);

        }
        arrows--;
            
    }
    public void kill (String cause)
    {

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