package dangers;

import java.util.Random;

import map.map;

public class wumpus {

    private int x = 0;
    private int y = 0;
    private map pm;
    private Random rander = new Random();
    public wumpus(map spawn_map) {
        pm = spawn_map;
        pm.setRandomPosition("wumpus");
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
                break;
            case 1:
                result = "w";
                break;
            case 2: 
                result = "n";
                break;
            case 3:
                result = "s";
                break;
            default:
                result = "s";          
        }

        pm.move(result, pm.getCurrentLocation("wumpus"), "wumpus");
    }

}