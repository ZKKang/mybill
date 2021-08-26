package gui.panel;

import gui.util.ChartUtil;
import gui.util.GUIUtil;

import javax.swing.*;
import java.awt.*;

public class ReportPanel extends JPanel {
    static {
        GUIUtil.useLNF();
    }

    public static ReportPanel instance = new ReportPanel();


    public JLabel l = new JLabel();
    private ReportPanel() {
        this.setLayout(new BorderLayout());
        Image image = ChartUtil.getImage(350,230);
        ImageIcon icon = new ImageIcon(image);
        l.setIcon(icon);
        this.add(l);

    }

    public static void main(String[] args) {
        GUIUtil.showPanel(ReportPanel.instance);
    }
}
