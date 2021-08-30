package gui.panel;

import gui.entity.Category;
import gui.listener.RecordListener;
import gui.model.CategoryComboBoxModel;
import gui.service.CategoryService;
import gui.util.ColorUtil;
import gui.util.GUIUtil;
import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class RecordPanel extends WorkingPanel {
    static {
        GUIUtil.useLNF();
    }
    public static RecordPanel instance = new RecordPanel();

    JLabel lSpend = new JLabel("花费(￥)");
    JLabel lCategory = new JLabel("分类");
    JLabel lComment = new JLabel("备注");
    JLabel lDate = new JLabel("日期");

    public JTextField tfSpend = new JTextField("0");
    public CategoryComboBoxModel cbModel = new CategoryComboBoxModel();
    public JComboBox<Category> cbCategory = new JComboBox<>(cbModel);
    public JTextField tfComment = new JTextField();
    public JXDatePicker datepick = new JXDatePicker(new Date());
    public int id = -1;
    public JButton bSubmit = new JButton("记一笔");


    private RecordPanel(){
        GUIUtil.setColor(ColorUtil.grayColor, lSpend,lCategory,lComment,lDate);
        GUIUtil.setColor(ColorUtil.blueColor, bSubmit);
        JPanel pInput =new JPanel();
        JPanel pSubmit = new JPanel();
        int gap = 40;
        pInput.setLayout(new GridLayout(4,2,gap,gap));

        pInput.add(lSpend);
        pInput.add(tfSpend);
        pInput.add(lCategory);
        pInput.add(cbCategory);
        pInput.add(lComment);
        pInput.add(tfComment);
        pInput.add(lDate);
        pInput.add(datepick);

        pSubmit.add(bSubmit);

        this.setLayout(new BorderLayout());
        this.add(pInput,BorderLayout.NORTH);
        this.add(pSubmit,BorderLayout.SOUTH);
        addListener();

    }

    public static void main(String[] args) {
        GUIUtil.showPanel(RecordPanel.instance,0.8);
    }


    @Override
    public void addListener() {
        bSubmit.addActionListener(new RecordListener());
    }

    @Override
    public void updateData() {
        cbModel.cs = new CategoryService().list();
        cbCategory.updateUI();
    }
}
