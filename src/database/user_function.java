
package database;

import static database.admin_function.ps;
import static database.connect_database.con;
import static database.connect_database.setconnection;
import gui.create_panel;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class user_function extends connect_database{
    
    static String sql = "";
    static PreparedStatement ps;
    static ResultSet rs;
    
    public static boolean search()
    {
        try{
            setconnection();
            Statement s = (Statement) con.createStatement();
            String sql = "select * from addcar where " + "model = '"+car_attributes.getModel_name()+"' ";
            s.executeQuery(sql);
            return true;
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return false;
    }
    
    //.........................................................
    //to return data from server and set in user_control to show....
    protected static ResultSet get_data()
    {
        try{
            setconnection();
            ps = con.prepareStatement("SELECT * FROM `addcar` WHERE model = '"+car_attributes.getModel_name()+"' ");
            rs=ps.executeQuery();
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return rs;
    }
    
    static create_panel cp = new create_panel();
    
    public static void take_attrute(JPanel main_panel)
    {
        int size_X = main_panel.getWidth();
        int size_y = main_panel.getHeight();
        int w = 0 , h = 0;
        try{
            get_data();
            if(search() == true)
            {
                // to show in main panel..
                /*Retrieve one car details 
                and store it in food object*/
                rs.next();
                JPanel panel = new JPanel();
                panel.setLayout(null);
                panel.setBackground(Color.white);
                panel.setVisible(true);
                panel.setBounds(w, h, size_X , 430);

                main_panel.add(panel);
                cp.label_txt("", 0 , 0 , size_X , 250 , 0 , new JLabel() , new ImageIcon(rs.getString("image")) , main_panel , panel);
                cp.label_txt("model " + rs.getString("model") , 10 , 255 , size_X , 20 , 18 , new JLabel() , null , main_panel , panel);
                cp.label_txt("manufacture_type " + rs.getString("manufacture_type") , 10 , 280 , size_X , 20 , 18 , new JLabel() , null , main_panel , panel);
                cp.label_txt("year_of_purchase " + rs.getString("year_of_purchase") , 10 , 310 , size_X , 20 , 18 , new JLabel() , null , main_panel , panel);
                cp.label_txt("availablecolor " + rs.getString("availablecolor") , 10 , 340 , size_X , 20 , 18 , new JLabel() , null , main_panel , panel);
                cp.label_txt("price " + rs.getString("price") , 10 , 370 , size_X , 20 , 18 , new JLabel() , null , main_panel , panel);
                cp.label_txt("code " + rs.getString("code") , 10 , 400 , size_X , 20 , 18 , new JLabel() , null , main_panel , panel);
                System.err.println(rs.getString("model"));
                con.close();
                rs.close();
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    
    
}
