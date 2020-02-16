package wumpus;
import map.map;
public class wumpus extends map {

    private boolean life = true;

    public wumpus(map spawn_map)
    {
        spawn_map.setRandomPosition(this);
        System.out.print("Wumpus spawned at " + spawn_map.getCurrentLocation("wumpus"));
    }
    
    public boolean kill_wumpus () 
    {
        life = false;
        return life;
    }

}