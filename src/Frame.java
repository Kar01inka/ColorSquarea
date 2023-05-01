import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame implements ActionListener {

    Button AddButton;
    Button DeleteButton;
    Button ColorButton;
    Square[] squares;
    JRadioButton[] squareButtons;
    int buttonNumber = -1;


    Frame(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);


    JPanel menu = new JPanel();
        menu.setBackground(new Color (0x555555));
        menu.setPreferredSize(new Dimension(300, 300));
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
        this.add(menu, BorderLayout.WEST);

        AddButton = new Button("Add square");
        menu.add(AddButton);
        AddButton.addActionListener(this);
        DeleteButton = new Button("Delete square");
        menu.add(DeleteButton);
        DeleteButton.addActionListener(this);
        ColorButton = new Button("Choose color");
        menu.add(ColorButton);
        ColorButton.addActionListener(this);

    JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(0xa0a0a0));
        mainPanel.setLayout(new GridLayout(3,3));
        this.add(mainPanel, BorderLayout.CENTER);

        squares = new Square[9];
        squareButtons = new JRadioButton[9];
        for(int i=0;i<9;i++){
        squares[i] = new Square(Color.white);
        mainPanel.add(squares[i]);
        squareButtons[i] = new JRadioButton(Integer.toString(i+1));
        menu.add(squareButtons[i]);
    }

        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==AddButton && buttonNumber<8){
            buttonNumber++;
            squares[buttonNumber].setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
            squares[buttonNumber].setBackground(new Color(0xff0000));
        }else if(e.getSource()==DeleteButton&& buttonNumber>-1){
            squares[buttonNumber].setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
            squares[buttonNumber].setBackground(new Color(0xffffff));
            buttonNumber--;
        }else if(e.getSource()==ColorButton){
            JColorChooser colorChooser = new JColorChooser();
            Color color = JColorChooser.showDialog(null, "Pick a color", Color.white);
            for (int i=0;i<9;i++) {
                if(squareButtons[i].isSelected()&&i<=buttonNumber){
                    squares[i].setBackground(color);
                }
            }
        }
    }
}
