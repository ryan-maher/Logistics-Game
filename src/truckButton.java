import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.Border;

public class truckButton extends JButton {
    gameData game = new gameData();
    int price;

    truckButton(int truckPrice) {

        Color color = new Color(226, 184, 0);
        ImageIcon image = new ImageIcon("src/truckEmojiSmall.png");
        Border border = BorderFactory.createLineBorder(color, 3, true);
        setText("$ " + truckPrice);
        game.setTruckCost(truckPrice);
        price = truckPrice;
        setIcon(image);
        setHorizontalTextPosition(0);
        setVerticalTextPosition(3);
        setForeground(color);
        setFont(new Font("Gill Sans MT", Font.BOLD, 25));
        setIconTextGap(-5);
        setBackground(Color.gray);
        setBorder(border);
        setVerticalAlignment(0);
        setHorizontalAlignment(0);
        setFocusPainted(false);

    }

    void checkValid() {
        setEnabled(game.getCurrentMoney() >= game.getTruckCost());
    }
}
