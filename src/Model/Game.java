package Model;

/**
 * A Game osztaly, amely a jatek mukodeseert felel
 */
public class Game {

    public Game() {
        System.out.println("Function: Game class consturctor");
    }

    /**
     * @return az aktualis kor szama
     */
    public int getRound() {
        System.out.println("Function: Game class + getRound()");
        return 1;
    }

    /**
     * Elinditja a jatekot (inicializal)
     */
    public void startGame() {
        System.out.println("Function: Game class + startGame()");
    }

    /**
     * Ellenorzi, hogy valamely hallgato felvette-e a logarlecet
     */
    public void win() {
        System.out.println("Function: Game class + win()");
    }

    /**
     * Noveli a kor szamat
     */
    public void incrementRound() {
        System.out.println("Function: Game class + incrementRound()");
    }

    /**
     * Csokken az erteke, ha egy jatekos meghal
     */
    public void decreasePlayerNumber() {
        System.out.println("Function: Game class + decreasePlayerNumber()");
    }

    /**
     * Hallgato hozzaadasa a jatekhoz
     * 
     * @param Felvett hallgato
     */
    public void addStudent(Student s) {
        System.out.println("Function: Game class + addStudent()");
    }

    /**
     * Oktato hozzaadasa a jatekhoz
     * 
     * @param Felvett oktato
     */
    public void addTeacher(Teacher t) {
        System.out.println("Function: Game class + addTeacher()");
    }

    /**
     * Hallgato elvetele a jatekbol
     * 
     * @param s Elvett hallgato
     */
    public void removeStudent(Student s) {
        System.out.println("Function: Game class + removeStudent()");
    }

    /**
     * Oktato elvetele a jatekbol
     * 
     * @param t Elvett oktato
     */
    public void removeTeacher(Teacher t) {
        System.out.println("Function: Game class + removeTeacher()");
    }

    /**
     * A jatek elejen a labirintust epiti fel
     */
    public void initConnectRooms() {
        System.out.println("Function: Game class + initConnectRooms()");
    }

    /**
     * A korok vegen modositja a labirintust
     */
    public void manipulateRooms() {
        System.out.println("Function: Game class + manipulateRooms()");
    }

}
