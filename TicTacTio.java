// package game;

import java.util.Scanner;

public class TicTacTio {
    public static void main(String[] args) {

        char[] board = new char[9];
        for(int i=0 ; i< board.length ; i++){
            board[i]=(char)('1'+i);
        }

        for(int i=0 ; i< board.length ; i++){
            if( i%3 ==0) System.out.print("\n" );
    
            System.out.print(board[i] + " "  );
        }

        Scanner sc = new Scanner(System.in) ;

        char player ='X' ;
        int j=0;
        while(j<board.length ){
                
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
            if(board[position]=='X' || board[position]=='O'){
                System.out.print(" position allready occupied ");
                continue;
            }

            board[position]=player;

            for (int i = 0; i < board.length; i++) {
                if (i % 3 == 0) {
                    System.out.println();
                }
                System.out.print(board[i] + " ");
            }

            if((board[0] == board[1] && board[1] == board[2] ) || (board[3] == board[4] && board[4] == board[5] ) || (board[6] == board[7] && board[7] == board[8] )){  
                System.out.print( player + " player is win ");
                break ;
            }
            if((board[0] == board[3] && board[3] == board[6] ) || (board[1] == board[4] && board[4]==board[7])||(board[2] == board[5] && board[5]==board[8]) ){  
                System.out.print( player + " player is win ");
                break ;
            }
            if((board[0] == board[4] && board[4] == board[8] ) ||(board[2] == board[4] && board[4]==board[6]) ){  
                System.out.print( player + " player is win ");
                break ;
            }

            if(player == 'X') {
                player= 'O' ;
            }
            else {
                player = 'X' ;
            }
            j++;
        }

        if(j==9){
            System.out.print( " player is end but both does't win");
        }


    }
    
}
