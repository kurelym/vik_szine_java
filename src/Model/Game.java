package Model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * @param fileName a paraméterként átadott fájl elérési útja
     */
     public void buildGame(String filePath) throws IOException {
        //System.out.println("Function: Game class + buildGame() Func");

        Path path = Paths.get(filePath);
        List<String> lines = Files.readAllLines(path);

        Map<String, Room> roomMap = new HashMap<>();
        Map<String, Character> characterMap = new HashMap<>();

        String currentSection = "";
        String[] parts;

        // Feldolgozza a fájl tartalmát soronként
        for (String line : lines) {
            line = line.trim();

            switch (line) {
                case "-- Rooms --":
                    currentSection = "Rooms";
                    System.out.println("");
                    System.out.println("-- Rooms --");
                    continue;
                case "-- Room Connections --":
                    currentSection = "Connections";
                    System.out.println("");
                    System.out.println("-- Room Connections --");
                    continue;
                case "-- Characters --":
                    currentSection = "Characters";
                    System.out.println("");
                    System.out.println("-- Characters --");
                    continue;
                case "-- Objects --":
                    currentSection = "Objects";
                    System.out.println("");
                    System.out.println("-- Objects --");
                    continue;
                case "-- Objects in Rooms --":
                    currentSection = "ObjectsInRooms";
                    System.out.println("");
                    System.out.println("-- Objects in Rooms --");
                    continue;
                case "-- Activated Objects in Rooms --":
                    currentSection = "ActivatedObjectsInRooms";
                    System.out.println("");
                    System.out.println("-- Activated Objects in Rooms --");
                    continue;
                case "-- Objects Carried by Characters --":
                    currentSection = "ObjectsCarriedByCharacters";
                    System.out.println("");
                    System.out.println("-- Objects Carried by Characters --");
                    continue;
                default:
                    break;
            }
            switch (currentSection) {
                case "Rooms":
                    // Szobák létrehozása
                    parts = line.split(" ");
                    String roomName = parts[0];
                    int isCursed = Integer.parseInt(parts[1]);
                    Room newRoom;
                    if (isCursed == 1) {
                        newRoom = new CursedRoom();
                    } else {
                        newRoom = new Room();
                    }
                    newRoom.name = roomName;
                    roomMap.put(roomName, newRoom);

                    if (isCursed == 1) {
                        cursedRooms.add((CursedRoom) newRoom);
                    }
                    rooms.add(newRoom);
                    break;

                case "Connections":
                    // Szobák közötti kapcsolatok beállítása
                    parts = line.split(" ");
                    String room1Name = parts[0];
                    String room2Name = parts[1];
                    boolean duplex = parts[2].equals("2");

                    Room room1 = roomMap.get(room1Name);
                    Room room2 = roomMap.get(room2Name);

                    if (room1 != null && room2 != null) {
                        initConnectRooms(room1, room2, duplex);
                    }
                    break;

                case "Characters":
                    // Karakterek létrehozása és szobákhoz való hozzárendelés
                    parts = line.split(" ");
                    String characterName = parts[0];
                    String characterType = parts[1];
                    roomName = parts[2];

                    Room room = roomMap.get(roomName);

                    if (room == null) {
                        System.err.println("Error: Room " + roomName + " not found.");
                        continue;
                    }

                    switch (characterType) {
                        case "S":
                            Student student = new Student();
                            students.add(student);
                            room.addCharacter(student);
                            characterMap.put(student.getName(), student);
                            break;
                        case "T":
                            Teacher teacher = new Teacher();
                            teachers.add(teacher);
                            room.addCharacter(teacher);
                            characterMap.put(teacher.getName(), teacher);
                            break;
                        case "C":
                            Cleaner cleaner = new Cleaner();
                            cleaners.add(cleaner);
                            room.addCharacter(cleaner);
                            characterMap.put(cleaner.getName(), cleaner);
                            break;
                        default:
                            System.err.println("Error: Unknown character type: " + characterType);
                            break;
                    }
                    break;

                case "Objects":
                // Tárgyak létrehozása és szobákhoz való hozzárendelés
                String[] objectParts = line.split(" ");
                String objectName = objectParts[0];
                String objectType = objectParts[1];
                boolean isFake =  objectParts[2].equals("1");

                Item newItem;
                

                switch (objectType) {
                    case "F":
                        newItem = new FFP2();
                        newItem.setType(isFake);
                        
                        break;
                    case "SR":
                        newItem = new SlideRule();
                        newItem.setType(isFake);
                        break;
                    case "WB":
                        newItem = new WunderBaum();
                        newItem.setType(isFake);
                        break;
                    case "TVSZ":
                        newItem = new TVSZ();
                        newItem.setType(isFake);
                        break;
                    case "CC":
                        newItem = new CamembertCheese();
                        newItem.setType(isFake);
                        break;
                    case "T":
                        newItem = new Transistor();
                        newItem.setType(isFake);
                        if (objectParts.length > 3 && !isFake) {
                            String pairTransistorName = objectParts[3];
                            
                            // Megkeressük az items listában, hogy megtalálható-e a másik tranzisztor
                            for (Using u : items) {
                                if (u instanceof Transistor && ((Transistor) u).getName().equals(pairTransistorName)) {
                                    newItem.pairing((Transistor) u); // Meghívja a pairing függvényt
                                    break;
                                }
                            }
                        }

                        break;
                    case "DR":
                        newItem = new DirtyRag();
                        newItem.setType(isFake);
                        break;
                    default:
                        System.err.println("Error: Unknown object type: " + objectType);
                        newItem = null;
                        break;
                }

                if (newItem != null) {
                    items.add(newItem);
                }
                break;
                case "ActivatedObjectsInRooms":
                // Szobákhoz hozzárendeli a tárgyakat
                String[] objectRoomParts = line.split(" ");
                roomName = objectRoomParts[0];

                Room current_room = roomMap.get(roomName);

                if (current_room == null) {
                    System.err.println("Error: Room " + roomName + " not found.");
                    continue;
                }

                for (int i = 1; i < objectRoomParts.length; i++) {
                    String itemName = objectRoomParts[i];

                    // Tárgy keresése az items listában
                    Item item = null;
                    for (Using u : items) {
                        if (u instanceof Item && ((Item) u).getName().equals(itemName)) {
                            item = (Item) u;
                            break;
                        }
                    }
                    if (item != null) {
                        item.activated=true; // aktiváljuk
                        current_room.addItem(item); // A szobába felvesszük a tárgyat
                    } else {
                        System.err.println("Error: Item " + itemName + " not found in items list.");
                    }
                }
                break;

                case "ObjectsInRooms":
                    // Szobákhoz hozzárendeli a tárgyakat
                    objectRoomParts = line.split(" ");
                    roomName = objectRoomParts[0];

                   current_room = roomMap.get(roomName);

                    if (current_room == null) {
                        System.err.println("Error: Room " + roomName + " not found.");
                        continue;
                    }

                    for (int i = 1; i < objectRoomParts.length; i++) {
                        String itemName = objectRoomParts[i];

                        // Tárgy keresése az items listában
                        Item item = null;
                        for (Using u : items) {
                            if (u instanceof Item && ((Item) u).getName().equals(itemName)) {
                                item = (Item) u;
                                break;
                            }
                        }

                        if (item != null) {
                            current_room.addItem(item); // A szobába felvesszük a tárgyat
                        } else {
                            System.err.println("Error: Item " + itemName + " not found in items list.");
                        }
                    }
                    break;

                    case "ObjectsCarriedByCharacters":
                    // Tárgyak hozzárendelése karakterekhez
                    String[] characterObjects = line.split(" ");
                    String charName = characterObjects[0];

                    Character this_character = characterMap.get(charName);

                    if (this_character == null) {
                        System.err.println("Error: Character " + charName + " not found.");
                        continue;
                    }

                    for (int i = 1; i < characterObjects.length; i++) {
                        String itemName = characterObjects[i];

                        // Tárgy keresése az items listában
                        Item item = null;
                        for (Using u : items) {
                            if (u.getName().equals(itemName)) {
                                item = (Item) u;
                                break;
                            }
                        }

                        if (item != null) {
                            this_character.add(item); // Hozzáadjuk a karakterhez
                        } else {
                            System.err.println("Error: Item " + itemName + " not found in items list.");
                        }
                    }
                    break;
            }
        }
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
     * A játékban lévő játékosokat adja vissza
     * @return játékban lévő játékosokat listája
     */
    public  List<Student> getStudents(){
        System.out.println("Function: Game class + getStudents Func");
        return students;
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
