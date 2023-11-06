public class TicTacToeModel implements Boardgame{

    private String[][] board;
    private String message;
    private boolean firstStep;
    private String pawn;
    private int moveCount;
    private int[] prevClick = new int[2];

    public TicTacToeModel(){
        board = new String[3][3];
        message = "Player one's turn";
        firstStep = true;
        moveCount = 0;
        pawn = "X";
        // initialize board
        for (int i = 0; i < 3; i++){
             for (int j = 0; j < 3; j++){
                 board[i][j] = " ";
             }
        }
    }

    @Override
    public boolean move(int x, int y) {

        String status = getStatus(x, y);

        if (moveCount < 6) {   // utplaceringsfas
            if (status == " " && !(x == 1 && y == 1)) { // empty square and not center square
                board[x][y] = pawn; // place pawn
                switchTurn();
                moveCount += 1;
                return true;
            }
            else {  // non legal move
                message = "Please choose an empty position on the edge of the board";
                return false;
            }
        }
        else { // flyttfas
            // X or O depending on hows playing, p1 = X, p2 = O
           if (firstStep){
               if (status != pawn) { // not choosen the right pawn
                   message = "Please choose a pawn of type: " + pawn;
                   return false;
               }
               
               else{ // has choosen the right pawn
                   prevClick[0] = x; // Store current click to prevois click so we can use it with in the next click
                   prevClick[1] = y;
                   firstStep = false;
                   message = "Choose an empty square";
                   return true;
               } 
           }
           else{ // not the first move, means its time to choose an emtpy sqaure
               if(status != " "){ // a square that already has a pawn placed is clicked
                   message = "Please choose an empty square";
                   return false;
               }
               else{ // gets here if a empty square is pressed
                   board[x][y] = pawn; // swap squares between prevClick and current click
                   board[prevClick[0]][prevClick[1]] = " ";
                   firstStep = true;
                   switchTurn();
                   return true;
               }
               
           }
       }
   }

    @Override
    public String getStatus(int x, int y) {
        if (board[x][y] == null){
            return " ";
        }
        else {
            return board[x][y];
        }
    }

    @Override
    public String getMessage() {
        return message;
    }

    private void switchTurn(){
        if (pawn == "X"){
            pawn ="O";
            message = "Player two's turn";
        }
        else{
            pawn = "X";
            message = "Player one's turn";
        }
    }
}
