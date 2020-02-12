package pit;
import map.map;
public class pit extends map 
{

pit(map spawn_map)
{
    spawn_map.setRandomPosition(this);
    System.out.print("Pit spawned at " + spawn_map.getCurrentLocation("pit"));
}


}