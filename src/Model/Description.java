package Model;

public interface Description {
    /**
     *Az Item, Game, Room, és Character valósítja meg. Célja, hogy tartalmaz egy getDescription függvényt,
     *amivel lekérdezhető az egyes objektum állapota a kimeneti nyelvben definiált
     *state parancs során.
     * @return A lekérdezett string
     */
    public String getDescription();
}
