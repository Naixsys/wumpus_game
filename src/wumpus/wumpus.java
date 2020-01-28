package wumpus;
import map.map;
public class wumpus extends map {

    private boolean life = true;
    private map local_map;
    public wumpus(map spawn_map)
    {
        local_map = spawn_map;
        local_map.setRandomPosition(this);
        System.out.println("Spawned Wumpus\n");
    }
    
    public boolean kill_wumpus () 
    {
        life = false;
        return life;
    }

   /* public void moveWumpus()
    {
        local_map.moveWumpus(this);
    }*/
    public static void main(String[] args) {
        map map = new map();
        wumpus wumpus = new wumpus(map);

    }
}