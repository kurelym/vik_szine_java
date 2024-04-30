package Model;

import java.io.PrintStream;

/**
 * Az FFP2-maszk tárgyak működéséért felel, kezeli a maszk használatát, és megszűnését.
 */
public class FFP2 extends Item {
    private static int globalID = 1;
    private PrintStream output;

    public FFP2(PrintStream _output) {
        output = _output;
        name = "FFP2_"+globalID;
        globalID++;
        durability = 1;
        activated =false;
        owner = null;
        location = null;
        fake = false;

    }
    public String getDescription(){
        if(owner ==null){
            return "Name: " +name+" Durability: "+durability+" isActive: "+activated+"Room: "+location.getID()+" isFake: "+fake;
        }
        else{
            return "Name: " +name+" Durability: "+durability+" isActive: "+activated+"Owner: "+owner.getName()+" isFake: "+fake;
        }
    }
    public boolean useAgainstGas(){
        if(fake){
            return false;
        }
        else{
            if(output != null) {
                output.println(this.name + " USED_AGAINST_GAS");
            }
            this.decreaseDurability();
            return true;
        }
    }

    public boolean useable() {
        return false;
    }

    //Érdemi működsét nem valósítanak meg
    public boolean useSelectedItem(){
        //System.out.println("Function: FFP2 class + useSelectedItem func");
        return false;
    }
    public void roundPassed(){
        //System.out.println("Function: FFP2 class + roundPassed func");
    }
    public void useAtPickUp(){
        //System.out.println("Function: FFP2 class + useAtPickUp func");
    }
    public boolean useIt(){
        //System.out.println("Function: FFP2 class + useIt func");
        return false;
    }
    public boolean useAgainstTeacher(){
        //System.out.println("Function: FFP2 class + useAgainstTeacher func");
        return false;
    }
    public boolean isRealSlideRule(){
        //System.out.println("Function: FFP2 class + finishGame func");
        return false;
    }
    public boolean pairing(Using pair){
        //System.out.println("Function: FFP2 class + pairing func");
        return false;
    }
    public boolean daze(Character target){
        //System.out.println("Function: FFP2 class + daze func");
        return false;
    }
    public boolean removePair(){
        //System.out.println("Function: FFP2 class + removePair func");
        return false;
    }
    public boolean removeGas(){
        //System.out.println("Function: FFP2 class + removeGas func");
        return false;
    }
    public boolean cleanTheRoom(Room r){
        //System.out.println("Function: FFP2 class + cleanTheRoom func");
        return false;
    }
}
