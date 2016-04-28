package ru.levelp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Юлия on 26.04.2016.
 */
public class CalculatorGUI extends BaseFrame {
    private JLabel display;
    private JButton[] numBtns;

    public CalculatorGUI() {
        super(true, "Calculator");
    }

    @Override
    protected void prepareContent() {
        //JMenuBar - верхнее меню (полоска меню)
        //JMenu - сам элемент меню бара (File, Edit,...)
        //JMenuItem - элементы выпадающего меню
        JMenuBar bar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu viewMenu = new JMenu("View");
        JMenuItem quitMenuItem = new JMenuItem("Quit");
        JMenuItem defaultViewMenuItem = new JMenuItem("Default");
        JMenuItem darkViewMenuItem = new JMenuItem("Dark");
        viewMenu.add(defaultViewMenuItem);
        viewMenu.add(darkViewMenuItem);
        fileMenu.add(viewMenu);
        fileMenu.add(quitMenuItem);
        bar.add(fileMenu);
        setJMenuBar(bar);

        //Game -> (New Game, Quit) | View -> (Default, Dark)

        quitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        display = new JLabel("0");

        JPanel numPanel = new JPanel(new GridLayout(4, 3));
        JPanel eastPanel = new JPanel(new GridLayout(2, 1));
        JPanel arithmeticPanel = new JPanel(new GridLayout(4, 2));

       // NumButtonListener numListener = new NumButtonListener();

        numBtns = new JButton[10];
        for (int i = 0; i < numBtns.length; i++) {
            numBtns[i] = new JButton(String.valueOf(i));
       //     numBtns[i].addActionListener(numListener);
        }

        for (int i = 7; i < numBtns.length; i++) {
            numPanel.add(numBtns[i]);
        }
        for (int i = 4; i < 7; i++) {
            numPanel.add(numBtns[i]);
        }
        for (int i = 1; i < 4; i++) {
            numPanel.add(numBtns[i]);
        }
        numPanel.add(numBtns[0]);
        JButton comaBtn = new JButton(",");
        // кнопка ,
        numPanel.add(comaBtn);
        // кнопка -/+
        JButton minusBtn = new JButton("+/-");
        numPanel.add(minusBtn);

        JButton addBtn = new JButton("+");
        JButton subBtn = new JButton("-");
        JButton mulBtn = new JButton("X");
        JButton divBtn = new JButton("/");
        JButton percentBtn = new JButton("%");
        JButton sqrtBtn = new JButton("sqrt");
        JButton clearBtn = new JButton("C");
        JButton backBtn = new JButton("Back");
        JButton resultBtn = new JButton("=");

      //  OperationsListener operListener = new OperationsListener();
      //  addBtn.addActionListener(operListener);
      //  subBtn.addActionListener(operListener);
       // mulBtn.addActionListener(operListener);
       // divBtn.addActionListener(operListener);
       // resultBtn.addActionListener(operListener);

        arithmeticPanel.add(clearBtn);
        arithmeticPanel.add(backBtn);
        arithmeticPanel.add(percentBtn);
        arithmeticPanel.add(sqrtBtn);
        arithmeticPanel.add(addBtn);
        arithmeticPanel.add(subBtn);
        arithmeticPanel.add(mulBtn);
        arithmeticPanel.add(divBtn);

        eastPanel.add(arithmeticPanel);
        eastPanel.add(resultBtn);

        add(BorderLayout.NORTH, display);
        add(BorderLayout.CENTER, numPanel);
        add(BorderLayout.EAST, eastPanel);
    }

    public void appendNum(String num) {
        display.setText(display.getText() + num);
    }

    public String getText() {
        return display.getText();
    }

    public void clearDisplay() {
        display.setText("0");
    }

    public void setText(String text) {
        display.setText(text);
    }
}

