import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.border.Border;

public class gameWindow extends JFrame {
    gameData game = new gameData();
    truckPanel truckPanel = new truckPanel();
    biplanePanel biplanePanel = new biplanePanel();
    contractPanel contractPanel = new contractPanel();
    Color colorOrange = new Color(226, 184, 0);
    Color colorBlue = new Color(140, 190, 220);
    truckButton truckButton = new truckButton(5000);
    biplaneButton biplaneButton = new biplaneButton(25000);
    upgradeGearButton gearButton = new upgradeGearButton(1500);
    balanceLabel moneyBalance = new balanceLabel(0);
    incomeLabel moneyIncome = new incomeLabel();
    upgradeCapacityButton capacityButton = new upgradeCapacityButton(2000);
    upgradeWrenchButton wrenchButton = new upgradeWrenchButton(4000);
    upgradeOilButton oilButton = new upgradeOilButton(5000);
    Border borderOrange;
    Border borderBlue;
    labelUpdater updater;
    Timer timer;
    String truckImagePath;
    osChecker OScheck;

    gameWindow() {

        OScheck = new osChecker();

        if(OScheck.whichOS() == 1){
            truckImagePath = "src/truckEmojiSmall.png";
        } else {
            truckImagePath = "./truckEmojiSmall.png";
        }
        
        borderOrange = BorderFactory.createLineBorder(colorOrange, 1, true);
        borderBlue = BorderFactory.createLineBorder(colorBlue, 1, true);
        updater = new labelUpdater();
        timer = new Timer();
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1366, 768);
        setResizable(false);
        setTitle("Logistics Game");
        getContentPane().setBackground(colorBlue);
        setLayout(null);
        setVisible(true);

        ImageIcon image = new ImageIcon("src/truckEmojiSmall.png");
        setIconImage(image.getImage());

        add(moneyBalance);
        moneyBalance.setBounds(1150, 20, 170, 50);

        add(moneyIncome);
        moneyIncome.setBounds(1150, 80, 170, 50);

        add(truckPanel);
        truckPanel.setBounds(50, 20, 150, 480);
        truckPanel.setVisible(game.getTruckCount() != 0);

        add(biplanePanel);
        biplanePanel.setBounds(250, 20, 150, 480);
        biplanePanel.setVisible(game.getBiplaneCount() != 0);

        add(contractPanel);
        contractPanel.setBounds(450, 20, 600, 480);
        contractPanel.setVisible(game.getTruckCount() != 0 || game.getBiplaneCount() != 0);

        add(truckButton);
        truckButton.setBounds(50, 550, 150, 150);

        add(biplaneButton);
        biplaneButton.setBounds(250, 550, 150, 150);

        truckPanel.add(gearButton);
        gearButton.setBounds(10, 120, 130, 40);
        gearButton.setBorder(borderOrange);

        truckPanel.add(capacityButton);
        capacityButton.setBounds(10, 215, 130, 40);
        capacityButton.setBorder(borderOrange);

        biplanePanel.add(wrenchButton);
        wrenchButton.setBounds(10, 120, 130, 40);
        wrenchButton.setBorder(borderBlue);

        biplanePanel.add(oilButton);
        oilButton.setBounds(10, 215, 130, 40);
        oilButton.setBorder(borderBlue);

        truckButton.addActionListener((e) -> {

            if (game.getCurrentMoney() >= game.getTruckCost()) {

                // If user can afford truck, purchase and make truckPanel and contractPanel visible, if not already
                truckPanel.setVisible(true);
                contractPanel.setVisible(true);

                // Deduct cost of truck, increment truck count, and increase truck cost multiplier
                game.decrementMoney(game.getTruckCost());
                game.incrementTruckCount(1);
                game.increaseTruckCostMult(0.8);

                // Update GUI values
                truckButton.setText("$ " + game.getTruckCost());
                updater.updateBalance(moneyBalance);
                updater.updateIncome(moneyIncome);
                updater.updateTruckCount(truckPanel.truckCountLabel);
                updater.updateTruckIncome(truckPanel.incomePerTruck);

                checkAllButtonsValid();

            }

        });

        biplaneButton.addActionListener((e) -> {
            if (game.getCurrentMoney() >= game.getBiplaneCost()) {

                // If user can afford biplane, purchase and make biplanePanel visible, if not already
                biplanePanel.setVisible(true);
                contractPanel.setVisible(true); // in the case that user balance starts with enough to purchase biplane

                // Deduct cost of biplane, increment biplane count, and increase biplane cost multiplier
                game.decrementMoney(game.getBiplaneCost());
                game.increaseBiplaneIncome(200);
                game.incrementBiplaneCount(1);
                game.increaseBiplaneCostMult(0.6);

                // Update GUI values
                biplaneButton.setText("$ " + game.getBiplaneCost());
                updater.updateBalance(moneyBalance);
                updater.updateIncome(moneyIncome);
                updater.updateBiplaneIncome(biplanePanel.incomePerBiplane);
                updater.updateBiplaneCount(biplanePanel.biplaneCountLabel);

                checkAllButtonsValid();
            }

        });
        gearButton.addActionListener((e) -> {

            if (game.getCurrentMoney() >= gearButton.price) {

                game.decrementMoney(game.getGearCost());
                game.incrementGearLevel();
                game.increaseTruckIncome(25);
                game.increaseGearCostMult(1.3);

                updater.updateGearCost(gearButton);
                updater.updateBalance(moneyBalance);
                updater.updateIncome(moneyIncome);
                updater.updateGearLevel(truckPanel.gearLevel);
                updater.updateTruckIncome(truckPanel.incomePerTruck);

                checkAllButtonsValid();
            }

        });
        capacityButton.addActionListener((e) -> {

            if (game.getCurrentMoney() >= gearButton.price) {

                game.decrementMoney(game.getCapacityCost());
                game.incrementCapacityLevel();
                game.increaseTruckIncome(25);
                game.increaseCapacityCostMult(1.3);

                updater.updateCapacityCost(capacityButton);
                updater.updateBalance(moneyBalance);
                updater.updateIncome(moneyIncome);
                updater.updateCapacityLevel(truckPanel.capacityLevel);
                updater.updateTruckIncome(truckPanel.incomePerTruck);

                checkAllButtonsValid();
            }

        });
        wrenchButton.addActionListener((e) -> {

            if (game.getCurrentMoney() >= wrenchButton.price) {

                game.decrementMoney(game.getWrenchCost());
                game.incrementWrenchLevel();
                game.increaseBiplaneIncome(25);
                game.increaseWrenchCostMult(1.4);

                updater.updateWrenchCost(wrenchButton);
                updater.updateBalance(moneyBalance);
                updater.updateIncome(moneyIncome);
                updater.updateWrenchLevel(biplanePanel.wrenchLevel);
                updater.updateBiplaneIncome(biplanePanel.incomePerBiplane);

                checkAllButtonsValid();
            }

        });
        oilButton.addActionListener((e) -> {
            if (game.getCurrentMoney() >= oilButton.price) {

                game.decrementMoney(game.getOilCost());
                game.incrementOilLevel();
                game.increaseBiplaneIncome(25);
                game.increaseOilCostMult(1.5);

                updater.updateOilCost(oilButton);
                updater.updateBalance(moneyBalance);
                updater.updateIncome(moneyIncome);
                updater.updateOilLevel(biplanePanel.oilLevel);
                updater.updateBiplaneIncome(biplanePanel.incomePerBiplane);

                checkAllButtonsValid();
            }

        });

        // Runs every period to increment user balance, update GUI values, and check if buttons valid
        timer.schedule(new TimerTask() {
            public void run() {

                game.incrementMoney();
                updateGUI();
                checkAllButtonsValid();
                updater.updateContractsCount(contractPanel.contractsCount);

            }
        }, 0, game.period);
    }

    // Updates GUI values
    void updateGUI() {
        updater.updateBalance(moneyBalance);
        updater.updateIncome(moneyIncome);
        truckButton.setText("$ " + game.getTruckCost());
        updater.updateTruckCount(truckPanel.truckCountLabel);
        updater.updateTruckIncome(truckPanel.incomePerTruck);
        biplaneButton.setText("$ " + game.getBiplaneCost());
        updater.updateBiplaneCount(biplanePanel.biplaneCountLabel);
        updater.updateBiplaneIncome(biplanePanel.incomePerBiplane);
        updater.updateGearLevel(truckPanel.gearLevel);
        updater.updateGearCost(gearButton);
        updater.updateCapacityLevel(truckPanel.capacityLevel);
        updater.updateCapacityCost(capacityButton);
        updater.updateWrenchLevel(biplanePanel.wrenchLevel);
        updater.updateWrenchCost(wrenchButton);
        updater.updateOilLevel(biplanePanel.oilLevel);
        updater.updateOilCost(oilButton);
    }

    // Checks which buttons can be pressed based on current user balance
    void checkAllButtonsValid() {
        truckButton.checkValid();
        biplaneButton.checkValid();
        gearButton.checkValid();
        capacityButton.checkValid();
        wrenchButton.checkValid();
        oilButton.checkValid();
    }
}
