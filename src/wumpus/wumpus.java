package wumpus;

import java.util.Random;

import map.map;

public class wumpus {

    private boolean life = true;
    private Integer x = 0;
    private Integer y = 0;
    private map pm;
    private Random rander = new Random();
    public wumpus(map spawn_map) {
        pm = spawn_map;
        pm.setRandomPosition("wumpus");
        System.out.print("Wumpus spawned at " + pm.getCurrentLocation("wumpus") + "\n");
    }

    public void move(String direction, String current_location, String transport)
    {
        int determine = rander.nextInt(4);
        String result = "direction";
        
        switch (determine)
        {
            case 0:
                result = "right";
            case 1:
                result = "left";
            case 2: 
                result = "up";
            case 3:
                result = "down";           
        }

        pm.move(result, pm.getCurrentLocation("wumpus"), "wumpus");
    }

    public boolean kill_wumpus() {
        life = false;
        return life;
    }

    public Integer getX()
    {
        return x;
    }

    public Integer getY()
    {
        return y;
    }

}