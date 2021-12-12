package snakesandladders;


public class Dice {

 

    private int noOfDice;

    Dice(int noOfDice) {
        this.noOfDice = noOfDice;
    }

    // method to get a random dice number based on number of dice

    public int rollDice() {
        return ((int) (Math.random() * (6 * noOfDice - 1 * noOfDice))) + 1;

    }
}

