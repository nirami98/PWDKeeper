import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class DeleteData_Panel extends JPanel{
    
    JPanel inside_panel = new JPanel();
    JPanel submit_panel = new JPanel();
    
    JLabel website_lbl = new JLabel();
    JLabel email_lbl = new JLabel();
    public static JComboBox<String> website_cb = new JComboBox<>();
    public static JComboBox<String> email_cb = new JComboBox<>();
    JButton submit_button = new JButton();
    
    public DeleteData_Panel()
    {
        try {
            DatabaseConnectivity.displayDeleteData();
        } catch (Exception ex){}
        
        this.setLayout(new BorderLayout());
        
        website_lbl.setText("Website:");
        website_lbl.setFont(new Font("Times New Roman", Font.BOLD, 30));
        website_lbl.setOpaque(true);
        website_lbl.setHorizontalAlignment(JLabel.CENTER);
        
        website_cb.setSelectedIndex(-1);
        
        email_lbl.setText("Email:");
        email_lbl.setFont(new Font("Times New Roman", Font.BOLD, 30));
        email_lbl.setOpaque(true);
        email_lbl.setHorizontalAlignment(JLabel.CENTER);
        
        email_cb.setSelectedIndex(-1);
        
        submit_button.setFocusable(false);
        submit_button.setText("Delete data");
        submit_button.setFont(new Font("Times New Roman",Font.BOLD, 30));
        submit_button.addActionListener((ActionEvent e) -> {
            try {
                DatabaseConnectivity.deleteData();
            } catch (Exception ex) {
                PWD.status.setText("An error has occured");
                PWD.status.setFont(new Font("Times New Roman", Font.BOLD, 40));
                PWD.status.setOpaque(true);
                PWD.status.setHorizontalAlignment(JLabel.CENTER);
                PWD.status.setForeground(Color.red);
                ex.printStackTrace();
            }
            email_cb.setSelectedIndex(-1);
            website_cb.setSelectedIndex(-1);
        });
        
        inside_panel.setBorder(new EmptyBorder(50, 0, 10, 100));
        inside_panel.setLayout(new GridLayout(3, 2, 0, 10));
        inside_panel.add(website_lbl);
        inside_panel.add(website_cb);
        inside_panel.add(email_lbl);
        inside_panel.add(email_cb);
        
        submit_panel.add(submit_button);
        
        this.add(inside_panel, BorderLayout.NORTH);
        this.add(submit_panel);
    }
}
