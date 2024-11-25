package main;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.*;

public class msg  extends JDialog implements ActionListener{
    private JLabel label;
    private JButton ok;
    private JPanel panel;
    public msg(String message,String  type,JFrame frm){
        super(frm);
        setTitle("Message");
        label=new JLabel(message);
        // label.setBounds(20,20,200,30);
        label.setFont(new Font("Arial",Font.PLAIN,15));
        if(type=="Error")label.setForeground(Color.RED);
        else label.setForeground(Color.GREEN);
        ok=new JButton("OK");
        ok.setBounds(90,60,100,30);
        ok.addActionListener(this);
        panel=new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.setBounds(0,20,300,30);
        panel.add(label);
        add(ok);
        add(panel);
        setSize(300,150);
        setModal(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLayout(null); 
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        dispose();
    }
    
}
