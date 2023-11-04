import java.util.ArrayList;

public class FifteenModel implements Boardgame{

    private String[][] board;
    private int n;
    private String message;

    public FifteenModel() {
        n = 4;  // size of squared board
        board = new String[n][n];  // create new board matrix
        initializeBoard();
        shuffleBoard();
    }

    // method that shuffles the board by doing a certain amount of moves
    private void shuffleBoard() {

        System.out.println("Shuffling the board...");

        int[] emptyPos = {n-1, n-1}; // initialize empty position at bottom right corner
        
        // randomize a certain amount of moves to shuffle
        for (int i=0; i<1000; i++){
            
            // coordinates for empty position
            int x = emptyPos[0];
            int y = emptyPos[1];

            int[][] neighbors = getValidNeighbours(x, y);
            int possibleMoves = neighbors.length;

            // randomize an integer between 0 and possibleMoves-1 using Math.random
            int min = 0;
            int max = possibleMoves-1;
            int randomInt = (int) (Math.random() * (max - min + 1) + min);

            // use the randomized integer to select next move
            int[] nextMove = neighbors[randomInt];

            // make sure that the next move is possible before updating emptyPos
            if(move(nextMove[0], nextMove[1])){
                emptyPos = nextMove;
            }
        }
    }

    private void initializeBoard(){
        
        int count = 1;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                board[i][j] = String.format("%2d", count);  // format strings to have the same widt
                count++;
            }
        }

        board[n-1][n-1] = "  ";  // set last position as empty
    }

    // method that returns the possible moves from a given position inside the board
    private int[][] getValidNeighbours(int x, int y){

        int noOfValidNeighbours = 0;
        ArrayList<int[]> validNeighbours = new ArrayList<>();

        // adjecent coordinates
        int[] left = {x, y-1};
        int[] right = {x, y+1};
        int[] up = {x-1, y};
        int[] down = {x+1, y};

        if (y != 0){    // if choosen column is not 0 we can move left
            noOfValidNeighbours += 1;
            validNeighbours.add(left);
        }
        if (y != n-1){  // if choosen column is not n-1 we can move right
            noOfValidNeighbours += 1;
            validNeighbours.add(right);
        }
        if (x != 0) {   // if chosen row is not 0 we can move up
           noOfValidNeighbours += 1;
           validNeighbours.add(up); 
        }
        if (x != n-1) { // if chosen row is not n-1 we can move down
            noOfValidNeighbours += 1;
            validNeighbours.add(down);
        }
        
        int[][] returnArr = new int[noOfValidNeighbours][2];    // create a 2d int array

        // add possible neighbours to the return array
        int index = 0;
        for (int[] neighbour : validNeighbours){
            returnArr[index] = neighbour;
            index += 1;
        }

        return returnArr;
    }

    @Override
    public boolean move(int x, int y) {
        
        // check that x and y provide a coordinate within the board
        if (x >= 0 && x < n && y >= 0 && y < n){
            // // adjecent coordinates
            // int[] left = {x, y-1};
            // int[] right = {x, y+1};
            // int[] up = {x-1, y};
            // int[] down = {x+1, y};

            // int[][] directions = {left, right, up, down};
            int[][] directions = getValidNeighbours(x, y);
            // for (int[] direction : directions){
            //     System.out.println("Valid directions: " + direction[0] + " " + direction[1]);
            // }

            // loop over adjecent positions to find an empty position
            for (int[] direction : directions){
                int row = direction[0];
                int col = direction[1];
                // check status on adjecent positions
                String status = getStatus(row, col);

                if (status == "  "){     // if an adjecent position is empty the move is possible
                    
                    // swap empty position with choosen position
                    board[row][col] = board[x][y];
                    board[x][y] = "  ";
                    
                    message = "OK"; // update message

                    return true;
                }
            }

            // no empty adjecent position so the move is not possible, return false
            message = "Please choose a position next to the empty one!";    // update massage
            return false;  
        
        }

        else {
            // choosen position is not within the board
            message = "Please choose a position within the board!";
            return false;
        }

    }

    @Override
    public String getStatus(int x, int y) {
        if (x >= 0 && x < n && y >= 0 && y < n){
            return board[x][y];
        }
        else{
            return "Position out of bounds";
        }   
        
    }

    @Override
    public String getMessage() {
        return message;
    }
    
}
