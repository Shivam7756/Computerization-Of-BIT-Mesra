// package main;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.w3c.dom.events.MouseEvent;

import main.custombtn;
import main.panelbg;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

public class facuDisp extends JPanel implements ActionListener, MouseListener{
    private JScrollPane pane;
    private JPanel panel,contentPane;
    private JLabel label,name,lab2;
    private JButton bt;
    private JTable tab;
    private Image bgImage;
    private custombtn opt2;
    public facuDisp(){
        // setTitle("All Student Records");
        JPanel bg=new panelbg("images/v915-wit-005.jpg");
        bg.setSize(700,600);
        bg.setLayout(null);
        label=new JLabel("All Faculty Records");
        try {
            label.setFont(Font.createFont(Font.TRUETYPE_FONT, 
            new File("images/JosefinSansRegular-x3LYV.ttf")).deriveFont(30f));
        } catch (FontFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        label.setForeground(Color.gray);
        label.setBounds(200,10,700,60);
        add(label);
        // bt=new JButton("Back to Dashboard");
        // bt.setBounds(260,500,150,30);
        // bt.addActionListener(this);
        lab2=new JLabel("BACK TO MAIN MENU");
        lab2.setFont(new Font("Arial",Font.PLAIN,20));
        lab2.setBounds(5,10,220,30);
        lab2.setForeground(Color.white);
        opt2=new custombtn(50,"#3cd10c","#3cd10c",bg) ;
        opt2.setBounds(240,500,220,50);
        opt2.setLayout(null);
        opt2.add(lab2);
        opt2.addMouseListener(this);
        DefaultTableModel def=new DefaultTableModel();
        def.addColumn("Name");
        def.addColumn("Faculty ID");
        tab=new JTable(def);
        pane=new JScrollPane(tab);
        pane.setBounds(40,80,600,400);
        bg.add(opt2);
        bg.add(pane);
        add(bg);
        setSize(700,600);
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        // setResizable(false);
        // getContentPane().add(pane, BorderLayout.CENTER);
    }
    public static void main(String args[]){
        new facuDisp();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
         DefaultTableModel def=(DefaultTableModel) tab.getModel();
         def.addRow(new Object[]{"Pranav","BTECH/60077/19","5"});
    }
    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

   

}
