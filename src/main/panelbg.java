package main;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Image;
import java.awt.Graphics;

public class panelbg extends JPanel{
    private Image img;
    public panelbg(String path){
        this.img=new ImageIcon(path).getImage();
    }
    @Override
    protected void paintComponent(Graphics g) {
 
     super.paintComponent(g);
     g.drawImage(img,0,0,null);
   }
    
}
