import javax.swing.*;

import main.custombtn;
import main.panelbg;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
public class uploadMarks extends JPanel implements ActionListener, MouseListener {
    private JLabel semLabel,label,rLabel,mLabel,sLabel,warning,img,lab2;
    private JTextField roll,marks;
    private JComboBox<String> subs,sem;
    private JButton submit;
    private JPanel panel;
    private custombtn opt2;
    public uploadMarks(){
        panel=new panelbg("images/v915-wit-005.jpg");
        panel.setSize(700,600);
        // setTitle("Upload Marks");
        String s[]={"1","2","3","4","5","6","7","8"};
        String sub[]={"Maths","DBMS","DAA"};
        label=new JLabel("Upload Marks");
        label.setBounds(250,50,200,30);
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
        semLabel=new JLabel("Semester");
        semLabel.setBounds(100,140,100,30);
        sem=new JComboBox<String>(s);
        sem.setBounds(200,140,300,30);
        rLabel=new JLabel("Roll Number");
        rLabel.setBounds(100,190,100,30);
        roll=new JTextField();
        roll.setBounds(200,190,300,30);
        sLabel=new JLabel("Subject");
        sLabel.setBounds(100,240,100,30);
        subs=new JComboBox<String>(sub);
        subs.setBounds(200,240,300,30);
        mLabel=new JLabel("Marks");
        mLabel.setBounds(100,290,100,30);
        marks=new JTextField();
        marks.setBounds(200,290,300,30);
        // submit=new JButton("Submit");
        // submit.setBounds(300,390,100,40);
        lab2=new JLabel("UPLOAD");
        lab2.setFont(new Font("Arial",Font.PLAIN,20));
        lab2.setBounds(55,10,150,30);
        lab2.setForeground(Color.white);
        opt2=new custombtn(50,"#3cd10c","#3cd10c",panel) ;
        opt2.setBounds(250,390,200,50);
        opt2.setLayout(null);
        opt2.add(lab2);
        opt2.addMouseListener(this);
        warning=new JLabel("All fields must be filled");
        warning.setFont(new Font("Arial",Font.ITALIC,18));
        warning.setBounds(260,440, 200,30);
        warning.setForeground(new Color(255,0,0));
        panel.setLayout(null);
        panel.setSize(700,600);
        panel.add(label);
        panel.add(semLabel);
        panel.add(sem);
        panel.add(rLabel);
        panel.add(roll);
        panel.add(sLabel);
        panel.add(subs);
        panel.add(mLabel);
        panel.add(marks);
        panel.add(opt2);
        // panel.add(warning);
        add(panel);
        setSize(700,600);
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        // setResizable(false);
    }
    public static void main(String args[]){
        new uploadMarks();
    }
    @Override
    public void actionPerformed(ActionEvent e){

    }
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
}
