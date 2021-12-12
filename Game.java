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
            String[] arr = sc.nextLine().split(" ");
            int st = Integer.parseInt(arr[0]);
            int en = Integer.parseInt(arr[1]);
            Snakes snake = new Snakes(st, en);
            snakeMap.put(st, snake);
        }

        System.out.println("Enter No of Ladders");
        int nLadders = sc.nextInt();

        HashMap<Integer, Ladders> ladderMap = new HashMap<Integer, Ladders>();
        sc.nextLine();
        while (nLadders-- > 0) {
            String[] arr = sc.nextLine().split(" ");
            int st = Integer.parseInt(arr[0]);
            int en = Integer.parseInt(arr[1]);
            Ladders ladder = new Ladders(st, en);
            ladderMap.put(st, ladder);
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
