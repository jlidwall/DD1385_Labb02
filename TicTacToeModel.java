public class TicTacToeModel implements Boardgame{

    private String[][] board;
    private String message;
    private boolean firstMove;
    private String turn;
    private int moveCount;

    public TicTacToeModel(){
        board = new String[3][3];
        message = "Player one's turn";
        firstMove = true;
        moveCount = 0;
        turn = "X";
    }

    @Override
    public boolean move(int x, int y) {

        String status = getStatus(x, y); 

        if (moveCount < 6) {   // utplaceringsfas
            if (status == null && !(x == 1 && y == 1)) { // empty square and not center square
                board[x][y] = turn; // place pawn
                switchturn();
                moveCount += 1;
                return true;
            }
            else {
                message = "Felaktigt drag";
                return false;
            }
            // kolla att det inte ligger en spelpjäs där
            // placera ut spelpjäs och returnera true

        }
        else { // flyttfas
            // kolla vilken spelares tur det är
            // kolla först att en korrekt spelpjäs är vald
            // kolla sedan att en tom ruta trycks som är granne 
            // slutligen flytta spelpjäs och returna true
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
    
}
