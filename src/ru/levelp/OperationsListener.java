package ru.levelp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Юлия on 26.04.2016.
 */
public class OperationsListener implements ActionListener {
    private String operation = "+";
    private double operand = 0;
    private CalculatorUI ui;

    public OperationsListener(CalculatorUI ui) {
        this.ui = ui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton pressed = (JButton) e.getSource();

        if (pressed.getText().equals("+")) {
            this.operation = "+";
            operand = Double.parseDouble(ui.getText());
            ui.clearDisplay();
        } else if (pressed.getText().equals("=")) {
            double operand2 = Double.parseDouble(ui.getText());
            double result = 0;
            if (operation.equals("+")) {
                result = operand + operand2;
            }
            ui.setText(String.valueOf(result));
        }
    }


}
