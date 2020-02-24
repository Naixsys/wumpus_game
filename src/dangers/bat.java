package dangers;

import map.map;
public class bat{

    private map pm;
    public bat(map spawn_map) {
            pm = spawn_map;
            pm.setRandomPosition("bat");
        }
}