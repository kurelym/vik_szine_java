package Model;

import java.io.PrintStream;

/**
 * A Dobozolt káposztás camembert tárgy működéséért felel. Kezeli a sajt használatát és megszűnését.
 */
public class CamembertCheese extends Item{
    private static int globalID = 1;
    private PrintStream output;
    public CamembertCheese(PrintStream _output){
        output = _output;
        name = "CamambertCheese_"+globalID;
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
    public boolean daze(Character target){
        if(output!=null){
            output.println("GAS_ATTACK");
        }
        return target.gasAttack();
    }
    public boolean useIt(){
        //System.out.println("Function: CamembertCheese class + useIt func");
        if(!isFake()) {
            activated = true;
            if(output!=null){
                output.println(this.name+" USED_BY "+owner.name);
            }
            owner.inventory.remove(this);
            return owner.getRoom().addItem(this);    
        } else {
            System.out.println("Ez egy hamis tárgy, nem tudod használni");
            return false;
        }
    }
    public boolean removeGas(){
        //System.out.println("Function: CamembertCheese class + removeGas func");
        activated=false;
        if(output!=null){
            output.println(this.name+" REMOVED_FROM "+location.name);
        }
        this.decreaseDurability();
        return true;
    }
    public boolean useSelectedItem(){
        //System.out.println("Function: CamembertCheese class + useSelectedItem func");
        return useIt();
    }

    public boolean useable() {
        return true;
    }

    //Érdemi műküdést nem megvalósító függvények
    public void roundPassed(){
        //System.out.println("Function: CamembertCheese class + roundPassed func");
    }
    public void useAtPickUp(){
        //System.out.println("Function: CamembertCheese class + useAtPickUp func");
    }
    public boolean cleanTheRoom(Room r){
        //System.out.println("Function: CamembertCheese class + cleanTheRoom func");
        return false;
    }
    public boolean useAgainstTeacher(){
        //System.out.println("Function: CamembertCheese class + useAgainstTeacher func");
        return false;
    }
    public boolean isRealSlideRule(){
        //System.out.println("Function: CamembertCheese class + finishGame func");
        return false;
    }
    public boolean pairing(Transistor pair){
        //System.out.println("Function: CamembertCheese class + pairing func");
        return false;
    }
    public boolean removePair(){
        //System.out.println("Function: CamambertCheese class + removePair func");
        return false;
    }
    public boolean useAgainstGas(){
        //System.out.println("Function: CamembertCheese class + useAgainstGas func");
        return false;
    }
}
