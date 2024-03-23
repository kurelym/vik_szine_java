package Model;

/**
 * Az osztály egy oktatót reprezentál a játékban.
 */
public class Teacher extends Character {

    /**
     * Konstruktor a Teacher osztályhoz.
     */
    public Teacher(){
        System.out.println("Függvény: Teacher osztály + Konstruktor függvény");
    }

    /**
     * Metódus amely levezérli az oktató támadási próbálkozását abban a szobában ahol tartózkodik
     */
    public void tryToKill(){
        System.out.println("Függvény: Teacher osztály + tryToKill függvény");
    }

    /**
     * Metódus a tanár támadás kezelésére a karakteren.
     * @return Mindig false, mivel az oktatók támadása nincs hatással egy másik oktatóra
     */
    public boolean teacherAttack(){
        System.out.println("Függvény: Teacher osztály + teacherAttack függvény");
        return false;
    }

    /**
     * Metódus a nedves táblatörlő támadás kezelésére a karakteren.
     * @return Mindig true, mivel a nedves táblatörlő mindig hatásos az oktatók ellen.
     */
    public boolean ragAttack(){
        System.out.println("Függvény: Teacher osztály + ragAttack függvény");
        return true;
    }
}