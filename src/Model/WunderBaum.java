package Model;

/**
 * A WunderBaum tárgy működéséért felel. Kezeli a WunderBaum használatát és megszűnését.
 */
public class WunderBaum extends Item{
    private static int globalID = 0;
    public WunderBaum(){
        name = "WunderBaum_"+globalID;
        globalID++;
        durability = 1;
        activated =false;
        owner = null;
        location = null;
        fake = false;
        System.out.println("Function: WunderBaum class + Constructor func");
    }
    public String getDescription(){
        System.out.println("Function: WunderBaum class + getDescription func");
        if(owner ==null){
            return "Name: " +name+" Durability: "+durability+" isActive: "+activated+"Room: "+location.getID()+" isFake: "+fake;
        }
        else{
            return "Name: " +name+" Durability: "+durability+" isActive: "+activated+"Owner: "+owner.getName()+" isFake: "+fake;
        }
    }
    public boolean useIt(){
        System.out.println("Function: DirtyRag class + useIt func");
        activated = true;
        return owner.getRoom().addItem(this);
    }
    public boolean cleanTheRoom(Room r){
        System.out.println("Function: WunderBaum class + cleanTheRoom func");
        activated=true;
        this.decreaseDurability();
        r.Clean();
        return true;
    }
    public boolean useSelectedItem(Transistor anotherItem){
        System.out.println("Function: WunderBaum class + useSelectedItem func");
        return useIt();
    }
    //Érdemi működsét nem megvalósító függvények
    public void roundPassed(){
        System.out.println("Function: WunderBaum class + roundPassed func");
    }
    public void useAtPickUp(){
        System.out.println("Function: WunderBaum class + useAtPickUp func");
    }
    public boolean useAgainstGas(){
        System.out.println("Function: WunderBaum class + useAgainstGas func");
        return false;
    }
    public boolean finishGame(){
        System.out.println("Function: WunderBaum class + finishGame func");
        return false;
    }
    public boolean pairing(Transistor pair){
        System.out.println("Function: WunderBaum class + pairing func");
        return false;
    }
    public boolean daze(Character target){
        System.out.println("Function: WunderBaum class + daze func");
        return false;
    }
    public boolean removePair(){
        System.out.println("Function: WunderBaum class + removePair func");
        return false;
    }
    public boolean removeGas(){
        System.out.println("Function: WunderBaum class + removeGas func");
        return false;
    }
    public boolean useAgainstTeacher(){
        System.out.println("Function: WunderBaum class + useAgainstTeacher func");
        return false;
    }
}
