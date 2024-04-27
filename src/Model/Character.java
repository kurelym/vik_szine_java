package Model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Az absztrakt osztály egy karaktert reprezentál a játékban.
 */
public abstract class Character implements Description {
    protected String name;
    protected List<Using> inventory;
    protected Room location;
    protected boolean alive;
    protected boolean dazed;
    /**
     * Konstruktor a Character osztályhoz.
     */
    protected Character(Room startingRoom){
        name ="Character";
        inventory = new ArrayList<>();
        location = startingRoom;
        startingRoom.addCharacter(this);
        alive = false;
        dazed = false;
        System.out.println("Function: Character class + Konstruktor Func");
    }
    /**
     * Metódus a karakter átmegy egy másik szobába.
     * @param destination A cél szoba.
     * @return true, ha a karakter sikeresen átmegy a szobába, egyébként false.
     */
    public boolean goToRoom(Room destination){
        System.out.println("Function: Character class + goToRoom Func: "+name+" - "+destination.name);
        if(destination.addCharacter(this)){
            location.removeCharacter(this);
            location = destination;
            return true;
        }
        else{
            return false;
        }
        
    }
    /**
    * Metódus a karakter inventoryjához hozzáad egy tárgyat
    * A pálya txt-ből való betöltéséhez kell
    * @param item A tárgy
    */
    public void add(Using item){
        System.out.println("Function: Character class + add Func "+name+" - "+item.getName());
        this.inventory.add(item);
    }

    /**
     * Metódus egy tárgy felvételére.
     * @param item A felvenni kívánt tárgy.
     * @return true, ha a tárgy sikeresen fel lett véve, egyébként false.
     */
    public boolean pickUpItem(Using item, Room room){
        System.out.println("Function: Character class + pickUpItem Func "+name+" - " +item.getName());
        if(inventory.size()==5){
            return false;
        }
        else{
            room.removeItem(item);
            item.setLocation(null);
            inventory.add(item);
            item.setOwner(this);
            item.useAtPickUp();
            return true;
        }
    }
    /**
     * Metódus ellenőrzi, hogy a karakter életben van-e.
     * @return true, ha a karakter életben van, egyébként false.
     */
    public boolean isAlive(){
        System.out.println("Function: Character class + isAlive Func");
        return alive;
    }
    /**
     * Metódus egy tárgy eldobására.
     * @param item Az eldobni kívánt tárgy.
     */
    public void dropItem(Using item){
        System.out.println("Function: Character class + dropItem Func");
        if(!inventory.isEmpty()){
            location.addItem(item);
            inventory.remove(item);
        }
    }
    /**
     * Metódus egy tárgy eldobására, akkor mikor egy sörökorsót vettünk fel/a tanárnál ha tele van a Bag FIFO módon
     */
    public void dropItem(){
        System.out.println("Function: Character class + dropItem Func");
        if(!inventory.isEmpty()){
            location.addItem(inventory.get(0));
            inventory.remove(0);
        }
    }
    /**
     * Metódus visszaadja azt a szobát, ahol a karakter tartózkodik.
     * @return A szoba, ahol a karakter tartózkodik.
     */
    public Room getRoom(){
        //System.out.println("Function: Character class + getRoom Func");
        return location;
    }
    /**
     * Metódus a karakter nevének lekérdezésére.
     * @return A karakter neve.
     */
    public String getName(){
        //System.out.println("Function: Character class + getName Func");
        return name;
    }

    /**
     * Metódus az összes tárgy eldobására a karakter zsebéből.
     */
    public void dropAllItem(){
        System.out.println("Function: Character class + dropAllItem Func");
        for(Using u:inventory){
            location.addItem(u);
        }
        inventory.clear();
    }

    /**
     * Metódus a gáz támadás kezelésére a karakteren.
     * @return true, ha a karakter meg tudja magát védeni a gáz támadás ellen, egyébként false.
     */
    public boolean gasAttack(){
        System.out.println("Function: Character class + gasAttack Func");
        for(Using u :  inventory){
            if(u.useAgainstGas()){
                dazed = false;
                return false;
            }
            else{
                dazed = true;
            }
        }
        return true;
    }
    /**
     * Miután a takarító kisegíti az adott karaktert a szobából, a dazed változó értét visszaállítja false-re
     */
    public void clearMind(){
        dazed = false;
    }
    /**
     * Metódus ellenőrzi, hogy van-e a karakternek logarléce.
     * @return true, ha a karakternek van, egyébként false.
     */
    public boolean hasTheSlideRule(){
        System.out.println("Function: Character class + hasTheSlideRule Func");
        for(Using u : inventory){
            if(u.finishGame()){
                return true;
            }
        }
        return false;
    }

    /**
     * Lekérdezhető, hogy egy karakter le van-e bénúlva
     * @return igaz, ha az adott karakter le van-e bénúlva
     */
    public boolean isDazed(){
        System.out.println("Function: Character class + isDazed Func");
        return dazed;
    }
    /**
     * Absztrakt metódus a tanár támadásának kezelésére a karakteren.
     * @return ture, ha a karakter meg tudja védeni magát a tanár támadás ellen, egyébként false.
     */
    abstract boolean teacherAttack();

    /**
     * Absztrakt metódus a táblatörlő rongy kezelésére a karakteren.
     * @return true, ha a karakterre hatással van a táblatörlő rongy, egyébként false.
     */
    abstract boolean ragAttack();
}