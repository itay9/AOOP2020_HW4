/**
* itay dali
* 204711196
* beer sheva campus
*/

package components;

import utilities.Point;
import utilities.Utilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Moked implements Utilities {
    private int reportCounter;
    private ReadWriteLock readWriteLock;
    private Lock readLock;
    private Lock writeLock;
    private FileWriter out; //output
    private File file;
    private final String fileName = "reports.txt";

    public Moked() throws IOException {
        reportCounter = 0;
        readWriteLock = new ReentrantReadWriteLock();
        readLock = readWriteLock.readLock();
        writeLock = readWriteLock.writeLock();
        out = new FileWriter(fileName);
        file = new File(fileName);
        successMessage("moked");
    }

    public FileWriter getOut() {
        return out;
    }

    public int getReportCounter() {
        return reportCounter;
    }

    /**
     * @param vehicle vehicle that got speeding ticket
     * @return string of msg to print
     */
    public String reportMSG(Vehicle vehicle) {
        String string = "Car number " + String.valueOf(vehicle.getID()) + " got a ticket, file location: '" + file.getPath()+ "'";
        return string;
    }

    public void giveReport(Vehicle vehicle) {
        try {
            out.write("time: " + String.valueOf(vehicle.getTimeFromRouteStart()) + ", vehicle number: " + String.valueOf(vehicle.getID()) + ", #" + (++reportCounter));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(reportMSG(vehicle));
    }


    public static void main(String[] args) {
        System.out.println(0);
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
        r = new Road(new Junction(), new Junction());
        Vehicle v = new Vehicle(r);

        moked.giveReport(v);
        try {
            moked.out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
