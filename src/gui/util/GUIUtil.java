package gui.util;

import javax.swing.*;
import java.awt.*;

public class GUIUtil {

    public static void setImageIcon(JButton b, String fileName, String tip) {
        ImageIcon i = new ImageIcon("../../img/"+fileName);
        b.setIcon(i);
        b.setPreferredSize(new Dimension(61, 81));
        b.setToolTipText(tip);
        b.setVerticalTextPosition(JButton.BOTTOM);
        b.setHorizontalTextPosition(JButton.CENTER);
        b.setText(tip);
    }

    public static void showPanel(JPanel p,double strechRate) {
        GUIUtil.useLNF();
        JFrame f = new JFrame();
        f.setSize(500,450);
        f.setLocation(1400,600);

        f.setLocationRelativeTo(null);
        CenterPanel cp = new CenterPanel(strechRate,true);
        f.setContentPane(cp);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        cp.show(p);
    }

    public static void useLNF() {
        try {
            javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
