package player;
import map.map;

public class player extends map {

    private int lives = 3;
    private boolean health = true;
    
    public player (map spawn_map) {

        System.out.print("Player spawned at " + spawn_map.getCurrentLocation("player"));
    }

}