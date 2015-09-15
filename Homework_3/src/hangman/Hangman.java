package hangman;

import java.io.FileNotFoundException;

/**
 * Created by Pratik on 9/12/2015.
 */
public class Hangman {

    public static void main(String[] args) throws FileNotFoundException {
        if (args.length < 2) {
            System.out.println("Please enter valid input");
            System.exit(0);
        }
        Game game = new Game();
        game.readFile(args[0]);

        Player[] players = new Player[args.length -1];
        for(int i = 0; i < players.length; i++) {
            players[i] = new Player();
            players[i].setName(args[i+1]);
        }

        for(int player = 0; player < players.length; player++) {
            System.out.println(players[player].getName() + "\'s turn... All the best!");
            game.playGame(players[player]);
        }


        System.out.println("Final Scores-> ");
        for(int i = 0; i < players.length; i++) {
            System.out.println(players[i].getName() + ": " + players[i].getScore());
        }

    }
}
