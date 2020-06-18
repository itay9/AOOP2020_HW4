package gui;

import components.Driving;
import components.Vehicle;

import javax.swing.*;
import java.util.ArrayList;

public class Prototype {
    private JPanel simulator;
    private Driving driving;
    private ArrayList<Vehicle> vehicles = null;

    /**
     * def ctor
     */
    public Prototype(){
        simulator = new JPanel();
        vehicles = new ArrayList<Vehicle>();
    }

    /**
     * param ctor
     * @param panel simulator panel
     * @param drive driving obj
     */
    public Prototype(JPanel panel,Driving drive){
        simulator = panel;
        driving = drive;
        vehicles = new ArrayList<Vehicle>();
        vehicles = driving.getVehicles();
    }
}
