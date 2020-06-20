/**
* itay dali 204711196
* chen azulay 201017159
* beer sheva campus
*/

package components;

import utilities.Point;
import utilities.Utilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

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
            lock.writeLock().lock();

            out.write("time: " + String.valueOf(vehicle.getTimeFromRouteStart()) + ", vehicle number: " + String.valueOf(vehicle.getID()) + ", #" + (++reportCounter)+"\n");
            lock.writeLock().unlock();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(reportMSG(vehicle));
    }

/*
    public static void main(String[] args) {
        Moked moked = null;
        try {
            moked = new Moked();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Road r;
        r = new Road(new Junction(), new Junction());
        Vehicle v = new Vehicle(r);
        for (int i =0;i<5;i++) {
            moked.giveReport(v);
        }
            try {
                moked.out.close();
            } catch (IOException e) {
                e.printStackTrace();

            }
    }
*/

}
