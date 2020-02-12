package player;

public class player {

    private int lives = 3;
    private boolean health = true;
    
    public player () {

        System.out.print("Player spawned at " + spawn_map.getCurrentLocation("player"));
    }

}