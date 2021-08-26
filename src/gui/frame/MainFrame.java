package gui.frame;

import gui.panel.MainPanel;
import gui.util.GUIUtil;

import javax.swing.*;

public class MainFrame extends JFrame {
    static {
        GUIUtil.useLNF();
    }
    public static MainFrame instance = new MainFrame();

    private MainFrame() {
        this.setSize(500,450);
        this.setTitle("我的账单");
        this.setContentPane(MainPanel.instance);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        instance.setVisible(true);
    }
}