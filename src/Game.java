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

    public boolean makeMove(int position)throws InvalidMoveException{
        
        if(position < 0 || position > 8){
              throw new InvalidMoveException("Position must be between 1 and 9");
        }
        int row = position/3;
        int col =position%3;

        if(board.isOccupied(row, col)){
            // return false;
            throw new InvalidMoveException("Position already occupied");
        }
        board.placeMark(row, col, currentPlayer);
        return true;
    }

    public void switchPlayer(){
        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        } else {
            currentPlayer = 'X';
        }
    }
    public GameStatus gameStatus(){
        return status;
    }
    public void updateStatus(){

        if(checker.checkWinner(board, currentPlayer)){
            if(currentPlayer=='X'){
                status = GameStatus.X_WON;
            }
            else{
                status =GameStatus.O_WON;
            }
        }
    }
    public void checkDraw(int moves){

        if(moves == 9 && status == GameStatus.RUNNING){
            status = GameStatus.DRAW;
        }
    }
    public char getCurrentPlayer() {
        return currentPlayer;
    }
}
