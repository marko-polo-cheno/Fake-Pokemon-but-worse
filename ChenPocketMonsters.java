/*
 * Mark Chen
 * Oct 4th 2018
 * This is a game called Pocket Monsters. You are in a place called Kanto and there are people called Trainers.
 * Trainers have pets called Pocket Monsters. This program allows you to interact and examine all the data from Kanto's people.
 */
package chenpocketmonsters;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class ChenPocketMonsters {

    static int numOfTypes = getNumOfTypes(); // Number of types of PM that exist in types
    static int numOfTrainers = getNumOfTrainers(); // Number of types of PM that exist in types
    static String[][] typesData = getTypesData(numOfTypes);
    static Trainer[] trainerData = getTrainerData(typesData);
    
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to Kanto!");
        
        menu();

    }
    
    /**
     * Reads the first line in the trainer data file for the number of trainers there are
     * @return  - the number of trainers there are
     */
    public static int getNumOfTrainers() {
        int numOfTrainers = 0;
        try {
            FileReader frTrainer = new FileReader("src\\chenpocketmonsters\\trainer.txt");
            BufferedReader brTrainer = new BufferedReader(frTrainer);
            numOfTrainers = Integer.parseInt(brTrainer.readLine());
            brTrainer.close();
        } catch (IOException e) {
            System.out.println("error" + e);
        }
        return numOfTrainers;
    }
    /**
     * Reads the first line in the trainer data file for the number of trainers there are
     * @return  - the number of trainers there are
     */
    public static int getNumOfTypes() {
        int numToRead = 0;
        try {
            FileReader frTrainer = new FileReader("src\\chenpocketmonsters\\types.txt");
            BufferedReader brTypes = new BufferedReader(frTrainer);
            String line;
            boolean eof = false;
            while(!eof){
                line = brTypes.readLine();
                if (line == null){
                    eof = true;
                } else {
                    numToRead++;
                }
            }
            brTypes.close();
        } catch (IOException e) {
            System.out.println("error" + e);
        }
        return (numToRead/5);
    }
    
    /**
     * Gets the information from types data file and stores in arrays
     *
     * @param num - pass number of types of PM to be read
     * @return - stored array to be used in program
     */
    public static String[][] getTypesData(int num) {
        int numbOfTypes = num;
        String[][] typesDataLocal = new String[numbOfTypes][5];
        String types;
        int typeNumber = 0;

        try {
            FileReader frTypes = new FileReader("src\\chenpocketmonsters\\types.txt");
            BufferedReader brTypes = new BufferedReader(frTypes);

            boolean eof = false;

            while (!eof) {
                types = brTypes.readLine();
                if (types == null) {
                    eof = true;
                } else {
                    typesDataLocal[typeNumber][0] = types;
                    for (int i = 1; i < 5; i++) {
                        typesDataLocal[typeNumber][i] = brTypes.readLine();
                    }
                    typeNumber++;
                }
            }
            brTypes.close();
        } catch (IOException e) {
            System.out.println("error" + e);
        }
        return typesDataLocal;
    }

    /**
     * Gets all Trainer data and links abilities to pocket monsters and puts everything into a Trainer array
     * @param typesData - the array of types of PMs with the abilites
     * @return 
     */
    public static Trainer[] getTrainerData(String[][] typesData) {
        trainerData = new Trainer[numOfTrainers];
        try {

            FileReader frTrainer = new FileReader("src\\chenpocketmonsters\\trainer.txt");
            BufferedReader brTrainer = new BufferedReader(frTrainer);

            String trainerName, name, type;
            double height, weight;
            int trainerAge, hitpoints, exp, level;
            PocketMonster animal1 = new PocketMonster("empty");
            PocketMonster animal2 = new PocketMonster("empty");
            PocketMonster animal3 = new PocketMonster("empty");

            int trainerNum = 0;

            brTrainer.readLine();

            while (trainerNum < numOfTrainers) {

                trainerName = brTrainer.readLine();
                trainerAge = Integer.parseInt(brTrainer.readLine());

                for (int i = 0; i < 3; i++) {
                    name = brTrainer.readLine();
                    type = brTrainer.readLine();
                    height = Double.parseDouble(brTrainer.readLine());
                    weight = Double.parseDouble(brTrainer.readLine());
                    hitpoints = Integer.parseInt(brTrainer.readLine());
                    exp = Integer.parseInt(brTrainer.readLine());
                    level = Integer.parseInt(brTrainer.readLine());
                    if (i == 0) {
                        animal1 = new PocketMonster(name, type, height, weight, hitpoints, exp, level, getSkillSet(type));
                    } else if (i == 1) {
                        animal2 = new PocketMonster(name, type, height, weight, hitpoints, exp, level, getSkillSet(type));
                    } else {
                        animal3 = new PocketMonster(name, type, height, weight, hitpoints, exp, level, getSkillSet(type));
                    }
                }
                trainerData[trainerNum] = new Trainer(trainerName, trainerAge, animal1, animal2, animal3);
                //System.out.println(trainerData[trainerNum]);
                //System.out.println(trainerData[trainerNum].getAnimal1());

                trainerNum++;
            }
            brTrainer.close();
        } catch (IOException e) {
            System.out.println("error" + e);
        }
        return trainerData;
    }

    public static String[] getSkillSet(String type) {
        String[] abilities = new String[5];
        for (int i = 0; i < numOfTypes; i++) {
            if (typesData[i][0].equalsIgnoreCase(type)) {
                abilities = typesData[i];
            }
        }
        return abilities;
    }

    /**
     * The Start Menu of game for user to see the trainers and decide who to
     * inspect
     *
     * @param trainerData - the array of trainers, containing all trainer data
     */
    public static void menu() {
        //Make menu based of trainers names from array (creates a string that is a list of all the names of trainers)
        String allNames = "";
        for (int indexInTrainerArray = 0; indexInTrainerArray < numOfTrainers; indexInTrainerArray++) {
            allNames += "\n-" + trainerData[indexInTrainerArray].getName();
        }

        boolean validInput = false;
        boolean done = false;
        String input;

        while (!done) {
            //Show menu
            validInput = false;
            input = JOptionPane.showInputDialog(null,
                    "Who would you like to speak with?"
                    + allNames
                    + "\n-Done (to quit)\n");

            //Using user input, see what action to take
            if (input.equalsIgnoreCase("Done")) {
                System.out.println("Good Game!");
                done = true;

            } else {
                //Cycle through to see if a trainer is actually chosen
                for (int indexInTrainerArray = 0; indexInTrainerArray < numOfTrainers; indexInTrainerArray++) {
                    if (input.equalsIgnoreCase(trainerData[indexInTrainerArray].getName())) {
                        validInput = true;
                        trainerMenu(indexInTrainerArray);
                    }
                }
                //Indicate choice not understood
                if (!validInput) {
                    System.out.println("Sorry, please enter a valid command.");
                }
            }
        }
    }

    public static void trainerMenu(int trainerNum) {
        boolean validInput = false;
        boolean done = false;
        String input;
        while (!done) {
            input = JOptionPane.showInputDialog(null,
                    trainerData[trainerNum].getName() + " holds the following:\n"
                    + trainerData[trainerNum].getAnimal1().getName() + "\n"
                    + trainerData[trainerNum].getAnimal2().getName() + "\n"
                    + trainerData[trainerNum].getAnimal3().getName() + "\n"
                    + "\nWhat would you like to do?\n"
                    + "Walk (in the grass - you might find a wild pocket monster!)\n"
                    + "Release (one of the pocket monsters in " + trainerData[trainerNum].getName() + "'s care)\n"
                    + "Examine (one of the monsters above)\n"
                    + "Train (select a pocket monster to increase xp)\n"
                    + "Back (to the previous menu)");

            if (input.equalsIgnoreCase("Walk")) {
                int rNum = (int) (Math.random()*3)+1;
                if (rNum == 1){
                    //if (Trainer.catchPM(trainerData[trainerNum].getAnimal3())) {

                } else {
                    JOptionPane.showMessageDialog(null,trainerData[trainerNum].getName() + " wanders around for a bit...");
                }
                validInput = true;
            } else if (input.equalsIgnoreCase("Release")) {
                release(trainerData[trainerNum], trainerNum);
                validInput = true;
            } else if (input.equalsIgnoreCase("Examine")) {
                examine(trainerData[trainerNum], trainerNum);
                validInput = true;
            } else if (input.equalsIgnoreCase("Train")) {
                train(trainerData[trainerNum], trainerNum);
                validInput = true;
            } else if (input.equalsIgnoreCase("Back")) {
                done = true;
            } else {
                System.out.println("Sorry, please enter a valid command.");
            }
        }
    }

    public static boolean examine(Trainer trainer, int trainerNum) {
        String nameOfPM = JOptionPane.showInputDialog(null, 
                "Which of " + trainer.getName()+ "'s Pocket Monsters would you like to examine?"
                + "\n-" + trainer.getAnimal1().getName()
                + "\n-" + trainer.getAnimal2().getName()
                + "\n-" + trainer.getAnimal3().getName()
                + "\n-Back (to the previous menu)");
        if (trainer.getAnimal1().getName().equalsIgnoreCase(nameOfPM)){
            JOptionPane.showMessageDialog(null,trainer.getAnimal1());
            trainerMenu(trainerNum);
            return true;
        } else if (trainer.getAnimal2().getName().equalsIgnoreCase(nameOfPM)){
            JOptionPane.showMessageDialog(null,trainer.getAnimal2());
            trainerMenu(trainerNum);
            return true;
        } else if (trainer.getAnimal3().getName().equalsIgnoreCase(nameOfPM)){
            JOptionPane.showMessageDialog(null,trainer.getAnimal3());
            trainerMenu(trainerNum);
            return true;
        } else if ("Back".equalsIgnoreCase(nameOfPM)){
            trainerMenu(trainerNum);
            return true;
        } else {
            System.out.println("Sorry, please enter a valid command.");
            return false;
        }
    }
    
    public static boolean train(Trainer trainer, int trainerNum){
        String nameOfPM = JOptionPane.showInputDialog(null, 
                "Which of " + trainer.getName()+ "'s Pocket Monsters would you like to examine?"
                + "\n-" + trainer.getAnimal1().getName()
                + "\n-" + trainer.getAnimal2().getName()
                + "\n-" + trainer.getAnimal3().getName()
                + "\n-Back (to the previous menu)");
        
        if (trainer.getAnimal1().getName().equalsIgnoreCase(nameOfPM)){
            trainer.getAnimal1().setExp(trainer.getAnimal1().getExp()+50);
            return true;
        } else if (trainer.getAnimal2().getName().equalsIgnoreCase(nameOfPM)){
            trainer.getAnimal2().setExp(trainer.getAnimal2().getExp()+50);
            return true;
        } else if (trainer.getAnimal3().getName().equalsIgnoreCase(nameOfPM)){
            trainer.getAnimal3().setExp(trainer.getAnimal3().getExp()+50);
            return true;
        } else if ("Back".equalsIgnoreCase(nameOfPM)){
            trainerMenu(trainerNum);
            return true;
        } else {
            System.out.println("Sorry, please enter a valid command.");
            return false;
        }
    }
    
    public static boolean release(Trainer trainer, int trainerNum){
        String nameOfPM = JOptionPane.showInputDialog(null, 
                "Which of " + trainer.getName()+ "'s Pocket Monsters would you like to release?"
                + "\n-" + trainer.getAnimal1().getName()
                + "\n-" + trainer.getAnimal2().getName()
                + "\n-" + trainer.getAnimal3().getName()
                + "\n-Back (to the previous menu)");
        
        if (trainer.getAnimal1().getName().equalsIgnoreCase(nameOfPM)){
            if (confirmRelease(nameOfPM)) {
                System.out.println(trainerData[0] == trainer);
                trainer.releasePM(nameOfPM);
                System.out.println(trainerData[0]);
            }
            release(trainer,trainerNum);
            return true;
        } else if (trainer.getAnimal2().getName().equalsIgnoreCase(nameOfPM)){
            if (confirmRelease(nameOfPM)) {
                trainer.releasePM(nameOfPM);
            }
            release(trainer,trainerNum);
            return true;
        } else if (trainer.getAnimal3().getName().equalsIgnoreCase(nameOfPM)){
            if (confirmRelease(nameOfPM)) {
                trainer.releasePM(nameOfPM);
            }
            release(trainer,trainerNum);
            return true;
        } else if ("Back".equalsIgnoreCase(nameOfPM)){
            trainerMenu(trainerNum);
            return true;
        } else {
            System.out.println("Sorry, please enter a valid command.");
            return false;
        }
    }
    
    public static boolean confirmRelease(String namePM){
        String input = JOptionPane.showInputDialog(null,"Are you sure you want to release " + namePM + "?\n(Yes/No)");
        if (input.equalsIgnoreCase("yes")){
            return true;
        } else {
            return false;
        }
    }
    /*
    public static PocketMonster makeAnimal(){
        String[4] name = ["Pika","Bird","Cow","Chicken"];
        int[4] type = ["Grass","Water","Fire","Electric"];
        double[4] height = [1.01,2.02,3.03,4.04];
        double[4] weight = [1.01,2.02,3.03,4.04];
        //PocketMonster newMonster = new PocketMonster(name,type,height,weight,hitpoints, exp,level,ability);
    
    }
    */
}
