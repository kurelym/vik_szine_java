package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class SkeletonTest {

    private static Game game = new Game();

    private static Teacher teacher = new Teacher();
    private static Student student = new Student();

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
            System.out.println("      vik_szine_java\n");
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
                case 0:
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
                    studentGoToRoomTest(scanner);
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
            System.out.println("Hallgató megtámadás    3");
            System.out.println("Vissza                 0");

            input = scanner.nextInt();
            switch (input) {
                case 1:
                    teacherGotoRoomTest(scanner);
                    break;
                case 2:
                    teacherPickUpItem(scanner);
                    break;
                case 3:
                    teacherAttackTest(scanner);
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
                mergeRoomsTest();
                    break;
                case 2:
                splitRoomTest();
                    break;
                case 3:
                doorManipulation(scanner);
                    break;
                case 4:
                createAdjacencies();
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
                    camembertcheeseTest(scanner);
                    break;
                case 2:
                    dirtyragTest(scanner);
                    break;
                case 3:
                    transistorTest(scanner);
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
    /*
     * Kristóf
     */
    static void teacherGotoRoomTest(Scanner scanner){
        teacher.goToRoom(room1);
        room1.addCharacter(teacher);
        int hasEnoughSpace = -1;
        System.out.println("Van elegendő hely szobában? Igen: 1, Nem: 0");
        hasEnoughSpace = scanner.nextInt();
        if(hasEnoughSpace==1){
            //van hely a szobában
            int gas = -1;
            System.out.println("Van gáz a szobában? Igen: 1, Nem: 0");
            gas = scanner.nextInt();
            if(gas==1){
                //van gáz
                camembertcheese.daze(teacher);
                teacher.gasAttack();
                int mask = -1;
                System.out.println("Van a tanárnál FFP2-es maszk? Igen: 1, Nem: 0");
                mask = scanner.nextInt();
                if(mask == 1){
                    //van maszk
                    ffp2.useAgainstGas();
                    int rag = -1;
                    System.out.println("Van dirtyrag a szobában? Igen: 1, Nem: 0");
                    rag = scanner.nextInt();
                    if(rag==1){
                        dirtyrag.daze(teacher);
                        teacher.ragAttack();
                        System.out.println("A tanár ebben a körben nem támad");
                    }
                    else if(rag==0){
                        teacher.tryToKill(room1);
                        System.out.println("A tanár támad");
                    }
                    else{
                        System.out.println("Hibás bemenet: "+rag);
                    }
                }
                else if(mask==0){
                    //nincs maszk
                    teacher.dropAllItem();
                    System.out.println("A tanár behorpadt");
                }
                else{
                    System.out.println("Hibás bemenet: "+mask);
                }
            }
            else if(gas==0){
                int rag = -1;
                    System.out.println("Van dirtyrag a szobában? Igen: 1, Nem: 0");
                    rag = scanner.nextInt();
                    if(rag==1){
                        dirtyrag.daze(teacher);
                        teacher.ragAttack();
                        System.out.println("A tanár ebben a körben nem támad");
                    }
                    else if(rag==0){
                        teacher.tryToKill(room1);
                        System.out.println("A tanár támad");
                    }
                    else{
                        System.out.println("Hibás bemenet: "+rag);
                    }
                
            }
            else{
                System.out.println("Hibás bemenet: "+gas);
            }
        }
        else if(hasEnoughSpace==0){
            //nincs hely a szobában
            System.out.println("A szoba tele van.");
            return;
        }
        else{
            System.out.println("Hibás bemenet: "+hasEnoughSpace);
        }
    }
    static void teacherPickUpItem(Scanner scanner){
        int hasEnoughSpace = -1;
        System.out.println("Van-e elegendő hely a táskában? Igen: 1, Nem: 0");
        hasEnoughSpace = scanner.nextInt();
        if(hasEnoughSpace==1){
            teacher.pickUpItem(camembertcheese);
            System.out.println("A tanár felvett egy tárgyat");
        }
        else if(hasEnoughSpace==0){
            Using lastItemInTheBag = new CamembertCheese();
            teacher.dropItem(lastItemInTheBag);
            teacher.pickUpItem(camembertcheese);
            System.out.println("A tanár felvett egy tárgyat, miután kidobta a táskájából a legrégebben felvett tárgyat");
        }
        else{
            System.out.println("Hibás bemenet: "+hasEnoughSpace);
        }
    }
    static void teacherAttackTest(Scanner scanner){
        teacher.tryToKill(room1);
        int anyoneInTheRoom = -1;
        System.out.println("Van-e hallgató a szobában? Igen: 1, Nem: 0");
        anyoneInTheRoom = scanner.nextInt();
        if(anyoneInTheRoom==1){
            student.teacherAttack();
            int protect = -1;
            System.out.println("Van-e a hallgatónál TVSZ? Igen: 1, Nem: 0");
            protect = scanner.nextInt();
            if(protect == 1){
                tvsz.useAgainstTeacher();
                tvsz.roundPassed();
                System.out.println("A hallgató kivédte a támadást");
            }
            else if(protect == 0){
                System.out.println("Van-e a hallgatónál aktív holybeer? Igen: 1, Nem: 0");
                protect = scanner.nextInt();
                if(protect==1){
                    holybeer.useAgainstTeacher();
                    System.out.println("A hallgató kivédte a támadást");
                }
                else if(protect==0){
                    game.decreasePlayerNumber();
                    System.out.println("A hallgató nem tudta kivédeni a támadást");
                }
                else{
                    System.out.println("Hibás bemenet: "+protect);
                }
            }
            else{
                System.out.println("Hibás bemenet: "+protect);
            }
        }
        else if(anyoneInTheRoom==0){
            System.out.println("Nem történ érdemi támadás");
        }
        else{
            System.out.println("Hibás bemenet: "+anyoneInTheRoom);
        }
    }
    /*
     * Bálint
     */
    static void camembertcheeseTest(Scanner scanner){
        int next = -1;
        System.out.println("Aktiválódjon a camembertcheese? Igen: 1, Nem: 0");
        next = scanner.nextInt();
        if(next==1){
        student.useItem(camembertcheese);
        camembertcheese.useIt();
        room1.addItem(camembertcheese);
        }
        else if(next==0){
            System.out.println("A camembertcheese a táskában maradt");
            return;
        }
        else{
            System.out.println("Hibás bemenet: "+next);
        }
    }
    static void dirtyragTest(Scanner scanner){
        int next = -1;
        System.out.println("Aktiválódjon a nedves táblatörlőrongy? Igen: 1, Nem: 0");
        next = scanner.nextInt();
        if(next==1){
            student.useItem(dirtyrag);
            dirtyrag.useIt();
            room1.addItem(dirtyrag);
        }
        else if(next==0){
            System.out.println("A nedves táblatörlőrongy a táskában maradt");
            return;
        }
        else{
            System.out.println("Hibás bemenet: "+next);
        }
    }
    static void transistorTest(Scanner scanner) {
        int next = -1;
        int numberOfActivatedTransistors = 0;
        while (next!=1) {
        System.out.println("Párosítsuk a tranzisztorokat? Igen: 1, Nem: 0");
        next = scanner.nextInt();
        if(next==1){
            transistor1.pairing(transistor2);
            transistor2.pairing(transistor1);
        }
        else if(next==0){
            System.out.println("Nem történt semmi");
        }
        else{
            System.out.println("Hibás bemenet: "+next);
        }
        }
        while(numberOfActivatedTransistors!=2){
            System.out.println("Transzitor elhelyezése az aktuális szobában? Igen: 1, Nem: 0");
            next = scanner.nextInt();
            if(next==1){
                if(numberOfActivatedTransistors ==0){
                student.dropItem(transistor1);
                room1.addItem(transistor1);
                numberOfActivatedTransistors++;
                System.out.println("Az aktivált tranzisztorok száma: "+numberOfActivatedTransistors);
                }
                else if( numberOfActivatedTransistors == 1){
                    numberOfActivatedTransistors++;
                    student.dropItem(transistor2);
                    room2.addItem(transistor2);
                    student.goToRoom(room1);
                    room2.removeCharacter(student);
                    room1.addCharacter(student);
                    transistor1.removePair();
                    transistor2.removePair();
                    System.out.println("TELEPORT");
                }
            }
            else if(next==0){
                System.out.println("Az aktuális szoba elhagyása? Igen: 1, Nem: 0");
                next = scanner.nextInt();
                if(next==1){
                    student.goToRoom(room2);
                    room1.removeCharacter(student);
                    room2.addCharacter(student);
                }
                else if(next==0){
                    System.out.println("Nem történt semmi");
                }
            }
            else{
                System.out.println("Hibás bemenet: "+next);
            }
        }
    }
    static void holyBeerTest(Scanner scanner) {
        int hasEnoughSpace = -1;
        System.out.println("Van elegendő hely a táskában? Igen: 1, Nem: 0");
        hasEnoughSpace = scanner.nextInt();
        if(hasEnoughSpace==1){
            student.pickUpItem(holybeer);
            holybeer.useIt();
            for(int i = 0; i< 3; i++){
                holybeer.roundPassed();
                System.out.println("Még védve vagy a tanárokkal szemben");
            }
            System.out.println("Elhasználódott a Szentsöröspohár");
        }
        else if(hasEnoughSpace==0){
            System.out.println("Tele van a bag");
        }
        else{
            System.out.println("Hibás bemenet: "+hasEnoughSpace);
        }
    }
    static void slideRuleTest(Scanner scanner){
        int hasEnoughSpace = -1;
        System.out.println("Van elegendő hely a táskában? Igen: 1, Nem: 0");
        hasEnoughSpace = scanner.nextInt();
        if(hasEnoughSpace==1){
            student.pickUpItem(sliderule);
            game.win();
            student.hasTheSlideRule();
            sliderule.finishGame();
            System.out.println("Nyertél öcsipók!!!");
        }
        else if(hasEnoughSpace==0){
            System.out.println("Tele van a bag");
        }
        else{
            System.out.println("Hibás bemenet: "+hasEnoughSpace);
        }     
    }

    /*
     * András
     */
    static void mergeRoomsTest(){
        game.manipulateRooms();
        room1.Merge(room2);
        room1.removeNeighbour(room2);
        room2.removeNeighbour(room1);
    }

    static void splitRoomTest(){
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

    static void createAdjacencies(){
            room4.addNeighbour(room5);
            room5.addNeighbour(room4);
    }
    /*
     * Mózes
     */
    static void studentGoToRoomTest(Scanner scanner){
        student.goToRoom(room1);
        room1.addCharacter(student);
        int hasEnoughSpace = -1;
        System.out.println("Van elegendő hely szobában? Igen: 1, Nem: 0");
        hasEnoughSpace = scanner.nextInt();
        if(hasEnoughSpace==1){
            //van hely a szobában
            int gas = -1;
            System.out.println("Van gáz a szobában? Igen: 1, Nem: 0");
            gas = scanner.nextInt();
            if(gas==1){
                //van gáz
                camembertcheese.daze(student);
                student.gasAttack();
                int mask = -1;
                System.out.println("Van a hallgatónál FFP2-es maszk? Igen: 1, Nem: 0");
                mask = scanner.nextInt();
                if(mask == 1){
                    //van maszk
                    ffp2.useAgainstGas();
                    System.out.println("A Hallgató rendben megérkezett");
                }
                else if(mask==0){
                    //nincs maszk
                    student.dropAllItem();
                    System.out.println("A Hallgató behorpadt");
                }
                else{
                    System.out.println("Hibás bemenet: "+mask);
                }
            }
            else if(gas==0){
                //nincs gáz
                System.out.println("A Hallgató rendben megérkezett");
            }
            else{
                System.out.println("Hibás bemenet: "+gas);
            }
        }
        else if(hasEnoughSpace==0){
            //nincs hely a szobában
            System.out.println("A szoba tele van.");
            return;
        }
        else{
            System.out.println("Hibás bemenet: "+hasEnoughSpace);
        }
    }
}
