class ParkingSystem {

    int totalBig;
    int totalMid;
    int totalSmall;

    public ParkingSystem(int big, int medium, int small) {
        this.totalBig=big;
        this.totalMid=medium;
        this.totalSmall=small;   
    }
    
    public boolean addCar(int carType) {

        if(carType==1)
        {
            if(totalBig>0)
            {
                totalBig--;
                return true;
            }
        }   
        else if(carType==2)
        {
            if(totalMid>0)
            {
                totalMid--;
                return true;
            }
        }
        else if(carType==3)
        {
            if(totalSmall>0)
            {
                totalSmall--;
                return true;
            }
        }
        else
        {
            return false;
        }
        return false;    
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */