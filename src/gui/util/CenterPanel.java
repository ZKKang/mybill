package gui.util;

import gui.panel.WorkingPanel;

import javax.swing.*;
import java.awt.*;

public class CenterPanel extends JPanel {

    private double rate; // 拉伸比例
    private JComponent component; // 组件
    private boolean strech;  // 是否拉伸

    public CenterPanel(double rate, boolean strech){
        setLayout(null);
        this.rate = rate;
        this.strech = strech;
    }
    public CenterPanel(double rate) {
        this(rate,true);
    }


    public void show(JComponent p) {
        this.component = p;
        Component[] components = this.getComponents();
        for(Component c : components) {
            remove(c);
        }
        add(p);
        if(p instanceof WorkingPanel) {
            ((WorkingPanel) p).updateData();
        }
        this.updateUI();
    }

    @Override
    public void repaint() {
        if(component != null) {
            Dimension containerSize = this.getSize();
            Dimension componentSize = component.getPreferredSize();
            if(this.strech) {
                component.setSize((int)(containerSize.width*rate),(int)(containerSize.height*rate));
            }
            component.setLocation(containerSize.width/2-component.getSize().width/2,containerSize.height/2-component.getSize().height/2);
        }
        super.repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(500,500);
        frame.setLocation(1400,300);
        CenterPanel centerPanel = new CenterPanel(0.8,true);
        frame.setContentPane(centerPanel);
        JButton b = new JButton("abc");
        centerPanel.show(b);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
