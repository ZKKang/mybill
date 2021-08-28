package gui.panel;

import gui.listener.RecoverListener;
import gui.util.ColorUtil;
import gui.util.GUIUtil;

import javax.swing.*;

public class RecoverPanel extends WorkingPanel {
    static {
        GUIUtil.useLNF();
    }

    public static RecoverPanel instance = new RecoverPanel();

    public JButton bBack = new JButton("恢复");

    private RecoverPanel(){
        GUIUtil.setColor(ColorUtil.blueColor,bBack);
        this.add(bBack);
        addListener();
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(RecoverPanel.instance);
    }

    @Override
    public void addListener() {
        bBack.addActionListener(new RecoverListener());
    }

    @Override
    public void updateData() {

    }
}
