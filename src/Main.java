package src;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        Game game = new Game();

        game.printBoard();
        
        Scanner sc = new Scanner(System.in);
        
        int moves=0;

        while(moves<9 ){
                
            System.out.print("Player " + game.getCurrentPlayer() + ", choose position: ");

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

            boolean moveSuccessful = game.makeMove(position);

            if (!moveSuccessful) {
                System.out.println("Position already occupied");
                continue;
            }

            game.printBoard();

            game.updateStatus();

            if(game.gameStatus() == GameStatus.X_WON ||
            game.gameStatus() == GameStatus.O_WON){
                break;
            }

            game.switchPlayer();

            moves++;        
        }
        game.checkDraw(moves);
        
        if(game.gameStatus() == GameStatus.X_WON){
            System.out.println("Player X wins");
        }
        else if(game.gameStatus() == GameStatus.O_WON){
            System.out.println("Player O wins!");
        }
        else if(game.gameStatus() == GameStatus.DRAW){
            System.out.println("Game is a draw!");
        }
    }
}