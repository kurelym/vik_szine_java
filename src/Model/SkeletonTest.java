package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SkeletonTest { 

    private Game game = new Game();
    private Character teacher = new Teacher();
    private Character student = new Student();
    private Room room1 = new Room();
    private Room room2 = new Room();
    private Room room3 = new Room();
    private Room room4 = new Room();
    private Room room5 = new Room();
    private Room room6 = new Room();

    private Using item = new TVSZ();

    /**
     * A program belépési pontja. Meghívja a főmenüt.
     * @param args parancssori argumentumok, amikben teszteseteket lehet megadni
     */
    public static void main(String[] args) {
        mainMenu(args);
    }

    /**
     * Főmenü megjelenítése és vezérlése.
     */
    static void mainMenu(String[] args) {
        int input = -1;
        Scanner scanner = new Scanner(System.in);

        if(args.length > 0) {
            String filePath = args[0];

            try {
                File file = new File(filePath);
                scanner = new Scanner(file);

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                    //TODO: File kezelés
                }
            } catch (FileNotFoundException e) {
            System.err.println("A fájl nem található: " + filePath);
            e.printStackTrace();
            } 
        }
        while(input != 0) {
            System.out.println("Hallgató mód       1");
            System.out.println("Oktató mód         2");
            System.out.println("Pályamanipuláció   3");
            System.out.println("Kilépés            0");

            input = scanner.nextInt();
            switch(input) {
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
     * @param scanner a bemeneti adatok beolvasásához használt Scanner objektum
     */
    static void studentMenu(Scanner scanner) {
        int input = -1;
        while(input != 0) {
            System.out.println("      Hallgató mód\n");
            System.out.println("Mozgás másik szobába   1");
            System.out.println("Tárgy használata       2");
            System.out.println("Tárgy felvétele        3");
            System.out.println("Vissza                 0");

            input = scanner.nextInt();
            switch(input) {
                case 1:
                    //TODO
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
     * @param scanner a bemeneti adatok beolvasásához használt Scanner objektum
     */
    static void teacherMenu(Scanner scanner) {
        int input = -1;
        while(input != 0) {
            System.out.println("      Oktató mód\n");
            System.out.println("Mozgás másik szobába   1");
            System.out.println("Tárgy felvétel         2");
            System.out.println("Vissza                 0");

            input = scanner.nextInt();
            switch(input) {
                case 1:
                    //TODO
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
     * @param scanner a bemeneti adatok beolvasásához használt Scanner objektum
     */
    static void roomMenu(Scanner scanner) {
        int input = -1;
        
        while(input != 0) {
            System.out.println("      Pályamanipuláció\n");
            System.out.println("Két szoba összeolvadása      1");
            System.out.println("Szoba szétválasztása         2");
            System.out.println("Ajtók manipulálása           3");
            System.out.println("Szobák szomszédossá tétele   4");
            System.out.println("Vissza                       0");

            input = scanner.nextInt();
            switch(input) {
                case 1:
                    //TODO
                    break;
                case 2:
                    //TODO
                    break;
                case 3:
                    //TODO
                    break;
                case 4:
                    //TODO
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
     * @param scanner a bemeneti adatok beolvasásához használt Scanner objektum
     */
    static void useItem(Scanner scanner) {
        int input = -1;
        
        while(input != 0) {
            System.out.println("      Tárgy használata\n");
            System.out.println("Káposztás camembert felbontása       1");
            System.out.println("Nedves táblatörlőrongy elhelyezése   2");
            System.out.println("Tranzisztor használata               3");
            System.out.println("Vissza                               0");

            input = scanner.nextInt();
            switch(input) {
                case 1:
                    //TODO
                    break;
                case 2:
                    //TODO
                    break;
                case 3:
                    //TODO
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
     * @param scanner a bemeneti adatok beolvasásához használt Scanner objektum
     */
    static void pickUpItem(Scanner scanner) {
        int input = -1;
        
        while(input != 0) {
            System.out.println("      Tárgy felvétele\n");
            System.out.println("Szent söröspohár felvétele   1");
            System.out.println("Logarléc felvétele           2");
            System.out.println("Vissza                       0");

            input = scanner.nextInt();
            switch(input) {
                case 1:
                    //TODO
                    break;
                case 2:
                    //TODO
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Hibás bemenet: " + input);
                    break;
            }
        }
    }


}
