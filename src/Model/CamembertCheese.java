package Model;
/**
 * A Dobozolt káposztás camembert tárgy működéséért felel. Kezeli a sajt használatát és megszűnését.
 */
public class CamembertCheese extends Item{
    public CamembertCheese(){
        System.out.println("Function: CamembertCheese class + Constructor func");
    }
    public String getDescription(){
        System.out.println("Function: CamembertCheese class + getDescription func");
        return "Description";
    }
    public boolean useAgainstGas(){
        System.out.println("Function: CamembertCheese class + useAgainstGas func");
        return true;
    }
    public boolean useIt(){
        System.out.println("Function: CamembertCheese class + useIt func");
        return false;
    }
    public boolean useAgainstTeacher(){
        System.out.println("Function: CamembertCheese class + useAgainstTeacher func");
        return false;
    }
    public boolean finishGame(){
        System.out.println("Function: CamembertCheese class + finishGame func");
        return false;
    }
    public boolean pairing(Transistor pair){
        System.out.println("Function: CamembertCheese class + pairing func");
        return false;
    }
    public boolean daze(Character target){
        System.out.println("Function: CamembertCheese class + daze func");
        return false;
    }
    public boolean removePair(){
        System.out.println("Function: CamambertCheese class + removePair func");
        return false;
    }
}
