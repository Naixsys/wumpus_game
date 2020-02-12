package main;
import map.map;
import Wumpus.Wumpus;
import pit.pit;
import control.control;


public class main
{

public static void main(String [] args)
{

    System.out.println("Wumpus game starting up\n");
    map main_map = new map();
    Wumpus main_wump = new Wumpus(main_map);
    main_wump.move("up", main_wump.getCurrentLocation(), "wumpus");
}

}