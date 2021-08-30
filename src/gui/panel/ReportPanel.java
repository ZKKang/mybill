package gui.panel;

import gui.entity.Record;
import gui.service.ReportService;
import gui.util.ChartUtil;
import gui.util.GUIUtil;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ReportPanel extends WorkingPanel {
    static {
        GUIUtil.useLNF();
    }

    public static ReportPanel instance = new ReportPanel();


    public JLabel l = new JLabel();
    private ReportPanel() {
        this.setLayout(new BorderLayout());
        List<Record> rs = new ReportService().listThisMonthRecords();

        Image image = ChartUtil.getImage(rs,700,460);
        ImageIcon icon = new ImageIcon(image);
        l.setIcon(icon);
        this.add(l);

    }

    public static void main(String[] args) {
        GUIUtil.showPanel(ReportPanel.instance);
    }

    @Override
    public void addListener() {

    }

    @Override
    public void updateData() {

    }
}
