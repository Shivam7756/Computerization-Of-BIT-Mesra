import java.io.File;
import java.io.IOException;
import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.event.*;
import main.custombtn;
import main.panelbg;

public class subjectAllotment extends JPanel implements MouseListener{
    private JTextArea facId,subId;
    private JLabel fac,sub,lable,or,allotLab,editLab;
    private custombtn allot,edit;
    private panelbg bg;
    public subjectAllotment(){
        bg=new panelbg("images/v915-wit-005.jpg");
        bg.setSize(700,600);
        bg.setLayout(null);
        lable=new JLabel("Subject Allotment");
        lable.setBounds(200,30,300,30);
        lable.setForeground(Color.gray);
        fac=new JLabel("Faculty ID");
        sub=new JLabel("Subject ID");
        facId=new JTextArea();
        subId=new JTextArea();
        allotLab=new JLabel("Allot");
        allotLab.setFont(new Font("Arial",Font.PLAIN,20));
        allotLab.setBounds(100,10,150,30);
        allotLab.setForeground(Color.white);
        allot=new custombtn(50,"#3cd10c","#3cd10c",bg);
        allot.setBounds(200,350,250,50);
        allot.setLayout(null);
        allot.add(allotLab);
        or=new JLabel("OR");
        or.setFont(new Font("Arial",Font.PLAIN,15));
        or.setBounds(310,402,100,30);
        editLab=new JLabel("Edit Allotment");
        editLab.setFont(new Font("Arial",Font.PLAIN,20));
        editLab.setBounds(55,10,150,30);
        editLab.setForeground(Color.white);
        edit=new custombtn(50,"#f40c0c","#f40c0c",bg);
        edit.setBounds(200,430,250,50);
        edit.setLayout(null);
        edit.add(editLab);
        try {
            lable.setFont( Font.createFont(Font.TRUETYPE_FONT, 
            new File("images/JosefinSansRegular-x3LYV.ttf")).deriveFont(30f));
        } catch (FontFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        fac.setBounds(100,200,100,30);
        facId.setBounds(220,200,200,30);
        sub.setBounds(100,250,100,30);
        subId.setBounds(220,250,200,30);
        allot.addMouseListener(this);
        edit.addMouseListener(this);
        bg.add(lable);
        bg.add(fac);
        bg.add(facId);
        bg.add(sub);
        bg.add(subId);
        bg.add(allot);
        bg.add(or);
        bg.add(edit);
        add(bg);
        setSize(700,600);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String args[]){
        new subjectAllotment();
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==edit){
            // opt1.reColor("#dd5e89","#f7bb97");
            edit.setBorder(BorderFactory.createLineBorder(Color.black));
            edit.repaint();
        }else if(e.getSource()==allot){
            allot.setBorder(BorderFactory.createLineBorder(Color.black));
         allot.repaint();
        }
        
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==edit){
            // opt1.reColor("#f7bb97","#dd5e89");
            edit.setBorder(null);
            edit.repaint();
        }else if(e.getSource()==allot){
            allot.setBorder(null);
           allot.repaint();
        }
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==edit){
            edit.reColor("#df73ff","#df73ff");
            editLab.setForeground(Color.black);
            edit.repaint();
        }else if(e.getSource()==allot){
         allot.reColor("#189950","#189950");
         allotLab.setForeground(Color.black);
         allot.repaint();
        }
    }
    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==edit){
            edit.reColor("#f40c0c","#f40c0c");
            editLab.setForeground(Color.white);
            edit.repaint();
        }else if(e.getSource()==allot){
            allot.reColor("#3cd10c","#3cd10c");
            allotLab.setForeground(Color.white);
           allot.repaint();
        }
    }
}