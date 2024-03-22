package Model;
/*
 * A Dobozolt káposztás camembert tárgy működéséért felel. Kezeli a sajt használatát és megszűnését.
 */
public class CamambertCheese extends Item{
    public CamambertCheese(){
        System.out.println("Function: CamambertCheese class + Constructor func");
    }
    public String getDescription(){
        System.out.println("Function: CamambertCheese class + getDescription func");
        return "Description";
    }
    public boolean useAgainstGas(){
        System.out.println("Function: CamambertCheese class + useAgainstGas func");
        return true;
    }
    public boolean useIt(){
        System.out.println("Function: CamambertCheese class + useIt func");
        return false;
    }
    public boolean useAgainstTeacher(){
        System.out.println("Function: CamambertCheese class + useAgainstTeacher func");
        return false;
    }
    public boolean finishGame(){
        System.out.println("Function: CamambertCheese class + finishGame func");
        return false;
    }
    public boolean pairing(Transistor pair){
        System.out.println("Function: CamambertCheese class + pairing func");
        return false;
    }
    public boolean daze(Character target){
        System.out.println("Function: CamambertCheese class + daze func");
        return false;
    }
    public boolean removePair(){
        System.out.println("Function: CamambertCheese class + removePair func");
        return false;
    }
}
