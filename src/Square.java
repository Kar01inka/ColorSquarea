import javax.swing.*;
import java.awt.*;

public class Square extends JPanel{

    Color color;
    Square(Color color){
        this.color=color;
        this.setBackground(this.color);
    }

}
