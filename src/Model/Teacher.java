package Model;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Az osztály egy oktatót reprezentál a játékban.
 */
public class Teacher extends Character {
    private static int globalID = 1;
    private PrintStream output;
    /**
     * Konstruktor a Teacher osztályhoz.
     */
    public Teacher(Room r, PrintStream _output){
        super(r,_output);
        output = _output;
        name = "Teacher_"+globalID;
        globalID++;
        //System.out.println("Function: Teacher class + Konstruktor Func");
    }
    @Override
    public boolean pickUpItem(Using item){
        if(inventory.size()==5){
            dropItem();
        }
        if(item.getLocation()!=null){
            item.getLocation().removeItem(item);
            item.setLocation(null);
            item.setOwner(this);
            inventory.add(item);
            if(output!=null){
                output.println(this.name+" PICKED_UP "+item.getName());
            }
            item.useAtPickUp();
            return true;
        }
        return false;
    }
    /**
     * Metódus amely levezérli az oktató támadási próbálkozását abban a szobában ahol tartózkodik
     */
    public void tryToKill() {
        if (!dazed) {
            List<Character> originalCharacters = location.getCharacters();
            List<Character> characters = new ArrayList<>(originalCharacters);
            List<Character> toRemove = new ArrayList<>();
    
            for (Character c : characters) {
                boolean dead = c.teacherAttack();
                if (dead) {
                    toRemove.add(c);
                }
            }

            originalCharacters.removeAll(toRemove);
            if (toRemove.size()!=0){
                if(output!=null){
                    output.println(this.name+" KILLING_IN "+location.name);
                }
            }
        }
    }
    /**
     * Metódus a tanár támadás kezelésére a karakteren.
     * @return Mindig false, mivel az oktatók támadása nincs hatással egy másik oktatóra
     */
    public boolean teacherAttack(){
        //System.out.println("Function: Teacher class + teacherAttack Func");
        return false;
    }

    /**
     * Metódus a nedves táblatörlő támadás kezelésére a karakteren.
     * @return Mindig true, mivel a nedves táblatörlő mindig hatásos az oktatók ellen.
     */
    public boolean ragAttack(){
        //System.out.println("Function: Teacher class + ragAttack Func");
        dazed = true;
        if(output!=null){
            output.println("RAG_ATTACKED "+this.name);
        }
        return true;
    }
    /**
     * Az adott tanár állapotáról ad leírást
     * @return Egy stringbe adja vissza a tanárról a leíást
     */
    public String getDescription() {
        //System.out.println("Function: Teacher class + getDescription Func");
        String itemnames = "Items:";
        for(Using u:inventory){
            itemnames = itemnames + " "+u.getName();
        }
        return "Name: "+name+" Location: "+location.getID()+" isAlive: "+alive+" isDazed: "+dazed+itemnames;
    }
}