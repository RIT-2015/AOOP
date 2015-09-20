import java.util.Scanner;

public class Player implements PlayerInterface {

    private Connect4FieldInterface connect4Field;
    private String name;
    private char gamePiece;
    private String move;
    private Scanner inputScanner = new Scanner(System.in);

    public Player(Connect4FieldInterface connect4Field,
                  String name,
                  char gamePiece) {
        this.connect4Field = connect4Field;
        this.name = name;
        this.gamePiece = gamePiece;
    }

    @Override
    public char getGamePiece() {
        return this.gamePiece;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int nextMove() {
        System.out.println(this.name + "\'s turn \n Enter column number:");
        move = inputScanner.next();
        if (move.length() != 1 && !move.matches("\\d+")) {
            return -1;
        }
        return Integer.parseInt(move);
    }
}
