package Model;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Program {
    private static Game game;
    /**
     * A program belépési pontja. Meghívja a főmenüt.
     * 
     * @param args parancssori argumentumok, amikben teszteseteket lehet megadni
     *
     * */
    public Program(Game jatek) {
        // Létrehoz egy új Game objektumot
        game = jatek;
        // Az elérési út a projekt mappájában lévő map.txt fájlhoz
        String filePath = "src\\Model\\map.txt";

        try {
            // Meghívja a buildGame függvényt a map.txt fájlon
            game.buildGame(filePath);

            System.out.println("A játék sikeresen felépült a " + filePath + " fájlból.");
            mainMenu();
        } catch (IOException e) {
            System.err.println("Hiba történt a játék építésekor: " + e.getMessage());
        }
    }

    /**
     * Főmenü
     */
    static void mainMenu(){
        int input = -1;
        List<Student> students = game.getStudents();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu");
        game.startGame();
        while (!game.win()) {
            for(int i=0;i<students.size();i++){
                System.out.println(students.get(i).getDescription());
                System.out.println("Lehetséges műveletek:");
                System.out.println("Mozgás másik szobába   1");
                System.out.println("Tárgy használata       2");
                System.out.println("Tárgy felvétele        3");
                System.out.println("Tárgy eldobása         4");
                
                input = scanner.nextInt();
                switch (input) {
                    case 1:
                        goToRoom(scanner, students.get(i));
                        break;
                    case 2:
                        useItem(scanner, students.get(i));
                        break;
                    case 3:
                        pickUpItem(scanner, students.get(i));
                        break;
                    case 4:
                        dropItem(scanner, students.get(i));
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Hibás bemenet: " + input);
                        break;
                }
                
            }
            game.incrementRound();
        }
        scanner.close();
        return;
    }

    /**
     * Tárgy használata menü
     * @param scanner a bemeneti adatok beolvasásához használt Scanner objektum
     * @param student az aktív hallgató
     */
    static void useItem(Scanner scanner, Student student) {
        int input = -1;

        while (input != 0) {
            for(int j=0; j<student.getInventory().size();j++){
                System.out.println("Inventory:");
                System.out.println(j+1+". "+student.getInventory().get(j).getName());
            }

            input = scanner.nextInt();
            if (input==0) break;
            if(input<=student.getInventory().size()){
                student.useItem(input-1, null);
                input=0;
            }
        }
    }

    /**
     * Tárgy felvétele menü
     * @param scanner a bemeneti adatok beolvasásához használt Scanner objektum
     * @param student az aktív hallgató
     */
    static void pickUpItem(Scanner scanner, Student student) {
        int input = -1;
        while (input != 0) {
            System.out.println("Felvehető tárgyak:");
            System.out.println(student.getRoom().getDescription());
            for(int j=0; j<student.getRoom().getItems().size();j++){
                
                System.out.println(j+1+". "+student.getRoom().getItems().get(j).getName());
            }

            input = scanner.nextInt();
            if (input==0) break;
            if(input<=student.getRoom().getItems().size()){
                if(student.pickUpItem(student.getRoom().getItems().get(input-1))){
                    System.out.println("Sikeresen felvetted a tárgyat");
                    System.out.println(student.getDescription());

                    input=0;
                }
                else {
                    System.out.println("Tele van az inventory-d, dobj el egy tárgyat ahhoz, hogy újat tudj felvenni!");
                    dropItem(scanner, student);
                }
            }
        }
    }

    /**
     * Tárgy eldobása menü
     * @param scanner a bemeneti adatok beolvasásához használt Scanner objektum
     * @param student az aktív hallgató
     */
    static void dropItem(Scanner scanner, Student student){
        int input = -1;
        while (input != 0){
            for(int j=0; j<student.getInventory().size();j++){
                System.out.println("Inventory:");
                System.out.println(j+1+". "+student.getInventory().get(j).getName());
            }
            
            input = scanner.nextInt();
            if (input==0) break;
            if(input<=student.getInventory().size()){
                student.dropItem(student.getInventory().get(input-1));
                input=0;
            }
        }
    }

    /**
     * Szobszédos szobába való közlekedés menü
     * @param scanner a bemeneti adatok beolvasásához használt Scanner objektum
     * @param student az aktív hallgató
     */
    static void goToRoom(Scanner scanner, Student student){
        int input = -1;
        while (input!=0){
            for(int j=0; j<student.getRoom().getNeighbours().size(); j++){
                System.out.println("A szomszédos szobák:");
                System.out.println(j+1+". "+student.getRoom().getNeighbours().get(j).getName());
            }
            System.out.println("Melyik szobába szeretnél átmenni?");
            input = scanner.nextInt();
            if (input==0) break;
            if(input<=student.getRoom().getNeighbours().size()){
                if(student.goToRoom(student.getRoom().getNeighbours().get(input-1))){
                    System.out.println("Sikeresen átmentél a szobába");
                    input = 0;
                }
                else System.out.println("A szoba tele van, válassz másikat!");
            }
        }
    }
    /*
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
    }*/
}
