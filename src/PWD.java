import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class PWD
{
    public static void main(String[] args) {
        PWD obj = new PWD();
    }
    
    JFrame frame = new JFrame();
    
    JPanel title_panel = new JPanel();
    JPanel side_menu = new JPanel();
    JPanel center_data = new JPanel();
    JPanel data = new JPanel();
    JPanel status_panel = new JPanel();
    
    JButton add_data = new JButton();
    JButton view_data = new JButton();
    JButton update_data = new JButton();
    JButton delete_data = new JButton();
    JButton home_button = new JButton();
    JLabel name = new JLabel();
    public static JLabel status = new JLabel();
    
    CardLayout card;
    public AddData_Panel addPanel = new AddData_Panel();
    public ViewData_Panel viewPanel = new ViewData_Panel();
    public UpdateData_Panel updatePanel = new UpdateData_Panel();
    public DeleteData_Panel deletePanel = new DeleteData_Panel();
    public Home_Panel homePanel = new Home_Panel();

    public PWD()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,500);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        
        side_menu.setLayout(new GridLayout(5, 1));
        side_menu.setBounds(0, 0, 150, 500);
        title_panel.setPreferredSize(new Dimension(650, 100));
        center_data.setPreferredSize(new Dimension(650, 300));
        status_panel.setPreferredSize(new Dimension(650, 100));
        
        side_menu.add(home_button);
        home_button.setFocusable(false);
        home_button.setText("Home");
        home_button.setFont(new Font("Times New Roman",Font.BOLD, 45));
        home_button.addActionListener(e -> 
        {
            status.setText("");
            name.setText("");
            card.show(data, "homePanel");
        });
        
        side_menu.add(add_data);
        add_data.setFocusable(false);
        add_data.setText("Add");
        add_data.setFont(new Font("Times New Roman",Font.BOLD, 45));
        add_data.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                status.setText("");
                name.setText("Add Data");
                card.show(data, "addPanel");
            }
        });//anonymous inner class
        
        side_menu.add(view_data);
        view_data.setFocusable(false);
        view_data.setText("View");
        view_data.setFont(new Font("Times New Roman",Font.BOLD, 45));
        view_data.addActionListener(e -> 
        {
            ViewData_Panel.website_cb.setSelectedIndex(-1);
            ViewData_Panel.email_cb.setSelectedIndex(-1);
            status.setText("");
            name.setText("View Data");
            card.show(data, "viewPanel");
        }); //lamba function
        
        side_menu.add(update_data);
        update_data.setFocusable(false);
        update_data.setText("Update");
        update_data.setFont(new Font("Times New Roman",Font.BOLD, 45));
        update_data.addActionListener(new MyActionListener()); //child class
        
        side_menu.add(delete_data);
        delete_data.setFocusable(false);
        delete_data.setText("Delete");
        delete_data.setFont(new Font("Times New Roman",Font.BOLD, 45));
        delete_data.addActionListener(e -> 
        {
            status.setText("");
            name.setText("Delete Data");
            card.show(data, "deletePanel");
        });
        
        name.setText("");
        name.setFont(new Font("Times New Roman", Font.BOLD, 60));
        name.setOpaque(true);
        name.setHorizontalAlignment(JLabel.CENTER);
        title_panel.add(name);
        
        card = new CardLayout();
        data.setLayout(card);    
        data.add(homePanel, "homePanel");
        data.add(addPanel, "addPanel");
        data.add(viewPanel, "viewPanel");
        data.add(updatePanel, "updatePanel");
        data.add(deletePanel, "deletePanel");
        
        status.setText("");
        status.setFont(new Font("Times New Roman", Font.BOLD, 60));
        status.setOpaque(true);
        status.setHorizontalAlignment(JLabel.CENTER);
        status_panel.add(status);
        
        center_data.setLayout(new BorderLayout());
        center_data.add(title_panel, BorderLayout.NORTH);
        center_data.add(data, BorderLayout.CENTER);
        center_data.add(status_panel, BorderLayout.SOUTH);
        
        frame.add(side_menu, BorderLayout.WEST);
        frame.add(center_data);
        
    } 
    
    class MyActionListener implements ActionListener //inner class
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            status.setText("");
            name.setText("Update Data");
            card.show(data, "updatePanel");
        }
    }
}
