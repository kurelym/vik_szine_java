
package Model;

public class SlideRule extends Item{
    public String getDescription(){
        System.out.println("Function: SlideRule class + getDescription func");
        return "Description";
    }
    public boolean useAgainstGas(){
        System.out.println("Function: SlideRule class + useAgainstGas func");
        return false;
    }
    public boolean useIt(){
        System.out.println("Function: SlideRule class + useIt func");
        return false;
    }
    public boolean useAgainstTeacher(){
        System.out.println("Function: SlideRule class + useAgainstTeacher func");
        return false;
    }
    public boolean finishGame(){
        System.out.println("Function: SlideRule class + finishGame func");
        return true;
    }
    public boolean pairing(Transistor pair){
        System.out.println("Function: SlideRule class + pairing func");
        return false;
    }
    public boolean daze(Character target){
        System.out.println("Function: SlideRule class + daze func");
        return false;
    }
    public boolean removePair(){
        System.out.println("Function: SlideRule class + removePair func");
        return false;
    }
}