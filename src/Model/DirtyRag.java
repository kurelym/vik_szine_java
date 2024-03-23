
package Model;
/**
 * A Nedves táblatörlő rongy tárgy működéséért felel. Kezeli a rongy használatát, a 
 * különböző típusú használati esetekben.
 */
public class DirtyRag extends Item{
    public DirtyRag(){
        System.out.println("Function: DirtyRag class + Constructor func");
    }
    public String getDescription(){
        System.out.println("Function: DirtyRag class + getDescription func");
        return "Description";
    }
    public boolean useAgainstGas(){
        System.out.println("Function: DirtyRag class + useAgainstGas func");
        return false;
    }
    public boolean useIt(){
        System.out.println("Function: DirtyRag class + useIt func");
        return true;
    }
    public boolean useAgainstTeacher(){
        System.out.println("Function: DirtyRag class + useAgainstTeacher func");
        return false;
    }
    public boolean finishGame(){
        System.out.println("Function: DirtyRag class + finishGame func");
        return false;
    }
    public boolean pairing(Transistor pair){
        System.out.println("Function: DirtyRag class + pairing func");
        return false;
    }
    public boolean daze(Character target){
        System.out.println("Function: DirtyRag class + daze func");
        return true;
    }
    public boolean removePair(){
        System.out.println("Function: DirtyRag class + removePair func");
        return false;
    }
}