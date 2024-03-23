package Model;

/**
 * Gyűjtemény az Item osztály és leszármazottai által megvalósított függvényekről.
 */
public interface Using {
    /**
     * Leírást ad az adott tárgyról (Leszármazottakban felüldefiniált)
     * @return Az adott tárgy leírása
     */
    public String getDescription();
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
     * Átállítható, hogy az adott tárgyak helyileg hol van, még ha egy karakter zsebében van, akkor is.
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
     * Átállítható vele a tárgy birtokosa.
     * @return Az aktuális birtokosa a tárgynak
     */
    public Character getOwner();
    /**
     * Csökkenti a durability attribútum értékét.
     */
    public void roundPassed();
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
    public boolean finishGame();
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
} 
