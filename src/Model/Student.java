package Model;

public class Student {

    public Student(){
        System.out.println("Function: Student class + Constructor func");
    }
    public void useItem(Item i){
        System.out.println("Function: Student class + useItem func");
    }
    public boolean teacherAttack(){
        System.out.println("Function: Student class + teacherAttack func");
        return false;
    }
    public boolean ragAttack(){
        System.out.println("Function: Student class + ragAttack func");
        return true;
    }
}
