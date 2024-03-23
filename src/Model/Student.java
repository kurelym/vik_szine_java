package Model;

/**
 * Az osztály egy hallgatót reprezentál a játékban.
 */
public class Student extends Character {

    /**
     * Konstruktor a Student osztályhoz.
     */
    public Student(){
        System.out.println("Function: Student osztály + Konstruktor Func");
    }

    /**
     * Metódus egy tárgy használatára (aktiválására) a hallgató által.
     * @param item A használni kívánt tárgy.
     */
    public void useItem(Using item){
        System.out.println("Function: Student osztály + useItem Func");
    }

    /**
     * Metódus a tanár támadás kezelésére a hallgatón.
     * @return true, ha a hallgató meg tudja védeni magát az oktatóval szemben, egyébként false.
     */
    public boolean teacherAttack(){
        System.out.println("Function: Student osztály + teacherAttack Func");
        return false;
    }

    /**
     * Metódus a nedves táblatörlő támadás kezelésére a hallgatón.
     * @return Mindig true, mivel a táblatörlő rongy a hallgatókra nincs hatással.
     */
    public boolean ragAttack(){
        System.out.println("Function: Student osztály + ragAttack Func");
        return true;
    }
}

