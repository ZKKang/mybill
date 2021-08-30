package test;

import gui.util.GUIUtil;

import javax.swing.*;
import java.awt.*;

public class TestGUI {

    public static void main(String[] args) {
        JFrame mainFrame = new JFrame();
        mainFrame.setTitle("我的记账本");
        mainFrame.setSize(500,450);
        mainFrame.setLocation(1400,600);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());

        JToolBar tb = new JToolBar();
        JButton bSpend = new JButton();
        GUIUtil.setImageIcon(bSpend,"home.png","消费一览");
        JButton bRecord = new JButton("记一笔");

        JButton bCategory = new JButton("消费分类");

        JButton bReport = new JButton("月消费报表");
        JButton bConfig = new JButton("设置");
        JButton bBackup = new JButton("备份");
        JButton bRecover = new JButton("恢复");
        tb.add(bSpend);
        tb.add(bRecord);
        tb.add(bCategory);
        tb.add(bReport);
        tb.add(bConfig);
        tb.add(bBackup);
        tb.add(bRecover);
        mainFrame.add(tb,BorderLayout.NORTH);

//        mainFrame.add(MainPanel.instance);
        mainFrame.setVisible(true);
    }
}
