package Model;

abstract class Item implements Using {
    public String getName(){
        System.out.println("Function: Item class + getName func");
        return "Item";
    }
    public int getDurability(){
        System.out.println("Function: Item class + getDurability func");
        return 0;
    }
    public boolean isActive(){
        System.out.println("Function: Item class + isActive func");
        return true;
    }
    public void setLocation(Room newLocation){
        System.out.println("Function: Item class + setLocation func");
    }
    public final Room getLocation(){
        System.out.println("Function: Item class + getLocation func");
        return new Room();
    }
    public final void setOwner(Character newOwner){
        System.out.println("Function: Item class + setOwner func");
    }
    public final Character getOwner()
    {
        System.out.println("Function: Item class + getOwner func");
        return new Character();
    }
    public final void roundPassed(){
        System.out.println("Function: Item class + roundPassed func");
    }
}