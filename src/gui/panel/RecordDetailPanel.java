package gui.panel;

import com.sun.deploy.panel.JHighDPITable;
import gui.entity.Category;
import gui.entity.Record;
import gui.listener.RecordDetailListener;
import gui.model.CategoryComboBoxModel;
import gui.model.RecordTableModel;
import gui.service.RecordService;
import gui.util.DateUtil;
import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class RecordDetailPanel extends WorkingPanel {

    public static RecordDetailPanel instance = new RecordDetailPanel();

    public RecordTableModel recordTableModel = new RecordTableModel();
    public JHighDPITable jTable = new JHighDPITable(recordTableModel);

    public JButton bQuery = new JButton("查询");
    public JButton bEdit = new JButton("修改");
    public JButton bDelete = new JButton("删除");
    public JButton bQueryAll = new JButton("查询全部");
    public CategoryComboBoxModel cbModel = new CategoryComboBoxModel();
    public JComboBox<Category> cbCategory = new JComboBox<>(cbModel);
    public JTextField tComment = new JTextField();
    public JXDatePicker startDate = new JXDatePicker(DateUtil.monthBegin());
    public JXDatePicker endDate = new JXDatePicker(new Date());
    private RecordDetailPanel() {
        JScrollPane tablePane = new JScrollPane(jTable);
        setLayout(new BorderLayout());
        this.add(tablePane, BorderLayout.CENTER);

        JPanel queryPanel = new JPanel();
        buildTopQuery(queryPanel);
        this.add(queryPanel,BorderLayout.NORTH);

        JPanel btnPanel = new JPanel();
        buildBottomBtn(btnPanel);
        this.add(btnPanel,BorderLayout.SOUTH);
        addListener();
    }

    private void buildBottomBtn(JPanel btnPanel) {
        btnPanel.add(bQuery);
        btnPanel.add(bQueryAll);
        btnPanel.add(bEdit);
        btnPanel.add(bDelete);
    }

    private void buildTopQuery(JPanel queryPanel) {
        queryPanel.setLayout(new FlowLayout());
        JLabel lCategory = new JLabel("类型");
        queryPanel.add(lCategory);
        queryPanel.add(cbCategory);
        JLabel lComment = new JLabel("备注");
        queryPanel.add(lComment);
        queryPanel.add(tComment);
        JLabel lStartDate = new JLabel("时间");
        queryPanel.add(lStartDate);
        queryPanel.add(startDate);
        JLabel lEndDate = new JLabel("~");
        queryPanel.add(lEndDate);
        queryPanel.add(endDate);
        tComment.setPreferredSize(new Dimension(50,20));
    }

    @Override
    public void addListener() {
        RecordDetailListener recordDetailListener = new RecordDetailListener();
        bQuery.addActionListener(recordDetailListener);
        bEdit.addActionListener(recordDetailListener);
        bDelete.addActionListener(recordDetailListener);
        bQueryAll.addActionListener(recordDetailListener);
    }

    @Override
    public void updateData() {
        jTable.updateUI();
        jTable.getSelectionModel().setSelectionInterval(0, 0);

    }

    public Record getSelectedRecord() {
        int index = jTable.getSelectedRow();
        return recordTableModel.records.get(index);
    }
}
