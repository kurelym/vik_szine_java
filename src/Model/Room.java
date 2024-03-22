package Model;

public class Room {
    
    public Room(){
        System.out.println("Function: Room constructor");
    }

    public void Split(){
        System.out.println("Function: Room Split");
    }

    public void Merge(Room r){
        System.out.println("Function: Room Merge");
    }

    public void addNeighbour(Room anotherone){
        System.out.println("Function: Room addNeighbour");
    }

    public void removeNeighbour(Room delete){
        System.out.println("Function: Room removeNeighbour");
    }

    public Boolean addCharacter(Character anotherone){
        System.out.println("Function: Room addCharacter");
        return true;
    }

    public void removeCharacter(Character left){
        System.out.println("Function: Room removeCharacter");
    }

    public Boolean addItem(Using u){
        System.out.println("Function: Room addItem");
        return true;
    }

    public void removeItem(Using u){
        System.out.println("Function: Room removeItem");
    }

    public int getID(){
        System.out.println("Function: Room getID");
        return 1;
    }

    public int getCapacity(){
        System.out.println("Function: Room getCapacity");
        return 1;
    }

}