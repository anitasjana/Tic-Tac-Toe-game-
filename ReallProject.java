import java.util.Scanner;

public class ReallProject {
    public static void main(String[] args) {

        char[][] board = new char[3][3];
        int c=0;
        
        for(int i=0 ; i< board.length ; i++){
            for(int j=0;j<board.length ;j++){
                board[i][j] =  (char)('1' + c) ;
                c = c + 1;
            }
        }

        for(int i=0 ; i< board.length ; i++){
            for(int j=0;j<board.length ;j++){
               System.out.print(board[i][j] + " "  );
            }
            System.out.println();
        }

        Scanner sc = new Scanner(System.in) ;

        char player ='X' ;
        int moves=0;
        int turns=9;
        boolean isWon = false ;
        while(moves<turns ){
                
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
            if(board[row][col]=='X' || board[row][col]=='O'){
                System.out.print(" position allready occupied ");
                continue;
            }

            board[row][col]=player;

            for(int i=0 ; i< board.length ; i++){
                for(int k=0;k<board.length ;k++){
                System.out.print(board[i][k] + " "  );
                }
                System.out.println();
           }
        if (isWon!=true){
           for(int i=0;i<board.length;i++){
                if(board[i][0]==player && board[i][1]==player && board[i][2]==player){
                    System.out.println("X win");
                    isWon = true; 
                    break;
                }
           }
           for(int i=0;i<board.length;i++){
                if(board[0][i]==player && board[1][i]==player && board[2][i]==player){
                    System.out.println("X win");
                    isWon = true;
                    break;
                }
           }
            int a = board.length - 1; 
            if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
                System.out.println(player + " win");
                isWon = true;
                break;
            }
            if (board[0][a] == player && board[1][a - 1] == player && board[2][a - 2] == player) {
                System.out.println(player + " win");
                isWon = true;
                break;
            }
        }
        if(isWon==true) break;

            

            if(player == 'X') {
                player= 'O' ;
            }
            else {
                player = 'X' ;
            }
            moves++;
        }

        if(moves==9 && !isWon){
            System.out.print( "\nGame over , but both does't win");
        }


    }
}
