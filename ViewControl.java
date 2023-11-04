import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ViewControl extends JFrame implements ActionListener {

    private Boardgame game;
    private int size;
    private Square[][] board;
    private JTextField mess = new JTextField();

    ViewControl (Boardgame gm, int n, String title){

        game = gm;
        size = n;
        board = new Square[size][size];

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("William Rosengren - Jonatan Lidwall");

        JPanel mainPanel = new JPanel(new GridLayout(2, 1));
        getContentPane().add(mainPanel);

        mess.setText(title);
        mess.setEditable(false);
        mainPanel.add(mess);

        JPanel buttonPanel = addButtons();
        mainPanel.add(buttonPanel);

        add(mainPanel);
        pack();
        setVisible(true);
        
        // Create a JPanel with a 4x4 GridLayout
        //JPanel panel = new JPanel(new GridLayout(size, size));
    }
        
    private JPanel addButtons() {

        // create a new panel with the grid layout manager for the buttons
        JPanel buttonPanel = new JPanel(new GridLayout(size, size));

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                board[row][col] = new Square(game.getStatus(row, col), row, col);
                board[row][col].addActionListener(this); // Register ActionListener
                buttonPanel.add(board[row][col]);
            }
        }
        return buttonPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Square source = (Square) e.getSource();
        game.move(source.getRow(), source.getCol());
        mess.setText(game.getMessage());
        updateButtons();
    }

    private void updateButtons() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                board[row][col].setText(game.getStatus(row, col));
            }
        }
    }

    // public static void main(String[] args) {
    //     SwingUtilities.invokeLater(() -> {
    //         ViewControl viewControl = new ViewControl(null, 4);
    //     });
    // }
}


