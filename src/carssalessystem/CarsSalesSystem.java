package carssalessystem;

import gui.splash_screen;
import gui.system;
import javax.swing.JOptionPane;

public class CarsSalesSystem {

    
    public static void main(String[] args) {
        // TODO code application logic here
        
        splash_screen s = new splash_screen();
        s.setVisible(true);
        s.setTitle("Food App");
        try{
            for(int i=0;i<=100;i++)
            {
                Thread.sleep(50);
                s.jProgressBar1.setValue(i);
            }
            s.setVisible(false);
            system login = new system();
            login.setVisible(true);
            login.setResizable(false);
            s.dispose();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
}
