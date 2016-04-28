package ru.levelp;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Юлия on 26.04.2016.
 */
public class MyButton extends JButton {
    public MyButton(String a) {

        JButton MyButton = new JButton();
        Font font = new Font("Times New Roman", Font.PLAIN, 14);
        MyButton.setFont(font);
        MyButton.setForeground(Color.blue);
        MyButton.setBackground(Color.black);

    }


}

