
import main.custombtn;
import main.msg;
import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.awt.Image;
import java.lang.Class;
import java.sql.*;
public class App extends JFrame implements ActionListener, MouseListener {
    private JTextField user_id;
    private JPasswordField password;
    private JButton submit;
    private JLabel label,lab,lab2,lab1;
    private custombtn opt2,opt1;

    private JPanel panel;
    public App(){
        panel=new JPanel();
        panel.setSize(400,500);
        panel.setLayout(null);
        panel.setBackground(Color.decode("#291c79"));
        ImageIcon  image;
        setTitle("Login Portal");
        image=new ImageIcon("images/220px-Birla_Institute_of_Technology_Mesra.png");
        Image temp = image.getImage().getScaledInstance(120,120, Image.SCALE_DEFAULT);
        ImageIcon newImg=new ImageIcon(temp);
        lab=new JLabel(newImg);
        lab.setBounds(125,30,120,120);
        user_id=new JTextField("USER ID");
        user_id.setForeground(Color.lightGray);
        password=new JPasswordField();
        password.setText("PASSWORD");
        password.setForeground(Color.lightGray);
        submit=new JButton("Login");
        label=new JLabel("Login Portal");
        label.setBounds(110,110,200,130);
        user_id.setBounds(90,210,200,30);
        password.setBounds(90,260,200,30);
        // submit.setBounds(100,330,100,50);
        // submit.addActionListener(this);
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
        label.setForeground(Color.white);
        lab2=new JLabel("LOGIN");
        lab2.setFont(new Font("Arial",Font.PLAIN,20));
        lab2.setBounds(65,10,150,30);
        lab2.setForeground(Color.white);
        opt2=new custombtn(50,"#3cd10c","#3cd10c",panel) ;
        opt2.setBounds(90,330,200,50);
        opt2.setLayout(null);
        opt2.add(lab2);
        opt2.setOpaque(false);
        opt2.addMouseListener(this);
        lab1=new JLabel("REGISTER");
        lab1.setFont(new Font("Arial",Font.PLAIN,20));
        lab1.setBounds(50,10,150,30);
        lab1.setForeground(Color.white);
        opt1=new custombtn(50,"#f40c0c","#f40c0c",panel) ;
        opt1.setBounds(90,400,200,50);
        opt1.setLayout(null);
        opt1.add(lab1);
        opt1.setOpaque(false);
        opt1.addMouseListener(this);
        panel.add(lab);
        panel.add(label);
        panel.add(user_id);
        panel.add(password);
        panel.add(opt2);
        panel.add(opt1);
        add(panel);
        setSize(400,500);
        setLayout(null); 
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    public static void main(String args[]){
        new App();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        // dispose();
    }
    private boolean validate(String id,String pass){
         String url="jdbc:mysql://localhost:3306/cse_module";
         String user="root";
         String pa="Pranav@2046";
         try {
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con=DriverManager.getConnection(url, user, pa);
             Statement st=con.createStatement();
             ResultSet res=st.executeQuery("select user_password from login where user_id='"+id+"'"); 
             if(res.next() && pass.equals(res.getString(1)))return true;
         } catch (Exception e) {
             //TODO: handle exception
             System.out.println(e);
             return false;
         }
         return false;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==opt2){
            if(user_id.getText().toString().length()==0 ||
             new String( password.getPassword()).length()==0 ){
                  new msg("All Fields must be filled","Error",this);
                return;
            }
            if(validate(user_id.getText().toString(),new String( password.getPassword()))==true){
               dispose();
                new dashboard();
            }
            else {
                new msg("Wrong Credentials","Error",App.this);
            }
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==opt2){
            opt2.setBorder(BorderFactory.createLineBorder(Color.black));
         opt2.repaint();
        }
        if(e.getSource()==opt1){
            // opt1.reColor("#dd5e89","#f7bb97");
            opt1.setBorder(BorderFactory.createLineBorder(Color.black));
            opt1.repaint();
        }
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==opt2){
            opt2.setBorder(null);
         opt2.repaint();
        }
        if(e.getSource()==opt1){
            // opt1.reColor("#f7bb97","#dd5e89");
            opt1.setBorder(null);
            opt1.repaint();
        }
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==opt2){
            opt2.reColor("#189950","#189950");
            lab2.setForeground(Color.black);
            opt2.repaint();
        }
        if(e.getSource()==opt1){
            opt1.reColor("#df73ff","#df73ff");
            lab1.setForeground(Color.black);
            opt1.repaint();
        }
    }
    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==opt2){
            opt2.reColor("#3cd10c","#3cd10c");
            lab2.setForeground(Color.white);
         opt2.repaint();
        }
        if(e.getSource()==opt1){
            opt1.reColor("#f40c0c","#f40c0c");
            lab1.setForeground(Color.white);
            opt1.repaint();
        }
    }

}


