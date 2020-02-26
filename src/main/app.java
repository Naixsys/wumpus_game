package main;

import map.map;
import dangers.*;
import player.player;

public class app {

    public static void main(String[] args) 
    {
        map main_map = new map();
        main_map.setRandomPosition("bat");
        main_map.setRandomPosition("bat");
        main_map.setRandomPosition("pit");
        main_map.setRandomPosition("pit");

        wumpus wumpus = new wumpus(main_map);
        player main_player = new player(main_map);

        while(true)
        {
            System.out.println(main_map.display());
            main_player.take_turn();
            wumpus.move();

        }

    }
}
