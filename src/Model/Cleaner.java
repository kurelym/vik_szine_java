package Model;

import java.io.PrintStream;

public class Cleaner extends Character  {
    private static int globalID = 0;
    private PrintStream output;
    public Cleaner(Room r, PrintStream _output){
        super(r,_output);
        output = _output;
        name = "Cleaner_"+globalID;
        globalID++;
        //System.out.println("Function: Cleaner class + Konstruktor Func");
    }
    /**
     * A goToRoom metódus felüldefiniálása.
     * @param destination A cél szoba.
     * @return true, ha a takarító sikeresen átmegy a szobába, egyébként false.
     */
    @Override
    public boolean goToRoom(Room destination){
        //System.out.println("Function: Cleaner class + goToRoom Func");
        if(destination.addCharacter(this)){
            location.removeCharacter(this);
            location = destination;
            destination.Clean(this);
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * A gasAttack metódus felüldefiniálása a takarítón
     * @return false-al tér vissza mindig, mert takarítóra nincs hatással a gáz
     */
    @Override
    public boolean gasAttack(){
        //System.out.println("Function: Cleaner class + gasAttack Func");
        return false;
    }
    /**
     * Metódus a tanár támadás kezelésére a takarítón
     * @return mindig false-al tér vissza a takarító esetén
     */
    public boolean teacherAttack(){
        //System.out.println("Function: Cleaner class + teacherAttack Func");
        return false;
    }

    /**
     * Metódus a nedves táblatörlő támadás kezelésére a takarítón
     * @return mindig false-al tér vissza a takarító esetén
     */
    public boolean ragAttack(){
        //System.out.println("Function: Cleaner class + ragAttack Func");
        return false;
    }

    /**
     * Az adott takarító állapotáról ad leírást
     * @return Egy stringbe adja vissza a takarítóról a leíást
     */
    public String getDescription() {
        //System.out.println("Function: Cleaner class + getDescription Func");
        return "Name: "+name+" Location: "+location.getID()+" isAlive: "+alive+" isDazed: "+dazed;
    }
    @Override
    public boolean isTeacher() {
        return false;
    }

    @Override
    public boolean isCleaner() {
        return true;
    }

}
