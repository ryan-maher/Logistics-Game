import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class truckPanel extends JPanel {
    Color colorOrange = new Color(226, 184, 0);
    Font font = new Font("Gill Sans MT", Font.BOLD, 25);
    Border border;
    ImageIcon truckImage;
    ImageIcon truckImage30px;
    ImageIcon gearImage;
    ImageIcon packageImage;
    JLabel truckCountLabel;
    JLabel incomePerTruck;
    JLabel gearLevel;
    JLabel capacityLevel;

    truckPanel() {

        border = BorderFactory.createLineBorder(colorOrange, 3, true);
        truckImage = new ImageIcon("src/truckEmojiTiny.png");
        truckImage30px = new ImageIcon("src/truckEmoji30px.png");
        gearImage = new ImageIcon("src/gearEmojiTiny.png");
        packageImage = new ImageIcon("src/packageEmoji30px.png");
        truckCountLabel = new JLabel();
        incomePerTruck = new JLabel();
        gearLevel = new JLabel();
        capacityLevel = new JLabel();
        setLayout(null);
        setBorder(border);
        setBackground(Color.gray);

        JLabel truckIcon = new JLabel();
        truckIcon.setIcon(truckImage);

        JLabel truckIcon2 = new JLabel();
        truckIcon2.setIcon(truckImage30px);

        JLabel gearIcon = new JLabel();
        gearIcon.setIcon(gearImage);

        JPanel truckIconPanel = new JPanel();
        truckIconPanel.add(truckIcon);
        truckIconPanel.setBackground(Color.gray);
        truckIconPanel.setBounds(10, 5, 60, 60);
        add(truckIconPanel);

        truckCountLabel.setText(" x 0");
        truckCountLabel.setFont(font);
        truckCountLabel.setForeground(colorOrange);
        truckCountLabel.setBounds(80, 5, 100, 60);
        add(truckCountLabel);

        JLabel gearIconPanel = new JLabel();
        gearIconPanel.setIcon(gearImage);
        gearIconPanel.setBounds(20, 75, 50, 50);
        add(gearIconPanel);

        gearLevel.setText("Lv 0");
        gearLevel.setFont(font);
        gearLevel.setForeground(colorOrange);
        gearLevel.setBounds(60, 75, 80, 50);
        add(gearLevel);

        JLabel capacityIconLabel = new JLabel();
        capacityIconLabel.setIcon(packageImage);
        capacityIconLabel.setBounds(20, 170, 50, 50);
        add(capacityIconLabel);

        capacityLevel.setText("Lv 0");
        capacityLevel.setFont(font);
        capacityLevel.setForeground(colorOrange);
        capacityLevel.setBounds(60, 170, 80, 50);
        add(capacityLevel);

        incomePerTruck.setFont(new Font("Gill Sans MT", Font.BOLD, 23));
        incomePerTruck.setForeground(colorOrange);
        incomePerTruck.setBounds(10, 400, 150, 100);
        add(incomePerTruck);

        truckIcon2.setBounds(100, 420, 50, 50);
        add(truckIcon2);
    }
}