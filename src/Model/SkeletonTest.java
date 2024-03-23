package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.ListDataEvent;
import java.util.Timer;
import java.util.TimerTask;
public class SkeletonTest {

    static Game game = new Game();

    static Teacher teacher = new Teacher();
    static Student student = new Student();

    private static List<Character> list = new ArrayList<>();

    private static Room room1 = new Room();
    private static Room room2 = new Room();
    private static Room room3 = new Room();
    private static Room room4 = new Room();
    private static Room room5 = new Room();
    private static CursedRoom cursedroom = new CursedRoom();

    private static TVSZ tvsz = new TVSZ();
    private static SlideRule sliderule = new SlideRule();
    private static HolyBeer holybeer = new HolyBeer();
    private static FFP2 ffp2 = new FFP2();
    private static CamembertCheese camembertcheese = new CamembertCheese();
    private static Transistor transistor1 = new Transistor();
    private static Transistor transistor2 = new Transistor();
    private static DirtyRag dirtyrag = new DirtyRag();

    /**
     * A program belépési pontja. Meghívja a főmenüt.
     * 
     * @param args parancssori argumentumok, amikben teszteseteket lehet megadni
     */
    public static void main(String[] args) {
        mainMenu(args);
        list.add(teacher);
        list.add(student);

    }

    /**
     * Főmenü megjelenítése és vezérlése.
     */
    static void mainMenu(String[] args) {
        int input = -1;
        Scanner scanner = new Scanner(System.in);

        if (args.length > 0) {
            String filePath = args[0];

            try {
                File file = new File(filePath);
                scanner = new Scanner(file);

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                    // TODO: File kezelés
                }
            } catch (FileNotFoundException e) {
                System.err.println("A fájl nem található: " + filePath);
                e.printStackTrace();
            }
        }

        while (input != 0) {
            System.out.println("Hallgató mód       1");
            System.out.println("Oktató mód         2");
            System.out.println("Pályamanipuláció   3");
            System.out.println("Kilépés            0");

            input = scanner.nextInt();
            switch (input) {
                case 1:
                    studentMenu(scanner);
                    break;
                case 2:
                    teacherMenu(scanner);
                    break;
                case 3:
                    roomMenu(scanner);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Hibás bemenet: " + input);
                    break;
            }
        }
        scanner.close(); // Scanner bezárása
        return;
    }

    /**
     * Hallgatói menü megjelenítése és vezérlése.
     * 
     * @param scanner a bemeneti adatok beolvasásához használt Scanner objektum
     */
    static void studentMenu(Scanner scanner) {
        int input = -1;
        while (input != 0) {
            System.out.println("      Hallgató mód\n");
            System.out.println("Mozgás másik szobába   1");
            System.out.println("Tárgy használata       2");
            System.out.println("Tárgy felvétele        3");
            System.out.println("Vissza                 0");

            input = scanner.nextInt();
            switch (input) {
                case 1:
                    student.goToRoom(room1);
                    break;
                case 2:
                    useItem(scanner);
                    break;
                case 3:
                    pickUpItem(scanner);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Hibás bemenet: " + input);
                    break;
            }
        }
    }

    /**
     * Oktatói menü megjelenítése és vezérlése.
     * 
     * @param scanner a bemeneti adatok beolvasásához használt Scanner objektum
     */
    static void teacherMenu(Scanner scanner) {
        int input = -1;
        while (input != 0) {
            System.out.println("      Oktató mód\n");
            System.out.println("Mozgás másik szobába   1");
            System.out.println("Tárgy felvétel         2");
            System.out.println("Vissza                 0");

            input = scanner.nextInt();
            switch (input) {
                case 1:
                    teacher.goToRoom(room1);
                    break;
                case 2:
                    pickUpItem(scanner);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Hibás bemenet: " + input);
                    break;
            }
        }
    }

    /**
     * Pályamanipulációs menü megjelenítése és vezérlése.
     * 
     * @param scanner a bemeneti adatok beolvasásához használt Scanner objektum
     */
    static void roomMenu(Scanner scanner) {
        int input = -1;

        while (input != 0) {
            System.out.println("      Pályamanipuláció\n");
            System.out.println("Két szoba összeolvadása      1");
            System.out.println("Szoba szétválasztása         2");
            System.out.println("Ajtók manipulálása           3");
            System.out.println("Szobák szomszédossá tétele   4");
            System.out.println("Vissza                       0");

            input = scanner.nextInt();
            switch (input) {
                case 1:
                    mergeRoomsTest(scanner);
                    break;
                case 2:
                    splitRoomTest(scanner);
                    break;
                case 3:
                    doorManipulation(scanner);
                    break;
                case 4:
                    createAdjacencies(scanner);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Hibás bemenet: " + input);
                    break;
            }
        }
    }

    /**
     * Tárgy használat menü megjelenítése és vezérlése.
     * 
     * @param scanner a bemeneti adatok beolvasásához használt Scanner objektum
     */
    static void useItem(Scanner scanner) {
        int input = -1;

        while (input != 0) {
            System.out.println("      Tárgy használata\n");
            System.out.println("Káposztás camembert felbontása       1");
            System.out.println("Nedves táblatörlőrongy elhelyezése   2");
            System.out.println("Tranzisztor használata               3");
            System.out.println("Vissza                               0");

            input = scanner.nextInt();
            switch (input) {
                case 1:
                    student.useItem(camembertcheese);
                    camembertcheese.useIt();
                    room1.addItem(camembertcheese);
                    break;
                case 2:
                    student.useItem(dirtyrag);
                    dirtyrag.useIt();
                    room1.addItem(dirtyrag);
                    break;
                case 3:
                    transistorTest();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Hibás bemenet: " + input);
                    break;
            }
        }
    }

    /**
     * Tárgy felvétel menü megjelenítése és vezérlése.
     * 
     * @param scanner a bemeneti adatok beolvasásához használt Scanner objektum
     */
    static void pickUpItem(Scanner scanner) {
        int input = -1;

        while (input != 0) {
            System.out.println("      Tárgy felvétele\n");
            System.out.println("Szent söröspohár felvétele   1");
            System.out.println("Logarléc felvétele           2");
            System.out.println("Vissza                       0");

            input = scanner.nextInt();
            switch (input) {
                case 1:
                    holyBeerTest(scanner);
                    break;
                case 2:
                    slideRuleTest(scanner);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Hibás bemenet: " + input);
                    break;
            }
        }
    }

    static void transistorTest() {
        student.pickUpItem(transistor1);
        student.pickUpItem(transistor2);
        transistor1.pairing(transistor2);
        student.dropItem(transistor1);
        room1.addItem(transistor1);
        student.goToRoom(room2);
        room1.removeCharacter(student);
        room2.addCharacter(student);
        student.dropItem(transistor2);
        room2.addItem(transistor2);
        student.goToRoom(room1);
        room2.removeCharacter(student);
        room1.addCharacter(student);
        transistor1.removePair();
        transistor2.removePair();
    }

    static void holyBeerTest(Scanner scanner) {
        int hasEnoughSpace = -1;
        System.out.println("Van elegendő hely a táskában? Yes: 1, No: 0");
        hasEnoughSpace = scanner.nextInt();
        if(hasEnoughSpace==1){
            student.pickUpItem(holybeer);
            for(int i = 0; i< 3; i++){
                holybeer.roundPassed();
            }
            System.out.println("Elhasználódott a Szentsöröspohár");
        }
        else{
            System.out.println("Tele van a bag");
        }
    }
    static void slideRuleTest(Scanner scanner){
        student.pickUpItem(sliderule);
        game.win();
        student.hasTheSlideRule();
        sliderule.finishGame();
                    
    }

    static void mergeRoomsTest(Scanner scanner){
        game.manipulateRooms();
        room1.Merge(room2);
        room1.removeNeighbour(room2);
        room2.removeNeighbour(room1);
    }

    static void splitRoomTest(Scanner scanner){
        game.manipulateRooms();
        room3 = room1.Split();
        room3.addNeighbour(room1);
        room1.addNeighbour(room3);
    }

    static void doorManipulation(Scanner scanner){
        int hidden;
        System.out.println("Láthatóak az ajtajai a szobának? Igen: 1 Nem: 0");
        hidden = scanner.nextInt();
        if (hidden == 1){
            cursedroom.doorManipulation();
            cursedroom.removeNeighbour(room1);
            room1.removeNeighbour(cursedroom);
        }
        else if (hidden == 0){
            cursedroom.doorManipulation();
            cursedroom.addNeighbour(room1);
            room1.addNeighbour(cursedroom);
        }
    }

    static void createAdjacencies(Scanner scanner){
            room4.addNeighbour(room5);
            room5.addNeighbour(room4);
    }
}
