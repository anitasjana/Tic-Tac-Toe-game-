package src;

public class Game {
    private Board board;
    private WinChecker checker;
    private GameStatus status;
    private char currentPlayer;

    public Game(){
        board = new Board();
        checker =  new WinChecker();
        status = GameStatus.RUNNING;
        currentPlayer =  'X';

        
        board.initializeBoard();
    }
    public void printBoard(){
       board.printBoard();
    }
    public boolean makeMove(int position){
        int row = position/3;
        int col =position%3;

        if(board.isOccupied(row, col)){
            return false;
        }
        board.placeMark(row, col, currentPlayer);
        return true;
    }
}
