package Controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import Model.Game;
import Model.Student;
import Model.Transistor;
import Model.Using;
import Model.Room;

public class GameViewController {
    private Game game;
    private JFrame view;
    private List<Student> players;

    public GameViewController(String[] names){
        for(String name: names){
            players.add(game.findStudentByName(name));
        }
    }

    public void startGame(){

    }

    public void addView(JFrame j){
        view=j;
    }

    public void goToRoom(String pickedRoom){
        //Tudni kéne, hogy ki a CurrentPlayer
        /*CurrentPlayer.goToRoom(*/game.findRoomByName(pickedRoom)/*)*/;
    }

    public void Activate(String first, String second){
        Transistor t1 = (Transistor)game.findItemByName(first);
        Transistor t2 = (Transistor)game.findItemByName(second);
        t1.pairing(t2);
    }

    public void Use(int idx){
        //Tudni kéne, hogy ki a CurrentPlayer
        //CurrentPlayer.UseItem(idx);
    }

    public void Drop(String pickedItem){
        //Tudni kéne, hogy ki a CurrentPlayer
        /*CurrentPlayer.dropItem(*/game.findItemByName(pickedItem)/*)*/;
    }

    public void PickUp(String pickedItem){
        //Tudni kéne, hogy ki a CurrentPlayer
        /*CurrentPlayer.pickUpItem(*/game.findItemByName(pickedItem)/*)*/;
    }

    public void refreshViewData(){
        int round = game.getRound();

        List<Room> rooms = game.getRooms();

        List<Room> neighbours = new ArrayList<>();
        List<Using> items = new ArrayList<>();
        for(Room room: rooms){
            neighbours.addAll(room.getNeighbours());
            items.addAll(room.getItems());
        }

        ViewData newData;

        view.update(newData);
    }
}
