public class TicTacToeModel implements Boardgame{

    private String[][] board;
    private String message;
    private boolean firstMove;
    private int moveCount;

    public TicTacToeModel(){
        board = new String[3][3];
        message = "Player one's turn";
        firstMove = true;
        moveCount = 0;
    }

    @Override
    public boolean move(int x, int y) {

        if (moveCount < 6) {   // utplaceringsfas
            // kolla att det inte är mittpunkten
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
