package components;

import utilities.Utilities;

import java.io.IOException;

public class BigBrother implements Utilities {
    private static BigBrother bigBrotherInst = null;
    private Moked moked;
    private BigBrother(){
        try {
            moked = new Moked();
            successMessage("BigBrother");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static BigBrother getBigBrotherInst(){
        if (bigBrotherInst == null){
            bigBrotherInst = new BigBrother();}
        return bigBrotherInst;
    }
    public void checkSpeeding(Vehicle vehicle){
        RouteParts routePart = vehicle.getCurrentRoutePart();
        if (routePart instanceof Road){
            int maxSpeed = ((Road) routePart).getMaxSpeed();
            if (vehicle.getSpeed()>maxSpeed){
                moked.giveReport(vehicle);
            }
        }
    }

    public static void main(String[] args) {
        Road r= new Road(new Junction(), new Junction());
        Vehicle v1 = new Vehicle(r);
        Vehicle v2 = new Vehicle(r);
        r.setMaxSpeed(40);


    }
}
