public class Battery {

    //add the attributes for class Battery
    double c_Rate;
    double r_Rate;
    double powerAmount;

    //No Parameter Constructor
    //set the attributes with default value
    public Battery(){
        c_Rate = 0.1;
        r_Rate = 0.2;
        powerAmount = 0;
    }

    public Battery(double cRate,double rRate){
        c_Rate = cRate;
        r_Rate = rRate;
        powerAmount = 0;
    }

    public double getConsumptionReate(){
        return c_Rate;

    }

    public double getProductionReate(){
        return r_Rate;
    }


    //冲 p 电量
    //charge power which amount is p
    public void chargeBattery(double p){
        powerAmount = (powerAmount + p - 1 > 0) ? 1 : powerAmount + p;
    }
    //如果剩余电量》=p，使用 p电量，返回true，否则剩余电量=0，返回false
    //if the remaining power amount is larger than p, consume the p power and return true;
    //else the remaining power become 0 and return false;
    public boolean useBattery(double p){
        double temp = powerAmount;
        powerAmount = (powerAmount >= p) ? powerAmount - p : 0;
        return temp >= p;
    }

}
