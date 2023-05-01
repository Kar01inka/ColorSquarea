import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;


public class Button extends JButton{

    Button(String text){
        this.setText(text);
        this.setBackground(new Color(0x999999));
        this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.setMaximumSize(new Dimension(250,70));
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setFont(new Font("Verdana", Font.PLAIN, 15));
    }


}
