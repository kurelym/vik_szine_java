package View;

import javax.swing.*;

import Controller.GameViewController;
import Model.Graph;
import Model.ViewData;

import java.awt.*;
import java.awt.event.*;

public class GameView extends JFrame {
    private JTextField player1label = new JTextField(20);
    private JTextField player2label = new JTextField(20);
    private JTextField player3label = new JTextField(20);
    private JTextField player4label = new JTextField(20);
    private JTextField player5label = new JTextField(20);
    private JTextField roundlabel = new JTextField(20);
    private JComboBox items = new JComboBox();
    private JComboBox neighbours = new JComboBox();
    private JList inventory = new JList();
    private JButton pickupButton = new JButton("PICKUP");
    private JButton dropButton = new JButton("DROP");
    private JButton goToRoomButton = new JButton("GOTOROOM");
    private JButton useButton = new JButton("USE");
    private JButton activateButton = new JButton("ACTIVATE");
    private GameViewController gameviewcontroller;
    private Graph graph;

    public GameView(GameViewController gvc){
        gameviewcontroller = gvc;
    }
    public void update(ViewData newData){

    }
    public class ButtonsListener implements ActionListener{
        JComboBox cbN;
        JComboBox cbI;
        JList iL;
        GameViewController gvc;
        public ButtonsListener(JComboBox _cbN, JComboBox _cbI, JList _iL, GameViewController _gvc){
            gvc = _gvc;
            cbN = _cbN;
            cbI = _cbI;
            iL = _iL;
        }
        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equals("pickup")) {
				
			}
            else if(ae.getActionCommand().equals("drop")){

            }
            else if(ae.getActionCommand().equals("gotoroom")){

            }
            else if(ae.getActionCommand().equals("use")){

            }
            else if(ae.getActionCommand().equals("activate")){

            }
        }
    }
}