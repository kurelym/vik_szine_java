package Model;

public class FFP2 extends Item {
    public String getDescription(){
        System.out.println("Function: FFP2 class + getDescription func");
        return "Description";
    }
    public boolean useAgainstGas(){
        System.out.println("Function: FFP2 class + useAgainstGas func");
        return true;
    }
    public boolean useIt(){
        System.out.println("Function: FFP2 class + useIt func");
        return false;
    }
    public boolean useAgainstTeacher(){
        System.out.println("Function: FFP2 class + useAgainstTeacher func");
        return false;
    }
    public boolean finishGame(){
        System.out.println("Function: FFP2 class + finishGame func");
        return false;
    }
    public boolean pairing(Transistor pair){
        System.out.println("Function: FFP2 class + pairing func");
        return false;
    }
    public boolean daze(Character target){
        System.out.println("Function: FFP2 class + daze func");
        return false;
    }
    public boolean removePair(){
        System.out.println("Function: FFP2 class + removePair func");
        return false;
    }
}
