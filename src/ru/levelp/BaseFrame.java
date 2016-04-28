package ru.levelp;

import javax.swing.*;

/**
 * Created by Юлия on 26.04.2016.
 */
public class BaseFrame extends JFrame {
    public BaseFrame(boolean exitOnClose, String title) {
        super(title);
        init(exitOnClose);
    }

    public BaseFrame(boolean exitOnClose) {
        init(exitOnClose);
    }

    private void init(boolean exitOnClose) {
        if (exitOnClose) {
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }
        setBounds(100, 100, 400, 550);

        prepareContent();
    }

    protected void prepareContent() {

    }
}
