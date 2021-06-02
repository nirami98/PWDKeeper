
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class PWD implements ActionListener
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
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        
        side_menu.setLayout(new GridLayout(5, 1));
        side_menu.setBounds(0, 0, 150, 500);
        
        side_menu.add(home_button);
        home_button.setFocusable(false);
        home_button.addActionListener(this);
        home_button.setText("Home");
        home_button.setFont(new Font("Times New Roman",Font.BOLD, 45));
        
        side_menu.add(add_data);
        add_data.setFocusable(false);
        add_data.addActionListener(this);
        add_data.setText("Add");
        add_data.setFont(new Font("Times New Roman",Font.BOLD, 45));
        
        side_menu.add(view_data);
        view_data.setFocusable(false);
        view_data.addActionListener(this);
        view_data.setText("View");
        view_data.setFont(new Font("Times New Roman",Font.BOLD, 45));
        
        side_menu.add(update_data);
        update_data.setFocusable(false);
        update_data.addActionListener(this);
        update_data.setText("Update");
        update_data.setFont(new Font("Times New Roman",Font.BOLD, 45));
        
        side_menu.add(delete_data);
        delete_data.setFocusable(false);
        delete_data.addActionListener(this);
        delete_data.setText("Delete");
        delete_data.setFont(new Font("Times New Roman",Font.BOLD, 45));
        
        name.setText("PWDKeeper");
        name.setFont(new Font("Times New Roman", Font.BOLD, 60));
        name.setOpaque(true);
        name.setHorizontalAlignment(JLabel.CENTER);
        title_panel.add(name);
        
        card = new CardLayout();
        data.setLayout(card);        
        data.add(addPanel, "addPanel");
        data.add(viewPanel, "viewPanel");
        data.add(updatePanel, "updatePanel");
        data.add(deletePanel, "deletePanel");
        data.add(homePanel, "homePanel");
        
        center_data.setLayout(new GridLayout(3, 1));
        center_data.add(title_panel);
        center_data.add(data);
        center_data.add(status_panel);
        
        frame.add(side_menu, BorderLayout.WEST);
        frame.add(center_data);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        if(str.equals("Add"))
        {
            card.show(data, "addPanel");
            System.out.println("add clicked");
        }
    }   
}
