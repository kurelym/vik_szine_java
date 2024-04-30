package Model;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
public class Main {
    
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        if (args.length > 0) {
            startTest(args);
        } else {
            startGame(scanner);
        }

        scanner.close();
    }

    public static void startGame(Scanner scanner) throws IOException {
        
        int studentCnt = 0;
        int teacherCnt = 0;
        int cleanerCnt = 0;
        String filePath = "src\\Model\\map.txt";
        Game game = new Game();
        game.buildGame(filePath);

        System.out.println("Játékosok száma: ");
        while(!scanner.hasNextInt()) {
            System.err.println("Nem megfelelő input!\n");
            scanner.next();
        }

        studentCnt = scanner.nextInt();
        for(int i = 0; i < studentCnt; i++) {
            Student student = new Student(game.getRooms().get(0),null);
            game.addStudent(student);
        }

        System.out.println("Oktatók száma: ");
        while(!scanner.hasNextInt()) {
            System.err.println("Nem megfelelő input!\n");
            scanner.next();
        }

        teacherCnt = scanner.nextInt();
        for(int i = 0; i < teacherCnt; i++) {
            Teacher teacher = new Teacher(game.getRooms().get(game.getRooms().size() - 1),null);
            game.addTeacher(teacher);
        }

        System.out.println("Takarítók száma: ");
        while(!scanner.hasNextInt()) {
            System.err.println("Nem megfelelő input!\n");
            scanner.next();
        }

        cleanerCnt = scanner.nextInt();
        for(int i = 0; i < cleanerCnt; i++) {
            Cleaner cleaner = new Cleaner(game.getRooms().get(game.getRooms().size() / 2),null);
            game.addCleaner(cleaner);
        }

        Program program = new Program(game);
        program.mainMenu();

    }

    public static void startTest(String[] args) {
        String initFilePath = args[0];
        String inputFilePath = args[1];
        String outputFilePath = args[2];

        try (PrintStream fileOutput = new PrintStream(new FileOutputStream(outputFilePath, false))) {
            Game game = new Game(fileOutput);
            try {
                game.buildGame(initFilePath);
            } catch (IOException e) {
                fileOutput.println("Hiba történt az init.txt beolvasása közben: " + e.getMessage());
            }

            try {
                List<String> linesList = Files.readAllLines(Path.of(inputFilePath));
                for (String line : linesList) {
                   
                    String[] words = line.split(" ");

                    if (words.length == 0) {
                        continue; 
                    }
                    String command = words[0].toUpperCase();
                    String characterName;
                    String roomName;
                    String itemName;
                    switch (command) {
                        case "MOVE":
                        characterName = words[1];
                        roomName = words[2];
            
                        Room destinationRoom = game.findRoomByName(roomName);
                        if (destinationRoom == null) {
                            fileOutput.println("Hiba: Nem található szoba ezzel a névvel: " + roomName);
                            break;
                        }
            
                        Character character = game.findCharacterByName(characterName);
                        if (character == null) {
                            fileOutput.println("Hiba: Nem található karakter ezzel a névvel: " + characterName);
                            break;
                        }
            
                        character.goToRoom(destinationRoom);
                        break;

                        case "USE":
                            characterName = words[1];
                            itemName = words[2];

                            Student student = game.findStudentByName(characterName);
                            if (student == null) {
                                fileOutput.println("Hiba: Nem található karakter ezzel a névvel: " + characterName);
                                break;
                            }

                            int index = game.findItemIndexByNameAtStudent(itemName,student);
                            if(index == -1){
                                fileOutput.println("Hiba: Nem található item ezzel a névvel: " + itemName+", ennél a hallgatónál: "+characterName);
                                break;
                            }
                            student.useItem(index);
                            break;

                        case "PICKUP":
                            characterName = words[1];
                            itemName = words[2];
                
                            Character character2 = game.findCharacterByName(characterName);
                            if (character2 == null) {
                                fileOutput.println("Hiba: Nem található karakter ezzel a névvel: " + characterName);
                                break;
                            }

                            Using item = game.findItemByNameAtRoom(itemName,character2.location);
                            if(item == null){
                                fileOutput.println("Hiba: Nem található item ezzel a névvel: " + itemName+", ebben a szobában: "+character2.location.getName());
                                break;
                            }

                            character2.pickUpItem(item);
                            break;

                        case "DROP":
                           
                            characterName = words[1];
                            itemName = words[2];
                
                            Character character3 = game.findCharacterByName(characterName);
                            if (character3 == null) {
                                fileOutput.println("Hiba: Nem található karakter ezzel a névvel: " + characterName);
                                break;
                            }

                            Using item2 = game.findItemByNameAtRoom(itemName,character3.location);
                            if(item2 == null){
                                fileOutput.println("Hiba: Nem található item ezzel a névvel: " + itemName+", ebben a szobában: "+character3.location.getName());
                                break;
                            }

                            character3.dropItem(item2);
                            break;

                        case "SPLIT":
                            roomName = words[1];
                
                            Room originRoom = game.findRoomByName(roomName);
                            if (originRoom == null) {
                                fileOutput.println("Hiba: Nem található szoba ezzel a névvel: " + roomName);
                                break;
                            }

                            Room newRoom = originRoom.Split();
                            newRoom.name = words[2];
                            game.addRoom(newRoom);
                            break;

                        case "MERGE":
                            String roomName1 = words[1];
                            String roomName2 = words[2];
                    
                            Room Room1 = game.findRoomByName(roomName1);
                            if (Room1 == null) {
                                fileOutput.println("Hiba: Nem található szoba ezzel a névvel: " + roomName1);
                                break;
                            }
                            Room Room2 = game.findRoomByName(roomName2);
                            if (Room2 == null) {
                                fileOutput.println("Hiba: Nem található szoba ezzel a névvel: " + roomName2);
                                break;
                            }

                            Room1.Merge(Room2);

                            break;

                        case "DOORMANIPULATION":
                            String roomName21 = words[1];
                            String roomName22 = words[2];
                    
                            Room room21 = game.findRoomByName(roomName21);
                            if (room21 == null) {
                                fileOutput.println("Hiba: Nem található szoba ezzel a névvel: " + roomName21);
                                break;
                            }
                            Room room22 = game.findRoomByName(roomName22);
                            if (room22 == null) {
                                fileOutput.println("Hiba: Nem található szoba ezzel a névvel: " + roomName22);
                                break;
                            }

                            switch(words[3]){
                                case "0":
                                    room21.neighbours.remove(room22);
                                    room22.neighbours.remove(room21);
                                    break;
                                case "1":
                                    if (!room21.getNeighbours().contains(room22)) {
                                        room21.getNeighbours().add(room22);
                                    }
                                    room22.getNeighbours().remove(room21);
                                    
                                    break;
                    
                                case "2":
                                    if (!room21.getNeighbours().contains(room22)) {
                                        room21.getNeighbours().add(room22);
                                    }
                                    if (!room22.getNeighbours().contains(room21)) {
                                        room22.getNeighbours().add(room21);
                                    }
                                    break;
                        
                                default:
                                    fileOutput.println("Hiba: Ismeretlen kapcsolat típus: " + words[3]);
                                    break;
                            }
                            break;

                        default:
                            System.err.println("Hiba: Ismeretlen parancs: " + command);
                            break;
                    }
                }
            } catch (IOException e) {
                fileOutput.println("Hiba történt az input.txt fájl beolvasása közben: " + e.getMessage());
            }

        } catch (FileNotFoundException e) {
            System.err.println("Nem sikerült létrehozni az output.txt fájlt: " + e.getMessage());
        }

    }
    
}