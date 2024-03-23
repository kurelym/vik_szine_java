package Model;
/**
 * A Szent söröspoharak tárgyak működéséért felel, 
 * és számon tartja hogy hány körig tart még a hatása, és kezeli a megszűnését.
 */
public class HolyBeer extends Item{
    public HolyBeer(){
        System.out.println("Function: HolyBeer class + Constructor func");
    }
    public String getDescription(){
        System.out.println("Function: HolyBeer class + getDescription func");
        return "Description";
    }
    public boolean useAgainstGas(){
        System.out.println("Function: HolyBeer class + useAgainstGas func");
        return false;
    }
    public boolean useIt(){
        System.out.println("Function: HolyBeer class + useIt func");
        return true;
    }
    public boolean useAgainstTeacher(){
        System.out.println("Function: HolyBeer class + useAgainstTeacher func");
        return true;
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
}
