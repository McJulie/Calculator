package ru.levelp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Юлия on 26.04.2016.
 */
public class NumButtonListener implements ActionListener {
    private CalculatorUI ui;

    public NumButtonListener(CalculatorUI ui) {
        this.ui = ui;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        ui.appendNum(button.getText());
    }
}

