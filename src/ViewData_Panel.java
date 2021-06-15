import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ViewData_Panel extends JPanel{
    
    JPanel options_panel = new JPanel();
    
    JLabel website_lbl = new JLabel();
    JLabel email_lbl = new JLabel();
    public static JComboBox<String> website_cb = new JComboBox<>();
    public static JComboBox<String> email_cb = new JComboBox<>();
    public static JPasswordField password = new JPasswordField();
    
    JCheckBox check = new JCheckBox();
    String password_data="";
    
    public ViewData_Panel() 
    {
        
        this.setLayout(new BorderLayout());
        
        website_lbl.setText("Website:");
        website_lbl.setFont(new Font("Times New Roman", Font.BOLD, 30));
        website_lbl.setOpaque(true);
        website_lbl.setHorizontalAlignment(JLabel.CENTER);
        
        website_cb.setSelectedIndex(-1);
        website_cb.addActionListener((ActionEvent e) -> {
            try{
                DatabaseConnectivity.getEmail_View();
                email_cb.setSelectedIndex(-1);
            }
            catch(Exception ex){}
        });
        
        
        email_lbl.setText("Email:");
        email_lbl.setFont(new Font("Times New Roman", Font.BOLD, 30));
        email_lbl.setOpaque(true);
        email_lbl.setHorizontalAlignment(JLabel.CENTER);
        

        email_cb.addActionListener((ActionEvent e) -> {
            try {
                password_data = DatabaseConnectivity.viewData();
                password.setText(password_data);
            } catch (Exception ex) {}
        });
        
        
        password.setFont(new Font("Times New Roman", Font.BOLD, 25));
        password.setOpaque(true);
        password.setHorizontalAlignment(JLabel.CENTER);
        password.setEditable(false);
        
        check.setText("Show Password");
        check.setFont(new Font("Times New Roman", Font.BOLD, 25));
        check.setOpaque(true);
        check.setHorizontalAlignment(JLabel.CENTER);
        check.setPreferredSize(new Dimension(20, 20));
        check.addActionListener(e -> 
        {
            JCheckBox c = (JCheckBox) e.getSource();
            password.setEchoChar(c.isSelected() ? '\u0000' : (Character)UIManager.get("PasswordField.echoChar"));
        });
        
        options_panel.setBorder(new EmptyBorder(50, 50, 10, 50));
        options_panel.setLayout(new GridLayout(3,2,0,10));
        options_panel.add(website_lbl);
        options_panel.add(website_cb);
        options_panel.add(email_lbl);
        options_panel.add(email_cb);
        options_panel.add(password);
        options_panel.add(check);
        
        this.add(options_panel,BorderLayout.NORTH);
    }
}
