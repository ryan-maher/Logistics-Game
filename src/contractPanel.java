import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class contractPanel extends JPanel {
    Color colorGreen = new Color(81, 236, 0);
    Border border;
    Font font;
    Font subfont;
    contract contractRow1;
    contract contractRow2;
    contract contractRow3;
    contract contractRow4;
    JLabel contractLabel;
    JLabel contractsCount;

    contractPanel() {

        border = BorderFactory.createLineBorder(colorGreen, 3, true);
        font = new Font("Gill Sans MT", Font.BOLD, 25);
        subfont = new Font("Gill Sans MT", Font.BOLD, 20);
        contractRow1 = new contract(5, 1, 0, 5000);
        contractRow2 = new contract(10, 0, 1, 8000);
        contractRow3 = new contract(15, 1, 1, 10000);
        contractRow4 = new contract(20, 2, 3, 20000);
        contractLabel = new JLabel();
        contractsCount = new JLabel();
        setLayout(null);
        setBorder(border);
        setBackground(Color.gray);

        JLabel title = new JLabel();
        title.setText("CONTRACTS");
        title.setFont(font);
        title.setForeground(colorGreen);
        title.setBounds(250, -20, 200, 100);
        add(title);

        contractLabel.setText("Requirements             Time          Reward");
        contractLabel.setFont(subfont);
        contractLabel.setForeground(colorGreen);
        contractLabel.setBounds(40, 20, 400, 100);
        add(contractLabel);

        contractRow1.setBounds(40, 90, 530, 60);
        add(contractRow1);

        contractRow2.setBounds(40, 160, 530, 60);
        add(contractRow2);

        contractRow3.setBounds(40, 230, 530, 60);
        add(contractRow3);

        contractRow4.setBounds(40, 300, 530, 60);
        add(contractRow4);

        contractsCount.setText("Contracts Completed: 0");
        contractsCount.setFont(subfont);
        contractsCount.setForeground(colorGreen);
        contractsCount.setBounds(340, 430, 250, 40);
        add(contractsCount);

    }
}