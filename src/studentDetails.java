import main.panelbg;
import main.stack;
import main.custombtn;
import main.msg;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import javax.swing.SwingUtilities;
import java.util.Vector;
public class studentDetails extends JPanel implements ActionListener,MouseListener{
    private JLabel label,nLable,idLabel,or,lab1,lab2;
    private JButton submit;
    private JTextField name,id;
    private custombtn opt1,opt2;
    private Vector<String> dis;
    private boolean flag=true;
    public studentDetails(){
        // setTitle("Student Details");
        JPanel bg=new panelbg("images/v915-wit-005.jpg");
        bg.setSize(700,600);
        bg.setLayout(null);
        label=new JLabel("Search Student Details");
        nLable=new JLabel("Enter Student Name");
        idLabel=new JLabel("Enter Student Roll No");
        name=new JTextField();
        id=new JTextField();
        submit=new JButton("Submit");
        label.setBounds(170,30,400,100);
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
        nLable.setBounds(130,120,400,80);
        name.setBounds(130,180,400,40);
        idLabel.setBounds(130,240,400,80);
        id.setBounds(130,300,400,40);
        // submit.setBounds(270,400,100,40);
        // submit.addActionListener(this);
        lab2=new JLabel("SUBMIT");
        lab2.setFont(new Font("Arial",Font.PLAIN,20));
        lab2.setBounds(85,10,150,30);
        lab2.setForeground(Color.white);
        opt2=new custombtn(50,"#3cd10c","#3cd10c",bg) ;
        opt2.setBounds(200,400,250,50);
        opt2.setLayout(null);
        opt2.add(lab2);
        opt2.addMouseListener(this);
        or=new JLabel("OR");
        or.setFont(new Font("Arial",Font.PLAIN,15));
        or.setBounds(310,445,100,30);
        lab1=new JLabel("All Student List");
         lab1.setFont(new Font("Arial",Font.PLAIN,20));
         lab1.setBounds(55,10,150,30);
         lab1.setForeground(Color.white);
         opt1=new custombtn(50,"#f40c0c","#f40c0c",bg) ;
         opt1.setBounds(200,480,250,50);
         opt1.setLayout(null);
         opt1.add(lab1);
         opt1.addMouseListener(this);
         dis=new Vector<String>();
        bg.add(label);
        bg.add(nLable);
        bg.add(name);
        bg.add(idLabel);
        bg.add(id);
        bg.add(opt2);
        bg.add(or);
        bg.add(opt1);
        add(bg);
        setSize(700,600);
        setLayout(null);
        setVisible(true);
        // setResizable(false);
    }
    // public static void main(String args[]){
    //     new studentDetails();
    // }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==submit){   
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==opt1){
            stack.Stack.push(new studentDisp());
            stack.title.push("Display Details");
             dashboard.update();
             opt1.reColor("#f40c0c","#f40c0c");
             lab1.setForeground(Color.white);
             opt1.repaint();
        }
        if(e.getSource()==opt2){
            if(name.getText().toString().length()==0 ||
              id.getText().toString().length()==0){
                  new msg("All Fields must be filled","Error",dashboard.f);
                  return;
              }else{
                  db();
                  if(flag==false){
                    new msg("Please verify entered data","Error",dashboard.f);
                      return;
                  }
                  stack.Stack.push(new studentinfo(dis));
                  stack.title.push("Student Details");
                  dashboard.update();
                  opt2.reColor("#3cd10c","#3cd10c");
                  lab2.setForeground(Color.white);
                  opt2.repaint();
              }
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==opt1){
            // opt1.reColor("#dd5e89","#f7bb97");
            opt1.setBorder(BorderFactory.createLineBorder(Color.black));
            opt1.repaint();
        }else if(e.getSource()==opt2){
            opt2.setBorder(BorderFactory.createLineBorder(Color.black));
         opt2.repaint();
        }
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==opt1){
            // opt1.reColor("#f7bb97","#dd5e89");
            opt1.setBorder(null);
            opt1.repaint();
        }else if(e.getSource()==opt2){
            opt2.setBorder(null);
         opt2.repaint();
        }
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==opt1){
            opt1.reColor("#df73ff","#df73ff");
            lab1.setForeground(Color.black);
            opt1.repaint();
        }else if(e.getSource()==opt2){
         opt2.reColor("#189950","#189950");
         lab2.setForeground(Color.black);
         opt2.repaint();
        }
    }
    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==opt1){
            opt1.reColor("#f40c0c","#f40c0c");
            lab1.setForeground(Color.white);
            opt1.repaint();
        }else if(e.getSource()==opt2){
            opt2.reColor("#3cd10c","#3cd10c");
            lab2.setForeground(Color.white);
         opt2.repaint();
        }
    }
    private void db(){
        String url="jdbc:mysql://localhost:3306/cse_module";
        String user="root";
        String pass="Pranav@2046";
        String[] emp={""};
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(url, user, pass);
            Statement st=con.createStatement();
            String in=id.getText();
            ResultSet res=st.executeQuery("select * from student_details where roll_no='"+in+"'"); 
            if(res.getFetchSize()==0)flag=false;
            if(res.next()){
                System.out.println("Hello ji");
                dis.add(res.getString(2));
                dis.add(res.getString(1));
                dis.add(res.getString(7));
                dis.add(res.getString(4));
                dis.add(res.getString(6));
                dis.add(res.getString(5));
                dis.add(res.getString(3));
                dis.add(res.getString(8));
            }
            if(dis.size()==0)flag=false;
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e);
            new msg("Please verify entered data","Error",dashboard.f);
        }
    }
   
}
