package Model;

import java.util.List;

public abstract class Character {

    protected Character(){
        System.out.println("Function: Character class + Constructor func");
    }
    public boolean pickUpItem(Using i){
        System.out.println("Function: Character class + pickUpItem func");
        return true;
    }
    public void dropItem(Using i){
        System.out.println("Function: Characte class + dropItem func");
    }
    public  String getName(){
        System.out.println("Function: Character class + getName func");
        return "";
    }
    public Room getLocation(){
        System.out.println("Function: Character class + getLocation func");
        return null;
    }
    public void dropAllItem(){
        System.out.println("Function: Character class + dropAllItem func");
    }
    public boolean gasAttack(){
        System.out.println("Function: Character class + gasAttack func");
        return true;
    }
    public boolean hasTheSlideRule(){
        System.out.println("Function: Character class + hasTheSlideRule func");
        return true;
    }
    public boolean isAlive(){
        System.out.println("Function: Character class + isAlive func");
        return true;
    }
    abstract boolean teacherAttack();

    abstract boolean ragAttack();
}