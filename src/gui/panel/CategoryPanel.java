package gui.panel;

import gui.model.CategoryTableModel;
import gui.util.ColorUtil;
import gui.util.GUIUtil;

import javax.swing.*;
import java.awt.*;

public class CategoryPanel extends JPanel {
    static {
        GUIUtil.useLNF();
    }

    public static CategoryPanel instance = new CategoryPanel();

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
        btnPanel.add(bAdd);
        btnPanel.add(bEdit);
        btnPanel.add(bDelete);
        this.add(btnPanel,BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(CategoryPanel.instance,0.8);
    }
}
