package Model;

public class Teacher {
   
public
    Teacher(){
        System.out.println("Function: Teacher + tryToKill");
    }
     void tryToKill(){
        System.out.println("Function: Teacher + tryToKill");
     }
     bool teacherAttack(){
        System.out.println("Function: Teacher + teacherAttack");
        return false;
     }
     bool ragAttack(){
        System.out.println("Function: Teacher + ragAttack");
        return true;
     }


}