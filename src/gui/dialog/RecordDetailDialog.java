package gui.dialog;

import gui.frame.MainFrame;
import gui.model.RecordTableModel;
import gui.util.CenterPanel;

import javax.swing.*;
import java.awt.*;

public class RecordDetailDialog extends JDialog {

    public static RecordDetailDialog instance = new RecordDetailDialog();

    public CenterPanel workingPanel;
    public RecordTableModel recordTableModel = null;
    public JTable jTable = null;
    private RecordDetailDialog() {
        super(MainFrame.instance);
        setModal(true);
        setTitle("消费详情一览");
        setSize(400, 300);
        setLocation(300, 200);
        setLayout(new BorderLayout());
        workingPanel = new CenterPanel(0.9);
        add(workingPanel, BorderLayout.CENTER);
    }

    public void updateDate(){
        recordTableModel = new RecordTableModel();
        jTable = new JTable(RecordDetailDialog.instance.recordTableModel);

        JScrollPane jScrollPane = new JScrollPane(jTable);
        workingPanel.show(jScrollPane);
    }


}
