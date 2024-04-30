package Model;

import java.io.PrintStream;

/**
 * A Szent söröspoharak tárgyak működéséért felel, 
 * és számon tartja hogy hány körig tart még a hatása, és kezeli a megszűnését.
 */
public class HolyBeer extends Item{
    private static int globalID = 0;
    private PrintStream output;

    public HolyBeer(PrintStream _output) {
        output = _output;
        name = "HolyBeer_"+globalID;
        globalID++;
        durability = 5;
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
    public void useAtPickUp() {
        activated=true;
        owner.dropItem();
    }
    public boolean useAgainstTeacher(){
        if(activated){
            if(output!=null){
                output.println(this.name+" USED_AGAINST_TEACHER");
            }
        }
        return activated;
    }
    public void roundPassed(){
        if(durability>0){
            durability--;
            if(durability!=0) System.out.println(getName() + " még " + durability + " körig hat!");
            if(durability==0){
                activated=false;
                System.out.println(getName() + " nem hat tovább!");
            }
        }
        System.out.println(getName() + " még " + durability + " körig hat!");
    }

    public boolean useable() {
        return false;
    }

    //Érdemi működést nem valósít meg
    public boolean useSelectedItem(){
        return false;
    }
    public boolean useIt(){
        return false;
    }
    public boolean useAgainstGas(){
        return false;
    }
    public boolean isRealSlideRule(){
        return false;
    }
    public boolean pairing(Using pair){
        return false;
    }
    public boolean daze(Character target){
        return false;
    }
    public boolean removePair(){
        return false;
    }
    public boolean removeGas(){
        return false;
    }
    public boolean cleanTheRoom(Room r){
        return false;
    }
}
