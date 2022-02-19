package gui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class create_panel extends JPanel{
    
    public create_panel()
    {}
    // every panel :---> label(image) , Name , Description ..
    // to create label ...
    public void label_txt(String name , int pos_x , int pos_y ,int w , int h , int size_text , JLabel l , ImageIcon icon , JPanel big_panel , JPanel panel)
    {
        l.setText(name);
        l.setBounds(pos_x, pos_y, w, h);
        l.setVisible(true);
        l.setFont(new Font("", Font.BOLD, size_text));
        l.setIcon(icon);
        panel.add(l);
    }
    //...............
    public void create_btn(String name , int pos_x , int pos_y ,int w , int h , int size_text , JButton btn , ImageIcon icon , JPanel big_panel , JPanel panel)
    {
        btn.setText(name);
        btn.setBounds(pos_x, pos_y, w, h);
        btn.setVisible(true);
        btn.setFont(new Font("", Font.BOLD, size_text));
        btn.setIcon(icon);
        panel.add(btn);
    }
    
}
