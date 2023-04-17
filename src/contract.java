import java.awt.Color;
import java.awt.Font;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class contract extends JPanel {
    Color colorGreen = new Color(81, 236, 0);
    Border border;
    Font font;
    ImageIcon truckImage30px;
    ImageIcon biplaneImage30px;
    JLabel timeLabel;
    JLabel rewardLabel;
    JLabel truckCountLabel;
    JLabel biplaneCountLabel;
    JButton startContract;
    JButton claimContract;
    gameData game;
    Timer contractTimer;
    Timer validTimer;
    Timer showTimer;
    JLabel truckIcon30px;
    JLabel biplaneIcon30px;
    JLabel timerLabel;
    JLabel waiting;
    int t;
    int r;
    int newReward;
    int rewardIncrement;
    int truckCount;
    int planeCount;

    contract(int time, int trucks, int planes, int reward) {

        border = BorderFactory.createLineBorder(colorGreen, 3, true);
        font = new Font("Gill Sans MT", Font.BOLD, 20);
        truckImage30px = new ImageIcon("src/truckEmoji30px.png");
        biplaneImage30px = new ImageIcon("src/biplaneEmoji30px.png");
        timeLabel = new JLabel();
        rewardLabel = new JLabel();
        truckCountLabel = new JLabel();
        biplaneCountLabel = new JLabel();
        startContract = new JButton();
        claimContract = new JButton();
        contractTimer = new Timer();
        biplaneIcon30px = new JLabel();
        timerLabel = new JLabel();
        waiting = new JLabel();
        validTimer = new Timer();
        showTimer = new Timer();

        game = new gameData();

        setLayout(null);
        setBorder(border);
        setBackground(Color.gray);

        rewardIncrement = 0;
        t = time;
        newReward = reward;
        truckCount = trucks;
        planeCount = planes;

        truckIcon30px = new JLabel();
        truckIcon30px.setIcon(truckImage30px);
        truckIcon30px.setBounds(10, 5, 50, 50);

        add(truckIcon30px);
        truckCountLabel.setText("x " + trucks);
        truckCountLabel.setFont(font);
        truckCountLabel.setForeground(colorGreen);
        truckCountLabel.setBounds(50, 15, 50, 30);
        add(truckCountLabel);

        biplaneIcon30px.setIcon(biplaneImage30px);
        biplaneIcon30px.setBounds(100, 5, 50, 50);
        add(biplaneIcon30px);

        biplaneCountLabel.setText("x " + planes);
        biplaneCountLabel.setFont(font);
        biplaneCountLabel.setForeground(colorGreen);
        biplaneCountLabel.setBounds(140, 15, 50, 30);
        add(biplaneCountLabel);

        timeLabel.setText("" + time + "s");
        timeLabel.setFont(font);
        timeLabel.setForeground(colorGreen);
        timeLabel.setBounds(220, 5, 50, 50);
        add(timeLabel);

        rewardLabel.setText("$" + reward);
        rewardLabel.setFont(font);
        rewardLabel.setForeground(colorGreen);
        rewardLabel.setBounds(320, 5, 150, 50);
        add(rewardLabel);

        startContract.setText("Start");
        startContract.setBounds(410, 15, 100, 30);
        startContract.setFont(font);
        startContract.setForeground(colorGreen);
        startContract.setBackground(Color.gray);
        startContract.setFocusPainted(false);
        startContract.setBorder(border);
        add(startContract);

        timerLabel.setText("30s");
        timerLabel.setForeground(colorGreen);
        timerLabel.setFont(font);
        timerLabel.setBounds(450, 15, 100, 30);
        timerLabel.setVisible(false);
        add(timerLabel);

        waiting.setText("Waiting for new ..");
        waiting.setForeground(colorGreen);
        waiting.setFont(font);
        waiting.setBounds(50, 15, 300, 30);
        waiting.setVisible(false);
        add(waiting);

        claimContract.setText("Claim");
        claimContract.setBounds(410, 15, 100, 30);
        claimContract.setFont(font);
        claimContract.setForeground(colorGreen);
        claimContract.setBackground(Color.gray);
        claimContract.setFocusPainted(false);
        claimContract.setBorder(border);
        claimContract.setVisible(false);
        add(claimContract);

        startContract.addActionListener((e) -> {

            game.decrementTruckCount(truckCount);
            game.decrementBiplaneCount(planeCount);

            if (startContract.isEnabled()) {
                startContract.setEnabled(false);
                startContract.setVisible(false);
            }

            if (!timerLabel.isVisible()) {
                timerLabel.setVisible(true);
            }

            contractTimer.schedule(new TimerTask() {
                public void run() {
                    timerLabel.setText(t + "s");
                    --t;
                    if (t == -1) {
                        timerLabel.setVisible(false);
                        claimContract.setVisible(true);
                        game.incrementTruckCount(truckCount);
                        game.incrementBiplaneCount(planeCount);
                        t = time + 5;
                        cancel();
                    }

                }
            }, 0L, 1000L);
        });
        claimContract.addActionListener((e) -> {

            claimContract.setEnabled(false);
            game.increaseMoney(newReward);
            game.incrementContractsCompleted();
            hideContract();
            waiting.setVisible(true);

            Random rand = new Random();
            r = rand.nextInt(11) + 10;

            showTimer.schedule(new TimerTask() {
                public void run() {
                    --r;
                    if (r == -1) {

                        rewardIncrement += 2000;
                        newReward = reward + rewardIncrement;

                        if (trucks > 0) {
                            ++truckCount;
                        }

                        if (planes > 0) {
                            ++planeCount;
                        }

                        showContract();
                        cancel();
                    }

                }
            }, 0, 1000);
        });
        validTimer.schedule(new TimerTask() {
            public void run() {

                startContract.setEnabled(game.getTruckCount() >= truckCount && game.getBiplaneCount() >= planeCount);

            }
        }, 0, game.period);
    }

    void hideContract() {
        truckIcon30px.setVisible(false);
        truckCountLabel.setVisible(false);
        biplaneIcon30px.setVisible(false);
        biplaneCountLabel.setVisible(false);
        timeLabel.setVisible(false);
        rewardLabel.setVisible(false);
        claimContract.setVisible(false);
    }

    void showContract() {
        waiting.setVisible(false);
        truckIcon30px.setVisible(true);
        truckCountLabel.setVisible(true);
        truckCountLabel.setText("x " + truckCount);
        biplaneIcon30px.setVisible(true);
        biplaneCountLabel.setVisible(true);
        biplaneCountLabel.setText("x " + planeCount);
        timeLabel.setVisible(true);
        timeLabel.setText(t + "s");
        rewardLabel.setVisible(true);
        claimContract.setVisible(false);
        startContract.setVisible(true);
        claimContract.setEnabled(true);
        rewardLabel.setText("$" + newReward);
    }
}