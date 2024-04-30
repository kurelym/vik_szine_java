
package Model;

import java.io.PrintStream;

/**
 * A Nedves táblatörlő rongy tárgy működéséért felel. Kezeli a rongy használatát
 */
public class DirtyRag extends Item{
    private static int globalID = 1;
    private PrintStream output;
    public DirtyRag(PrintStream _output){
        output = _output;
        name = "DirtyRag_"+globalID;
        globalID++;
        durability = 5;
        activated =false;
        owner = null;
        location = null;
        fake = false;
        //System.out.println("Function: DirtyRag class + Constructor func");
    }
    public String getDescription(){
        //System.out.println("Function: DirtyRag class + getDescription func");
        if(owner ==null){
            return "Name: " +name+" Durability: "+durability+" isActive: "+activated+"Room: "+location.getID()+" isFake: "+fake;
        }
        else{
            return "Name: " +name+" Durability: "+durability+" isActive: "+activated+"Owner: "+owner.getName()+" isFake: "+fake;
        }
    }
    public boolean daze(Character target){
        //System.out.println("Function: DirtyRag class + daze func");
        if(activated){
            return target.ragAttack();
        }
        else{
            return false;
        }
    }
    public boolean useIt(){
        //System.out.println("Function: DirtyRag class + useIt func");
        activated = true;
        owner.inventory.remove(this);
        if(output!=null){
            output.println(this.name+" USED_BY "+owner.name);
        }
        return owner.getRoom().addItem(this);
    }
    public void roundPassed(){
        //System.out.println("Function: DirtyRag class + roundPassed func");
        if(durability>0){
        durability--;
            if(output!=null){
                output.println(this.name+" DURABILITY_DECRASED_TO "+this.durability);
            }
            if(durability==0){
                activated=false;
            }
        }
    }
    public boolean useSelectedItem(){
        //System.out.println("Function: DirtyRag class + useSelectedItem func");
        return useIt();
    }

    public boolean useable() {
        return true;
    }

    //Érdemi működést nem valósít meg
    public void useAtPickUp(){
        //System.out.println("Function: DirtyRag class + useAtPickUp func");
    }
    public boolean useAgainstTeacher(){
        //System.out.println("Function: DirtyRag class + useAgainstTeacher func");
        return false;
    }
    public boolean isRealSlideRule(){
        //System.out.println("Function: DirtyRag class + finishGame func");
        return false;
    }
    public boolean pairing(Transistor pair){
        //System.out.println("Function: DirtyRag class + pairing func");
        return false;
    }
    public boolean removePair(){
        //System.out.println("Function: DirtyRag class + removePair func");
        return false;
    }
    public boolean useAgainstGas(){
        //System.out.println("Function: DirtyRag class + useAgainstGas func");
        return false;
    }
    public boolean removeGas(){
        //System.out.println("Function: DirtyRag class + removeGas func");
        return false;
    }
    public boolean cleanTheRoom(Room r){
        //System.out.println("Function: DirtyRag class + cleanTheRoom func");
        return false;
    }
}