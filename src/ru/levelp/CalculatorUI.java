package ru.levelp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Юлия on 26.04.2016.
 */
public class CalculatorUI extends BaseFrame {
    private JLabel display;
    private JButton[] numBtns;

    public CalculatorUI() {
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

        JPanel firstPanel = new JPanel(new GridLayout(3, 1));
        JPanel secondPanel = new JPanel(new GridLayout(2, 4));
        JPanel thirdPanel = new JPanel(new GridLayout(2, 4));
        JPanel fourthPanel = new JPanel(new GridLayout(2, 1));
        JPanel fifthPanel = new JPanel(new GridLayout(1, 4));
        JPanel sixthPanel = new JPanel(new GridLayout(1, 2));
                JPanel seventhPanel = new JPanel(new GridLayout(1, 2));

        JPanel eastPanel = new JPanel(new GridLayout(3, 1));
        JPanel firstEastPanel = new JPanel(new GridLayout(2, 1));
        JPanel secondEastPanel = new JPanel(new GridLayout(2, 1));

        NumButtonListener numListener = new NumButtonListener(this);

        numBtns = new JButton[10];
        for (int i = 0; i < numBtns.length; i++) {
            numBtns[i] = new JButton(String.valueOf(i));
            numBtns[i].addActionListener(numListener);
        }

        for (int i = 7; i < numBtns.length; i++) {
            thirdPanel.add(numBtns[i]);

        }
        JButton divBtn = new JButton("/");
        thirdPanel.add(divBtn);
        for (int i = 4; i < 7; i++) {
            thirdPanel.add(numBtns[i]);
        }
        JButton mulBtn = new JButton("X");
        thirdPanel.add(mulBtn);
        for (int i = 1; i < 4; i++) {
            fifthPanel.add(numBtns[i]);
        }
        MyButton subBtn = new MyButton("-");
        fifthPanel.add(subBtn);

        sixthPanel.add(numBtns[0]);
        JButton comaBtn = new JButton(",");

        seventhPanel.add(comaBtn);
                JButton addBtn = new JButton("+");
        seventhPanel.add(addBtn);

        JButton mcBtn = new JButton("MC");
        JButton mrBtn = new JButton("MR");
        JButton msBtn = new JButton("MS");
        JButton memaddBtn = new JButton("M+");
        JButton memdelBtn = new JButton("M-");
        JButton backBtn = new JButton("<-");
        JButton cleareBtn = new JButton("CE");
        JButton clearBtn = new JButton("C");
        JButton minusBtn = new JButton("+/-");
        JButton sqrtBtn = new JButton("Sqrt");
        JButton percentBtn = new JButton("%");
        JButton transpBtn = new JButton("1/x");
        JButton resultBtn = new JButton("=");
        secondPanel.add(mcBtn);
        secondPanel.add(mrBtn);
        secondPanel.add(msBtn);
        secondPanel.add(memaddBtn);
        secondPanel.add(backBtn);
        secondPanel.add(cleareBtn);
        secondPanel.add(clearBtn);
        secondPanel.add(minusBtn);
        firstEastPanel.add(memdelBtn);
        firstEastPanel.add(sqrtBtn);
        secondEastPanel.add(percentBtn);
        secondEastPanel.add(transpBtn);
        OperationsListener operListener = new OperationsListener(this);
        addBtn.addActionListener(operListener);
        subBtn.addActionListener(operListener);
        mulBtn.addActionListener(operListener);
        divBtn.addActionListener(operListener);
        resultBtn.addActionListener(operListener);


        eastPanel.add(firstEastPanel);
        eastPanel.add(secondEastPanel);
        eastPanel.add(resultBtn);
Font font = new Font("Times New Roman", Font.PLAIN, 24 );
        display.setFont(font);
        add(BorderLayout.NORTH, display);
        add(BorderLayout.CENTER, firstPanel);
        firstPanel.add(secondPanel);
        firstPanel.add(thirdPanel);
        firstPanel.add(fourthPanel);
        fourthPanel.add(fifthPanel);
        fourthPanel.add(sixthPanel);

        sixthPanel.add(seventhPanel);
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