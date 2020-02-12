package wumpus;
import map.map;
public class wumpus extends map {

    private boolean life = true;
<<<<<<< HEAD

    public wumpus(map spawn_map)
    {
        spawn_map.setRandomPosition(this);
        System.out.print("Wumpus spawned at " + spawn_map.getCurrentLocation("wumpus"));
=======
    private map local_map;
    public wumpus(map spawn_map)
    {
        local_map = spawn_map;
        local_map.setRandomPosition(this);
        System.out.println("Spawned Wumpus\n");
>>>>>>> 41c05a8b3ec2a011a5510a09781edab5e9daeace
    }
    
    public boolean kill_wumpus () 
    {
        life = false;
        return life;
    }
<<<<<<< HEAD
=======

   /* public void moveWumpus()
    {
        local_map.moveWumpus(this);
    }*/
    public static void main(String[] args) {
        map map = new map();
        wumpus wumpus = new wumpus(map);

    }
>>>>>>> 41c05a8b3ec2a011a5510a09781edab5e9daeace
}