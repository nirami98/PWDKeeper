import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class AddData_Panel extends JPanel
{
    JPanel inside_panel = new JPanel();
    JPanel submit_panel = new JPanel();
    
    JLabel website_lbl = new JLabel();
    JLabel email_lbl = new JLabel();
    JLabel password_lbl = new JLabel();
    public static JTextField website_text = new JTextField();
    public static JTextField email_text = new JTextField();
    public static JPasswordField password_text = new JPasswordField();
    JButton submit_button = new JButton();
    
    public AddData_Panel()
    {
        this.setLayout(new BorderLayout());
        
        website_lbl.setText("Website:");
        website_lbl.setFont(new Font("Times New Roman", Font.BOLD, 30));
        website_lbl.setOpaque(true);
        website_lbl.setHorizontalAlignment(JLabel.CENTER);
        
        email_lbl.setText("Email:");
        email_lbl.setFont(new Font("Times New Roman", Font.BOLD, 30));
        email_lbl.setOpaque(true);
        email_lbl.setHorizontalAlignment(JLabel.CENTER);
        
        password_lbl.setText("Password:");
        password_lbl.setFont(new Font("Times New Roman", Font.BOLD, 30));
        password_lbl.setOpaque(true);
        password_lbl.setHorizontalAlignment(JLabel.CENTER);
        
        submit_button.setFocusable(false);
        submit_button.setText("Submit");
        submit_button.setFont(new Font("Times New Roman",Font.BOLD, 30));
        submit_button.addActionListener((ActionEvent e) -> {
            try {
                DatabaseConnectivity.addData();
            } catch (Exception ex) {
                PWD.status.setText("An error has occured");
                PWD.status.setFont(new Font("Times New Roman", Font.BOLD, 40));
                PWD.status.setOpaque(true);
                PWD.status.setHorizontalAlignment(JLabel.CENTER);
                PWD.status.setForeground(Color.red);
                ex.printStackTrace();
            }
            website_text.setText(null);
            email_text.setText(null);
            password_text.setText(null);
        });
        
        inside_panel.setBorder(new EmptyBorder(50, 0, 10, 100));
        inside_panel.setLayout(new GridLayout(3, 2, 0, 10));
        inside_panel.add(website_lbl);
        inside_panel.add(website_text);
        inside_panel.add(email_lbl);
        inside_panel.add(email_text);
        inside_panel.add(password_lbl);
        inside_panel.add(password_text);
        
        submit_panel.add(submit_button);
        
        this.add(inside_panel, BorderLayout.NORTH);
        this.add(submit_panel);
    }
}
