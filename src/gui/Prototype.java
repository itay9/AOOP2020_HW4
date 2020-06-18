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
    public void Clone()
    {
        JSlider JunctionsSlider;
        JTextField Index=new JTextField();
        JunctionsSlider = new JSlider(0, 50, 0);
        JunctionsSlider.setMajorTickSpacing(10);
        JunctionsSlider.setMinorTickSpacing(1);
        JunctionsSlider.setPaintTicks(true);
        JunctionsSlider.setPaintLabels(true);

        String []ComboBoxOptions= {"Default","City","Highway"};
        JOptionPane dialogBox =new JOptionPane();
        JDialog dialog = dialogBox.createDialog(simulator, "Create Road System");
        dialog.setSize(600, 300);
        JLabel txt1 = new JLabel("Number of Junctions:"), txt2 = new JLabel("Number of Vehicles: "+vehicles.size());
        JLabel txt3=new JLabel("Choose Mode");
        JComboBox CityOrRoad=new JComboBox(ComboBoxOptions);
        dialogBox.setMessage(new Object	[]{ JunctionsSlider, txt2,Index});
        dialogBox.setOptionType(JOptionPane.OK_CANCEL_OPTION);
        dialog.setVisible(true);

    }
}
