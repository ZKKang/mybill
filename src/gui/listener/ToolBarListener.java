package gui.listener;

import gui.panel.*;
import gui.service.RecordService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class ToolBarListener implements ActionListener {
    public static Map<JButton,JPanel> jb2jp = null;


    @Override
    public void actionPerformed(ActionEvent e) {
        MainPanel mainPanel = MainPanel.instance;
        JButton button = (JButton)e.getSource();

        RecordPanel.instance.id = -1;
        if(MainPanel.instance.bRecordDetail == button) {
            RecordDetailPanel.instance.bEdit.setEnabled(true);
            RecordDetailPanel.instance.recordTableModel.records = new RecordService().list();
        }


        jb2jp = new HashMap<>();
        jb2jp.put(MainPanel.instance.bBackup, BackUpPanel.instance);
        jb2jp.put(MainPanel.instance.bCategory, CategoryPanel.instance);
        jb2jp.put(MainPanel.instance.bRecordDetail, RecordDetailPanel.instance);
        jb2jp.put(MainPanel.instance.bConfig, ConfigPanel.instance);
        jb2jp.put(MainPanel.instance.bSpend, SpendPanel.instance);
        jb2jp.put(MainPanel.instance.bRecord, RecordPanel.instance);
        jb2jp.put(MainPanel.instance.bRecover, RecoverPanel.instance);
        jb2jp.put(MainPanel.instance.bReport, ReportPanel.instance);
        mainPanel.workingPanel.show(jb2jp.get(button));

    }
}
