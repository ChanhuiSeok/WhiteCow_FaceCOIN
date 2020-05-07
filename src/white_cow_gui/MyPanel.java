package white_cow_gui;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
 
public class MyPanel extends JPanel {
 
    private Image img;
    ImageIcon ic  = new ImageIcon("./picture/background.png");
    //ImageIcon ic2 = new ImageIcon("./picture/receipt.png");
    Image img1 = ic.getImage();
    //Image img2 = ic2.getImage();
    public MyPanel() {
   
    }
 
    public void setImage(Image img) {
    	
                // Image which we will render later
        this.img = img;
     
                // Set JPanel size to image size
        Dimension size = new Dimension(1700, 900);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }
 
        @Override
    public void paintComponent(Graphics g) {
        g.drawImage(img1,0,0,this.getWidth(),this.getHeight(),this);
        //g.drawImage(img2, 114,252,258,507,null);
        g.drawImage(img,460,109,779,596, null);
       
    }
}