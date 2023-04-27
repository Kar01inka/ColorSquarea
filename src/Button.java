import javax.swing.*;

public class Button extends JButton {
    int buttonNumber = 0;

    String buttonText;

    Button(){

    }

    int addButton(){
        buttonNumber++;

        return buttonNumber;
    }
    int removeButton(){
        buttonNumber--;

        return buttonNumber;
    }
}
