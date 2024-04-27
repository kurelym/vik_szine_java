package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A labirintus menedzselése, a saját kapacitásának és szomszédainak, a benne lévő tárgyak és benne tartózkodó karakterek nyilvántartása. A szoba transzformációk végrehajtása.Elgázosítás esetén az állapotának megváltoztatása.
 */
public class CursedRoom extends Room{
    private List<Room> hiddenNeighbours;
    private List<Integer> directionOfConnecntion;
    private static int globalID = 0;
    /**
     * Létrehozza az osztályt
     */
    public CursedRoom(){
        super();
        hiddenNeighbours=new ArrayList<>(); 
        directionOfConnecntion = new ArrayList<>();
        System.out.println("Function: CursedRoom class + constructor func");
    }
    /**
     * Amennyiben a hiddenNeighbours lista üres, eltüntet ajtókat, amennyiben nem üres, előhoz ajtókat
     */
    public void doorManipulation(){
        System.out.println("Function: CursedRoom class + doorManipulation func");
        if(characters.isEmpty()){
            if(hiddenNeighbours.isEmpty()){
                Random r = new Random();
                int id = r.nextInt(0, neighbours.size()-1);
                if(neighbours.get(id).isNeighbours(this)){
                    neighbours.get(id).removeNeighbour(this);
                    directionOfConnecntion.add(2);
                    hiddenNeighbours.add(neighbours.get(id));
                    this.removeNeighbour(neighbours.get(id));
                }
                else{
                    directionOfConnecntion.add(1);
                    hiddenNeighbours.add(neighbours.get(id));
                    this.removeNeighbour(neighbours.get(id));
                }
            }
            else{
                for(int i=0;i<hiddenNeighbours.size();i++){
                    if(directionOfConnecntion.get(i)==1){
                        this.addNeighbour(hiddenNeighbours.get(i));
                    }
                    else if(directionOfConnecntion.get(i)==2){
                        hiddenNeighbours.get(i).addNeighbour(this);
                        this.addNeighbour(hiddenNeighbours.get(i));
                    }
                }
                hiddenNeighbours.clear();
                directionOfConnecntion.clear();
            }
        }
    }
    /**
     * Az adott átkozott szoba állapotáról ad leírást
     * @return Egy stringbe adja vissza a átkozott szobáról a leíást
     */
    @Override
    public String getDescription() {
        System.out.println("Function: CursedRoom class + getDescription Func");
        String members ="Characters:";
        String stuff ="Items:";
        String stuffA ="Activated Items:";
        String neighB ="Neighbours:";
        String neighBH ="Hidden Neighbours:";
        for(Using u: items){
            stuff = stuff + " " +u.getName();
        }
        for(Using uA: activatedItems){
            stuffA = stuffA + " " +uA.getName();
        }
        for(Room n: neighbours){
            neighB = neighB + " " +n.getID();
        }
        for(Character c: characters){
            members = members + " " +c.getName();
        }
        if(hiddenNeighbours.isEmpty()){
            neighBH = neighBH +" 0;";
        }
        else{
            for(Room nH: hiddenNeighbours){
                neighBH = neighBH +" "+nH.getID();
            }
        }
        return name+": "+members+", "+stuff+", "+stuffA+", "+neighB+", "+neighBH;
    }
}