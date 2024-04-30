package Model;

import java.io.PrintStream;

/**
 * A Logarléc tárgy működéséért felel. Ebből a tárgyból egy darab eredeti van van a pályán,
 * és ha egy hallgató felveszi vége a játéknak és a hallgatók nyertek, de az oktatók 
 * is felvehetik, ezzel nehezítve a hallgatók dolgát.
 */
public class SlideRule extends Item{
    private static int globalID = 1;
    private PrintStream output;
    
    public SlideRule(PrintStream _output){
        //System.out.println("Function: SlideRule class + Constructor func");
        output = _output;
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
            if(output!=null){
                output.println("GAME_WON");
            }
            return true;
        }
        else{
            if(output!=null){
                output.println("GAME_NOT_WON");
            }
            return false;
        }
    }

    public boolean useable() {
        return false;
    }

    public void useAtPickUp(){
        isRealSlideRule();
    }

    //Érdemi működést megvalósító függvénye
    public boolean useSelectedItem(){
        //System.out.println("Function: SlideRule class + useSelectedItem func");
        return false;
    }
    public void roundPassed(){
        //System.out.println("Function: SlideRule class + roundPassed func");
        
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