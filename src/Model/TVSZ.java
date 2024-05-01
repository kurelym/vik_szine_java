package Model;

import java.io.PrintStream;

/**
 * A TVSZ denevérbőrre nyomtatott példányai tárgyak működéséért felel, 
 * és számon tartja hogy eddig hányszor volt használva, és kezeli a megszűnését.
 */
public class TVSZ extends Item{
    private static int globalID = 1;
    private PrintStream output;
    public TVSZ(PrintStream _output){
        output = _output;
        name = "TVSZ_"+globalID;
        globalID++;
        durability = 3;
        activated =false;
        owner = null;
        location = null;
        fake = false;
        //System.out.println("Function: TVSZ class + Constructor func");
    }
    public String getDescription(){
        //System.out.println("Function: TVSZ class + getDescription func");
        if(owner ==null){
            return "Name: " +name+" Durability: "+durability+" isActive: "+activated+"Room: "+location.getID()+" isFake: "+fake;
        }
        else{
            return "Name: " +name+" Durability: "+durability+" isActive: "+activated+"Owner: "+owner.getName()+" isFake: "+fake;
        }
    }
    public boolean useAgainstTeacher(){
        //System.out.println("Function: TVSZ class + useAgainstTeacher func");
        if(durability>0&& fake==false){
            this.decreaseDurability();
            if(output!=null){
                output.println(this.name+" USED_AGAINST_TEACHER");
            }
            return true;
        }
        else{
            return false;
        }
    }

    public boolean useable() {
        return false;
    }

    //Érdemi működsét nem megvalósító függvények
    public boolean useSelectedItem(){
        //System.out.println("Function: TVSZ class + useSelectedItem func");
        return false;
    }
    public void roundPassed(){
        //System.out.println("Function: TVSZ class + roundPassed func");
    }
    public void useAtPickUp(){
        //System.out.println("Function: TVSZ class + useAtPickUp func");
    }
    public boolean useAgainstGas(){
        //System.out.println("Function: TVSZ class + useAgainstGas func");
        return false;
    }
    public boolean useIt(){
        //System.out.println("Function: TVSZ class + useIt func");
        return false;
    }
    public boolean isRealSlideRule(){
        //System.out.println("Function: TVSZ class + finishGame func");
        return false;
    }
    public boolean pairing(Transistor pair){
        //System.out.println("Function: TVSZ class + pairing func");
        return false;
    }
    public boolean daze(Character target){
        //System.out.println("Function: TVSZ class + daze func");
        return false;
    }
    public boolean removePair(){
        //System.out.println("Function: TVSZ class + removePair func");
        return false;
    }
    public boolean removeGas(){
        //System.out.println("Function: TVSZ class + removeGas func");
        return false;
    }
    public boolean cleanTheRoom(Room r){
        //System.out.println("Function: TVSZ class + cleanTheRoom func");
        return false;
    }
}
