package snakesandladders;
import java.util.*;

public class Board {
    private Dice dice;
    private Queue<Player> playerTurns;
    private HashMap<Integer, Snakes> snakes;
    private HashMap<Integer, Ladders> ladders;
    private int boardSize;
    private List<String> orderOfWinning = new ArrayList();

    Board(int boardSize, Dice dice, HashMap<Integer, Snakes> snakes, HashMap<Integer, Ladders> ladders,
            Queue<Player> playerTurns) {
        this.boardSize = boardSize;
        this.dice = dice;
        this.snakes = snakes;
        this.ladders = ladders;
        this.playerTurns = playerTurns;

    }

    public void startGame() {
        while (true) {
            Player p = playerTurns.poll();
            int currLoc = p.getLocation();
            int nextLoc = currLoc + dice.rollDice();
            int count = 0;
            boolean remove = false;
            System.out.println(p.getName() + " rolled "+ (nextLoc-currLoc));
            if (nextLoc <= boardSize) {
            	if(nextLoc- currLoc == 6) {
            		count += 1;
            		if(count == 3) {
            			nextLoc = currLoc;
            			continue;
            		}
            		nextLoc += nextLoc + dice.rollDice();
            	}
                if (snakes.containsKey(nextLoc)) {
                    System.out.println(p.getName() + " was bitten by a snake!");
                    Snakes obj = snakes.get(nextLoc);
                    nextLoc = obj.getEndPoint();
                } else if (ladders.containsKey(nextLoc)) {
                    System.out.println(p.getName() + " climbed a Ladder!");
                    Ladders obj = ladders.get(nextLoc);
                    nextLoc = obj.getEndPoint();
                }
                currLoc = nextLoc;
                System.out.println(p.getName() + " moved to " + currLoc);
                if (currLoc == boardSize) {
                	orderOfWinning.add(p.getName());
                    System.out.println(p.getName() + " won the Game!!");
                    playerTurns.remove(p);
                    remove = true;
                    if(playerTurns.size() == 1) {
                    	System.out.println(orderOfWinning);
                    	break;
                    }
                }
                p.setLocation(currLoc);

            }
            if(remove == false)
            playerTurns.add(p);

        }
    }

}
