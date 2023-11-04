

public class MockModel implements Boardgame {

    private int counter;

    public MockModel(){
        counter = 0;
    }

    @Override
    public boolean move(int x, int y) {
        counter++;
        return true;
    }

    @Override
    public String getStatus(int x, int y) {
        return "Button!";
    }

    @Override
    public String getMessage() {
        return "You pressed a button " + counter + " times";
    }
    
}
