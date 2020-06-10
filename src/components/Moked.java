
package components;

import java.io.FileWriter;
import java.io.IOException;

public class Moked {
    private int reportCounter;
    private FileWriter out; //output
    public Moked() throws IOException {
        reportCounter = 0;
        out = new FileWriter("out.txt");
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
    public void giveReport(Vehicle vehicle){
        out.write("time: "+TIME+", vehicle number: "+String.valueOf(vehicle.getID())+", #"+(++reportCounter));
        System.out.println(reportMSG(vehicle));
    }
}
