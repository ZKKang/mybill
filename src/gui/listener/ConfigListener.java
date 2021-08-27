package gui.listener;

import gui.panel.ConfigPanel;
import gui.service.ConfigService;
import gui.util.GUIUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ConfigListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        ConfigPanel configPanel = ConfigPanel.instance;
        if(!GUIUtil.checkNumber(configPanel.tfBudget,"本月预算")){
            return;
        }
        String mysqlPath = configPanel.tfMysqlPath.getText();
        if(mysqlPath.length() != 0) {
            File commandFile = new File(mysqlPath,"bin/mysql.exe");
            if(!commandFile.exists()) {
                JOptionPane.showMessageDialog(configPanel, "Mysql路径不正确");
                configPanel.tfMysqlPath.grabFocus();
                return;
            }
        }
        ConfigService configService = new ConfigService();
        configService.update(ConfigService.budget,configPanel.tfBudget.getText());
        configService.update(ConfigService.mysqlPath,mysqlPath);
        JOptionPane.showMessageDialog(configPanel, "设置修改成功");
    }
}
