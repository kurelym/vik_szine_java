package Model;

import java.util.Scanner;

public class SkeletonTest {
    
    public static void main(String[] args) {
        mainMenu();
    }

    static void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        int input = -1;
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
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Hibás bemenet: " + input);
                    break;
            }
        }
    }

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
                    break;
                case 2:
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Hibás bemenet: " + input);
                    break;
            }
        }
    }

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
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
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
