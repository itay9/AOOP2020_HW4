package components;

import java.io.IOException;

public class BigBrother {
    private static BigBrother bigBrotherInst = null;
    private Moked moked;
    private BigBrother(){
        try {
            moked = new Moked();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static BigBrother getBigBrotherInst(){
        if (bigBrotherInst == null){
            bigBrotherInst = new BigBrother();}
        return bigBrotherInst;
    }
    public void speeding(Vehicle vehicle){
        RouteParts routePart = vehicle.getCurrentRoutePart();
        if (routePart instanceof Road){
            int maxSpeed = ((Road) routePart).getMaxSpeed();
            int timeOnCurrentPart = vehicle.getTimeOnCurrentPart();
            double len = ((Road) routePart).length;
            if (len/timeOnCurrentPart>maxSpeed){
                //todo report to Moked for report
                //todo moked.report(vehicle)
            }
        }
    }
}
