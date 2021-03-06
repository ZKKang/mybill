package gui.panel;

import gui.listener.ToolBarListener;
import gui.util.CenterPanel;
import gui.util.GUIUtil;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    static {
        GUIUtil.useLNF();
    }
    public static MainPanel instance = new MainPanel();
    public JToolBar tb = new JToolBar();
    public JButton bSpend = new JButton();
    public JButton bRecord = new JButton();
    public JButton bCategory = new JButton();
    public JButton bRecordDetail = new JButton();
    public JButton bReport = new JButton();
    public JButton bConfig = new JButton();
    public JButton bBackup = new JButton();
    public JButton bRecover = new JButton();

    public CenterPanel workingPanel;
    private MainPanel() {
        GUIUtil.setImageIcon(bSpend, "home.png", "消费一览");
        GUIUtil.setImageIcon(bRecord, "record.png", "记一笔");
        GUIUtil.setImageIcon(bCategory, "category2.png", "消费分类");
        GUIUtil.setImageIcon(bRecordDetail, "category1.png", "消费详情");
        GUIUtil.setImageIcon(bReport, "report.png", "月消费报表");
        GUIUtil.setImageIcon(bConfig, "config.png", "设置");
        GUIUtil.setImageIcon(bBackup, "backup.png", "备份");
        GUIUtil.setImageIcon(bRecover, "restore.png", "恢复");
        tb.add(bSpend);
        tb.add(bRecord);
        tb.add(bCategory);
        tb.add(bRecordDetail);
        tb.add(bReport);
        tb.add(bConfig);
        tb.add(bBackup);
        tb.add(bRecover);
        tb.setFloatable(false);
        setLayout(new BorderLayout());
        add(tb, BorderLayout.NORTH);
        workingPanel = new CenterPanel(0.9);
        add(workingPanel,BorderLayout.CENTER);

        addListener();

    }

    private void addListener() {
        ToolBarListener toolBarListener = new ToolBarListener();
        bSpend.addActionListener(toolBarListener);
        bRecord.addActionListener(toolBarListener);
        bCategory.addActionListener(toolBarListener);
        bReport.addActionListener(toolBarListener);
        bConfig.addActionListener(toolBarListener);
        bBackup.addActionListener(toolBarListener);
        bRecover.addActionListener(toolBarListener);
        bRecordDetail.addActionListener(toolBarListener);
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(MainPanel.instance,1);
    }
}
