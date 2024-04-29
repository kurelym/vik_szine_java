package Model;
/**
 * A Tranzisztor tárgy működéséért felel. Kezeli a tranzisztorok összekapcsolását, 
 * illetve ennek a kapcsolatnak a bontását.
 */
public class Transistor extends Item{
    private static int globalID = 0;
    private Transistor pair;
    public Transistor(){
        name = "Transistor_"+globalID;
        globalID++;
        durability = 1;
        activated =false;
        owner = null;
        location = null;
        pair = null;
        fake = false;
        //System.out.println("Function: Transistor class + Constructor func");
    }
    public String getDescription(){
        //System.out.println("Function: Transistor class + getDescription func");
        if(owner ==null){
            return "Name: " +name+" Durability: "+durability+" isActive: "+activated+"Room: "+location.getID()+" isFake: "+fake;
        }
        else{
            return "Name: " +name+" Durability: "+durability+" isActive: "+activated+"Owner: "+owner.getName()+" isFake: "+fake;
        }
    }
    public boolean removePair(){
        //System.out.println("Function: Transistor class + removePair func");
        this.pair.removePair();
        this.pair = null;
        return true;
    }
    public boolean pairing(Transistor pair){
        //System.out.println("Function: Transistor class + pairing func");
        if(this.pair!=null){
            return false;
        }
        else{
            this.pair = pair;
            activated = true;
            pair.pairing(this);
            return true;
        }
    }
    public boolean useSelectedItem(Transistor anotherItem){
        //System.out.println("Function: SlideRule class + useSelectedItem func");
        return pairing(anotherItem);
    }

    public boolean useable() {
        return true;
    }

    //Érdemi működést nem valósítanak meg
    public void roundPassed(){
        //System.out.println("Function: Transistor class + roundPassed func");
    }
    public void useAtPickUp(){
        //System.out.println("Function: Transistor class + useAtPickUp func");
    }
    public boolean useAgainstGas(){
        //System.out.println("Function: Transistor class + useAgainstGas func");
        return false;
    }
    public boolean useIt(){
        //System.out.println("Function: Transistor class + useIt func");
        return false;
    }
    public boolean useAgainstTeacher(){
        //System.out.println("Function: Transistor class + useAgainstTeacher func");
        return false;
    }
    public boolean isRealSlideRule(){
        //System.out.println("Function: Transistor class + finishGame func");
        return false;
    }
    public boolean daze(Character target){
        //System.out.println("Function: Transistor class + daze func");
        return false;
    }
    public boolean removeGas(){
        //System.out.println("Function: Transistor class + removeGas func");
        return false;
    }
    public boolean cleanTheRoom(Room r){
        //System.out.println("Function: Transistor class + cleanTheRoom func");
        return false;
    }
}
