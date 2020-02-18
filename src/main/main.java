package main;

import map.map;
import wumpus.wumpus;
import pits.pit;
import player.player;

public class main {

    public static void main(String[] args) {
        /* When doing any movement based actions/updating the map in any way
        Do not invoke methods through the object you want to update. Use the 
        map object. Otherwise local copies of the map passed to the moveable objects
        will be updated instead of the map itself, which will cause all kinds of hell. */
        while(true){
        System.out.println("Wumpus game starting up\n");
        map main_map = new map();
        player main_player = new player(main_map);
        main_player.move( main_map.getCurrentLocation("player"));
        System.out.println("The player is now at " + main_map.getCurrentLocation("player"));
        System.out.println("VIOLA!!!");
        
        
    }

    }
}
