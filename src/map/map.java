package map;

import java.util.Random;


public class map {
    protected Random rander = new Random();
    public volatile String[][] map_grid;

    public map() {
        map_grid = new String[5][5];
    }

    public void setRandomPosition(String entity) {
        while (true) {
            
            int xpos = rander.nextInt(map_grid[0].length);
            int ypos = rander.nextInt(map_grid.length);
            if (xpos < 0) {
                xpos = 0;
            }

            if (ypos < 0) {
                ypos = 0;
            }

            if (map_grid[ypos][xpos] == null) {
                map_grid[ypos][xpos] = entity;
                break;
            }

            else {
                continue;
            }
        }
    }

    public String getCurrentLocation(String regex) {
        String loc = "Error, can't find the location of " + regex + " on the map.";
        for (int x = 0; x < map_grid.length; x++) {
            for (int y = 0; y < map_grid[0].length; y++) {
                if (map_grid[x][y] == regex) {
                    loc = (x + "," + y).toString();
                    return loc;
                }

            }
        }
        // System.out.println(loc);
        return loc;
    }

    public void setCurrentLocation(String transport, int x_pos, int y_pos, String current_location) {
        int set_x_pos = Integer.parseInt(String.valueOf(current_location.charAt(0)));
        int set_y_pos = Integer.parseInt(String.valueOf(current_location.charAt(2)));
        map_grid[set_x_pos][set_y_pos] = null;
        set_x_pos += x_pos;
        set_y_pos += y_pos;
        map_grid[set_x_pos][set_y_pos] = transport;
    }

    public void move(String direction, String current_location, String moved_obj) {

        if (direction.equals("n") == true) {
            if (String.valueOf(current_location.charAt(0)).equals("4") == false) {
                setCurrentLocation(moved_obj, 1, 0, current_location);
            }

            else {
                System.out.println(moved_obj + " already at the top of the map");
            }
        }
        if (direction.equals("s") == true) {
            if (String.valueOf(current_location.charAt(0)).equals("0") == false) {
                
                setCurrentLocation(moved_obj, -1, 0, current_location);
            }

            else {
                System.out.println(moved_obj + " already at the bottom of the map");
            }
        }
        if (direction.equals("w") == true) {
            if (String.valueOf(current_location.charAt(2)).equals("0") == false) {
                setCurrentLocation(moved_obj, 0, -1, current_location);

            }

            else {
                System.out.println(moved_obj + " already at the far west of the map");
            }
        }
        if (direction.equals("e") == true) {
            if (String.valueOf(current_location.charAt(2)).equals("4") == false) {
                setCurrentLocation(moved_obj, 0, 1, current_location);
            }

            else {
                System.out.println(moved_obj + " already at the far east of the map");

            }
        }
    }

}
