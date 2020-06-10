
package components;

import java.io.FileWriter;

public class Moked {
    private int reportCounter;
    private FileWriter out; //output
    public Moked(){
        reportCounter = 0;
        out = null;
    }

    public FileWriter getOut() {
        return out;
    }

    public int getReportCounter() {
        return reportCounter;
    }
    public void incCount(){
        reportCounter++;
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

}
