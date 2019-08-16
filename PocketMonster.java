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
public class PocketMonster {

    //attributes
    private String name, type;
    private int level, exp, hitpoints, attackChoice;
    private double weight, height;
    private String[] ability = new String[5];

    /**
     * Primary Constructor for default pocket monster
     */
    public PocketMonster(String nom) {
        
        name = nom;
        level = 1;
        exp = 100;
        hitpoints = level * 100;
        attackChoice = 0;
        weight = 10.0;
        height = 10.0;
        ability = new String[] {"no type","1","2","3","4"};
    }
    
    /**
     * Secondary Constructor for Pocket Monster stats
     * @param name - name of pocket monster
     * @param type - type of pocket monster
     * @param height - height of monster
     * @param weight - weight of monster
     * @param hitpoints - health of monster
     * @param exp - experience of monster
     * @param level - level of monster
     * @param ability - array of the abilites of monster
     */
    public PocketMonster(String name, String type, double height, double weight, int hitpoints, int exp, int level, String[] ability) {
        this(name);
        this.type = type;
        this.height = height;
        this.weight = weight;
        this.hitpoints = hitpoints;
        this.exp = exp;
        this.level = level;
        
        this.ability[0] = ability[0];
        this.ability[1] = ability[1];
        this.ability[2] = ability[2];
        this.ability[3] = ability[3];
        this.ability[4] = ability[4];
        
    }
    /**
     * Returns the PM's move choice
     * @param animalName - the name of the PM
     * @param power - the number that indicated the respective move to make
     * @return - a message displaying the move
     */
    public String activateAbility(String animalName, int power){
        return animalName + " has used " + ability[power];
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
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * @return the exp
     */
    public int getExp() {
        return exp;
    }

    /**
     * @param exp the exp to set
     */
    public void setExp(int exp) {
        this.exp = exp;
    }

    /**
     * @return the hitpoints
     */
    public int getHitpoints() {
        return hitpoints;
    }

    /**
     * @param hitpoints the hitpoints to set
     */
    public void setHitpoints(int hitpoints) {
        this.hitpoints = hitpoints;
    }

    /**
     * @return the attackChoice
     */
    public int getAttackChoice() {
        return attackChoice;
    }

    /**
     * @param attackChoice the attackChoice to set
     */
    public void setAttackChoice(int attackChoice) {
        this.attackChoice = attackChoice;
    }

    /**
     * @return the weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * @return the height
     */
    public double getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * @return the ability
     */
    public String[] getAbility() {
        return ability;
    }

    /**
     * @param ability the ability to set
     */
    public void setAbility(String[] ability) {
        this.ability = ability;
    }
    
    /**
     * to string method for a pocket monster object
     * @return all stats of a pocket monster
     */
    public String toString(){
        return "Here are the details you asked for:"
                + "\nName: " + name 
                + "\nType: " + ability[0] 
                + "\nHeight: " + height 
                + "\nWeight: " + weight 
                + "\nHit Points: " + hitpoints 
                + "\nLevel: " + level
                + "\nExperience " + exp
                + "\nAbilities: " + ability[1] + ", "+ ability[2] + ", "+ ability[3] + ", "+ ability[4]; 
    }

}
