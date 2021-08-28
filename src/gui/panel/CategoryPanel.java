package gui.panel;

import gui.entity.Category;
import gui.listener.CategoryListener;
import gui.model.CategoryTableModel;
import gui.service.CategoryService;
import gui.util.ColorUtil;
import gui.util.GUIUtil;

import javax.swing.*;
import java.awt.*;

public class CategoryPanel extends WorkingPanel {
    static {
        GUIUtil.useLNF();
    }

    public static CategoryPanel instance = new CategoryPanel();

    public JButton bDetail = new JButton("详情");
    public JButton bAdd = new JButton("新增");
    public JButton bEdit = new JButton("编辑");
    public JButton bDelete = new JButton("删除");

    String columNames[] = new String[]{"分类名称","消费次数"};

    public CategoryTableModel ctm = new CategoryTableModel();
    public JTable t =new JTable(ctm);

    private CategoryPanel(){
        GUIUtil.setColor(ColorUtil.blueColor, bAdd,bEdit,bDelete);
        this.setLayout(new BorderLayout());
        JScrollPane tablePane = new JScrollPane(t);
        this.add(tablePane,BorderLayout.CENTER);
        JPanel btnPanel = new JPanel();
        btnPanel.add(bDetail);
        btnPanel.add(bAdd);
        btnPanel.add(bEdit);
        btnPanel.add(bDelete);
        this.add(btnPanel,BorderLayout.SOUTH);
        addListener();
    }


    @Override
    public void addListener() {
        CategoryListener categoryListener = new CategoryListener();
        bAdd.addActionListener(categoryListener);
        bEdit.addActionListener(categoryListener);
        bDelete.addActionListener(categoryListener);
        bDetail.addActionListener(categoryListener);
    }

    @Override
    public void updateData() {
        ctm.cs = new CategoryService().list();
        t.updateUI();
        t.getSelectionModel().setSelectionInterval(0, 0);

        if(0==ctm.cs.size()){
            bEdit.setEnabled(false);
            bDelete.setEnabled(false);
        }
        else{
            bEdit.setEnabled(true);
            bDelete.setEnabled(true);
        }
    }

    public Category getSelectedCategory() {
        int index = t.getSelectedRow();
        return ctm.cs.get(index);
    }
}
