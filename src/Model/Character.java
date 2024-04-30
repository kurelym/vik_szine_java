package Model;

import java.io.PrintStream;
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
    private PrintStream output;
    /**
     * Konstruktor a Character osztályhoz.
     */
    protected Character(Room startingRoom, PrintStream _output) {
        output = _output;
        name ="Character";
        inventory = new ArrayList<>();
        location = startingRoom;
        startingRoom.addCharacter(this);
        alive = true;
        dazed = false;
    }
    /**
     * Metódus a karakter átmegy egy másik szobába.
     * @param destination A cél szoba.
     * @return true, ha a karakter sikeresen átmegy a szobába, egyébként false.
     */
    public boolean goToRoom(Room destination) {
        if(destination.addCharacter(this)){
            location.removeCharacter(this);
            location = destination;
            return true;
        }
        else {
            return false;
        }
        
    }
    /**
    * Metódus a karakter inventoryjához hozzáad egy tárgyat
    * A pálya txt-ből való betöltéséhez kell
    * @param item A tárgy
    */
    public void add(Using item){
        this.inventory.add(item);
    }

    /**
     * Metódus egy tárgy felvételére.
     * @param item A felvenni kívánt tárgy.
     * @return true, ha a tárgy sikeresen fel lett véve, egyébként false.
     */
    public boolean pickUpItem(Using item) {
        if(inventory.size()==5) {
            return false;
        }
        else {
            item.getLocation().removeItem(item);
            item.setLocation(null);
            inventory.add(item);
            item.setOwner(this);
            if(output != null) {
                output.println(this.name + " PICKED_UP " + item.getName());
            }
            item.useAtPickUp();
            return true;
        }
    }
    /**
     * Metódus ellenőrzi, hogy a karakter életben van-e.
     * @return true, ha a karakter életben van, egyébként false.
     */
    public boolean isAlive() {
        return alive;
    }
    /**
     * Metódus egy tárgy eldobására.
     * @param item Az eldobni kívánt tárgy.
     */
    public void dropItem(Using item) {
        if(!inventory.isEmpty()){
            location.addItem(item);
            inventory.remove(item);
            if(output != null) {
                output.println(this.name + " DROPPED " + item.getName() + " IN " + this.location.getName());
            }
        }
    }
    /**
     * Metódus egy tárgy eldobására, akkor mikor egy sörökorsót vettünk fel/a tanárnál ha tele van a Bag FIFO módon
     */
    public void dropItem() {
        if(!inventory.isEmpty()){
            location.addItem(inventory.get(0));
            if(output != null) {
                output.println(this.name + " DROPPED " + inventory.get(0).getName() + " IN " + this.location.getName());
            }
            inventory.remove(0);
        }
    }
    /**
     * Metódus visszaadja azt a szobát, ahol a karakter tartózkodik.
     * @return A szoba, ahol a karakter tartózkodik.
     */
    public Room getRoom(){
        return location;
    }
    /**
     * Metódus a karakter nevének lekérdezésére.
     * @return A karakter neve.
     */
    public String getName() {
        return name;
    }

    /**
     * Metódus az összes tárgy eldobására a karakter zsebéből.
     */
    public void dropAllItem(){
        for(Using u:inventory){
            if(output != null) {
                output.println(this.name + " DROPPED " + u.getName() + " IN " + this.location.getName());
            }
            location.addItem(u);
        }
        inventory.clear();
    }

    /**
     * Metódus a gáz támadás kezelésére a karakteren.
     * @return true, ha a karakter meg tudja magát védeni a gáz támadás ellen, egyébként false.
     */
    public boolean gasAttack() {
        if(!this.inventory.isEmpty()) {
            for(Using u :  inventory){
                if(u.useAgainstGas()){
                    System.out.println(getName() + " gáz támadás ért, de meg tudtad védeni magad!");
                    dazed = false;
                    return true;
                }
            }
        }
        System.out.println(getName() + " gáz támadás ért, sajnos nem volt módod védekezni ellene");
        dazed = true;
        if(output!=null){
            output.println(this.name+" DAZED");
        }
        dropAllItem();
        return false;
    }
    /**
     * Miután a takarító kisegíti az adott karaktert a szobából, a dazed változó értét visszaállítja false-re
     */
    public void clearMind() {
        dazed = false;
    }
    /**
     * Metódus ellenőrzi, hogy van-e a karakternek logarléce.
     * @return true, ha a karakternek van, egyébként false.
     */
    public boolean hasTheSlideRule() {
        for(Using u : inventory){
            if(u.isRealSlideRule()){
                return true;
            }
        }
        return false;
    }

    /**
     * Lekérdezhető, hogy egy karakter le van-e bénúlva
     * @return igaz, ha az adott karakter le van-e bénúlva
     */
    public boolean isDazed() {
        //System.out.println("Function: Character class + isDazed Func");
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

    abstract boolean isTeacher();

    abstract boolean isCleaner();
}