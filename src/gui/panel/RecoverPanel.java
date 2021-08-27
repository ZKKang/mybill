package gui.panel;

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
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(RecoverPanel.instance);
    }

    @Override
    public void addListener() {

    }

    @Override
    public void updateData() {

    }
}
