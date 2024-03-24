package Model;

/**
 * Az osztály egy oktatót reprezentál a játékban.
 */
public class Teacher extends Character {

    /**
     * Konstruktor a Teacher osztályhoz.
     */
    public Teacher(){
        System.out.println("Function: Teacher osztály + Konstruktor Func");
    }

    /**
     * Metódus amely levezérli az oktató támadási próbálkozását abban a szobában ahol tartózkodik
     */
    public void tryToKill(Room r){
        System.out.println("Function: Teacher osztály + tryToKill Func");
    }

    /**
     * Metódus a tanár támadás kezelésére a karakteren.
     * @return Mindig false, mivel az oktatók támadása nincs hatással egy másik oktatóra
     */
    public boolean teacherAttack(){
        System.out.println("Function: Teacher osztály + teacherAttack Func");
        return false;
    }

    /**
     * Metódus a nedves táblatörlő támadás kezelésére a karakteren.
     * @return Mindig true, mivel a nedves táblatörlő mindig hatásos az oktatók ellen.
     */
    public boolean ragAttack(){
        System.out.println("Function: Teacher osztály + ragAttack Func");
        return true;
    }
}