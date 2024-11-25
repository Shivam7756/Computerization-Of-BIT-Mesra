package main;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.awt.*;

public class custombtn extends JPanel  {
    private int cornerRadius;
    private String col1,col2;
    private JPanel panel;
    public custombtn(int radius,JPanel panel){
        super();
          this.cornerRadius=radius;
          this.col1="#DD5E89";
          this.col2="#DD5E89";
          this.panel=panel;
    }
    public custombtn(int radius,String col1,String col2,JPanel panel){
        super();
        this.cornerRadius=radius;
          this.col1=col1;
          this.col2=col2;
          this.panel=panel;
    }
    @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Dimension arcs = new Dimension(cornerRadius, cornerRadius);
            int width = getWidth();
            int height = getHeight();
            Graphics2D graphics = (Graphics2D) g;
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            //Draws the rounded panel with borders.
            // if (backgroundColor != null) {
            //     graphics.setColor(backgroundColor);
            // } else {
            //     graphics.setColor(getBackground());
            // }
            Color color1 =Color.decode(col1);
            Color color2 = Color.decode(col2);
            graphics.setColor(Color.GREEN);
            GradientPaint gp = new GradientPaint(0, 0, color1, 0, height, color2);
            graphics.setPaint(gp);
            graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint background
            // graphics.setColor(Color.red);
            // graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint border
            // graphics.fillRect(0, 0, width, height);
        }
        public void reColor(String col1,String col2){
            this.col1=col1;
            this.col2=col2;
        }
    
}
