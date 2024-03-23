package Model;

/**
 * Az absztrakt osztály egy karaktert reprezentál a játékban.
 */
public abstract class Character {

    /**
     * Konstruktor a Character osztályhoz.
     */
    protected Character(){
        System.out.println("Függvény: Character osztály + Konstruktor függvény");
    }

    /**
     * Metódus egy tárgy felvételére.
     * @param item A felvenni kívánt tárgy.
     * @return true, ha a tárgy sikeresen fel lett véve, egyébként false.
     */
    public boolean pickUpItem(Using item){
        System.out.println("Függvény: Character osztály + pickUpItem függvény");
        return true;
    }

    /**
     * Metódus egy tárgy eldobására.
     * @param item Az eldobni kívánt tárgy.
     */
    public void dropItem(Using item){
        System.out.println("Függvény: Character osztály + dropItem függvény");
    }

        /**
     * Metódus a karakter átmegy egy másik szobába.
     * @param destination A cél szoba.
     * @return true, ha a karakter sikeresen átmegy a szobába, egyébként false.
     */
    public boolean goToRoom(Room destionation){
        System.out.println("Függvény: Character osztály + goToRoom függvény");
        return true;
    }

    /**
     * Metódus visszaadja azt a szobát, ahol a karakter tartózkodik.
     * @return A szoba, ahol a karakter tartózkodik.
     */
    public Room getRoom(){
        System.out.println("Függvény: Character osztály + getRoom függvény");
        return null;
    }
    /**
     * Metódus a karakter nevének lekérdezésére.
     * @return A karakter neve.
     */
    public String getName(){
        System.out.println("Függvény: Character osztály + getName függvény");
        return "";
    }

    /**
     * Metódus a karakter tartózkodási helyének lekérdezésére.
     * @return A szoba, ahol a karakter tartózkodik.
     */
    public Room getLocation(){
        System.out.println("Függvény: Character osztály + getLocation függvény");
        return null;
    }

    /**
     * Metódus az összes tárgy eldobására a karakter zsebéből.
     */
    public void dropAllItem(){
        System.out.println("Függvény: Character osztály + dropAllItem függvény");
    }

    /**
     * Metódus a gáz támadás kezelésére a karakteren.
     * @return true, ha a karakter meg tudja magát védeni a gáz támadás ellen, egyébként false.
     */
    public boolean gasAttack(){
        System.out.println("Függvény: Character osztály + gasAttack függvény");
        return true;
    }

    /**
     * Metódus ellenőrzi, hogy van-e a karakternek logarléce.
     * @return true, ha a karakternek van, egyébként false.
     */
    public boolean hasTheSlideRule(){
        System.out.println("Függvény: Character osztály + hasTheSlideRule függvény");
        return true;
    }

    /**
     * Metódus ellenőrzi, hogy a karakter életben van-e.
     * @return true, ha a karakter életben van, egyébként false.
     */
    public boolean isAlive(){
        System.out.println("Függvény: Character osztály + isAlive függvény");
        return true;
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