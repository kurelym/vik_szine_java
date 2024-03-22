package Model;

import java.util.List;

public abstract class Character {
    String name;
    List<Item> inventory;
    Room location;
    bool alive;
    List<Item> activatedItems;
public
    Character(){
        System.out.println("Function: Character + Constructor");
    }
    bool pickUpItem(Item i){
        System.out.println("Function: Character + pickUpItem");
        return true;
    }
    void dropItem(Item i){
        System.out.println("Function: Character + dropItem");
    }
    String getName(){
        System.out.println("Function: Character + getName");
        return "";
    }
    Room getLocation(){
        System.out.println("Function: Character + getLocation");
        return null;
    }
    void dropAllItem(){
        System.out.println("Function: Character + dropAllItem");
    }
    bool gasAttack(){
        System.out.println("Function: Character + gasAttack");
        return true;
    }
    bool hasTheSlideRule(){
        System.out.println("Function: Character + hasTheSlideRule");
        return true;
    }
    bool isAlive(){
        System.out.println("Function: Character + isAlive");
        return true;
    }
    abstract bool teacherAttack();

    abstract bool  ragAttack();
}