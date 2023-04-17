import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class upgradeGearButton extends JButton {
    gameData game = new gameData();
    int price;
    Color colorOrange = new Color(226, 184, 0);
    Font font = new Font("Gill Sans MT", Font.BOLD, 25);
    ImageIcon upArrowImage = new ImageIcon("src/upArrowEmojiTiny.png");

    upgradeGearButton(int upgradePrice) {
        price = upgradePrice;
        setIcon(upArrowImage);
        setFocusPainted(false);
        setBackground(Color.gray);
        setText("$ " + price);
        setForeground(colorOrange);
        setFont(font);
        setHorizontalTextPosition(LEFT);
        game.setGearCost(price);
    }

    void checkValid() {
        if (game.getGearLevel() < 5) {
            setEnabled(game.getCurrentMoney() >= game.getGearCost());
        } else {
            setEnabled(false);
        }

    }
}
