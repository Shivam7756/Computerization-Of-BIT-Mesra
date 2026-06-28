
import main.stack;
import main.newPanel;
import java.awt.Color;
import java.awt.Font;
import java.util.Stack;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class dashboard extends JFrame implements MouseListener  {
    public static JFrame f;
    private JPanel panel,userpanel,main;
    public static JPanel panel2;
    private JLabel user,copyright,type;
    private  static JLabel back;
    private ImageIcon backImg;
    public dashboard(){
        main=new JPanel();
        main.setSize(700,730);
        main.setLayout(null);
        main.setBackground(Color.decode("#291c79"));
        userpanel=new JPanel();
        userpanel.setBounds(400,9,280,50);
        userpanel.setOpaque(false);
        userpanel.setLayout(new BoxLayout(userpanel,BoxLayout.Y_AXIS));
        stack.Stack=new Stack<JPanel>();
        stack.title=new Stack<String>();
        setTitle("Dashboard");
        // BufferedImage buttonIcon=null;
        // try {
        //     buttonIcon = ImageIO.read(new File());
        // } catch (IOException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
        ImageIcon myimg=new ImageIcon("images/back.png");
        Image tmp = myimg.getImage().getScaledInstance(40,40, Image.SCALE_DEFAULT);
        backImg=new ImageIcon(tmp);
        back=new JLabel(backImg);
        // back.setBorder(BorderFactory.createEmptyBorder());
        back.setBounds(0,10,80,30);
        back.addMouseListener(this);
        panel=new newPanel("#291c79","#291c79");
        panel.setBounds(0,0,700,60);
        panel.setBackground(Color.darkGray);
        user =new JLabel("Random Kumar Agnihotri");
        user.setFont(new Font("Arial",Font.PLAIN,16));
        user.setBounds(420,10,250,30);
        user.setForeground(Color.white);
        type=new JLabel("Faculty");
        type.setFont(new Font("Bank Gothic",Font.ITALIC,13));
        type.setBounds(480,25,150,30);
        type.setForeground(Color.red);
        panel.setLayout(null);
        copyright=new JLabel("BIT DEOGHAR COMPUTERIZATION");
        copyright.setBounds(250,657,250,40);
        copyright.setForeground(Color.white);
        this.panel.add(back);
        userpanel.add(user);
        userpanel.add(type);
        panel.add(userpanel);
        panel2=new JPanel();
        panel2.setBounds(0,65,700,600);
        panel2.setBackground(Color.WHITE);
        // JPanel temp=new studentDetails();
        JPanel temp=new dashMenu();
        panel2.add(temp);
        stack.Stack.push(temp);
        stack.title.push("Dashboard");
        panel2.setLayout(null);
        main.add(panel);
        main.add(panel2);
        main.add(copyright);
        add(main);
        setSize(700,730);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        if(stack.Stack.size()==1)back.setVisible(false);
        f=this;
    }
    
    // public static void main(String args[]){
    //      f=new dashboard();
    // }
    public static void update(){
            panel2.removeAll();
            panel2.add(stack.Stack.peek());
            panel2.revalidate();
            panel2.repaint();
            f.setTitle(stack.title.peek());
            back.setVisible(true);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==back){
            // JPanel temp=stack.Stack.peek();
            stack.Stack.pop();
            stack.title.pop();
            update();
            if(stack.Stack.size()==1 && stack.title.size()==1)back.setVisible(false);
            // if(stack.Stack.peek()==stack.current)back.setVisible(false);
        }
        
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
    public static void main(String args[]){
        new dashboard();
    }
   
}
// BTECH/60063/19