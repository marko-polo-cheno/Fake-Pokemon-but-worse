/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chenpocketmonsters;

/**
 *
 * @author CSQ
 */
public class Trainer {

    //attributes
    private String name;
    private int age;
    private PocketMonster animal1, animal2, animal3;
    private boolean catchPM, releasePM;
    
    /**
     * Primary Constructor for a default trainer
     */
    public Trainer(String name, int age){
        this.name = name;
        this.age = age;
        animal1 = new PocketMonster("empty");
        animal2 = new PocketMonster("empty");
        animal3 = new PocketMonster("empty");
    }
    /**
     * Secondary constructor with all Trainer attributes
     * @param name - name of trainer
     * @param age - age of trainer
     * @param animal1 - one of trainer's pets
     * @param animal2 - one of trainer's pets
     * @param animal3 - one of trainer's pets
     */
    public Trainer(String name, int age, PocketMonster animal1, PocketMonster animal2, PocketMonster animal3){
        this(name,age);
        if (age == 0){
            age = 1;
        } else if (age <1){
            age = age*-1;
        }
        this.name = name;
        this.age = age;
        this.animal1 = animal1;
        this.animal2 = animal2;
        this.animal3 = animal3;
    }
    
    /**
     * Sees if a PocketMonster is 
     * @param pm
     * @return 
     */
    public boolean catchPM(PocketMonster pm){
        int rNum = (int) (Math.random()*4)+1;
        if (rNum != 1 && (pm.getName().equals("empty"))){
            return true;
        } else {
            return false;
        }
    }
    /**
     * This method will see if releasing PM is ok, and will release respective PM and indicate if completed
     * @param pmName - The user inputted name for PM to release if ok
     * @return 
     */
    public boolean releasePM(String pmName){
        if (animal1.getName().equals(pmName)){
            animal1 = new PocketMonster("empty");
            
            return true;
        } else if (animal2.getName().equals(pmName)){
            animal2 = new PocketMonster("empty");
            return true;
        } else if (animal3.getName().equals(pmName)){
            animal3 = new PocketMonster("empty");
            return true;
        } else {
            return false;
        }
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the animal1
     */
    public PocketMonster getAnimal1() {
        return animal1;
    }

    /**
     * @param animal1 the animal1 to set
     */
    public void setAnimal1(PocketMonster animal1) {
        this.animal1 = animal1;
    }

    /**
     * @return the animal2
     */
    public PocketMonster getAnimal2() {
        return animal2;
    }

    /**
     * @param animal2 the animal2 to set
     */
    public void setAnimal2(PocketMonster animal2) {
        this.animal2 = animal2;
    }

    /**
     * @return the animal3
     */
    public PocketMonster getAnimal3() {
        return animal3;
    }

    /**
     * @param animal3 the animal3 to set
     */
    public void setAnimal3(PocketMonster animal3) {
        this.animal3 = animal3;
    }

    /**
     * @return the catchPM
     */
    public boolean isCatchPM() {
        return catchPM;
    }

    /**
     * @param catchPM the catchPM to set
     */
    public void setCatchPM(boolean catchPM) {
        this.catchPM = catchPM;
    }

    /**
     * @return the releasePM
     */
    public boolean isReleasePM() {
        return releasePM;
    }

    /**
     * @param releasePM the releasePM to set
     */
    public void setReleasePM(boolean releasePM) {
        this.releasePM = releasePM;
    }
    
    /**
     * Format trainer class output
     * @return - the information of a trainer
     */
    @Override
    public String toString(){
        return "Trainer: " + name + "\nAge: " + age + "\nPM1: " + animal1.getName() 
            + "\nPM2: " + animal2.getName() + "\nPM3: " + animal3.getName();
    }
}
