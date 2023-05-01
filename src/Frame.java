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
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);


    JPanel menu = new JPanel();
        menu.setBackground(new Color (0x888888));
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

        JTextArea instruction = new JTextArea("Choose squares to change the color, then choose a color. Only added squares can change color.");
        instruction.setLineWrap(true);
        instruction.setWrapStyleWord(true);
        instruction.setMaximumSize(new Dimension(250,70));
        instruction.setBackground(new Color(0x888888));
        Font instructionFont = new Font("Verdana", Font.PLAIN, 15);
        instruction.setFont(instructionFont);
        menu.add(instruction);


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
        }else if(e.getSource()==DeleteButton&& buttonNumber>-1){
            squares[buttonNumber].setBorder(null);
            squares[buttonNumber].setBackground(new Color(0xffffff));
            buttonNumber--;
        }else if(e.getSource()==ColorButton){
            new JColorChooser();
            Color color = JColorChooser.showDialog(null, "Pick a color", Color.white);
            for (int i=0;i<9;i++) {
                if(squareButtons[i].isSelected()&&i<=buttonNumber){
                    squares[i].setBackground(color);
                }
            }
        }
    }
}
