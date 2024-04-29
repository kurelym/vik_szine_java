package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A Tranzisztor tárgy működéséért felel. Kezeli a tranzisztorok összekapcsolását, 
 * illetve ennek a kapcsolatnak a bontását.
 */
public class Transistor extends Item{
    private static int globalID = 0;
    private Transistor pair;
    public Transistor(){
        name = "Transistor_"+globalID;
        globalID++;
        durability = 1;
        activated =false;
        owner = null;
        location = null;
        pair = null;
        fake = false;
        //System.out.println("Function: Transistor class + Constructor func");
    }
    public String getDescription(){
        //System.out.println("Function: Transistor class + getDescription func");
        if(owner ==null){
            return "Name: " +name+" Durability: "+durability+" isActive: "+activated+"Room: "+location.getID()+" isFake: "+fake;
        }
        else{
            return "Name: " +name+" Durability: "+durability+" isActive: "+activated+"Owner: "+owner.getName()+" isFake: "+fake;
        }
    }
    public boolean removePair(){
        //System.out.println("Function: Transistor class + removePair func");
        if(this.pair!=null){
            this.pair.activated=false;
            this.pair.location.removeItem(this.pair);
            owner.location.addItem(this.pair);
            this.pair.pair=null;

            pair = null;
            activated = false;
        }
        return true;
    }
    public boolean pairing(Using _pair){
        //System.out.println("Function: Transistor class + pairing func");
        if(this.pair!=null){
            Room tmp=owner.location;
            owner.goToRoom(this.pair.location);
            removePair();
            tmp.addItem(this);
            tmp=null;
        }

        else{
            Transistor _new = (Transistor)_pair;
            this.pair = _new;
            activated = true;
            _new.pair = this;
            _new.activated = true;
            owner.inventory.remove(this);
            owner.location.addItem(this);
        }
        return true;
    }

    public boolean useSelectedItem(){
        //System.out.println("Function: SlideRule class + useSelectedItem func");
        if(pair!=null){
            pairing(null);
        }
        else{
            Scanner scanner=new Scanner(System.in);
            int input=-1;
            List<Using> useableItems=new ArrayList<>();

            while (input != 0) {
                System.out.println("Inventory:");
                for(int j=0; j<owner.inventory.size();j++){
                    if(owner.inventory.get(j).useable() && !owner.inventory.get(j).equals(this)) {
                        useableItems.add(owner.inventory.get(j));
                        System.out.println(useableItems.size()+". "+owner.inventory.get(j).getName());
                    }
                }

                System.out.println("0. Mégse");
                input = scanner.nextInt();
                if (input==0) {
                    return false;
                }

                if(input<=useableItems.size()){
                    if(this.pairing(useableItems.get(input-1))){
                        return true;
                    }
                    else{
                        System.out.println("Ezt a két tárgyat nem lehet párosítani");
                    }
                }
            }
        }
        return false;
    }

    public boolean useable() {
        return true;
    }

    //Érdemi működést nem valósítanak meg
    public void roundPassed(){
        //System.out.println("Function: Transistor class + roundPassed func");
    }
    public void useAtPickUp(){
        //System.out.println("Function: Transistor class + useAtPickUp func");
    }
    public boolean useAgainstGas(){
        //System.out.println("Function: Transistor class + useAgainstGas func");
        return false;
    }
    public boolean useIt(){
        //System.out.println("Function: Transistor class + useIt func");
        return false;
    }
    public boolean useAgainstTeacher(){
        //System.out.println("Function: Transistor class + useAgainstTeacher func");
        return false;
    }
    public boolean isRealSlideRule(){
        //System.out.println("Function: Transistor class + finishGame func");
        return false;
    }
    public boolean daze(Character target){
        //System.out.println("Function: Transistor class + daze func");
        return false;
    }
    public boolean removeGas(){
        //System.out.println("Function: Transistor class + removeGas func");
        return false;
    }
    public boolean cleanTheRoom(Room r){
        //System.out.println("Function: Transistor class + cleanTheRoom func");
        return false;
    }
}
