package wumpus;

public class wumpus {

    private boolean life = true;
    
    public wumpus(){

    }
    
    public boolean kill_wumpus () {

        life = false;

        return life;
    }

}