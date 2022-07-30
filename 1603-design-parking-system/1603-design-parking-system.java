class ParkingSystem {
    
    private int bigSlots;
    private int mediumSlots;
    private int smallSlots;
    private int currentBig;
    private int currentMedium;
    private int currentSmall;

    public ParkingSystem(int big, int medium, int small) {
        bigSlots = big;
        mediumSlots = medium;
        smallSlots = small;
    }
    
    public boolean addCar(int carType) {
        if(carType == 1) {
            if(currentBig < bigSlots) {
                currentBig++;
                return true;
            }
        }
        else if(carType == 2) {
            
            if(currentMedium < mediumSlots) {
                currentMedium++;
                return true;
            }
        }
        else if(carType == 3) {
            if(currentSmall < smallSlots) {
                currentSmall++;
                return true;
            }  
        }
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */