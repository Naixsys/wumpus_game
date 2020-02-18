package player;

import map.map;


import control.control;
public class player extends control{

    private int lives = 3;
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

    public void move(String current_location)
    {   
        System.out.println("Which direction would like to move:\n\t* North\n\t* South\n\t* East\n\t* West");
        String input = user_input.nextLine();
        input = input.toLowerCase();
        pm.move(input, pm.getCurrentLocation("player"), "player");
    }

    public void kill ()
    {
        this.lives =this.lives--;
        System.out.println("Player" + id_num + " has " + lives + "left\n");
    }



}