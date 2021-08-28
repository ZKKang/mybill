package gui.dialog;

import gui.frame.MainFrame;
import gui.model.RecordTableModel;
import gui.panel.WorkingPanel;
import gui.util.CenterPanel;

import javax.swing.*;
import java.awt.*;

public class MainDialog extends JDialog {

    public static MainDialog instance = new MainDialog();
    public String title = "消费详情";
    public CenterPanel workingPanel = new CenterPanel(0.9);
    private MainDialog() {
        super(MainFrame.instance);
        setModal(true);
        setTitle(title);
        setSize(500, 450);
        setLayout(new BorderLayout());
        setLocation(MainFrame.instance.getX()+MainFrame.instance.getWidth(),MainFrame.instance.getY());
        add(workingPanel, BorderLayout.CENTER);
    }
    public void addPanel(WorkingPanel panel){
        panel.updateData();
        add(panel,BorderLayout.CENTER);
    }

}
