import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.Border;

public class biplaneButton extends JButton {
    gameData game = new gameData();
    int price;

    biplaneButton(int biplanePrice) {
        Color color = new Color(104, 186, 236);
        ImageIcon image = new ImageIcon("src/biplaneEmojiSmall.png");
        Border border = BorderFactory.createLineBorder(color, 3, true);
        setText("$ " + biplanePrice);
        game.setBiplaneCost(biplanePrice);
        price = biplanePrice;
        setIcon(image);
        setHorizontalTextPosition(0);
        setVerticalTextPosition(3);
        setForeground(color);
        setFont(new Font("Gill Sans MT", Font.BOLD, 25));
        setIconTextGap(-5);
        setBackground(Color.gray);
        setOpaque(true);
        setBorder(border);
        setVerticalAlignment(0);
        setHorizontalAlignment(0);
        setFocusPainted(false);
    }

    void checkValid() {
        setEnabled(game.getCurrentMoney() >= game.getBiplaneCost());
    }
}