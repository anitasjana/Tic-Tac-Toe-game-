package src;

public class Board {

    private char[][] board;

    public Board(){
        board = new char[3][3];
    }
    public void initializeBoard(){
        int c = 0;

        for(int i = 0; i < board.length; i++) {

            for(int j = 0; j < board.length; j++) {

                board[i][j] = (char)('1' + c);
                c++;
            }
        }
    }
    public void printBoard() {
        for(int i=0 ; i< board.length ; i++){
            for(int k=0;k<board.length ;k++){
                System.out.print(board[i][k] + " "  );
            }
            System.out.println();
        }
    }
    public void placeMark(int row, int col, char player) {
        board[row][col] = player;
    }
    public boolean isOccupied(int row, int col) {
        return board[row][col] == 'X' || board[row][col] == 'O';
    }
    public char getCell(int row, int col) {
    return board[row][col];
    }
}
