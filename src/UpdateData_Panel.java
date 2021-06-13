import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class UpdateData_Panel extends JPanel {

    JPanel options_panel = new JPanel();
    JLabel website_lbl = new JLabel();
    JLabel email_lbl = new JLabel();
    public static JComboBox<String> website_cb = new JComboBox<>();
    public static JComboBox<String> email_cb = new JComboBox<>();

    JPanel data_panel = new JPanel();
    JLabel datapassword_lbl = new JLabel();
    JLabel dataemail_lbl = new JLabel();
    public static JTextField email_text = new JTextField();
    public static JPasswordField password_text = new JPasswordField();
    public static JCheckBox check_email = new JCheckBox();
    public static JCheckBox check_password = new JCheckBox();

    JPanel submit_panel = new JPanel();
    JButton submit_button = new JButton();

    public UpdateData_Panel() {
        try {
            DatabaseConnectivity.displayUpdateData();
        } catch (Exception ex) {
        }

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

        dataemail_lbl.setText("Email:");
        dataemail_lbl.setFont(new Font("Times New Roman", Font.BOLD, 30));
        dataemail_lbl.setOpaque(true);
        dataemail_lbl.setHorizontalAlignment(JLabel.CENTER);

        email_text.setEditable(false);

        check_email.setText("Edit");
        check_email.setFont(new Font("Times New Roman", Font.BOLD, 25));
        check_email.setOpaque(true);
        check_email.setHorizontalAlignment(JLabel.CENTER);
        check_email.setPreferredSize(new Dimension(20, 20));
        check_email.addActionListener(e -> {
            if (check_email.isSelected())
                email_text.setEditable(true);
            else
                email_text.setEditable(false);
        });

        datapassword_lbl.setText("Password:");
        datapassword_lbl.setFont(new Font("Times New Roman", Font.BOLD, 30));
        datapassword_lbl.setOpaque(true);
        datapassword_lbl.setHorizontalAlignment(JLabel.CENTER);

        password_text.setEditable(false);

        check_password.setText("Edit");
        check_password.setFont(new Font("Times New Roman", Font.BOLD, 25));
        check_password.setOpaque(true);
        check_password.setHorizontalAlignment(JLabel.CENTER);
        check_password.setPreferredSize(new Dimension(20, 20));
        check_password.addActionListener(e -> {
            if (check_password.isSelected())
                password_text.setEditable(true);
            else
                password_text.setEditable(false);
        });

        submit_button.setFocusable(false);
        submit_button.setText("Update");
        submit_button.setFont(new Font("Times New Roman", Font.BOLD, 30));
        submit_button.addActionListener((ActionEvent e) -> {
            try {
                DatabaseConnectivity.updateData();
            } catch (Exception ex) {
                Logger.getLogger(UpdateData_Panel.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        options_panel.setBorder(new EmptyBorder(0, 50, 0, 50));
        options_panel.setLayout(new GridLayout(3, 2, 0, 10));
        options_panel.add(website_lbl);
        options_panel.add(website_cb);
        options_panel.add(email_lbl);
        options_panel.add(email_cb);

        data_panel.setBorder(new EmptyBorder(0, 50, 10, 50));
        data_panel.setLayout(new GridLayout(2, 3, 0, 10));
        data_panel.add(dataemail_lbl);
        data_panel.add(email_text);
        data_panel.add(check_email);
        data_panel.add(datapassword_lbl);
        data_panel.add(password_text);
        data_panel.add(check_password);

        submit_panel.add(submit_button);

        this.add(options_panel, BorderLayout.NORTH);
        this.add(data_panel);
        this.add(submit_panel, BorderLayout.SOUTH);
    }
}
