package dangers;

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
        x = Integer.parseInt(String.valueOf(pm.getCurrentLocation("wumpus").charAt(0)));
        y = Integer.parseInt(String.valueOf(pm.getCurrentLocation("wumpus").charAt(2)));
        System.out.print("Wumpus spawned at " + pm.getCurrentLocation("wumpus") + "\n");
    }

    public void move()
    {
        int determine = rander.nextInt(4);
        String result = "direction";
        
        switch (determine)
        {
            case 0:
                result = "e";
            case 1:
                result = "w";
            case 2: 
                result = "n";
            case 3:
                result = "s";           
        }

        pm.move(result, (x+","+y), "wumpus");
        x = Integer.parseInt(String.valueOf(pm.getCurrentLocation("wumpus").charAt(0)));
        y = Integer.parseInt(String.valueOf(pm.getCurrentLocation("wumpus").charAt(2)));
    }

}