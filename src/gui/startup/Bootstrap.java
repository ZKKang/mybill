package gui.startup;

import gui.frame.MainFrame;
import gui.panel.MainPanel;
import gui.panel.SpendPanel;
import gui.util.GUIUtil;

import javax.swing.*;
import java.awt.*;

public class Bootstrap {
    public static void main(String[] args) throws Exception{
        GUIUtil.useLNF();
        GUIUtil.initGlobalFont(new Font("宋体",Font.PLAIN,20));
        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {

                MainFrame.instance.setVisible(true);
                MainPanel.instance.workingPanel.show(SpendPanel.instance);
            }
        });
    }
}
