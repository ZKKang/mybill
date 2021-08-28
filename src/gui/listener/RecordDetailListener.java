package gui.listener;

import gui.dialog.MainDialog;
import gui.entity.Category;
import gui.entity.Record;
import gui.panel.RecordDetailPanel;
import gui.panel.RecordPanel;
import gui.service.RecordService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RecordDetailListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        RecordService recordService = new RecordService();
        RecordDetailPanel detailPanel = RecordDetailPanel.instance;
        if(detailPanel.bQuery == button) {
            Record record = new Record();
            Category selectCategory = (Category) detailPanel.cbCategory.getSelectedItem();
            record.setCategoryId(selectCategory.getId());
            record.setCategoryName(selectCategory.getName());
            record.setComment(detailPanel.tComment.getText().trim());
            record.setStartDate(detailPanel.startDate.getDate());
            record.setEndDate(detailPanel.endDate.getDate());
            List<Record> recordList =  recordService.list(record);
            detailPanel.recordTableModel.records = recordList;
        }else if(detailPanel.bEdit == button) {
            Record record = detailPanel.getSelectedRecord();
            RecordPanel.instance.id = record.getId();
            RecordPanel.instance.cbModel.setSelectedItem(record.getCategoryId());
            RecordPanel.instance.tfSpend.setText(String.valueOf(record.getSpend()));
            RecordPanel.instance.tfComment.setText(record.getComment());
            RecordPanel.instance.datepick.setDate(record.getDate());
            RecordPanel.instance.bSubmit.setText("修改");
            MainDialog.instance.addPanel(RecordPanel.instance);
            MainDialog.instance.setVisible(true);
        }else if(detailPanel.bDelete == button) {
            Record record = detailPanel.getSelectedRecord();
            recordService.delete(record);
        }else if(detailPanel.bQueryAll == button) {
            List<Record> recordList =  recordService.list();
            detailPanel.recordTableModel.records = recordList;
        }
        detailPanel.updateData();

    }
}
