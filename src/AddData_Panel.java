import java.awt.*;
import java.util.*;
import javax.swing.*;

public class AddData_Panel extends JPanel{
    JLabel lbl=new JLabel();
    public AddData_Panel()
    {
        this.setLayout(new BorderLayout());
        lbl.setText("Hello! Welcome to add panel");
        //lbl.setFont(new Font("Lemon", Font.BOLD, 40));
        this.add(lbl,BorderLayout.CENTER);
    }
}
