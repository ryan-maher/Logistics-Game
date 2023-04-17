public class gameData {

    // Period (in ms) determines the frequency of values incremented
    // Lower is faster, 1000ms = 1s
    int period = 500;
    private static int currentMoney = 0;
    private static int truckIncomePerPeriod = 50;
    private static int biplaneIncomePerPeriod = 100;
    private static int truckCost;
    private static int biplaneCost;
    private static double biplaneCostMult = 1.0;
    private static double truckCostMult = 1.0;
    private static int truckCount = 0;
    private static int biplaneCount = 0;
    private static int gearLevel = 0;
    private static int gearCost;
    private static double gearCostMult = 1.0;
    private static int capacityCost = 0;
    private static int capacityLevel = 0;
    private static double capacityCostMult = 1.0;
    private static int wrenchCost = 0;
    private static double wrenchCostMult = 1.0;
    private static int wrenchLevel = 0;
    private static int oilCost = 0;
    private static int oilLevel = 0;
    private static double oilCostMult = 1.0;
    private static int contractsCompleted = 0;


    public gameData() {
    }

    public void increaseTruckIncome(int valuePerSec) {
        truckIncomePerPeriod += valuePerSec;
    }

    public void increaseBiplaneIncome(int valuePerSec) {
        biplaneIncomePerPeriod += valuePerSec;
    }

    public void incrementMoney() {
        currentMoney += truckIncomePerPeriod * truckCount + biplaneIncomePerPeriod * biplaneCount;
    }

    public void increaseMoney(int value) {
        currentMoney += value;
    }

    public void incrementGearLevel() {
        ++gearLevel;
    }

    public void incrementCapacityLevel() {
        ++capacityLevel;
    }

    public int getGearLevel() {
        return gearLevel;
    }

    public int getCapacityLevel() {
        return capacityLevel;
    }

    public void decrementMoney(int value) {
        currentMoney -= value;
    }

    public int getCurrentMoney() {
        return currentMoney;
    }

    public int getTruckIncomePerPeriod() {
        return truckIncomePerPeriod;
    }

    public void setTruckIncomePerPeriod(int income) {
        truckIncomePerPeriod = income;
    }

    public int getBiplaneIncomePerPeriod() {
        return biplaneIncomePerPeriod;
    }

    public void setBiplaneIncomePerPeriod(int income) {
        biplaneIncomePerPeriod = income;
    }

    public void setCurrentMoney(int amount) {
        currentMoney += amount;
    }

    public void incrementTruckCount(int value) {
        truckCount += value;
    }

    public void incrementBiplaneCount(int value) {
        biplaneCount += value;
    }

    public void decrementTruckCount(int value) {
        truckCount -= value;
    }

    public int getTruckCount() {
        return truckCount;
    }

    public int getBiplaneCount() {
        return biplaneCount;
    }

    public void setTruckCost(int cost) {
        truckCost = cost;
    }

    public void setBiplaneCost(int cost) {
        biplaneCost = cost;
    }

    public int getTruckCost() {
        return (int)((double)truckCost * truckCostMult);
    }

    public void increaseTruckCostMult(double inc) {
        truckCostMult += inc;
    }

    public void setGearCost(int cost) {
        gearCost = cost;
    }

    public int getGearCost() {
        return (int)((double)gearCost * gearCostMult);
    }

    public void setWrenchCost(int cost) {
        wrenchCost = cost;
    }

    public int getWrenchCost() {
        return (int)((double)wrenchCost * wrenchCostMult);
    }

    public void increaseGearCostMult(double inc) {
        gearCostMult += inc;
    }

    public void setCapacityCost(int cost) {
        capacityCost = cost;
    }

    public int getCapacityCost() {
        return (int)((double)capacityCost * capacityCostMult);
    }

    public void increaseCapacityCostMult(double inc) {
        capacityCostMult += inc;
    }

    public int getWrenchLevel() {
        return wrenchLevel;
    }

    public void incrementContractsCompleted() {
        ++contractsCompleted;
    }

    public void incrementWrenchLevel() {
        ++wrenchLevel;
    }

    public void increaseWrenchCostMult(double inc) {
        wrenchCostMult += inc;
    }

    public void setOilCost(int cost) {
        oilCost = cost;
    }

    public int getOilLevel() {
        return oilLevel;
    }

    public int getOilCost() {
        return (int)((double)oilCost * oilCostMult);
    }

    public void incrementOilLevel() {
        ++oilLevel;
    }

    public void increaseOilCostMult(double inc) {
        oilCostMult += inc;
    }

    public int getContractsCompleted() {
        return contractsCompleted;
    }

    public void decrementBiplaneCount(int count) {
        biplaneCount -= count;
    }

    public void setTruckCount(int count) {
        truckCount = count;
    }

    public int getBiplaneCost() {
        return (int)((double)biplaneCost * biplaneCostMult);
    }

    public void increaseBiplaneCostMult(double inc) {
        biplaneCostMult += inc;
    }

    public double getTruckCostMult() {
        return truckCostMult;
    }

    public double getBiplaneCostMult() {
        return biplaneCostMult;
    }

    public void setTruckCostMult(double mult) {
        truckCostMult = mult;
    }

    public void setBiplaneCount(int count) {
        biplaneCount = count;
    }

    public void setBiplaneCostMult(double mult) {
        biplaneCostMult = mult;
    }

    public void setGearLevel(int level) {
        gearLevel = level;
    }

    public void setCapacityLevel(int level) {
        capacityLevel = level;
    }

    public void setWrenchLevel(int level) {
        wrenchLevel = level;
    }

    public void setOilLevel(int level) {
        oilLevel = level;
    }

    public double getGearCostMult() {
        return gearCostMult;
    }

    public double getCapacityCostMult() {
        return capacityCostMult;
    }

    public double getWrenchCostMult() {
        return wrenchCostMult;
    }

    public double getOilCostMult() {
        return oilCostMult;
    }

    public void setGearCostMult(double mult) {
        gearCostMult = mult;
    }

    public void setCapacityCostMult(double mult) {
        capacityCostMult = mult;
    }

    public void setWrenchCostMult(double mult) {
        wrenchCostMult = mult;
    }

    public void setOilCostMult(double mult) {
        oilCostMult = mult;
    }

    public void setContractsCompleted(int contracts) {
        contractsCompleted = contracts;
    }
}
