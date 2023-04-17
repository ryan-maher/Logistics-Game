import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class upgradeWrenchButton extends JButton {
    gameData game = new gameData();
    int price;
    Color colorBlue = new Color(140, 190, 220);
    Font font = new Font("Gill Sans MT", Font.BOLD, 25);
    ImageIcon upArrowImage = new ImageIcon("src/upArrowEmojiTiny.png");

    upgradeWrenchButton(int upgradePrice) {
        price = upgradePrice;
        setIcon(upArrowImage);
        setFocusPainted(false);
        setBackground(Color.gray);
        setText("$ " + price);
        setForeground(colorBlue);
        setFont(font);
        setHorizontalTextPosition(2);
        game.setWrenchCost(price);
    }

    void checkValid() {
        if (game.getWrenchLevel() < 5) {
            setEnabled(game.getCurrentMoney() >= game.getWrenchCost());
        } else {
            setEnabled(false);
        }

    }
}
