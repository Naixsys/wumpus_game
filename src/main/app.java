package main;

import map.map;
import dangers.*;
import player.*;


public class app {

    public static void main(String[] args) 
    {
        String instruction = "In this game you play as a hunter trying to kill a mythical creature known as the wumpus\nThe rules are if you:\n\t*Walk into the same room as the wumpus, you die\n\t*Walk into a pit, you die\n\t*Walk into a bat,you get carried away to a random place.\nShoot the wumpus with an arrow to win. If you run out of arrows (you get 3)....well, you also die\nYou get a view of the map every round, once you shoot or skip your turn, the wumpus moves.";
        map main_map = new map();
        main_map.setRandomPosition("bat");
        main_map.setRandomPosition("bat");
        main_map.setRandomPosition("pit");
        main_map.setRandomPosition("pit");

        wumpus wumpus = new wumpus(main_map);
        player main_player = new player(main_map);
        System.out.println("Do you want to print the rules? Y/N");
        if(main_player.read_and_return().equals("y") ==   true)
        {
            System.out.println(instruction);
        }
        while(true)
        {
            main_player.take_turn();
            wumpus.move();
            System.out.println(main_map.display());
        }

    }
}
