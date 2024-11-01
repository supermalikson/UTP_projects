import javax.swing.*;
import java.awt.*;

public
class Main {

    public static final int width = 1100;
    public static final int height = 800;

    public static void main(String[] args) {


        JFrame window = new JFrame("Chess");
        window.setLayout(new GridBagLayout());
        window.getContentPane().setBackground(new Color(122, 217, 238, 255));
        window.setMinimumSize(new Dimension(width,height));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Board panel = new Board();
        window.add(panel);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);


    }
}
