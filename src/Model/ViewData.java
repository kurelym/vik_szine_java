package Model;

import java.util.HashMap;
import java.util.List;

public class ViewData {
    private String[] names;
    private int round;
    private String[] inventory;
    private List<String> items;
    private List<String> neighbours;
    private List<String> nodes;
    private HashMap<String, List<String>> connectionBetweennodes;
    public ViewData(String[] _names, int _round,String[] _inventory,List<String> _items,List<String> _neighbours,List<String> _nodes, HashMap<String, List<String>> connenctions){
        names = _names;
        round =_round;
        items = _items;
        inventory = _inventory;
        neighbours = _neighbours;
        nodes = _nodes;
        connectionBetweennodes = connenctions;
    }
    public String[] getNames(){
        return names;
    }
    public String[] getInventory(){
        return inventory;
    }
    public int getRound(){
        return round;
    }
    public List<String> getNodes(){
        return nodes;
    }
    public List<String> getItems(){
        return items;
    }
    public List<String> getNeighbours(){
        return neighbours;
    }
    public HashMap<String, List<String>> getConnections(){
        return connectionBetweennodes;
    }
}
