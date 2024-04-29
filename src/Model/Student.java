package Model;

import java.util.List;

/**
 * Az osztály egy hallgatót reprezentál a játékban.
 */
public class Student extends Character {
    private static int globalID = 0;
    /**
     * Konstruktor a Student osztályhoz.
     */
    public Student(Room r){
        super(r);
        name = "Student_"+globalID;
        globalID++;
        //System.out.println("Function: Student osztály + Konstruktor Func");
        
    }

    /**
     * Metódus egy tárgy használatára (aktiválására) a hallgató által.
     * @param item A használni kívánt tárgy indexe a táskában.
     */
    public void useItem(int idx, Transistor anotherItem){
        //System.out.println("Function: Student osztály + useItem Func");
        inventory.get(idx).useSelectedItem(anotherItem);
    }

    /**
     * Metódus a tanár támadás kezelésére a hallgatón.
     * @return true, ha a hallgató meg tudja védeni magát az oktatóval szemben, egyébként false.
     */
    public boolean teacherAttack(){
        //System.out.println("Function: Student osztály + teacherAttack Func");
        for(Using u: inventory){
            if(u.useAgainstTeacher()){
                System.out.println(getName() + " megvédte magát " + u.getName() + "-t használva");
                return alive;
            }
        }
        alive = false;
        System.out.println(getName() + " kiesett a játékból");
        this.getRoom().removeCharacter(this);
        return alive;
    }

    /**
     * Metódus a nedves táblatörlő támadás kezelésére a hallgatón.
     * @return Mindig false, mivel a táblatörlő rongy a hallgatókra nincs hatással.
     */
    public boolean ragAttack(){
        //System.out.println("Function: Student osztály + ragAttack Func");
        return false;
    }

    public List<Using> getInventory(){
        return inventory;
    }

    /**
     * Az adott hallgató állapotáról ad leírást
     * @return Egy stringbe adja vissza a halggatóról a leíást
     */
    public String getDescription() {
        //System.out.println("Function: Student osztály + getDescription Func");
        String itemnames = " Items:";
        for(Using u:inventory){
            itemnames = itemnames + " "+u.getName();
        }
        boolean winner = hasTheSlideRule();
        return "Name: "+name+" Location: "+location.getID()+" isAlive: "+alive+" isDazed: "+dazed+itemnames+" Has the SlideRule: "+winner;
    }

    @Override
    public boolean isTeacher() {
        return false;
    }

    @Override
    public boolean isCleaner() {
        return false;
    }

}

