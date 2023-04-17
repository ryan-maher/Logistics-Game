import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class upgradeCapacityButton extends JButton {
    gameData game = new gameData();
    int price;
    Color colorOrange = new Color(226, 184, 0);
    Font font = new Font("Gill Sans MT", Font.BOLD, 25);
    ImageIcon upArrowImage = new ImageIcon("src/upArrowEmojiTiny.png");

    upgradeCapacityButton(int upgradePrice) {
        price = upgradePrice;
        setIcon(upArrowImage);
        setFocusPainted(false);
        setBackground(Color.gray);
        setText("$ " + price);
        setForeground(colorOrange);
        setFont(font);
        setHorizontalTextPosition(LEFT);
        game.setCapacityCost(price);
    }

    void checkValid() {
        if (game.getCapacityLevel() < 5) {
            setEnabled(game.getCurrentMoney() >= game.getCapacityCost());
        } else {
            setEnabled(false);
        }

    }
}
