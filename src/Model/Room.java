package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A labirintus menedzselése, a saját kapacitásának és szomszédainak, a benne lévő tárgyak és benne tartózkodó karakterek nyilvántartása. A szoba transzformációk végrehajtása.
 */
public class Room implements Description {
    private static int globalID = 0;
    protected String name;
    protected int capacity;
    protected List<Room> neighbours;
    protected List<Using> items;
    protected List<Character> characters;
    protected List<Using> activatedItems;
    protected List<Using> stickyItems;
    protected boolean clear;
    protected int visitor;
    /**
     * Létrehozza az osztályt
     */
    public Room(){
        name = "Room_"+globalID;
        globalID++;
        Random rand = new Random();
        capacity = rand.nextInt(5, 10);
        neighbours = new ArrayList<>();
        items = new ArrayList<>();
        characters = new ArrayList<>();
        activatedItems = new ArrayList<>();
        stickyItems = new ArrayList<>();
        clear = false;
        visitor = 0;
        //System.out.println("Function: Room class + constructor func: " + name);
    }
    /**
     * Az osztódó szoba két olyan szobára válik szét, amelyek egymás szomszédai lesznek, és megosztoznak a korábbi szoba képességein és szomszédain (a korábbi szomszédok vagy csak az egyik, vagy csak a
     * másik “új” szobának lesznek szomszédai). Csak olyan szobák transzformálódhatnak amelyekben nincsen se hallgató se oktató.
     * AKTIVÁLT ITEM_EK MARADNAK
     */
    public Room Split(){
        Room newroom = new Room();
        //System.out.println("Function: Room class + Split func");
        if(characters.isEmpty()){
            this.addNeighbour(newroom);
            newroom.addNeighbour(this);
            int sizeOfItems = items.size()/2;
            int sizeOfNeighbours = neighbours.size()/2;
            for(int i=0;i<sizeOfItems;i++){
                newroom.addItem(items.get(i));
                this.removeItem(items.get(i));
            }
            for(int f=0;f<sizeOfNeighbours;f++){
                newroom.addNeighbour(neighbours.get(f));
                this.removeNeighbour(neighbours.get(f));
            }
        }
        return newroom;
    }
    /**
     * Két szomszédos szoba egyesülésével létrejött szoba a korábbi két szoba tulajdonságaival és szomszédaival rendelkezik,de a befogadóképessége a nagyobb szoba
     * befogadóképességével lesz azonos. Csak olyan szobák transzformálódhatnak amelyekben nincsen se hallgató se oktató.
     * RAGADÓS TÁRGYAK NEM KERÜLNEK ÁT A MERGE SORÁN
     * @param r az a szoba amivel egyesül ez a helyiség
     */
    public void Merge(Room r){
        //System.out.println("Function: Room class + Merge func");
        if(characters.isEmpty() && r.characters.isEmpty() && r!=null) {
            if(this.capacity>=r.capacity){
                for(Using uR: r.items){
                    this.addItem(uR);
                    r.removeItem(uR);
                }
                for(Using uaR: r.activatedItems){
                    this.addItem(uaR);
                    r.removeItem(uaR);
                }
                for(Room nR: r.neighbours){
                    this.addNeighbour(nR);
                    nR.addNeighbour(this);
                    nR.removeNeighbour(r);
                    this.removeNeighbour(r);
                }
                r = null;
            }
            //Mivel a merge végén ki kell nullázni a kisebb szobát, így ha r a nagyobb,
            //akkor "átkellmenni" az őr merge-be, és onnan kinullázni ezt a szobát, mert
            // this = null nem lehetéséges
            else{
                r.Merge(this);
            }
        }
    }
    /**
     * Az adott szobához új szomszédok vehetőek fel. Ennek a függvénynek jelentős szerepe van az ajtók eltűnés és megjelenése során. Egy szoba csak egyszer lehet egy másik szoba szomszédja.
     * @param anotherone az a szoba, ami ennek az adott szobának az új szomszédja lesz
     */
    public void addNeighbour(Room anotherone){
        //System.out.println("Function: Room class + addNeighbour func"+ name+" - " +anotherone.name);
        if(this!=anotherone){
            neighbours.add(anotherone);
        }
    }
    /**
     * Az adott szoba szomszédai közül ki lehet venni bizonyos szobákat ezzel a függvénnyel.
     * @param delete az a szoba, ami ennek az adott szobának kikerül a szomszédai közül
     */
    public void removeNeighbour(Room delete){
        //System.out.println("Function: Room class + removeNeighbour func");
        if(neighbours.contains(delete)){
            neighbours.remove(delete);
        }
    }
    /**
     * Ha kapacitás engedi, akkor ezzel a függvénnyel lehet új karaktert adni a szobához.
     * @param anotherone az a karakter, ami belép a szobába
     * @return a szobába való lépés sikerességét adja vissza
     */
    public boolean addCharacter(Character character){
        //System.out.println("Function: Room class + addCharacter func"+name+" - "+anotherone.getName());
        if(capacity>characters.size()){
            for(Using aI:activatedItems){
                aI.daze(character);
                if(character.dazed) {
                    System.out.println(character.getName() + " elkábult " + aI.getName() + "-től");
                    break;
                }
            }
            if(clear) visitor++;
            if(visitor>=5){
                for(Using u: items){
                    stickyItems.add(u);
                }
                for(Using ua: activatedItems){
                    stickyItems.add(ua);
                }
            }
            characters.add(character);
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * Amikor valaki kimegy a szobából ezzel a függvénnyel lehet eltávolítani a listából.
     * @param left az a karakter, aki elhagyta a szobát
     */
    public void removeCharacter(Character left){
        //System.out.println("Function: Room class + removeCharacter func");
        if(characters.contains(left)){
            characters.remove(left);
        }
    }
    /**
     * Új tárgy elhelyezése a szobában.
     * @param u az a tárgy, ami bekerül a szobába
     * @return a tárgy bekerülésének sikerességét adja vissza
     */
    public boolean addItem(Using u){
        //System.out.println("Function: Room class + addItem func: "+name+" - "+u.getName());
        if(clear && visitor==5){
            
        }
        else if(u.isActive()){
            System.out.println("Sikeresen aktiváltad a tárgyat a szobában");
            activatedItems.add(u);
            u.setLocation(this);
            u.setOwner(null);
            for(Character character : this.getCharacters()) {
                u.daze(character);
            }
        }
        else{
            items.add(u);
            u.setLocation(this);
            u.setOwner(null);
        }
        return true;
    }
    /**
     * Egy tárgy eltávolítása a szobából, pl. mikor felveszi valaki.
     * @param u a tárgy, ami kikerül a szobából
     */
    public void removeItem(Using u){
        //System.out.println("Function: Room class + removeItem func");
        if(items.contains(u)) {
            items.remove(u);
        } else if(activatedItems.contains(u)) {
            activatedItems.remove(u);
        }
        u.setLocation(null);
    }
    /**
     * Visszaadja az ID-t.
     * @return A szoba ID-ját adja vissza
     */
    public String getID(){
        //System.out.println("Function: Room getID");
        return name;
    }
    /**
     * Visszaadja a kapacitást.
     * @return A szoba kapacitását adja vissza
     */
    public int getCapacity(){
        //System.out.println("Function: Room getCapacity");
        return capacity;
    }
    /**
     * Légfrissítő használatakor hívódik meg
     */
    public void Clean(){
        //System.out.println("Function: Room class + Clean Func");
        for(Using u: activatedItems){
            u.removeGas();
        }
    }
    /**
     * Takarító használatakor hívódik meg
     */
    public void Clean(Character cleaner){
        //System.out.println("Function: Room class + Clean(Character cleaner) Func");
        boolean hasGas = false;
        ArrayList<Using> removed = new ArrayList<>();
        if(!activatedItems.isEmpty()) {
            for(Using u: activatedItems){
                if(u.removeGas()){
                    System.out.println(cleaner.getName() + " kitakarított " + this.getName() + "-ben");
                    hasGas = true;
                    removed.add(u);
                }
            }
            for(Using item : removed) {
                activatedItems.remove(item);
            }
    
            if(hasGas) {
                clear = true;
                Random random = new Random();
                for(Character character : characters) {
                    if(!character.isDazed() && character != cleaner) {
                        character.goToRoom(this.getNeighbours().get(random.nextInt(0, getNeighbours().size())));
                        System.out.println(character.getName() + " ki lettél rakva a szobából " + character.getRoom().getName() + "-be");
                    }
                }
            }    
        }
    }
    /**
     * A Room objektum állapotáról ad leírást
     * @return Egy stringbe adja vissza a Room objektumról a leíást
     */
    public String getDescription() {
        //System.out.println("\nFunction: Room class + getDescription Func:\n");
        String members ="Characters:";
        String stuff ="Items:";
        String stuffA ="Activated Items:";
        String neighB ="Neighbours:";
        for(Using u: items){
            stuff = stuff + " " +u.getName();
        }
        for(Using uA: activatedItems){
            stuffA = stuffA + " " +uA.getName();
        }
        for(Room n: neighbours){
            neighB = neighB + " " +n.getID();
        }
        for(Character c: characters){
            members = members + " " +c.getName();
        }
        return name+": "+members+", "+stuff+", "+stuffA+", "+neighB;
    }

    /**
     * A szoba szomszédait adja vissza
     * @return a szoba szomszédainak listája
     */
    public List<Room> getNeighbours(){
        return neighbours;
    }

    /**
     * A szobában levő tárgyakat adja vissza
     * @return a szoba tárgyainak listája
     */
    public List<Using> getItems(){
        return items;
    }

    /**
     * A szoba nevét adja vissza
     * @return a szoba neve
     */
    public String getName(){
        return name;
    }
    /**
     * A szobában lévő karaktereket adja vissza
     * @return szobában lévő karakterek listája
     */
    public  List<Character> getCharacters(){
        return characters;
    }
    public boolean isNeighbours(Room r)
    {
        return neighbours.contains(r);
    }
}