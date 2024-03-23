package Model;
/**
 * A labirintus menedzselése, a saját kapacitásának és szomszédainak, a benne lévő tárgyak és benne tartózkodó karakterek nyilvántartása. A szoba transzformációk végrehajtása.Elgázosítás esetén az állapotának megváltoztatása.
 */
public class CursedRoom extends Room{
    /**
     * Létrehozza az osztályt
     */
    public CursedRoom(){
        System.out.println("Function: CursedRoom class + constructor func");
    }
    /**
     * Amennyiben a hiddenNeighbours lista üres, eltüntet ajtókat, amennyiben nem üres, előhoz ajtókat
     */
    public void doorManipulation(){
        System.out.println("Function: CursedRoom class + doorManipulation func");
    }
}