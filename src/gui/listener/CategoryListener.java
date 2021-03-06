package gui.listener;

import gui.dialog.MainDialog;
import gui.entity.Category;
import gui.panel.CategoryPanel;
import gui.panel.RecordDetailPanel;
import gui.service.CategoryService;
import gui.service.RecordService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CategoryListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        CategoryPanel categoryPanel = CategoryPanel.instance;
        if(categoryPanel.bAdd == button) {
            String name = JOptionPane.showInputDialog(null);
            if (0 == name.length()) {
                JOptionPane.showMessageDialog(categoryPanel, "分类名称不能为空");
                return;
            }

            new CategoryService().add(name);
        }
        if (button == categoryPanel.bEdit) {
            Category c = categoryPanel.getSelectedCategory();
            int id = c.getId();
            String name = JOptionPane.showInputDialog("修改分类名称", c.getName());
            if (0 == name.length()) {
                JOptionPane.showMessageDialog(categoryPanel, "分类名称不能为空");
                return;
            }

            new CategoryService().update(id, name);
        }
        if (button == categoryPanel.bDelete) {
            Category c = categoryPanel.getSelectedCategory();
            if (0 != c.getRecordNumber()) {
                JOptionPane.showMessageDialog(categoryPanel, "本分类下有消费记录存在，不能删除");
                return;
            }
            if (JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(categoryPanel, "确认要删除？"))
                return;

            int id = c.getId();
            new CategoryService().delete(id);
        }
        if (button == categoryPanel.bDetail) {
            Category c = categoryPanel.getSelectedCategory();
            if (0 == c.getRecordNumber()) {
                JOptionPane.showMessageDialog(categoryPanel, "本分类下无消费记录存在");
                return;
            }
            RecordDetailPanel recordDetailPanel = RecordDetailPanel.instance;
            Category category = categoryPanel.getSelectedCategory();
            recordDetailPanel.recordTableModel.records = new RecordService().listByCategoryId(category);
            recordDetailPanel.bEdit.setEnabled(false);
            MainDialog.instance.addPanel(recordDetailPanel);

            MainDialog.instance.setVisible(true);

        }
        categoryPanel.updateData();
    }
}
