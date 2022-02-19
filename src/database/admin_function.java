package database;

import gui.create_panel;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class admin_function extends connect_database{
    
    car_attributes car_att = new car_attributes();
    admin_attributes admin_attr = new admin_attributes();
    static String sql = "";
    static PreparedStatement ps;
    static ResultSet rs;
    
    
    public admin_function()
    {
    }
    
    //..............
    //................................//
    public boolean check_admin() throws SQLException
    {
        try {
            setconnection();
            Statement s = (Statement) con.createStatement();
            sql = "select * from addadmin where " + "Username = '"+admin_attr.getUsername()+"' and password = '"+admin_attr.getPassword()+"'";
            s.executeQuery(sql);
            con.close();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return false;
    }
    
    //..............
    public void add_car()
    {
        // to add car ......  in database ....
        try {
            setconnection();
            Statement s = (Statement) con.createStatement();
            sql = "INSERT INTO `addcar`(`model`, `manufacture_type`, `year_of_purchase`, `availablecolor`, `price`, `code`, `image`) VALUES "
                    + "( '"+car_att.getModel_name()+"' , '"+car_att.getManufacture_type()+"' , '"+car_att.getYear_of_purchase()+"' "
                    + " , '"+car_att.getAvilable_color()+"' , '"+car_att.getPrice()+"' , '"+car_att.getCode_car()+"' , '"+car_att.getCar_Image()+"' )";
            s.executeUpdate(sql);
            System.out.println("car saved");
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    //...............
    
    public static boolean search()
    {
        try{
            setconnection();
            Statement s = (Statement) con.createStatement();
            String sql = "select * from addcar where " + "code = '"+car_attributes.getCode_car()+"' ";
            s.executeQuery(sql);
            con.close();
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
            ps = con.prepareStatement("SELECT * FROM `addcar` WHERE code = '"+car_attributes.getCode_car()+"' ");
            rs=ps.executeQuery();
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return rs;
    }
    
    public static void take_attrute()
    {
        try{
            get_data();
            if(search() == true)
            {
                if(rs.next())
                {
                    car_attributes.setModel_name(rs.getString("model"));
                    car_attributes.setManufacture_type(rs.getString("manufacture_type"));
                    car_attributes.setYear_of_purchase(rs.getString("year_of_purchase"));
                    car_attributes.setAvilable_color(rs.getString("availablecolor"));
                    car_attributes.setPrice(rs.getString("price"));
                    car_attributes.setCode_car(rs.getString("code"));
                    car_attributes.setCar_Image(rs.getString("image")); 
                }
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    //......................
    // update car ....
    //...............................//
    public static boolean update_car()
    {
        try{
            setconnection();
            Statement st = con.createStatement();
            sql = "UPDATE `addcar` SET `model` = '"+car_attributes.getModel_name()+"' , `manufacture_type` = '"+car_attributes.getManufacture_type()+"' , "
                    + " `year_of_purchase` = '"+car_attributes.getYear_of_purchase()+"' , `availablecolor` = '"+car_attributes.getAvilable_color()+"' , "
                    + " `price` = '"+car_attributes.getPrice()+"' , `code` = '"+car_attributes.getCode_car()+"' , `image` = '"+car_attributes.getCar_Image()+"' "
                    + " WHERE `code` = '"+car_attributes.getCode_car()+"' ";
            st.executeUpdate(sql);
            con.close();
            return true;
        }catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return false;
    }
    
    //..................
    public void add_admin()
    {
        // to add car ......  in database ....
        try {
            setconnection();
            Statement s = (Statement) con.createStatement();
            sql = "INSERT INTO `addadmin`(`name`, `Username`, `password`) VALUES ( '"+admin_attr.getName()+"' , '"+admin_attr.getUsername()+"' , "
                    + " '"+admin_attr.getPassword()+"' )";
            s.executeUpdate(sql);
            System.out.println("admin saved");
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    //..........................
    // delete car ..
    public static boolean delete_car(String code)
    {
        try{
            setconnection();
            Statement st = con.createStatement();
            sql = "DELETE FROM `addcar` WHERE `code` = '"+code+"'";
            st.execute(sql);
            JOptionPane.showMessageDialog(null, "row is deleted");
            con.close();
            return true;
        }catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return false;
    }
    // to get ALL Car from database and show it ..
    // to get food or get drinks or ...
    static Statement statement;
    static create_panel cp = new create_panel();
    
    public static void get_All_cars(JPanel main_panel)
    {
        // select all data from database ....
        String query = "SELECT * FROM addcar";
        ResultSet rs = null;
        int size_X = main_panel.getWidth();
        int size_y = main_panel.getHeight();
        try {
            int w = 0 , h = 0;
            setconnection();
            statement = con.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                /*Retrieve one food details 
                and store it in food object*/
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
                
                w = 0;
                h = h + 450;
            }
            
            con.close();
        } catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
}
