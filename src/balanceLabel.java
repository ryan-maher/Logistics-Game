import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class balanceLabel extends JLabel {
    gameData game = new gameData();
    ImageIcon image = new ImageIcon("src/banknoteEmojiTiny.png");
    int initialBalance;

    balanceLabel(int initial) {
        Border border = BorderFactory.createLineBorder(Color.black, 3, true);
        setBorder(border);
        game.setCurrentMoney(initial);
        setText("$ " + game.getCurrentMoney());
        setBorder(border);
        setFont(new Font("Gill Sans MT", Font.BOLD, 20));
        setHorizontalAlignment(0);
        setIcon(image);
        initialBalance = initial;
    }
}