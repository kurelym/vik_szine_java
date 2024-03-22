package Model;

public interface Using {
    public String getDescription();
    public String getName();
    public int getDurability();
    public boolean isActive();
    public void setLocation(Room newLocation);
    public Room getLocation();
    public void setOwner(Character newOwner);
    public Character getOwner();
    public void roundPassed();
    public boolean useIt();
    public boolean useAgainstGas();
    public boolean useAgainstTeacher();
    public boolean finishGame();
    public boolean pairing(Transistor pair);
    public boolean daze(Character target);
    public boolean removePair();
} 
