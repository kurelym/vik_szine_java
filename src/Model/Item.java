package Model;
/**
 * Absztrakt ősosztálya a tárgyaknak.
 */
abstract class Item implements Using,Description {
    protected String name;
    protected int durability;
    protected boolean activated;
    protected Room location;
    protected Character owner;
    protected boolean fake;

    public String getName(){
        //System.out.println("Function: Item class + getName func");
        return name;
    }
    public void setType(boolean _fake){
        fake = _fake;
    }
    public int getDurability(){
        //System.out.println("Function: Item class + getDurability func");
        return durability;
    }
    public boolean isActive(){
        //System.out.println("Function: Item class + isActive func");
        return activated;
    }
    public void setLocation(Room newLocation){
        //System.out.println("Function: Item class + setLocation func");
        location = newLocation;
    }
    public final Room getLocation(){
        //System.out.println("Function: Item class + getLocation func");
        return location;
    }
    public final void setOwner(Character newOwner){
        //System.out.println("Function: Item class + setOwner func");
        owner = newOwner;
    }
    public final Character getOwner()
    {
        //System.out.println("Function: Item class + getOwner func");
        return owner;
    }
    public final void decreaseDurability(){
        //System.out.println("Function: Item class + roundPassed func");
        durability--;
    }
    public final boolean isFake(){
        //System.out.println("Function: Item class + isFake func");
        return fake;
    }
}