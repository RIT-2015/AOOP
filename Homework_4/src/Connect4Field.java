

public class Connect4Field implements Connect4FieldInterface {

    // TODO
    // condition on number of rows and columns.
    private int rows;
    private int columns;
    private char[][] gameBoard;
    private PlayerInterface[] thePlayers = new PlayerInterface[2];
    private int piecesForWinning = 4;
    private int lastPlayedRow;
    private int lastPlayedColumn;

    public Connect4Field() {
        this.rows = 9;
        this.columns = 25;
        makeBoard();
    }

    @Override
    public boolean isItaDraw() {
        return !(String.valueOf(gameBoard[0]).contains("O"));
    }

    @Override
    public void init(PlayerInterface playerA, PlayerInterface playerB) {
        this.thePlayers[0] = playerA;
        this.thePlayers[1] = playerB;
    }

    private void makeBoard() {
        gameBoard = new char[rows][columns];
        int blank;
        for(int currentRow = 0; currentRow < this.rows; currentRow++) {
            blank = 2 * currentRow;
            for (int currentColumn = 0; currentColumn < columns; currentColumn++) {
                if (currentColumn < blank / 2) {
                    gameBoard[currentRow][currentColumn] = ' ';
                } else if ((currentColumn < columns / 2) ||
                            ((currentColumn >= columns / 2) &&
                                    (currentColumn < columns - blank / 2))) {
                    gameBoard[currentRow][currentColumn] = 'O';
                } else {
                    gameBoard[currentRow][currentColumn] = ' ';
                }

            }
        }
    }
    @Override
    public boolean checkIfPiecedCanBeDroppedIn(int column) {
        if (column - 1 >= 0) {
            return gameBoard[0][column - 1] == 'O';
        } else {
            return false;
        }
    }

    private int getAvailableRow(int column) {
        int row = -1;
        column = column - 1;
        int lower, upper;
        if (gameBoard[rows/2][column] == 'O') {
            lower = rows / 2;
            upper = rows;
        } else {
            lower = 0;
            upper = rows / 2 ;
        }
        for(int i = lower; i < upper; i++) {
            if (gameBoard[i][column] == 'O')
                row = i;
        }
        return row;
    }
    @Override
    public void dropPieces(int column, char gamePiece) {
        if (checkIfPiecedCanBeDroppedIn(column)) {
            int row = getAvailableRow(column);
            lastPlayedRow = row;
            lastPlayedColumn = column - 1;
            gameBoard[row][column - 1] = gamePiece;
        } else {
            System.out.println("Sorry... we can not drop in that column");
        }
    }

    @Override
    public boolean didLastMoveWin() {
        return (checkHorizontally() || checkVertically() || checkDiagonally());
    }


    private String getWinningPattern(char gamePiece) {
        String pattern = "";
        for(int i = 0; i < piecesForWinning; i++) {
            pattern += gamePiece;
        }
        return pattern;
    }

    private boolean checkHorizontally() {
        char gamePiece = gameBoard[lastPlayedRow][lastPlayedColumn];
        String pattern = getWinningPattern(gamePiece);
        String playerState = String.valueOf(gameBoard[lastPlayedRow]);
        return (playerState.contains(pattern));
    }

    private boolean checkVertically() {
        char gamePiece = gameBoard[lastPlayedRow][lastPlayedColumn];
        String pattern = getWinningPattern(gamePiece);
        String playerState = "";
        for(int i = 0; i < rows; i++) {
            playerState += gameBoard[i][lastPlayedColumn];
        }
        return (playerState.contains(pattern));
    }

    private StringBuffer[] getDiagonalString(int lastPlayedRow, int lastPlayedColunm) {
        StringBuffer gamePiece = new StringBuffer(String.valueOf(gameBoard[lastPlayedRow][lastPlayedColunm]));
        StringBuffer[] diagonalStrings = new StringBuffer[2];
        diagonalStrings[0] = new StringBuffer();
        diagonalStrings[1] = new StringBuffer();

        int row,counter = 3;
        for(int i = 1; i <= counter; i++) {
            if ((lastPlayedRow + i) < rows) {
                row = lastPlayedRow + i;
                if ((lastPlayedColunm - i) >= 0)
                    diagonalStrings[0].append(gameBoard[row][lastPlayedColunm - i]);
                if ((lastPlayedColunm + i) < columns)
                    diagonalStrings[1].append(gameBoard[row][lastPlayedColunm + i]);
            }
        }
        diagonalStrings[0] = diagonalStrings[0].reverse().append(gamePiece);
        diagonalStrings[1] = diagonalStrings[1].reverse().append(gamePiece);
        for(int i = 1; i <= counter; i++) {
            if ((lastPlayedRow - i) > 0) {
                row = lastPlayedRow - i;
                if ((lastPlayedColunm - i) >= 0)
                    diagonalStrings[1].append(gameBoard[row][lastPlayedColunm - i]);
                if ((lastPlayedColunm + i) < columns)
                    diagonalStrings[0].append(gameBoard[row][lastPlayedColunm + i]);
            }
        }
        return diagonalStrings;
    }

    private boolean checkDiagonally() {
        char gamePiece = gameBoard[lastPlayedRow][lastPlayedColumn];
        String pattern = getWinningPattern(gamePiece);
        StringBuffer[] playerState = getDiagonalString(lastPlayedRow, lastPlayedColumn);
        return (String.valueOf(playerState[0]).contains(pattern) || String.valueOf(playerState[1]).contains(pattern));
    }

    @Override
    public  void playTheGame()      {
        int column;
        boolean gameIsOver = false;
        do {
            for ( int index = 0; index < 2; index ++ ) {
                System.out.println(this);
                if ( isItaDraw() )      {
                    System.out.println("Draw");
                    gameIsOver = true;
                    break;
                } else {
                    column = thePlayers[index].nextMove();
                    dropPieces(column, thePlayers[index].getGamePiece() );
                    if ( didLastMoveWin() ) {
                        System.out.println(this);
                        gameIsOver = true;
                        System.out.println("The winner is: " + thePlayers[index].getName());
                        break;
                    }
                }
            }
        }  while ( ! gameIsOver  );
    }


    public String toString(){
        String game = "";
        for(char[] row: gameBoard) {
            game = game + "\n";
            for (char element: row) {
                game = game + element;
            }
        }
        return game;
    }

//    public static void main(String[] args) {
//        Connect4Field cn4 = new Connect4Field();
//        cn4.setRows(3);
//        cn4.setColumns(7);
//        cn4.makeBoard();
//
//        System.out.println(cn4);
//        cn4.dropPieces(5, 'P');
//        cn4.dropPieces(5, 'P');
//        cn4.dropPieces(5, 'P');
//        cn4.dropPieces(5, 'P');
//        cn4.dropPieces(5, 'P');
//        System.out.println(cn4);
//        System.out.println(cn4.didLastMoveWin());
//        cn4.dropPieces(4, 'P');
//        cn4.dropPieces(3, 'P');
//        cn4.dropPieces(0, 'P');
//        cn4.dropPieces(5, 'P');
//
//        System.out.println(cn4);
//        System.out.println(cn4.didLastMoveWin());
//
//    }
}
