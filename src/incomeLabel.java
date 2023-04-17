import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class incomeLabel extends JLabel {
    ImageIcon image = new ImageIcon("src/chartEmojiTiny.png");

    incomeLabel() {

        Border border = BorderFactory.createLineBorder(Color.black, 3, true);
        this.setBorder(border);
        this.setText(" $ 0 / sec ");
        this.setBorder(border);
        this.setFont(new Font("Gill Sans MT", Font.BOLD, 20));
        this.setHorizontalAlignment(0);
        this.setIcon(this.image);

    }
}