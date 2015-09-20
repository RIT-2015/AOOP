import java.util.Scanner;

/**
 * Created by Pratik on 9/18/2015.
 */
public class PlayConnect4 {

    public static void main(String[] args) {
        Connect4Field theGame = new Connect4Field();
        Player[] players = new Player[2];
        String name, gamePiece;
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Welcome to Connect-4.");
        for(int i = 0; i < 2; i++) {
            System.out.println("What's the name of Player " + (i+1) + ": ");
            name = inputScanner.next();
            if (name.isEmpty()) {
                System.out.println("Illegal name");
                System.exit(1);
            }
            System.out.println("What's the Game piece of Player " + i+1 + ": ");
            gamePiece = inputScanner.next();
            if (gamePiece.length() != 1) {
                System.out.println("Illegal Game piece");
                System.exit(1);
            }
            players[i] = new Player(theGame, name, gamePiece.charAt(0));
        }
        theGame.init(players[0], players[1]);
        theGame.playTheGame();
    }
}
