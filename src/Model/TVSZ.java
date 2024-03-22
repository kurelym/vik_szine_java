package Model;

public class TVSZ extends Item{
    public String getDescription(){
        System.out.println("Function: TVSZ class + getDescription func");
        return "Description";
    }
    public boolean useAgainstGas(){
        System.out.println("Function: TVSZ class + useAgainstGas func");
        return false;
    }
    public boolean useIt(){
        System.out.println("Function: TVSZ class + useIt func");
        return false;
    }
    public boolean useAgainstTeacher(){
        System.out.println("Function: TVSZ class + useAgainstTeacher func");
        return true;
    }
    public boolean finishGame(){
        System.out.println("Function: TVSZ class + finishGame func");
        return false;
    }
    public boolean pairing(Transistor pair){
        System.out.println("Function: TVSZ class + pairing func");
        return false;
    }
    public boolean daze(Character target){
        System.out.println("Function: TVSZ class + daze func");
        return false;
    }
    public boolean removePair(){
        System.out.println("Function: TVSZ class + removePair func");
        return false;
    }
}
