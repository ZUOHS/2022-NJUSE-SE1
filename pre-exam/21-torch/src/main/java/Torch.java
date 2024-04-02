public class Torch {
    //add attibutes for torch
    Battery myBattery;

    public Torch(Battery battery){
        myBattery = battery;
        //add code here
    }

    /**
     * 10% power consumption per hour for using a torch
     * return true if enough power
     * return false if battery cannot support for the specified hours
     */
    public boolean turnOn(int hours){
        return myBattery.useBattery(hours * myBattery.getConsumptionReate());
    }
    /**
     * 20% power production per hour for charging the battery
     */
    public void charge(int hours){
        myBattery.chargeBattery(hours * myBattery.getProductionReate());
        //add code here
    }

}
