import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;

import static javax.swing.JFrame.*;

public class Main {
    public static void main(String[] args) {

        JFrame mainFrame = new JFrame();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        mainFrame.setExtendedState(MAXIMIZED_BOTH);
        mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel menu = new JPanel();
        menu.setBackground(new Color (0x555555));
        menu.setPreferredSize(new Dimension(300, 300));
        menu.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(0xa0a0a0));
        mainPanel.setLayout(new GridLayout(3,3));

        mainFrame.add(menu, BorderLayout.WEST);
        mainFrame.add(mainPanel, BorderLayout.CENTER);

        Square square1 = new Square(Color.red);
        mainPanel.add(square1);

        JButton button = new JButton("Add square");
        button.setBackground(new Color(0x999999));
        button.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        button.setSize(200, 75);

        menu.add(button);

        

        for(int i=0;i<9;i++){

        }


        mainFrame.setVisible(true);
    }
}