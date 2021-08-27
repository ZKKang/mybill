package gui.panel;

import gui.util.ColorUtil;
import gui.util.GUIUtil;

import javax.swing.*;

public class BackUpPanel extends WorkingPanel {
    static {
        GUIUtil.useLNF();
    }

    public static BackUpPanel instance = new BackUpPanel();

    public JButton bBack = new JButton("备份");

    private BackUpPanel(){
        GUIUtil.setColor(ColorUtil.blueColor,bBack);
        this.add(bBack);
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(BackUpPanel.instance);
    }

    @Override
    public void addListener() {

    }

    @Override
    public void updateData() {

    }
}
