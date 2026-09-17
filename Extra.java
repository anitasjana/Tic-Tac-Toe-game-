

import java.util.Scanner;

public class Extra{
    public static void main(String[] args) {
        Board board =new Board();

        board.initializeBoard();
        board.printBoard();
        
        Scanner sc = new Scanner(System.in);

        char player ='X' ;
        int moves=0;
        GameStatus status = GameStatus.RUNNING;
        while(moves<9 ){
                
            System.out.print("Player " + player + ", choose position: ");

            if(!sc.hasNextInt()){
                System.out.print("It's not intizer , plz give the intizer position into 1 to 9");
                sc.next();
                continue;
            }
            int positions = sc.nextInt();
            int position=positions-1;


            if(position<0 || position>8){
                System.out.print("invalid position , plz give the position into 1 to 9");
                continue;
            }

            int row = position/3;
            int col= position%3;

            if (board.isOccupied(row, col)) {
               System.out.println("Position already occupied");
               continue;
            }

            board.placeMark(row, col, player);
            board.printBoard();
            
            WinChecker checker = new WinChecker();
            if(checker.checkWinner(board, player)){
                if(player=='X'){
                    status = GameStatus.X_WON;
                }
                else{
                    status =GameStatus.O_WON;
                }
                break;
                // System.out.println("Player " + player + " wins");
                // break;
            }

            if (player == 'X') {
                player = 'O';
            } else {
                player = 'X';
            }

            moves++;        
        }
        if(status==GameStatus.X_WON){
            System.out.println("Player X wins");
        }
        else if (status == GameStatus.O_WON) {
            System.out.println("Player O wins!");
        }




    

    }
}