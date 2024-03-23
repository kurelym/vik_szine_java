package Model;

// A Game osztaly, amely a jatek mukodeseert felel

public class Game {

    public Game() {
        System.out.println("Function: [Game] consturctor");
    }

    // @return az aktualis kor szama
    public int getRound() {
        System.out.println("Function: [Game] " + getClass().getEnclosingMethod().getName());
        return 1;
    }

    // Elinditja a jatekot (inicializal)
    public void startGame() {
        System.out.println("Function: [Game] " + getClass().getEnclosingMethod().getName());
    }

    // Ellenorzi, hogy valamely hallgato felvette-e a logarlecet
    public void win() {
        System.out.println("Function: [Game] " + getClass().getEnclosingMethod().getName());
    }

    // Noveli a kor szamat
    public void incrementRound() {
        System.out.println("Function: [Game] " + getClass().getEnclosingMethod().getName());
    }

    // Csokken az erteke, ha egy jatekos meghal
    public void decreasePlayerNumber() {
        System.out.println("Function: [Game] " + getClass().getEnclosingMethod().getName());
    }

    // Hallgato hozzaadasa a jatekhoz
    // @param Felvett hallgato
    public void addStudent(Student s) {
        System.out.println("Function: [Game] " + getClass().getEnclosingMethod().getName());
    }

    // Oktato hozzaadasa a jatekhoz
    // @param Felvett oktato
    public void addTeacher(Teacher t) {
        System.out.println("Function: [Game] " + getClass().getEnclosingMethod().getName());
    }

    // Hallgato elvetele a jatekbol
    // @param Elvett hallgato
    void removeStudent(Student s) {
        System.out.println("Function: [Game] " + getClass().getEnclosingMethod().getName());
    }

    // Oktato elvetele a jatekbol
    // @param Elvett oktato
    void removeTeacher(Teacher t) {
        System.out.println("Function: [Game] " + getClass().getEnclosingMethod().getName());
    }

    // A jatek elejen a labirintust epiti fel
    void initConnectRooms() {
        System.out.println("Function: [Game] " + getClass().getEnclosingMethod().getName());
    }

    // A korok vegen modositja a labirintust
    void manipulateRooms() {
        System.out.println("Function: [Game] " + getClass().getEnclosingMethod().getName());
    }

}
