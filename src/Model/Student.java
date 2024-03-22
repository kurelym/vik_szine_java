package Model;

public class Student {

public
    Student(){
        System.out.println("Konstructor: Student");
    }
    void useItem(Item i){
        System.out.println("Function: Student + useItem");
    }
    bool teacherAttack(){
        System.out.println("Function: Student + teacherAttack");
        return false;
    }
    bool ragAttack(){
        System.out.println("Function: Student + ragAttack");
        return true;
    }
}
