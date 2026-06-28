
import main.panelbg;
import main.newPanel;
import main.custombtn;
import main.stack;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.awt.Font.*;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class dashMenu extends JPanel implements MouseListener {
    private custombtn opt1,opt2,opt3,opt4,opt5,opt6,opt7;
    private JPanel panel;
    private JLabel lab1,lab2,lab3,lab4,lab5,lab6,lab7,lable;
    private boolean pressed;
    public dashMenu(){
         panel=new panelbg("images/v915-wit-005.jpg");
         lable=new JLabel("Main Menu");
         lable.setBounds(220,30,400,30);
         try {
            lable.setFont(Font.createFont(Font.TRUETYPE_FONT, 
             new File("images/JosefinSansRegular-x3LYV.ttf")).deriveFont(40f));
        } catch (FontFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         lable.setForeground(Color.gray);
         lab1=new JLabel("Student Detais");
         lab1.setFont(new Font("Arial",Font.BOLD,15));
         lab1.setForeground(Color.white);
         lab1.setBounds(70,10,150,30);
         lab2=new JLabel("Faculty Detais");
         lab2.setFont(new Font("Arial",Font.BOLD,15));
         lab2.setForeground(Color.white);
         lab2.setBounds(70,10,150,30);
         lab3=new JLabel("Subject Allotment");
         lab3.setFont(new Font("Arial",Font.BOLD,15));
         lab3.setForeground(Color.white);
         lab3.setBounds(70,14,150,20);
         lab4=new JLabel("Add Student Details");
         lab4.setFont(new Font("Arial",Font.BOLD,15));
         lab4.setForeground(Color.white);
         lab4.setBounds(60,0,150,50);
         lab5=new JLabel("Add Faculty Details");
         lab5.setFont(new Font("Arial",Font.BOLD,15));
         lab5.setForeground(Color.white);
         lab5.setBounds(60,0,150,50);
         lab6=new JLabel("Upload Marks");
         lab6.setFont(new Font("Arial",Font.BOLD,15));
         lab6.setForeground(Color.white);
         lab6.setBounds(70,0,150,50);
         lab7=new JLabel("Subjects Offered");
         lab7.setFont(new Font("Arial",Font.BOLD,15));
         lab7.setForeground(Color.white);
         lab7.setBounds(60,0,150,50);
         opt1=new custombtn(50,"#f40c0c","#f40c0c",panel) ;
         opt1.setBounds(50,100,250,50);
        opt1.setOpaque(false);
         opt1.setLayout(null);
         opt1.add(lab1);
         opt1.addMouseListener(this);
         opt2=new custombtn(50,"#f40c0c","#f40c0c",panel) ;
         opt2.add(lab2);
         opt2.addMouseListener(this);
         opt2.setLayout(null);
         opt2.setBounds(50,220,250,50);
         opt3=new custombtn(50,"#f40c0c","#f40c0c",panel) ;
         opt3.setBounds(50,350,250,50);
         opt3.addMouseListener(this);
         opt3.add(lab3);
         opt3.setLayout(null);
         opt4=new custombtn(50,"#f40c0c","#f40c0c",panel) ;
         opt4.setBounds(380,100,250,50);
         opt4.add(lab4);
         opt4.setLayout(null);
         opt4.addMouseListener(this);
         opt5=new custombtn(50,"#f40c0c","#f40c0c",panel) ;
         opt5.addMouseListener(this);
         opt5.add(lab5);
         opt5.setLayout(null);
         opt5.setBounds(380,220,250,50);
         opt6=new custombtn(50,"#f40c0c","#f40c0c",panel) ;
         opt6.add(lab6);
         opt6.addMouseListener(this);
         opt6.setLayout(null);
         opt6.setBounds(380,350,250,50);
         opt7=new custombtn(50,"#f40c0c","#f40c0c",panel) ;
         opt7.addMouseListener(this);
         opt7.add(lab7);
         opt7.setLayout(null);
         opt7.setBounds(50,470,250,50);
         opt1.setOpaque(false);
         opt2.setOpaque(false);
         opt3.setOpaque(false);
         opt4.setOpaque(false);
         opt5.setOpaque(false);
         opt6.setOpaque(false);
         opt7.setOpaque(false);
         panel.add(lable);
         panel.add(opt1);
         panel.add(opt2);
         panel.add(opt3);
         panel.add(opt4);
         panel.add(opt5);
         panel.add(opt6);
         panel.add(opt7);
         panel.setSize(700,600);
         panel.setLayout(null);
         add(panel);
         setSize(700,600);
         setLayout(null);
         setVisible(true);
        //  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String args[]){
        new dashMenu();
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==opt1){
            stack.Stack.push(new studentDetails());
            stack.title.push("Student Details");
            dashboard.update();
            opt1.reColor("#f40c0c","#f40c0c");
            lab1.setForeground(Color.white);
            opt1.repaint();
        }
        if(e.getSource()==opt4){
            stack.Stack.push(new addStudentDetails());
            stack.title.push("Add Student Details");
            dashboard.update();
            opt4.reColor("#f40c0c","#f40c0c");
            lab4.setForeground(Color.white);
            opt4.repaint();
        }
        if(e.getSource()==opt5){
            stack.Stack.push(new addFacultyDetails());
            stack.title.push("Add Faculty Details");
            dashboard.update();
            opt5.reColor("#f40c0c","#f40c0c");
            lab5.setForeground(Color.white);
            opt5.repaint();
        }
        if(e.getSource()==opt6){
            stack.Stack.push(new uploadMarks());
            stack.title.push("Upload Marks");
            dashboard.update();
            opt6.reColor("#f40c0c","#f40c0c");
            lab6.setForeground(Color.white);
            opt6.repaint();
        }
        if(e.getSource()==opt2){
            stack.Stack.push(new facultyDetails());
            stack.title.push("Faculty Details");
            dashboard.update();
            opt2.reColor("#f40c0c","#f40c0c");
            lab2.setForeground(Color.white);
            opt2.repaint();
        }
        if(e.getSource()==opt3){
            stack.Stack.push(new subjectAllotment());
            stack.title.push("Subject Allotment");
            dashboard.update();
            opt2.reColor("#f40c0c","#f40c0c");
            lab2.setForeground(Color.white);
            opt2.repaint();
        }
        if(e.getSource()==opt7){
            stack.Stack.push(new subjectsOffered());
            stack.title.push("Subjects Offered");
            dashboard.update();
            opt7.reColor("#f40c0c","#f40c0c");
            lab7.setForeground(Color.white);
            opt7.repaint();
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
        }else if(e.getSource()==opt3){
            opt3.setBorder(BorderFactory.createLineBorder(Color.black));
         opt3.repaint();
        }else if(e.getSource()==opt4){
            opt4.setBorder(BorderFactory.createLineBorder(Color.black));
         opt4.repaint();
        }else if(e.getSource()==opt5){
            opt5.setBorder(BorderFactory.createLineBorder(Color.black));
         opt5.repaint();
        }else if(e.getSource()==opt6){
            opt6.setBorder(BorderFactory.createLineBorder(Color.black));
         opt6.repaint();
        }else if(e.getSource()==opt7){
            opt7.setBorder(BorderFactory.createLineBorder(Color.black));
         opt7.repaint();
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
        }else if(e.getSource()==opt3){
            opt3.setBorder(null);
         opt3.repaint();
        }else if(e.getSource()==opt4){
            opt4.setBorder(null);
         opt4.repaint();
        }else if(e.getSource()==opt5){
            opt5.setBorder(null);
         opt5.repaint();
        }else if(e.getSource()==opt6){
            opt6.setBorder(null);
         opt6.repaint();
        }else if(e.getSource()==opt7){
            opt7.setBorder(null);
         opt7.repaint();
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
         opt2.reColor("#df73ff","#df73ff");
         lab2.setForeground(Color.black);
         opt2.repaint();
        }else if(e.getSource()==opt3){
         opt3.reColor("#df73ff","#df73ff");
         lab3.setForeground(Color.black);
         opt3.repaint();
        }else if(e.getSource()==opt4){
         opt4.reColor("#df73ff","#df73ff");
         lab4.setForeground(Color.black);
         opt4.repaint();
        }else if(e.getSource()==opt5){
         opt5.reColor("#df73ff","#df73ff");
         lab5.setForeground(Color.black);
         opt5.repaint();
        }else if(e.getSource()==opt6){
         opt6.reColor("#df73ff","#df73ff");
         lab6.setForeground(Color.black);
         opt6.repaint();
        }
        else if(e.getSource()==opt7){
            opt7.reColor("#df73ff","#df73ff");
            lab7.setForeground(Color.black);
            opt7.repaint();
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
            opt2.reColor("#f40c0c","#f40c0c");
            lab2.setForeground(Color.white);
         opt2.repaint();
        }else if(e.getSource()==opt3){
            opt3.reColor("#f40c0c","#f40c0c");
            lab3.setForeground(Color.white);
         opt3.repaint();
        }else if(e.getSource()==opt4){
            opt4.reColor("#f40c0c","#f40c0c");
            lab4.setForeground(Color.white);
         opt4.repaint();
        }else if(e.getSource()==opt5){
            opt5.reColor("#f40c0c","#f40c0c");
            lab5.setForeground(Color.white);
         opt5.repaint();
        }else if(e.getSource()==opt6){
            opt6.reColor("#f40c0c","#f40c0c");
            lab6.setForeground(Color.white);
         opt6.repaint();
        }else if(e.getSource()==opt7){
            opt7.reColor("#f40c0c","#f40c0c");
            lab7.setForeground(Color.white);
         opt7.repaint();
        }
    }
}
