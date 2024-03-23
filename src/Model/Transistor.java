package Model;
/*
 * A Tranzisztor tárgy működéséért felel. Kezeli a tranzisztorok összekapcsolását, 
 * illetve ennek a kapcsolatnak a bontását.
 */
public class Transistor extends Item{
    public Transistor(){
        System.out.println("Function: Transistor class + Constructor func");
    }
    public String getDescription(){
        System.out.println("Function: Transistor class + getDescription func");
        return "Description";
    }
    public boolean useAgainstGas(){
        System.out.println("Function: Transistor class + useAgainstGas func");
        return false;
    }
    public boolean useIt(){
        System.out.println("Function: Transistor class + useIt func");
        return false;
    }
    public boolean useAgainstTeacher(){
        System.out.println("Function: Transistor class + useAgainstTeacher func");
        return false;
    }
    public boolean finishGame(){
        System.out.println("Function: Transistor class + finishGame func");
        return false;
    }
    public boolean pairing(Transistor pair){
        System.out.println("Function: Transistor class + pairing func");
        return true;
    }
    public boolean daze(Character target){
        System.out.println("Function: Transistor class + daze func");
        return false;
    }
    public boolean removePair(){
        System.out.println("Function: Transistor class + removePair func");
        return true;
    }
}
