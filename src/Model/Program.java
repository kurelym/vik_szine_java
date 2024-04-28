package Model;

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
    public Program(Game _game) {
        // Átadja a kapott game objektumot a sajátjának
        game = _game;
        // A mainMenu vezérli a játékot
        mainMenu();
    }

    /**
     * Főmenü
     */
    private static void mainMenu() {
        int input = -1;
        boolean gameOver = false;
        boolean roundOver = false;
        List<Student> students = game.getStudents();
        Scanner scanner = new Scanner(System.in);
        System.out.println(game.getDescription() + "\n");
        while (!gameOver) {
            for(int i=0;i<students.size();i++){
                if(!students.get(i).dazed) {
                    while(!roundOver) {

                        System.out.println();
                        System.out.println(students.get(i).getName() + " jön");
                        System.out.println("Lehetséges műveletek:");
                        System.out.println("Mozgás másik szobába   1");
                        System.out.println("Tárgy használata       2");
                        System.out.println("Tárgy felvétele        3");
                        System.out.println("Tárgy eldobása         4");
                        System.out.println("Tárgyaim listázása     5");
                        System.out.println("Körbenézés a szobában  6");
                        
                        input = scanner.nextInt();
                        switch (input) {
                            case 1:
                                roundOver = goToRoom(scanner, students.get(i));
                                break;
                            case 2:
                                roundOver = useItem(scanner, students.get(i));
                                break;
                            case 3:
                                roundOver = pickUpItem(scanner, students.get(i));
                                break;
                            case 4:
                                roundOver = dropItem(scanner, students.get(i));
                                break;
                            case 5:
                                System.out.println("Inventory:");
                                for(Using item : students.get(i).inventory) {
                                    System.out.println(item.getName());
                                }
                                roundOver = false;
                                break;
                            case 6:
                                System.out.println(students.get(i).getRoom().getDescription());
                                roundOver = false;
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Hibás bemenet: " + input);
                                break;
                        }   
                    }
                } else {
                    System.out.println(students.get(i).getName() + " el vagy kábulva, kimaradsz egy körből");
                    students.get(i).dazed = false;
                }
                
                roundOver = false;
            }
            gameOver = game.incrementRound(gameOver);
        }
        scanner.close();
        return;
    }

    /**
     * Tárgy használata menü
     * @param scanner a bemeneti adatok beolvasásához használt Scanner objektum
     * @param student az aktív hallgató
     */
    static boolean useItem(Scanner scanner, Student student) {
        boolean roundOver = false;
        int useableCnt = 0;
        int input = -1;

        while (input != 0) {
            System.out.println("Inventory:");
            for(int j=0; j<student.getInventory().size();j++){
                if(student.getInventory().get(j).useable()) {
                    System.out.println(j+1+". "+student.getInventory().get(j).getName());
                    useableCnt++;
                }
            }

            System.out.println("0. Mégse");
            input = scanner.nextInt();
            if (input==0) {
                roundOver = false;
                return roundOver;
            }
            if(input<=useableCnt){
                student.useItem(input-1, null);
                roundOver = true;
                input=0;
            }
        }
        return roundOver;
    }

    /**
     * Tárgy felvétele menü
     * @param scanner a bemeneti adatok beolvasásához használt Scanner objektum
     * @param student az aktív hallgató
     */
    static boolean pickUpItem(Scanner scanner, Student student) {
        boolean roundOver = false;
        int input = -1;
        while (input != 0) {
            /*System.out.println("Felvehető tárgyak:");
            System.out.println(student.getRoom().getDescription());
            for(int j=0; j<student.getRoom().getItems().size();j++){
                System.out.println(j+1+". "+student.getRoom().getItems().get(j).getName());
            }*/
            for(int j=0;j<student.getRoom().getItems().size();j++){
                System.out.println(j+1+". "+student.getRoom().getItems().get(j).getName());
            }

            System.out.println("0. Mégse");
            input = scanner.nextInt();
            if (input==0) {
                roundOver = false;
                return roundOver;
            }
            //System.out.println(student.getRoom().getDescription());
            if(input<=student.getRoom().getItems().size()){
                if(student.pickUpItem(student.getRoom().getItems().get(input-1))){
                    System.out.println("\nSikeresen felvetted a tárgyat\n");
                    roundOver = true;
                    input=0;
                }
                else {
                    System.out.println("Tele van az inventory-d, dobj el egy tárgyat ahhoz, hogy újat tudj felvenni!");
                    roundOver = false;
                    return roundOver;
                }
            }
        }
        return roundOver;
    }

    /**
     * Tárgy eldobása menü
     * @param scanner a bemeneti adatok beolvasásához használt Scanner objektum
     * @param student az aktív hallgató
     */
    static boolean dropItem(Scanner scanner, Student student){
        boolean roundOver = false;
        int input = -1;
        while (input != 0){
            System.out.println("Inventory:");
            for(int j=0; j<student.getInventory().size();j++){
                System.out.println(j+1+". "+student.getInventory().get(j).getName());
            }
            System.out.println("0. Mégse");
            input = scanner.nextInt();
            if (input==0) {
                roundOver = false;
                return roundOver;
            }
            if(input<=student.getInventory().size()){
                student.dropItem(student.getInventory().get(input-1));
                roundOver = true;
                input=0;
                return roundOver;
            }
        }
        return roundOver;
    }

    /**
     * Szobszédos szobába való közlekedés menü
     * @param scanner a bemeneti adatok beolvasásához használt Scanner objektum
     * @param student az aktív hallgató
     */
    static boolean goToRoom(Scanner scanner, Student student){
        boolean roundOver = false;
        int input = -1;
        while (input!=0){
            System.out.println("Melyik szobába szeretnél átmenni:");
            for(int j=0; j<student.getRoom().getNeighbours().size(); j++){
                System.out.println(j+1+". "+student.getRoom().getNeighbours().get(j).getName());
            }
            System.out.println("0. Mégse");
            input = scanner.nextInt();
            if (input==0) {
                roundOver = false;
                return roundOver;
            }
            if(input<=student.getRoom().getNeighbours().size()){
                if(student.goToRoom(student.getRoom().getNeighbours().get(input-1))){
                    System.out.println("\nSikeresen átmentél a szobába\n");
                    if(!student.getRoom().getCharacters().isEmpty()) {
                        for(Character character : student.getRoom().getCharacters()) {
                            if(character.isTeacher()) {
                                student.teacherAttack();
                                System.out.println(character.getName() + " megtámadta " + student.getName() + "-t");
                            }
                        }
                    }
                    roundOver = true;
                    input = 0;
                    return roundOver;
                }
                else {
                    System.out.println("\nA szoba tele van, válassz másikat!\n");
                    roundOver = false;
                    return roundOver;
                }
            }
        }
        return roundOver;
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
