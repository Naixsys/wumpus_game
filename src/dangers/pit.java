package dangers;

import map.map;

public class pit {
    private map pm;
    public pit(map spawn_map) {
        pm = spawn_map;
        pm.setRandomPosition("pit");
    }

}