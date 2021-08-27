package gui.listener;

import gui.entity.Category;
import gui.panel.RecordPanel;
import gui.service.RecordService;
import gui.util.GUIUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecordListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        RecordService recordService = new RecordService();
        RecordPanel recordPanel = RecordPanel.instance;
        String spend = recordPanel.tfSpend.getText();
        if(GUIUtil.checkZero(recordPanel.tfSpend,"消费金额")){
            recordService.add(Integer.valueOf(spend),(Category) recordPanel.cbCategory.getSelectedItem(),recordPanel.tfComment.getText(),recordPanel.datepick.getDate());
        }
    }
}