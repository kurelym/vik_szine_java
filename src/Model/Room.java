package Model;
/*
 * A labirintus menedzselése, a saját kapacitásának és szomszédainak, a benne lévő tárgyak és benne tartózkodó karakterek nyilvántartása. A szoba transzformációk végrehajtása.
 */
public class Room {
    /*
     * Létrehozza az osztályt
     */
    public Room(){
        System.out.println("Function: Room class + constructor func");
    }
    /*
     * Az osztódó szoba két olyan szobára válik szét, amelyek egymás szomszédai lesznek, és megosztoznak a korábbi szoba képességein és szomszédain (a korábbi szomszédok vagy csak az egyik, vagy csak a
     * másik “új” szobának lesznek szomszédai). Csak olyan szobák transzformálódhatnak amelyekben nincsen se hallgató se oktató.
     */
    public void Split(){
        System.out.println("Function: Room class + Split func");
    }
    /*
     * Két szomszédos szoba egyesülésével létrejött szoba a korábbi két szoba tulajdonságaival és szomszédaival rendelkezik,de a befogadóképessége a nagyobb szoba
     * befogadóképességével lesz azonos. Csak olyan szobák transzformálódhatnak amelyekben nincsen se hallgató se oktató.
     * @param r, az a szoba amivel egyesül ez a helyiség
     */
    public void Merge(Room r){
        System.out.println("Function: Room class + Merge func");
    }
    /*
     * Az adott szobához új szomszédok vehetőek fel. Ennek a függvénynek jelentős szerepe van az ajtók eltűnés és megjelenése során. Egy szoba csak egyszer lehet egy másik szoba szomszédja.
     * @param anotherone, az a szoba, ami ennek az adott szobának az új szomszédja lesz
     */
    public void addNeighbour(Room anotherone){
        System.out.println("Function: Room class + addNeighbour func");
    }
    /*
     * Az adott szoba szomszédai közül ki lehet venni bizonyos szobákat ezzel a függvénnyel.
     * @param delete, az a szoba, ami ennek az adott szobának kikerül a szomszédai közül
     */
    public void removeNeighbour(Room delete){
        System.out.println("Function: Room class + removeNeighbour func");
    }
    /*
     * Ha kapacitás engedi, akkor ezzel a függvénnyel lehet új karaktert adni a szobához.
     * @param anotherone, az a karakter, ami belép a szobába
     * @return a szobába való lépés sikerességét adja vissza
     */
    public Boolean addCharacter(Character anotherone){
        System.out.println("Function: Room class + addCharacter func");
        return true;
    }
    /*
     * Amikor valaki kimegy a szobából ezzel a függvénnyel lehet eltávolítani a listából.
     * @param left, az a karakter, aki elhagyta a szobát
     */
    public void removeCharacter(Character left){
        System.out.println("Function: Room class + removeCharacter func");
    }
    /*
     * Új tárgy elhelyezése a szobában.
     * @param u, az a tárgy, ami bekerül a szobába
     * @return a tárgy bekerülésének sikerességét adja vissza
     */
    public Boolean addItem(Using u){
        System.out.println("Function: Room class + addItem func");
        return true;
    }
    /*
     * Egy tárgy eltávolítása a szobából, pl. mikor felveszi valaki.
     * @param u, a tárgy, ami kikerül a szobából
     */
    public void removeItem(Using u){
        System.out.println("Function: Room class + removeItem func");
    }
    /*
     * Visszaadja az ID-t.
     * @return A szoba ID-ját adja vissza
     */
    public int getID(){
        System.out.println("Function: Room getID");
        return 1;
    }
    /*
     * Visszaadja a kapacitást.
     * @return A szoba kapacitását adja vissza
     */
    public int getCapacity(){
        System.out.println("Function: Room getCapacity");
        return 1;
    }

}