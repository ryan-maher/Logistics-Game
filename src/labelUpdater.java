import javax.swing.JButton;
import javax.swing.JLabel;

// Contains functions that update GUI values
public class labelUpdater {
    gameData game = new gameData();

    public labelUpdater() {
    }

    void updateBalance(JLabel label) {
        label.setText("$ " + game.getCurrentMoney());
    }

    void updateIncome(JLabel label) {
        label.setText("$ +" + ((game.getTruckIncomePerPeriod() * game.getTruckCount()) + (game.getBiplaneIncomePerPeriod() * game.getBiplaneCount())) * (1000 / game.period) + " / sec");
    }

    void updateGearLevel(JLabel label) {
        if (game.getGearLevel() < 5) {
            label.setText("Lv " + game.getGearLevel());
        } else {
            label.setText("Max");
        }

    }

    void updateCapacityLevel(JLabel label) {
        if (game.getCapacityLevel() < 5) {
            label.setText("Lv " + game.getCapacityLevel());
        } else {
            label.setText("Max");
        }

    }

    void updateWrenchLevel(JLabel label) {
        if (game.getWrenchLevel() < 5) {
            label.setText("Lv " + game.getWrenchLevel());
        } else {
            label.setText("Max");
        }

    }

    void updateOilLevel(JLabel label) {
        if (game.getOilLevel() < 5) {
            label.setText("Lv " + game.getOilLevel());
        } else {
            label.setText("Max");
        }

    }

    void updateTruckCount(JLabel label) {
        label.setText(" x " + game.getTruckCount());
    }

    void updateBiplaneCount(JLabel label) {
        label.setText(" x " + game.getBiplaneCount());
    }

    void updateTruckIncome(JLabel label) {
        label.setText("$ +" + game.getTruckIncomePerPeriod() * (1000 / game.period) + " /");
    }

    void updateBiplaneIncome(JLabel label) {
        label.setText("$ +" + game.getBiplaneIncomePerPeriod() * (1000 / game.period) + " /");
    }

    void updateGearCost(JButton button) {
        button.setText("$ " + game.getGearCost());
    }

    void updateCapacityCost(JButton button) {
        button.setText("$ " + game.getCapacityCost());
    }

    void updateWrenchCost(JButton button) {
        button.setText("$ " + game.getWrenchCost());
    }

    void updateOilCost(JButton button) {
        button.setText("$ " + game.getOilCost());
    }

    void updateContractsCount(JLabel label) {
        label.setText("Contracts Completed: " + game.getContractsCompleted());
    }
}
