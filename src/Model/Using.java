package Model;

/**
 * Gyűjtemény az Item osztály és leszármazottai által megvalósított függvényekről.
 */
public interface Using {
    /**
     * Az adott tárgy neve kérdezhető le vele.
     * @return Az adott tárgy neve
     */
    public String getName();
    /**
     * Getter a durability attribútumhoz.
     * @return Az adott tárgy kopottsága
     */
    public int getDurability();
    /**
     * Lekérdezhető vele, hogy aktiválva van-e egy tárgy.
     * @return Az adott tárgy aktiváltsági állapota
     */
    public boolean isActive();
    /**
     * Atállítható, hogy az adott tárgyak helyileg hol van, még ha egy karakter zsebében van, akkor is.
     * @param newLocation az új lokáció
     */
    public void setLocation(Room newLocation);
    /**
     * Lekérdezhető vele az adott tárgy location-je
     * @return Az aktuális lokáció
     */
    public Room getLocation();
    /**
     * Lekérdezhető vele a tárgy birtokosa.
     * @param newOwner az új birtokos
     */
    public void setOwner(Character newOwner);
    /**
     * Atállítható vele a tárgy birtokosa.
     * @return Az aktuális birtokosa a tárgynak
     */
    public Character getOwner();
    /**
     * Csökkenti a durability attribútum értékét.
     */
    public void decreaseDurability();
    /**
     * Az adott tárgy használata / aktiválása. (Leszármazottakban felüldefiniált).
     * @return A sikerességét adja meg az adott függvénynek
     */
    public boolean useIt();
    /**
     * useAgainstTeacher():Tanár támadás esetén hívódik meg.(Leszármazottakban felüldefiniált)
     * @return A sikerességét adja meg az adott függvénynek
     */
    public boolean useAgainstGas();
    /**
     * Gáztámadás esetén hívódik meg(Leszármazottakban felüldefiniált)
     * @return A sikerességét adja meg az adott függvénynek
     */
    public boolean useAgainstTeacher();
    /**
     * Játék végét kezeli le(Leszármazottakban felüldefiniált)
     * @return A sikerességét adja meg az adott függvénynek
     */
    public boolean isRealSlideRule();
    /**
     * Tranzisztorok párosításához szükséges(Leszármazottakban felüldefiniált)
     * @return A sikerességét adja meg az adott függvénynek
     */
    public boolean pairing(Transistor pair);
    /**
     * Megbénítja az adott karaktert(Leszármazottakban felüldefiniált)
     * @return A sikerességét adja meg az adott függvénynek
     */
    public boolean daze(Character target);
    /**
     * Tranzisztorok szétkapcsolásához szükséges (Leszármazottakban felüldefiniált)
     * @return A sikerességét adja meg az adott függvénynek
     */
    public boolean removePair();
    /**
     * A légfrissítő működését megvalósító függvény
     * @return A sikerességét adja meg az adott függvénynek
     */
    public boolean cleanTheRoom(Room r);
    /**
     * A camembert sajt által megvalósított függvény, amivel a gázt el tudjuk távolítani a szobából
     * @return A sikerességét adja meg az adott függvénynek
     */
    public boolean removeGas();
    /**
     * Lekérdezhető vele, hogy az adott tárgy hamis-e vagy sem
     * @return Igaz, haz adott tárgy hamisítvány
     */
    public boolean isFake();
    /*
     * A söröskorsó felvételekor hívódik meg
     */
    public void useAtPickUp();
    /**
     * Csökkenti a durability értékét minden kör végén
     * Az eltérés a decreaseDurabilityhez képest, hogy csak a HolyBeer, és a DirtyRag osztályok valósítják meg,
     * mert ezeknél a tárgyaknal csökken a durability a körök végén
     */
    public void roundPassed();
    /**
     * Egy csomagoló függvényként szolgált az olyan tárgyak esetére, amelyek kiválasztva lehet működésre bírni, 
     * interaktivitás van a használatukban (WunderBaum,Transistor,CamembertCheese,DirtyRag)
     * @return az adott tárgy használtának eredménye
     */
    public boolean useSelectedItem();

    public boolean useable();
} 
