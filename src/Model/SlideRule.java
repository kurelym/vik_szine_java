package Model;
/**
 * A Logarléc tárgy működéséért felel. Ebből a tárgyból egy darab eredeti van van a pályán,
 * és ha egy hallgató felveszi vége a játéknak és a hallgatók nyertek, de az oktatók 
 * is felvehetik, ezzel nehezítve a hallgatók dolgát.
 */
public class SlideRule extends Item{
    private static int globalID = 0;
    
    public SlideRule(){
        //System.out.println("Function: SlideRule class + Constructor func");
        name = "SlideRule_"+globalID;
        globalID++;
        durability = 1;
        activated =false;
        owner = null;
        location = null;
        fake = false;
    }
    public String getDescription(){
        //System.out.println("Function: SlideRule class + getDescription func");
        if(owner ==null){
            return "Name: " +name+" Durability: "+durability+" isActive: "+activated+"Room: "+location.getID()+" isFake: "+fake;
        }
        else{
            return "Name: " +name+" Durability: "+durability+" isActive: "+activated+"Owner: "+owner.getName()+" isFake: "+fake;
        }
    }
    public boolean isRealSlideRule(){
        //System.out.println("Function: SlideRule class + finishGame func");
        if(!fake){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean useable() {
        return false;
    }

    //Érdemi működést megvalósító függvénye
    public boolean useSelectedItem(Transistor anotherItem){
        //System.out.println("Function: SlideRule class + useSelectedItem func");
        return false;
    }
    public void roundPassed(){
        //System.out.println("Function: SlideRule class + roundPassed func");
        
    }
    public void useAtPickUp(){
        //System.out.println("Function: SlideRule class + useAtPickUp func");
    
    }
    public boolean useAgainstGas(){
        //System.out.println("Function: SlideRule class + useAgainstGas func");
        return false;
    }
    public boolean useIt(){
        //System.out.println("Function: SlideRule class + useIt func");
        return false;
    }
    public boolean useAgainstTeacher(){
        //System.out.println("Function: SlideRule class + useAgainstTeacher func");
        return false;
    }
    public boolean pairing(Transistor pair){
        //System.out.println("Function: SlideRule class + pairing func");
        return false;
    }
    public boolean daze(Character target){
        //System.out.println("Function: SlideRule class + daze func");
        return false;
    }
    public boolean removePair(){
        //System.out.println("Function: SlideRule class + removePair func");
        return false;
    }
    public boolean removeGas(){
        //System.out.println("Function: SlideRule class + removeGas func");
        return false;
    }
    public boolean cleanTheRoom(Room r){
        //System.out.println("Function: SlideRule class + cleanTheRoom func");
        return false;
    }
}