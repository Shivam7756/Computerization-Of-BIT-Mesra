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
import java.sql.*;
import main.custombtn;
import main.msg;
import main.panelbg;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

public class subjectsOffered extends JPanel implements ActionListener, MouseListener{
    private JScrollPane pane;
    private JPanel panel,contentPane;
    private JLabel label,name,lab2,lab1;
    private JButton bt;
    private JTable tab;
    private Image bgImage;
    private custombtn opt2,opt1;
    private String id;
    public subjectsOffered(){
        // setTitle("All Student Records");
        JPanel bg=new panelbg("images/v915-wit-005.jpg");
        bg.setSize(700,600);
        bg.setLayout(null);
        label=new JLabel("Subjects Offered");
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
        label.setBounds(210,10,700,60);
        bg.add(label);
        // bt=new JButton("Back to Dashboard");
        // bt.setBounds(260,500,150,30);
        // bt.addActionListener(this);
        lab2=new JLabel("BACK TO MAIN MENU");
        lab2.setFont(new Font("Arial",Font.PLAIN,20));
        lab2.setBounds(5,10,220,30);
        lab2.setForeground(Color.white);
        opt2=new custombtn(50,"#f40c0c","#f40c0c",bg) ;
        opt2.setBounds(70,500,220,50);
        opt2.setLayout(null);
        opt2.add(lab2);
        opt2.addMouseListener(this);
        lab1=new JLabel("ADD OR EDIT");
        lab1.setFont(new Font("Arial",Font.PLAIN,20));
        lab1.setBounds(50,10,220,30);
        lab1.setForeground(Color.white);
        opt1=new custombtn(50,"#3cd10c","#3cd10c",bg) ;
        opt1.setBounds(370,500,220,50);
        opt1.setLayout(null);
        opt1.add(lab1);
        opt1.addMouseListener(this);
        DefaultTableModel def=new DefaultTableModel();
        def.addColumn("ID");
        def.addColumn("Semester");
        def.addColumn("Name");
        def.addColumn("Credits");
        tab=new JTable(def);
        pane=new JScrollPane(tab);
        pane.setBounds(40,80,600,400);
        opt1.setOpaque(false);
        opt2.setOpaque(false);
        bg.add(opt2);
        bg.add(opt1);
        bg.add(pane);
        add(bg);
        setSize(700,600);
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        add();
        // setResizable(false);
        // getContentPane().add(pane, BorderLayout.CENTER);
    }
    public static void main(String args[]){
        new subjectsOffered();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
       
    }
    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==opt2){
            DefaultTableModel def=(DefaultTableModel) tab.getModel();
            def.addRow(new Object[]{"Pranav","BTECH/60077/19","5"});
        }
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
    private void add(){
        String url="jdbc:mysql://localhost:3306/cse_module";
        String user="root";
        String pass="Pranav@2046";
        String[] emp={""};
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(url, user, pass);
            Statement st=con.createStatement();
            
            ResultSet res=st.executeQuery("select * from subjects_offered"); 
            while(res.next()){ 
                DefaultTableModel def=(DefaultTableModel) tab.getModel();
                def.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(3),res.getString(4)});
            }
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e);
            new msg("Please verify entered data","Error",dashboard.f);
        }
    }
  

}
