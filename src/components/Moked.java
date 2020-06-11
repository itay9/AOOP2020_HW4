/**
* itay dali
* 204711196
* beer sheva campus
*/

package components;

import utilities.Point;
import utilities.Utilities;

import java.io.FileWriter;
import java.io.IOException;

public class Moked implements Utilities {
    private int reportCounter;
    private FileWriter out; //output
    public Moked() throws IOException {
        reportCounter = 0;
        out = new FileWriter("out.txt");
        successMessage("moked");
    }

    public FileWriter getOut() {
        return out;
    }

    public int getReportCounter() {
        return reportCounter;
    }

    /**
     *
     * @param vehicle vehicle that got speeding ticket
     * @return string of msg to print
     */
    public String reportMSG(Vehicle vehicle){
        String string = "Car number "+String.valueOf(vehicle.getID())+" got a ticket, file location: '"+out.toString()+"'";
        return string;
    }
    public void giveReport(Vehicle vehicle){
        try {
            out.write("time: "+String.valueOf(vehicle.getTimeFromRouteStart()) +", vehicle number: "+String.valueOf(vehicle.getID())+", #"+(++reportCounter));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(reportMSG(vehicle));
    }
    public static void main(String[] args){
        Moked moked = null;
        try {
            System.out.println(1);
            moked = new Moked();
            System.out.println(2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Road r;
        System.out.println(3);
        r = new Road(new Junction(),new Junction());
        Vehicle v = new Vehicle(r);

        moked.giveReport(v);
        try {
            moked.out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
