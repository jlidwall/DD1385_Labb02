import java.awt.Dimension;
import javax.swing.JButton;

public class Square extends JButton{

    private int row;
    private int col;

    public Square(String text, int x, int y){
        super(text);
        row = x;
        col = y;
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension preferredSize = super.getPreferredSize();
        int size = Math.max(preferredSize.width, preferredSize.height);
        return new Dimension(size, size);
    }

    public int[] getCoordinates(){
        int[] coordinates = {row, col};
        return coordinates;
    }

    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }
}
