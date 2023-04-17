import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class biplanePanel extends JPanel {
    Color colorBlue = new Color(104, 186, 236);
    Font font = new Font("Gill Sans MT", Font.BOLD, 25);
    Border border;
    ImageIcon biplaneImage;
    ImageIcon biplaneImage30px;
    ImageIcon wrenchImage;
    ImageIcon oilImage;
    JLabel biplaneCountLabel;
    JLabel incomePerBiplane;
    JLabel wrenchLevel;
    JLabel oilLevel;

    biplanePanel() {

        border = BorderFactory.createLineBorder(colorBlue, 3, true);
        biplaneImage = new ImageIcon("src/biplaneEmojiTiny.png");
        biplaneImage30px = new ImageIcon("src/biplaneEmoji30px.png");
        wrenchImage = new ImageIcon("src/wrenchEmoji30px.png");
        oilImage = new ImageIcon("src/oilEmoji30px.png");
        biplaneCountLabel = new JLabel();
        incomePerBiplane = new JLabel();
        wrenchLevel = new JLabel();
        oilLevel = new JLabel();
        setLayout(null);
        setBorder(border);
        setBackground(Color.gray);

        JLabel biplaneIcon = new JLabel();
        biplaneIcon.setIcon(biplaneImage);

        JLabel biplaneIcon30px = new JLabel();
        biplaneIcon30px.setIcon(biplaneImage30px);

        JLabel wrenchIcon = new JLabel();
        wrenchIcon.setIcon(wrenchImage);

        JPanel biplaneIconPanel = new JPanel();
        biplaneIconPanel.add(biplaneIcon);
        biplaneIconPanel.setBackground(Color.gray);
        biplaneIconPanel.setBounds(10, 5, 60, 60);
        biplaneCountLabel.setText(" x 0");
        biplaneCountLabel.setFont(font);
        biplaneCountLabel.setForeground(colorBlue);
        biplaneCountLabel.setBounds(80, 5, 100, 60);
        add(biplaneCountLabel);
        add(biplaneIconPanel);

        JLabel wrenchIconPanel = new JLabel();
        wrenchIconPanel.setIcon(wrenchImage);
        wrenchIconPanel.setBounds(20, 75, 50, 50);
        add(wrenchIconPanel);

        wrenchLevel.setText("Lv 0");
        wrenchLevel.setFont(font);
        wrenchLevel.setForeground(colorBlue);
        wrenchLevel.setBounds(60, 75, 80, 50);
        add(wrenchLevel);

        JLabel oilIconLabel = new JLabel();
        oilIconLabel.setIcon(oilImage);
        oilIconLabel.setBounds(20, 170, 50, 50);
        add(oilIconLabel);

        oilLevel.setText("Lv 0");
        oilLevel.setFont(font);
        oilLevel.setForeground(colorBlue);
        oilLevel.setBounds(60, 170, 80, 50);
        add(oilLevel);

        incomePerBiplane.setFont(new Font("Gill Sans MT", Font.BOLD, 23));
        incomePerBiplane.setForeground(colorBlue);
        incomePerBiplane.setBounds(10, 400, 150, 100);
        add(incomePerBiplane);

        biplaneIcon30px.setBounds(100, 420, 50, 50);
        add(biplaneIcon30px);
    }
}