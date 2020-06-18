package components;

import utilities.Utilities;

import java.io.IOException;

public class BigBrother implements Utilities {
    private static BigBrother bigBrotherInst = null;
    private Moked moked;
    private BigBrother(){
        try {
            //print("1");
            moked = new Moked();
            //print("2");
            successMessage("BigBrother");
            //print("3");
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
        //print(" speedeing 1");
        if (routePart instanceof Road){
            //print("speeding 2");
            int maxSpeed = ((Road) routePart).getMaxSpeed();
            if (vehicle.getSpeed()>maxSpeed){
                moked.giveReport(vehicle);
            }
        }
    }
/*
    public static void main(String[] args) {
        Road r= new Road(new Junction(), new Junction());
        Vehicle v1 = new Vehicle(r);
        Vehicle v2 = new Vehicle(r);
        r.setMaxSpeed(40);
        v1.setSpeed(30); //driving safe
        v2.setSpeed(50); // speeding , need to get report

        BigBrother brother = new BigBrother();
        brother.checkSpeeding(v1);
        brother.checkSpeeding(v2);

    }
    */

}
