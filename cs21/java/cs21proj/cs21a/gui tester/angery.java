
/**
 * Write a description of class angery here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import javax.swing.*; 
import java.awt.*; 
import java.awt.Graphics; 
import java.awt.image.BufferedImage; 
import java.awt.event.*;
import java.util.logging.*; 

public class angery extends JFrame 
{
    //private JPanel p1;
    //private JPanel p2; 
    private JLabel delet; 
    private JLabel _this; 
    private JLabel react; 
    private JLabel only; 
    private JLabel more; 
    private JLabel angerys; 
    
    public angery()
    {
        setLayout(new GridLayout(2, 3));  
        delet = new JLabel(); 
        delet.setIcon(new ImageIcon(new ImageIcon("angerywp.jpg").getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT))); 
        add(delet); 
        _this = new JLabel(); 
        _this.setIcon(new ImageIcon(new ImageIcon("delet.jpg").getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT)));
        add(_this); 
        react = new JLabel(); 
        react.setIcon(new ImageIcon(new ImageIcon("zoomgery.png").getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT)));
        add(react); 
        only = new JLabel(); 
        only.setIcon(new ImageIcon(new ImageIcon("fangery.png").getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT)));
        add(only); 
        more = new JLabel(); 
        more.setIcon(new ImageIcon(new ImageIcon("angerscape.jpg").getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT))); 
        add(more); 
        angerys = new JLabel(); 
        angerys.setIcon(new ImageIcon(new ImageIcon("eggery.jpg").getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT))); 
        add(angerys); 
    }
    
}
