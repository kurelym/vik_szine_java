package Model;

import java.util.Scanner;
import java.io.IOException;
public class Main {
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int mode;
        while (true) {
            System.out.println("Játék indítása - 1");
            System.out.println("Tesztek futtatása - 2");    
            if (scanner.hasNextInt()) {
                mode = scanner.nextInt();
                if (mode == 1 || mode == 2) {
                    break;
                } else {
                    System.err.println("Nem megfelelő input!\n");
                }
            } else {
                System.err.println("Nem megfelelő input!\n");
                scanner.next();
            }
        }

        switch (mode) {
            case 1:
                startGame(scanner);
                break;
            case 2:
                startTest(scanner);
                break;
        }

        scanner.close();
    }

    public static void startGame(Scanner scanner) {
        
        int studentCnt = 0;
        int teacherCnt = 0;
        int cleanerCnt = 0;
        String filePath = "src\\Model\\map.txt";
        Game game = new Game();
        try {
            
            game.buildGame(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int roomCnt = game.getRooms().size();

        try {
            game.buildGame(filePath);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Játékosok száma: ");
        while(!scanner.hasNextInt()) {
            System.err.println("Nem megfelelő input!\n");
            scanner.next();
        }

        studentCnt = scanner.nextInt();
        for(int i = 0; i < studentCnt; i++) {
            Student student = new Student(game.getRooms().get(0));  //A 0 indexű szoba mérete nagyobb kell legyen mint a játékosok max száma
            game.addStudent(student);
        }

        System.out.println("Oktatók száma: ");
        while(!scanner.hasNextInt()) {
            System.err.println("Nem megfelelő input!\n");
            scanner.next();
        }

        teacherCnt = scanner.nextInt();
        for(int i = 0; i < teacherCnt; i++) {
            Teacher teacher = new Teacher(game.getRooms().get(game.getRooms().size() - 1));
            game.addTeacher(teacher);
        }

        System.out.println("Takarítók száma: ");
        while(!scanner.hasNextInt()) {
            System.err.println("Nem megfelelő input!\n");
            scanner.next();
        }

        cleanerCnt = scanner.nextInt();
        for(int i = 0; i < cleanerCnt; i++) {
            Cleaner cleaner = new Cleaner(game.getRooms().get(game.getRooms().size() / 2));
            game.addCleaner(cleaner);
        }

        Program program = new Program(game);

    }

    public static void startTest(Scanner scanner) {
        //TODO Implemnt Test class and create and object here
    }
}
