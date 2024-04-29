package Model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
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
        //System.out.println("Function: Game class consturctor Func");
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
                    //System.out.println("");
                    //System.out.println("-- Rooms --");
                    continue;
                case "-- Room Connections --":
                    currentSection = "Connections";
                    //System.out.println("");
                    //System.out.println("-- Room Connections --");
                    continue;
                case "-- Characters --":
                    currentSection = "Characters";
                    //System.out.println("");
                    //System.out.println("-- Characters --");
                    continue;
                case "-- Objects --":
                    currentSection = "Objects";
                    //System.out.println("");
                    //System.out.println("-- Objects --");
                    continue;
                case "-- Objects in Rooms --":
                    currentSection = "ObjectsInRooms";
                    //System.out.println("");
                    //System.out.println("-- Objects in Rooms --");
                    continue;
                case "-- Activated Objects in Rooms --":
                    currentSection = "ActivatedObjectsInRooms";
                    //System.out.println("");
                    //System.out.println("-- Activated Objects in Rooms --");
                    continue;
                case "-- Objects Carried by Characters --":
                    currentSection = "ObjectsCarriedByCharacters";
                    //System.out.println("");
                    //System.out.println("-- Objects Carried by Characters --");
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
                            Student student = new Student(room);
                            students.add(student);
                            room.addCharacter(student);
                            characterMap.put(student.getName(), student);
                            break;
                        case "T":
                            Teacher teacher = new Teacher(room);
                            teachers.add(teacher);
                            room.addCharacter(teacher);
                            characterMap.put(teacher.getName(), teacher);
                            break;
                        case "C":
                            Cleaner cleaner = new Cleaner(room);
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
                    case "H":
                        newItem = new HolyBeer();
                        newItem.setType(isFake);
                        break;
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
     * Ellenorzi, hogy valamely hallgato felvette-e a logarlecet
     */
    public boolean studentsWon() {
        for(Student student: students){
            if(student.isAlive()) {
                for(Using item : student.getInventory()) {
                    if(item.isRealSlideRule()) {
                        System.out.println("Hallgatók győztek, " + student.getName() + " megtalálta a Logarlécet!");
                        return true;    
                    }
                }
            }
        }
        return false;
    }

    public boolean teachersWon() {
        if(round > maxRounds) {
            return true;
        }
        for(Student s: students){
            if(s.isAlive()){
                return false;
            }
        }
        System.out.println("Oktatók győztek, minden hallgató kibukott az egyetemről!");
        return true;
    }


    /**
     * Noveli a kor szamat
     */
    public boolean incrementRound(boolean gameOver) {
        //System.out.println("Function: Game class + incrementRound() Func\n");
        if(teachersWon() || studentsWon()){
            gameOver = true;
            return gameOver;
        }
        Random random = new Random();

        for(Teacher teacher : teachers) {  //Végigmegyünk a játékban lévő tanárok listáján
            //Minden tanár véletlenszerűen választ szobát a tartózkodási szobájának szomszédai közül (neighbours(0, size-1))
            int i = random.nextInt(teacher.getRoom().getNeighbours().size());
            teacher.goToRoom(teacher.getRoom().getNeighbours().get(i));
            if(teacher.dazed) {
                System.out.println(teacher.getName() + " elkábult, kimarad egy körből!");
                teacher.dazed = false;
                continue;
            }
            System.out.println(teacher.getName() + " átment " + teacher.getRoom().getName() + "-ba");
            teacher.tryToKill();
            ArrayList<Student> removeable = new ArrayList<>();
            for(Student student : students) {
                if(!student.isAlive()) {
                    removeable.add(student);
                }
            }
            for(Student student : removeable) {
                students.remove(student);
            }
            if(teacher.getRoom().getItems().size() > 1) {
                Using randomItem = teacher.getRoom().getItems().get(random.nextInt(0, teacher.getRoom().getItems().size() - 1));
                teacher.pickUpItem(randomItem);
                System.out.println(teacher.getName() + " felvette a " + randomItem.getName() + "-t");
            } else if(teacher.getRoom().getItems().size() == 1) {
                Using item = teacher.getRoom().getItems().get(0);
                teacher.pickUpItem(item);
                System.out.println(teacher.getName() + " felvette a " + item.getName() + "-t");
            }
        }

        for(Cleaner cleaner : cleaners) {
            if(cleaner.getRoom().getNeighbours().size() == 1) {
                cleaner.goToRoom(cleaner.getRoom().getNeighbours().get(0));
            } else {
                cleaner.goToRoom(cleaner.getRoom().getNeighbours().get(random.nextInt(0, cleaner.getRoom().getNeighbours().size() - 1)));                
            }
            System.out.println(cleaner.getName() + " átment " + cleaner.getRoom().getName() + "-ba");
        }

        for(Using item : items) {
            if(item.getDurability() == 0) {
                item.decreaseDurability();  //Durability -1 == Item nem működik tovább
                if(item.getOwner() != null) {
                    item.getOwner().dropItem(item); //Automatikusan eldobja az elhasznált tárgyat
                    item.getLocation().removeItem(item);
                    items.remove(item);
                    item = null;
                } else {
                    item.getLocation().removeItem(item);
                    items.remove(item);
                    item = null;
                }
            } else {
                item.roundPassed();
            }
        }
        if(teachersWon() || studentsWon()){
            gameOver = true;
            return gameOver;
        }

        //manipulateRooms();

        round++;
        System.out.println("Kör: " + round);
        return gameOver;
    }


    /**
     * Hallgato hozzaadasa a jatekhoz
     * 
     * @param s hallgató
     */
    public void addStudent(Student s) {
        //System.out.println("Function: Game class + addStudent() Func");
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
        //System.out.println("Function: Game class + addTeacher() Func");
        if(!teachers.contains(t)){
            teachers.add(t);
        }
    }
    /**
     * Takarító hozzáadása a játékhoz
     * @param c takarító
     */
    public void addCleaner(Cleaner c){
        //System.out.println("Function: Game class + addCleaner() Func");
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
        //System.out.println("Function: Game class + removeStudent() Func");
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
        //System.out.println("Function: Game class + removeTeacher() Func");
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
        //System.out.println("Function: Game class + removeCleaner() Func");
        if(cleaners.contains(c)){
            cleaners.remove(c);
        }
    }
    /**
     * A játék elejen a labirintust epiti fel
     */
    public void initConnectRooms(Room r1, Room r2, boolean duplex) {
        //System.out.println("Function: Game class + initConnectRooms() Func");
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
        //System.out.println("Function: Game class + manipulateRooms() Func");
        for(CursedRoom cR:cursedRooms){
            cR.doorManipulation();
        }
        //TODO: Mivel komplexebb lesz az algoritmus, így összecsapni nem akartam, szóval adok egy pongyolább leírást:
        //Végig iterálunk a rooms listán és páratlan körben minden második szobára split-et hívunk, míg párosban merge-t a 
        //az adott szoba egyik szomszédjára. Most ez jó kérdés, hogy hogyan lesz meghatározva, de a mostani fázisba írjuk bele, 
        //hogy az első szomszédra, aztán majd ennél egy valamivel okosabb algoritmust kitalálunk mert ez ilyen ping pongos szar
        //SPLIT-NÉL KELL, hogy a GAME IS ÉRTESÜLJÖN RÓLA
        if(round%2==1){
            for(int i = 0; i < rooms.size() - 1; i += 2) {
                Room newRoom = rooms.get(i).Split();
                rooms.add(newRoom);
                System.out.println(rooms.get(i) + " osztódott, az új szoba: " + newRoom.getName() + " az alábbi tulajdonságokkal rendelkezik:\n" + newRoom.getDescription());
            }
        }
        else{
            for(int i = 0; i < rooms.size() - 1; i += 2) {
                if(rooms.get(i).getNeighbours().size() == 1) {
                    Room newRoom = rooms.get(i).getNeighbours().get(0);
                    rooms.get(i).Merge(newRoom);
                    System.out.println(rooms.get(i).getName() + " összeolvadt " + newRoom.getName() + "-el, a szoba új tulajdonságai: " + rooms.get(i).getDescription());
                    rooms.remove(newRoom);
                    newRoom = null;    
                } else if(rooms.get(i).getNeighbours().size() == 0) {
                    continue;
                } else {
                    Random random = new Random();
                    Room newRoom = rooms.get(i).getNeighbours().get(random.nextInt(0, rooms.get(i).getNeighbours().size()));
                    rooms.get(i).Merge(newRoom);
                    rooms.remove(newRoom);
                    System.out.println(rooms.get(i).getName() + " összeolvadt " + newRoom.getName() + "-el, a szoba új tulajdonságai: " + rooms.get(i).getDescription());
                    newRoom = null;    
                }
            }
        }
    }

    public List<Room> getRooms() { return rooms; }
    /**
     * A játékban lévő játékosokat adja vissza
     * @return játékban lévő játékosok listája
     */
    public List<Student> getStudents(){
        //System.out.println("Function: Game class + getStudents Func");
        return students;
    }

    public List<Teacher> getTeachers(){
        //System.out.println("Function: Game class + getStudents Func");
        return teachers;
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
        return "Round:  "+round +"\nGameState:\n"+room+" "+roomC+" "+stuff+" "+membersS+" "+membersT+" "+membersC;
       
    }
}
