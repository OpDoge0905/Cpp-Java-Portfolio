import java.util.Scanner;

public class TicTacToe{
    public static void main(String[] args){
        System.out.println("Welcome to TicTacToe");
        //Game Setting
        int boardSize = 3; //Change the Board Size
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
            System.out.println();
            System.out.println(" || Time for " + currPlayer + " || ");
            System.out.println(" || Insert Row (0-"+(boardSize-1)+") and Column (0-"+(boardSize-1)+") || ");
            
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            
            if(row<0||row>=boardSize||col<0||col>=boardSize){ 
                //Out of Range Illegal
                System.out.println("(0-"+(boardSize-1)+") ONLY!!");
            }
            else if(gameBoard[row][col] != '-'){
                //Repeat Illegal
                System.out.println("There's already a piece!");
            }
            else{
                //Legal
                gameBoard[row][col] = currPlayer;
                checkWinner(gameBoard, boardSize, currPlayer);
                roundInd++;
                if(roundInd >= boardSize*boardSize){
                    //TIE
                    currPlayer = 'T';
                    announceWinner(gameBoard, boardSize, currPlayer);
                }
                currPlayer = currPlayer=='O'? 'X':'O';
            }
        }
    }

    public static void printBoard(char[][] gameBoard, int roundInd, int boardSize){
        if(roundInd>=0){
            System.out.println("=== Round " + roundInd + " ===\n");
        }
        else{
            System.out.println("=== RESULT ===\n");
        }
        
        for(int row=0; row<boardSize; row++){
            for(int col=0; col<boardSize; col++){
                System.out.print(gameBoard[row][col] + " ");
            }
            System.out.println();
        }       
    }

    // public static void checkWinner(char[][] gameBoard, int boardSize, char currPlayer){
        // for(int row=0; row<boardSize; row++){
  
            // if (gameBoard[row][0]!='-' && (gameBoard[row][0]==gameBoard[row][1])&&(gameBoard[row][1]==gameBoard[row][2])){
                // announceWinner(gameBoard, boardSize, currPlayer);
            // }
            // if (gameBoard[0][row]!='-' && (gameBoard[0][row]==gameBoard[1][row])&&(gameBoard[1][row]==gameBoard[2][row])){
                // announceWinner(gameBoard, boardSize, currPlayer);
            // }
        // }
  
        // if (gameBoard[0][0]!='-' && (gameBoard[0][0]==gameBoard[1][1])&&(gameBoard[1][1]==gameBoard[2][2])){
            // announceWinner(gameBoard, boardSize, currPlayer);
        // }
        // if (gameBoard[0][2]!='-' && (gameBoard[0][2]==gameBoard[1][1])&&(gameBoard[1][1]==gameBoard[2][0])){
            // announceWinner(gameBoard, boardSize, currPlayer);
        // }
    // }

public static void checkWinner(char[][] gameBoard, int boardSize, char currPlayer){
        for(int row=0; row<boardSize; row++){
            boolean rowWin = true;
            //Row Check
            for(int col=1; col<boardSize; col++){
                if(gameBoard[row][col]!=gameBoard[row][0]||gameBoard[row][0]=='-'){
                    rowWin = false;
                    break;
                }
            }
            if(rowWin){
                announceWinner(gameBoard, boardSize, currPlayer);
            }
            //Col Check
            boolean colWin = true;
            for(int col=1; col<boardSize; col++){
                if(gameBoard[col][row]!=gameBoard[0][row]||gameBoard[0][row]=='-'){
                    colWin = false;
                    break;
                }
            }
            if(colWin){
                announceWinner(gameBoard, boardSize, currPlayer);
            }
        }
        //Diagonals Check
        boolean tlbrWin = true;
        for(int row=1; row<boardSize; row++){
            if(gameBoard[row][row]!=gameBoard[0][0]||gameBoard[0][0]=='-'){
                tlbrWin = false;
                break;
            }
        }
        if(tlbrWin){
            announceWinner(gameBoard, boardSize, currPlayer);
        }
        boolean trblWin = true;
        for(int row=1; row<boardSize; row++){
            if(gameBoard[row][boardSize-1-row]!=gameBoard[0][boardSize-1]||gameBoard[0][boardSize-1]=='-'){
                tlbrWin = false;
                break;
            }
        }
        if(trblWin){
            announceWinner(gameBoard, boardSize, currPlayer);
        }
    }

    public static void announceWinner(char[][] gameBoard, int boardSize, char currPlayer){
        if(currPlayer=='O'||currPlayer=='X'){
            System.out.println(" || \"" + currPlayer + "\"" + " WINS THE GAME!! || ");
        }
        else{
            System.out.println(" ||  TIE!! || ");
        }
        printBoard(gameBoard, -1, boardSize);
        System.exit(0);
    }
}