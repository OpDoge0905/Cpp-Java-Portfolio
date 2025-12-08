import java.util.Scanner;

public class TicTacToe{
    public static void main(String[] args){
        System.out.println("Welcome to TicTacToe");
        //Game Setting
        int boardSize = 3;
        char gameBoard[][] = new char[boardSize][boardSize];
        int roundInd = 0;
        char currPlayer = 'O';

        //Initialize board
        for(int row=0; row<boardSize; row++){
            for(int col=0; col<boardSize; col++){
                gameBoard[row][col] = '-';
            }
        }

        Scanner scanner = new Scanner(System.in);
        //Game Section
        while(true){
            printBoard(gameBoard, roundInd, boardSize);
            System.out.println("Time for " + currPlayer);
            System.out.println("Insert Row (0-"+(boardSize-1)+") and Column (0-"+(boardSize-1)+")");
            
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            
            if(row<0||row>=boardSize||col<0||col>=boardSize){ //||!(row instanceof Integer)||!(col instanceof Integer) =>not pratical!
                System.out.println("(0-"+(boardSize-1)+") ONLY!!");
            }
            else if(gameBoard[row][col] != '-'){
                System.out.println("There's already a piece!");
            }
            else{
                gameBoard[row][col] = currPlayer;
                currPlayer = currPlayer=='O'? 'X':'O';
                roundInd++;
            }
            

        }

    }

    public static void printBoard(char[][] gameBoard, int roundInd, int boardSize){
        System.out.println("=== Round " + roundInd + " ===");
        for(int row=0; row<boardSize; row++){
            for(int col=0; col<boardSize; col++){
                System.out.print(gameBoard[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void checkWinner(char[][] gameBoard, int boardSize){
        for(int row=0; row<boardSize; row++){
            if (gameBoard[row][0]!='-'){
                if((gameBoard[row][0]==gameBoard[row][1])&&(gameBoard[row][1]==gameBoard[row][2]))
            }
        }
    }
}