package main;
import map.map;
import wumpus.wumpus;
import pits.pit;
import control.control;


public class main
{

public static void main(String [] args)
{

    System.out.println("Wumpus game starting up\n");
    map main_map = new map();
    wumpus main_wump = new wumpus(main_map);
    System.out.println(main_wump.getCurrentLocation("wumpus"));
    main_wump.move("up", main_wump.getCurrentLocation("wumpus"), "wumpus");
    System.out.println(main_wump.getCurrentLocation("wumpus"));
}

}