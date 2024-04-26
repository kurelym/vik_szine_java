package Model;
/**
 * A Szent söröspoharak tárgyak működéséért felel, 
 * és számon tartja hogy hány körig tart még a hatása, és kezeli a megszűnését.
 */
public class HolyBeer extends Item{
    private static int globalID = 0;
    public HolyBeer(){
        name = "HolyBeer_"+globalID;
        globalID++;
        durability = 3;
        activated =false;
        owner = null;
        location = null;
        fake = false;
        System.out.println("Function: HolyBeer class + Constructor func");
    }
    public String getDescription(){
        System.out.println("Function: HolyBeer class + getDescription func");
        if(owner ==null){
            return "Name: " +name+" Durability: "+durability+" isActive: "+activated+"Room: "+location.getID()+" isFake: "+fake;
        }
        else{
            return "Name: " +name+" Durability: "+durability+" isActive: "+activated+"Owner: "+owner.getName()+" isFake: "+fake;
        }
        
    }
    public void useAtPickUp(){
        System.out.println("Function: HolyBeer class + useAtPickUp func");
        activated=true;
        if(owner!=null){
            owner.dropItem();
        }
    }
    public boolean useAgainstTeacher(){
        System.out.println("Function: HolyBeer class + useAgainstTeacher func");
        return activated;
    }
    public void roundPassed(){
        System.out.println("Function: HolyBeer class + roundPassed func");
        if(durability>0){
            durability--;
            if(durability==0){
                activated=false;
            }
        }
    }
    //Érdemi működést nem valósít meg
    public boolean useSelectedItem(Transistor anotherItem){
        System.out.println("Function: HolyBeer class + useSelectedItem func");
        return false;
    }
    public boolean useIt(){
        System.out.println("Function: HolyBeer class + useIt func");
        return false;
    }
    public boolean useAgainstGas(){
        System.out.println("Function: HolyBeer class + useAgainstGas func");
        return false;
    }
    public boolean finishGame(){
        System.out.println("Function: HolyBeer class + finishGame func");
        return false;
    }
    public boolean pairing(Transistor pair){
        System.out.println("Function: HolyBeer class + pairing func");
        return false;
    }
    public boolean daze(Character target){
        System.out.println("Function: HolyBeer class + daze func");
        return false;
    }
    public boolean removePair(){
        System.out.println("Function: HolyBeer class + removePair func");
        return false;
    }
    public boolean removeGas(){
        System.out.println("Function: HolyBeer class + removeGas func");
        return false;
    }
    public boolean cleanTheRoom(Room r){
        System.out.println("Function: HolyBeer class + cleanTheRoom func");
        return false;
    }
}
