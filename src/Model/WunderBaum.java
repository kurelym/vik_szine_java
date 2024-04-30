package Model;

import java.io.PrintStream;

/**
 * A WunderBaum tárgy működéséért felel. Kezeli a WunderBaum használatát és megszűnését.
 */
public class WunderBaum extends Item{
    private static int globalID = 1;
    private PrintStream output;
    public WunderBaum(PrintStream _output){
        output = _output;
        name = "WunderBaum_"+globalID;
        globalID++;
        durability = 1;
        activated =false;
        owner = null;
        location = null;
        fake = false;
        //System.out.println("Function: WunderBaum class + Constructor func");
    }
    public String getDescription(){
        //System.out.println("Function: WunderBaum class + getDescription func");
        if(owner ==null){
            return "Name: " +name+" Durability: "+durability+" isActive: "+activated+"Room: "+location.getID()+" isFake: "+fake;
        }
        else{
            return "Name: " +name+" Durability: "+durability+" isActive: "+activated+"Owner: "+owner.getName()+" isFake: "+fake;
        }
    }
    public boolean useIt(){
        //System.out.println("Function: DirtyRag class + useIt func");
        activated = true;
        if(output!=null){
            output.println(this.name+" USED_BY "+owner.name);
        }
        return true;
    }
    public boolean cleanTheRoom(Room r){
        //System.out.println("Function: WunderBaum class + cleanTheRoom func");
        activated=true;
        this.decreaseDurability();
        r.Clean();
        activated=false;
        return true;
    }
    public boolean useSelectedItem(){
        //System.out.println("Function: WunderBaum class + useSelectedItem func");
        boolean success = useIt();
        cleanTheRoom(owner.location);
        return success;
    }

    public boolean useable() {
        return true;
    }

    //Érdemi működsét nem megvalósító függvények
    public void roundPassed(){
        //System.out.println("Function: WunderBaum class + roundPassed func");
    }
    public void useAtPickUp(){
        //System.out.println("Function: WunderBaum class + useAtPickUp func");
    }
    public boolean useAgainstGas(){
        //System.out.println("Function: WunderBaum class + useAgainstGas func");
        return false;
    }
    public boolean isRealSlideRule(){
        //System.out.println("Function: WunderBaum class + finishGame func");
        return false;
    }
    public boolean pairing(Transistor pair){
        //System.out.println("Function: WunderBaum class + pairing func");
        return false;
    }
    public boolean daze(Character target){
        //System.out.println("Function: WunderBaum class + daze func");
        return false;
    }
    public boolean removePair(){
        //System.out.println("Function: WunderBaum class + removePair func");
        return false;
    }
    public boolean removeGas(){
        //System.out.println("Function: WunderBaum class + removeGas func");
        return false;
    }
    public boolean useAgainstTeacher(){
        //System.out.println("Function: WunderBaum class + useAgainstTeacher func");
        return false;
    }
}
