package Model;

/**
 * A Game osztaly, amely a jatek mukodeseert felel
 */
public class Game {

    public Game() {
        System.out.println("Function: Game class consturctor Func");
    }

    /**
     * @return az aktualis kor szama
     */
    public int getRound() {
        System.out.println("Function: Game class + getRound() Func");
        return 1;
    }

    /**
     * Elinditja a jatekot (inicializal)
     */
    public void startGame() {
        System.out.println("Function: Game class + startGame() Func");
    }

    /**
     * Ellenorzi, hogy valamely hallgato felvette-e a logarlecet
     */
    public void win() {
        System.out.println("Function: Game class + win() Func");
    }

    /**
     * Noveli a kor szamat
     */
    public void incrementRound() {
        System.out.println("Function: Game class + incrementRound() Func");
    }

    /**
     * Csokken az erteke, ha egy jatekos meghal
     */
    public void decreasePlayerNumber() {
        System.out.println("Function: Game class + decreasePlayerNumber() Func");
    }

    /**
     * Hallgato hozzaadasa a jatekhoz
     * 
     * @param Felvett hallgato
     */
    public void addStudent(Student s) {
        System.out.println("Function: Game class + addStudent() Func");
    }

    /**
     * Oktato hozzaadasa a jatekhoz
     * 
     * @param Felvett oktato
     */
    public void addTeacher(Teacher t) {
        System.out.println("Function: Game class + addTeacher() Func");
    }

    /**
     * Hallgato elvetele a jatekbol
     * 
     * @param s Elvett hallgato
     */
    public void removeStudent(Student s) {
        System.out.println("Function: Game class + removeStudent() Func");
    }

    /**
     * Oktato elvetele a jatekbol
     * 
     * @param t Elvett oktato
     */
    public void removeTeacher(Teacher t) {
        System.out.println("Function: Game class + removeTeacher() Func");
    }

    /**
     * A jatek elejen a labirintust epiti fel
     */
    public void initConnectRooms() {
        System.out.println("Function: Game class + initConnectRooms() Func");
    }

    /**
     * A korok vegen modositja a labirintust
     */
    public void manipulateRooms() {
        System.out.println("Function: Game class + manipulateRooms() Func");
    }

}
