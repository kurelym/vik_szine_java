package Model;

public class Teacher {
   
   public Teacher(){
        System.out.println("Function: Teacher class + Constructor func");
    }
     public void tryToKill(){
        System.out.println("Function: Teacher class + tryToKill func");
     }
     public boolean teacherAttack(){
        System.out.println("Function: Teacher class + teacherAttack func");
        return false;
     }
     public boolean ragAttack(){
        System.out.println("Function: Teacher class + ragAttack func");
        return true;
     }

}