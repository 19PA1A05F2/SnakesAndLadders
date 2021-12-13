package snakesandladders;
import java.util.*;

public class Game {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Snakes and Ladders Game!");
        System.out.println("Enter Board Size");
        int bSize = sc.nextInt();
        
        System.out.println("Enter number of dices you want to play with:");
        int nDice = sc.nextInt();
        Dice dice = new Dice(nDice);
        
        System.out.println("Enter No of Snakes");
        int nSnakes = sc.nextInt();

        HashMap<Integer, Snakes> snakeMap = new HashMap<Integer, Snakes>();
        sc.nextLine();
        while (nSnakes-- > 0) {
        	int max = bSize-1;
            int min = 1;
            int range = max - min + 1;
            int start = (int)(Math.random() * range) + min;
            while(snakeMap.containsKey(start)) {
            	start = (int)(Math.random() * range) + min;
            }
            int end = (int)(Math.random() * (start-1)) + min;
            Snakes snake = new Snakes(start, end);
            snakeMap.put(start, snake);
            System.out.println(start+" " +end);
        }

        System.out.println("Enter No of Ladders");
        int nLadders = sc.nextInt();

        HashMap<Integer, Ladders> ladderMap = new HashMap<>();
        sc.nextLine();
        while (nLadders-- > 0) {
        	int max = bSize-1;
            int min = 1;
            int range = max - min + 1;
            int start = (int)(Math.random() * range) + min;
            while(snakeMap.containsKey(start) || ladderMap.containsKey(start)) {
            	start = (int)(Math.random() * range) + min-1;
            }
            int end = (int)(Math.random() * (range-start)) + min;
            Ladders ladder = new Ladders(start, end);
            ladderMap.put(start, ladder);
            System.out.println(start+" "+end);
        }
        

        Queue<Player> playerTurns = new LinkedList<Player>();

        System.out.println("Enter number of players: ");
        int nPlayers = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Players Name");
        while (nPlayers-- > 0) {
            String name = sc.nextLine();
            Player p = new Player(name);
            playerTurns.add(p);
        }

        Board gameBoard = new Board(bSize, dice, snakeMap, ladderMap, playerTurns);
        gameBoard.startGame();
        sc.close();
    }
}
