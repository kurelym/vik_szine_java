package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * A Game osztaly, amely a jatek mukodeseert felel
 */
public class Game implements Description {
    private int round;
    //Nem tudom miben állapodtunk meg de legyen 30
    private static int maxRounds = 30;
    private List<Teacher> teachers;
    private List<Student> students;
    private List<Cleaner> cleaners;
    private List<Room> rooms;
    private List<CursedRoom> cursedRooms;
    private List<Using> items;

    public Game() {
        round = 0;
        teachers = new ArrayList<>();
        students  = new ArrayList<>();
        cleaners  = new ArrayList<>();
        rooms  = new ArrayList<>();
        cursedRooms  = new ArrayList<>();
        items  = new ArrayList<>();
        System.out.println("Function: Game class consturctor Func");
    }

    /**
     * @return az aktualis kor szama
     */
    public int getRound() {
        System.out.println("Function: Game class + getRound() Func");
        return round;
    }
    /**
     * Egy fájlból generál egy pályát, amit paraméterként kap
     * @param fileName a paraméterként átadott fájl neve (BUILDMAP.txt)
     */
    public void buildGame(String fileName){
        System.out.println("Function: Game class + buildGame() Func");

        //TODO: Mivel komplexebb lesz az algoritmus, így összecsapni nem akartam, szóval adok egy pongyolább leírást:
        //ciklusban feldolgozzuk a BUILDMAP.txt tartalmát és a parancsnak megfelőlen switch
        //szobát hozunk létre
        //initConnectRooms
        //tárgyak létrehozása és szobáhozadása
        // hallagtók létrehozása és szobáhozadása
        //tanárok létrehozása és szobához adása
        //takarítok létrehozása és szobához adása
    }
    /**
     * Elinditja a játékot 
     */
    public void startGame() {
        System.out.println("Function: Game class + startGame() Func");
        incrementRound();
    }

    /**
     * Ellenorzi, hogy valamely hallgato felvette-e a logarlecet
     */
    public boolean win() {
        System.out.println("Function: Game class + win() Func");
        for(Student s: students){
            if(s.hasTheSlideRule()){
                System.out.println("Winner: "+s.getName());
                return true;
            }
        }
        return false;
    }

    /**
     * Noveli a kor szamat
     */
    public void incrementRound() {
        System.out.println("Function: Game class + incrementRound() Func");
        
        //TODO: Mivel komplexebb lesz az algoritmus, így összecsapni nem akartam, szóval adok egy pongyolább leírást:
        //tanárokat/takarítókat léptetünk, (ciklusban goToRoom,TryToKill, pickupItem)
        //szobákat manipulálunk, (manipulateRooms())
        //az elhasználódott tárgyakat kiszedjük (ciklusban a 0 durability-t null-ozuk)
        //a meghalt hallgatókat is takarítjuk(isAlive false hallgatól nullázása ciklusban)
        //Nyertes hallgatót keresünk a win-el(win())
         // nőveljük a kör értékét, (round++)

    }


    /**
     * Hallgato hozzaadasa a jatekhoz
     * 
     * @param s hallgató
     */
    public void addStudent(Student s) {
        System.out.println("Function: Game class + addStudent() Func");
        if(!students.contains(s)){
            students.add(s);
        }
    }

    /**
     * Oktato hozzaadasa a jatekhoz
     * 
     * @param t oktató
     */
    public void addTeacher(Teacher t) {
        System.out.println("Function: Game class + addTeacher() Func");
        if(!teachers.contains(t)){
            teachers.add(t);
        }
    }
    /**
     * Takarító hozzáadása a játékhoz
     * @param c takarító
     */
    public void addCleaner(Cleaner c){
        System.out.println("Function: Game class + addCleaner() Func");
        if(!cleaners.contains(c)){
            cleaners.add(c);
        }
    }
    /**
     * Hallgató törlése a játékból
     * 
     * @param s törölt hallgató
     */
    public void removeStudent(Student s) {
        System.out.println("Function: Game class + removeStudent() Func");
        if(students.contains(s)){
            students.remove(s);
        }
    }

    /**
     * Oktató törlése  a játékból
     * 
     * @param t törölt oktató
     */
    public void removeTeacher(Teacher t) {
        System.out.println("Function: Game class + removeTeacher() Func");
        if(teachers.contains(t)){
            teachers.remove(t);
        }
    }
    /**
     * Takarító törlése a játékból
     * 
     * @param c törölt takarító
     */
    public void removeCleaner(Cleaner c){
        System.out.println("Function: Game class + removeCleaner() Func");
        if(cleaners.contains(c)){
            cleaners.remove(c);
        }
    }
    /**
     * A játék elejen a labirintust epiti fel
     */
    public void initConnectRooms(Room r1, Room r2, boolean duplex) {
        System.out.println("Function: Game class + initConnectRooms() Func");
        if(duplex && r1 != null && r2!=null){
            r1.addNeighbour(r2);
            r2.addNeighbour(r1);
        }
        else if(!duplex && r1 != null && r2!=null){
            r1.addNeighbour(r2);
        }
    }

    /**
     * A korok vegen modositja a labirintust
     */
    public void manipulateRooms() {
        System.out.println("Function: Game class + manipulateRooms() Func");
        for(CursedRoom cR:cursedRooms){
            cR.doorManipulation();
        }
        //TODO: Mivel komplexebb lesz az algoritmus, így összecsapni nem akartam, szóval adok egy pongyolább leírást:
        //Végig iterálunk a rooms listán és páratlan körben minden második szobára split-et hívunk, míg párosban merge-t a 
        //az adott szoba egyik szomszédjára. Most ez jó kérdés, hogy hogyan lesz meghatározva, de a mostani fázisba írjuk bele, 
        //hogy az első szomszédra, aztán majd ennél egy valamivel okosabb algoritmust kitalálunk mert ez ilyen ping pongos szar
        //SPLIT-NÉL KELL, hogy a GAME IS ÉRTESÜLJÖN RÓLA
        if(round%2==1){
            for(int i =0; i<rooms.size();i+=2){
                rooms.get(i).Split();
            }
        }
        else{
            for(int i =0; i<rooms.size();i+=2){
                //TODO
                rooms.get(i).Merge(null);
            }
        }
    }
    /**
     * A Game objektum állapotáról ad leírást
     * @return Egy stringbe adja vissza a Game objektumról a leíást
     */
    public String getDescription() {
        System.out.println("Function: Game class + getDescription Func");
        String membersS ="Students:";
        String membersT ="Teachers:";
        String membersC ="Cleaners:";
        String stuff ="Items:";
        String room ="Rooms: ";
        String roomC ="CursedRooms: ";
        for(Using u: items){
            stuff = stuff + " " +u.getName();
        }
        for(Character cT: teachers){
            membersT = membersT + " " +cT.getName();
        }
        for(Room r: rooms){
            room = room + " " +r.getID();
        }
        for(Room rC: cursedRooms){
            roomC = roomC + " " +rC.getID();
        }
        for(Character c: students){
            membersS = membersS + " " +c.getName();
        }
        for(Character cC: cleaners){
            membersC = membersC + " " +cC.getName();
        }
        return "Round:  "+round +"GameState:\n"+room+" "+roomC+" "+stuff+" "+membersS+" "+membersT+" "+membersC;
       
    }
}
