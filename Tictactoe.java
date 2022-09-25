import java.util.*;

public class Tictactoe{
    
    public static String[][] matrix = new String[3][3];
    public static String turn;
    public static boolean gameOver;
    public static String winner;
    
    Tictactoe(String[][] matrix1,String Pturn){
        for(int i = 0; i<matrix.length;i++){
            for(int j = 0;j<matrix.length;j++){
                matrix[i][j] = matrix1[i][j];
            }
        }
        
        turn = Pturn;
        gameOver = false;
        
    }
    public static void changeTurn(){
        turn = turn.equals("X") ? "O" : "X";
    }
    
    public static boolean checkWin(){
        for(int i = 0; i<matrix.length;i++){
            // Checking horizontal win
            if(matrix[i][0].equals(matrix[i][1]) && matrix[i][0].equals(matrix[i][2])){
                return true;
            }
            
            // Checking vertical win
            if(matrix[0][i].equals(matrix[1][i]) && matrix[0][i].equals(matrix[2][i])){
                return true;
            }
            
        }
        
        // Check diagonal wins
        if(matrix[0][0].equals(matrix[1][1]) && matrix[0][0].equals(matrix[2][2])){
            return true;
        }
        if(matrix[0][2].equals(matrix[1][1]) && matrix[0][2].equals(matrix[2][0])){
            return true;
        }
        return false;
      
    }
    
    public static void main(String args[]){
        String[][] matrix = {{"1","2","3"},{"4","5","6"},{"7","8","9"}};
        System.out.println("\t\tTic Tac Toe");
        Tictactoe tictactoe = new Tictactoe(matrix,"X");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter turn: ");
        String turn = sc.nextLine();
        Tictactoe ttt = new Tictactoe(matrix,turn);
        
        // Game part
        
        game: while(!(ttt.gameOver)){
            System.out.println(" -------");
            for(int i = 0;i<ttt.matrix.length;i++){
                System.out.print("|");
                for(int j = 0;j<ttt.matrix.length;j++){
                    System.out.print(" "+ttt.matrix[i][j]);
                }
                System.out.println(" |");
            }
            System.out.println(" -------");
            
            // Taking input
            System.out.println("Enter the box you want to fill: ");
            String box = sc.nextLine();
            if(Integer.parseInt(box)>=1 && Integer.parseInt(box)<=9){
                for(int i = 0; i<ttt.matrix.length;i++){
                    for(int j = 0;j<ttt.matrix.length;j++){
                        if(box.compareTo(ttt.matrix[i][j]) == 0){
                            ttt.matrix[i][j] = ttt.turn;
                            break;
                        }
                    }
                }
                
            
            }else{
                System.out.println("Invalid input");
                continue game;
            }
            
            // Checking win
            boolean WinOrNot = checkWin();
            if(WinOrNot == true){
                System.out.println(ttt.turn+" has won the game!!!");
                break game;
            }
            
            // Changing turn
            ttt.changeTurn();
            
        }
        
    }
}
