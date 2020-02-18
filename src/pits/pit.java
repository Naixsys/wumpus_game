package pits;

import map.map;

public class pit {

    private static int pit_id = 0;
    pit(map spawn_map) {
        spawn_map.setRandomPosition("pit" + pit_id);
        pit_id++;
        System.out.print("Pit spawned at " + spawn_map.getCurrentLocation("pit"));
    }

}