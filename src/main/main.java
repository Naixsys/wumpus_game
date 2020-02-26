package main;

import map.map;
import dangers.*;
import player.player;

public class main {

    public static void main(String[] args) 
    {
        map main_map = new map();
        main_map.setRandomPosition("bat");
        main_map.setRandomPosition("bat");
        main_map.setRandomPosition("pit");
        main_map.setRandomPosition("pit");
/*
        pit pit1 = new pit(main_map);
        pit pit2 = new pit(main_map);
        bat bat1 = new bat(main_map);
        bat bat2 = new bat(main_map);
*/

        wumpus wumpus = new wumpus(main_map);
        player main_player = new player(main_map);

        while(true)
        {
            main_player.take_turn();
            wumpus.move();

        }

    }
}
