import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class upgradeOilButton extends JButton {
    gameData game = new gameData();
    int price;
    Color colorBlue = new Color(140, 190, 220);
    Font font = new Font("Gill Sans MT", Font.BOLD, 25);
    ImageIcon upArrowImage = new ImageIcon("src/upArrowEmojiTiny.png");

    upgradeOilButton(int upgradePrice) {
        price = upgradePrice;
        setIcon(upArrowImage);
        setFocusPainted(false);
        setBackground(Color.gray);
        setText("$ " + price);
        setForeground(colorBlue);
        setFont(font);
        setHorizontalTextPosition(LEFT);
        game.setOilCost(price);
    }

    void checkValid() {
        if (game.getOilLevel() < 5) {
            setEnabled(game.getCurrentMoney() >= game.getOilCost());
        } else {
            setEnabled(false);
        }

    }
}
