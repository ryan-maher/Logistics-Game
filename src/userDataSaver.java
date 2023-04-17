import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class userDataSaver {
    BufferedWriter fileWriter;
    BufferedReader fileReader;
    gameData game = new gameData();

    public userDataSaver() {
    }

    public void saveData(String user) {
        try {

            fileWriter = new BufferedWriter(new FileWriter("src/users/" + user + ".txt", false));
            fileWriter.write("" + game.getCurrentMoney() + "," + game.getTruckCount() + "," + game.getTruckCostMult() + "," + game.getTruckIncomePerPeriod() + "," + game.getGearLevel() + "," + game.getGearCostMult() + "," + game.getCapacityLevel() + "," + game.getCapacityCostMult() + "," + game.getBiplaneCount() + "," + game.getBiplaneCostMult() + "," + game.getBiplaneIncomePerPeriod() + "," + game.getWrenchLevel() + "," + game.getWrenchCostMult() + "," + game.getOilLevel() + "," + game.getOilCostMult() + "," + game.getContractsCompleted() + ",");
            fileWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void loadData(String user) {
        try {

            fileReader = new BufferedReader(new FileReader("src/users/" + user + ".txt"));
            String line = fileReader.readLine();
            String[] lineContents = line.split(",");

            game.setCurrentMoney(Integer.parseInt(lineContents[0]));
            game.setTruckCount(Integer.parseInt(lineContents[1]));
            game.setTruckCostMult(Double.parseDouble(lineContents[2]));
            game.setTruckIncomePerPeriod(Integer.parseInt(lineContents[3]));
            game.setGearLevel(Integer.parseInt(lineContents[4]));
            game.setGearCostMult(Double.parseDouble(lineContents[5]));
            game.setCapacityLevel(Integer.parseInt(lineContents[6]));
            game.setCapacityCostMult(Double.parseDouble(lineContents[7]));
            game.setBiplaneCount(Integer.parseInt(lineContents[8]));
            game.setBiplaneCostMult(Double.parseDouble(lineContents[9]));
            game.setBiplaneIncomePerPeriod(Integer.parseInt(lineContents[10]));
            game.setWrenchLevel(Integer.parseInt(lineContents[11]));
            game.setWrenchCostMult(Double.parseDouble(lineContents[12]));
            game.setOilLevel(Integer.parseInt(lineContents[13]));
            game.setOilCostMult(Double.parseDouble(lineContents[14]));
            game.setContractsCompleted(Integer.parseInt(lineContents[15]));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void createUser(String user) {
        try {

            fileWriter = new BufferedWriter(new FileWriter("src/users/userList.txt", true));
            fileWriter.write("\n" + user);
            fileWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {

            fileWriter = new BufferedWriter(new FileWriter("src/users/" + user + ".txt", false));
            fileWriter.write("5000,0,1.0,50,0,1.0,0,1.0,0,1.0,100,0,1.0,0,1.0,0,");
            fileWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}