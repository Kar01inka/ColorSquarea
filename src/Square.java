import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class Square extends JPanel{

    Color color;
    Square(Color color){
        this.color=color;
        this.setBackground(this.color);
        this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
    }

    void changeColor(int square, int color){

    }
}
