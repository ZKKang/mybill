package gui.panel;

import gui.listener.ConfigListener;
import gui.service.ConfigService;
import gui.util.ColorUtil;
import gui.util.GUIUtil;

import javax.swing.*;
import java.awt.*;

public class ConfigPanel extends WorkingPanel {
    static {
        GUIUtil.useLNF();
    }
    public static ConfigPanel instance = new ConfigPanel();

    JLabel lBudget = new JLabel("本月预算(￥)");
    public JTextField tfBudget = new JTextField();

    JLabel lMysql = new JLabel("Mysql安装目录");
    public JTextField tfMysqlPath = new JTextField("");

    JButton bSubmit = new JButton("更新");

    private ConfigPanel(){
        GUIUtil.setColor(ColorUtil.grayColor, lBudget,lMysql);
        GUIUtil.setColor(ColorUtil.blueColor, bSubmit);
        JPanel pInput = new JPanel();
        pInput.add(lBudget);
        pInput.add(tfBudget);
        pInput.add(lMysql);
        pInput.add(tfMysqlPath);
        int gap = 30;
        pInput.setLayout(new GridLayout(4,1,gap,gap));
        JPanel pBtn = new JPanel();
        pBtn.add(bSubmit);
        this.setLayout(new BorderLayout());
        this.add(pInput,BorderLayout.NORTH);
        this.add(pBtn,BorderLayout.SOUTH);
        addListener();

    }

    public static void main(String[] args) {
        GUIUtil.showPanel(ConfigPanel.instance);
    }

    @Override
    public void addListener() {
        bSubmit.addActionListener(new ConfigListener());
    }

    @Override
    public void updateData() {
        ConfigService configService = new ConfigService();
        tfBudget.setText(configService.get(ConfigService.budget));
        tfMysqlPath.setText(configService.get(ConfigService.mysqlPath));
    }
}
