import java.awt.*;
import javax.swing.*;

public class Home_Panel extends JPanel{
    JLabel main_lbl = new JLabel();
    public Home_Panel()
    {
        this.setLayout(new BorderLayout());
        main_lbl.setText("PWDKeeper");
        main_lbl.setFont(new Font("Times New Roman", Font.BOLD, 80));
        main_lbl.setOpaque(true);
        main_lbl.setHorizontalAlignment(JLabel.CENTER);

        this.add(main_lbl,BorderLayout.CENTER);
    }
}
