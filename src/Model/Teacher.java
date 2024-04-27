package Model;

import java.util.List;

/**
 * Az osztály egy oktatót reprezentál a játékban.
 */
public class Teacher extends Character {
    private static int globalID = 0;
    /**
     * Konstruktor a Teacher osztályhoz.
     */
    public Teacher(Room r){
        super(r);
        name = "Teacher_"+globalID;
        globalID++;
        System.out.println("Function: Teacher class + Konstruktor Func");
    }
    @Override
    public boolean pickUpItem(Using item, Room room){
        if(inventory.size()==5){
            dropItem();
        }
        room.removeItem(item);
        item.setLocation(null);
        item.setOwner(this);
        inventory.add(item);
        return true;
    }
    /**
     * Metódus amely levezérli az oktató támadási próbálkozását abban a szobában ahol tartózkodik
     */
    public void tryToKill(){
        System.out.println("Function: Teacher class + tryToKill Func");
        if(!dazed){
            List<Character> characters = location.getCharacters();
            for(Character c: characters){
                c.teacherAttack();
            }
        }
    }

    /**
     * Metódus a tanár támadás kezelésére a karakteren.
     * @return Mindig false, mivel az oktatók támadása nincs hatással egy másik oktatóra
     */
    public boolean teacherAttack(){
        System.out.println("Function: Teacher class + teacherAttack Func");
        return false;
    }

    /**
     * Metódus a nedves táblatörlő támadás kezelésére a karakteren.
     * @return Mindig true, mivel a nedves táblatörlő mindig hatásos az oktatók ellen.
     */
    public boolean ragAttack(){
        System.out.println("Function: Teacher class + ragAttack Func");
        dazed = true;
        return true;
    }
    /**
     * Az adott tanár állapotáról ad leírást
     * @return Egy stringbe adja vissza a tanárról a leíást
     */
    public String getDescription() {
        System.out.println("Function: Teacher class + getDescription Func");
        String itemnames = "Items:";
        for(Using u:inventory){
            itemnames = itemnames + " "+u.getName();
        }
        return "Name: "+name+" Location: "+location.getID()+" isAlive: "+alive+" isDazed: "+dazed+itemnames;
    }
}