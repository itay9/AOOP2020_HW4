package gui;

import components.Vehicle;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main extends JFrame implements ActionListener {
   private static final long serialVersionUID = 1L;
   private RoadSystemPanel panel;
   private String[] names = {"Exit","Blue","None","Blue","Magenta","Orange", "Random","Help"};
   private JMenu m1, m2, m3, m4, m5, m6, m7;
   private JMenuItem[] mi;
   private JMenuBar mb;

   
   public static void main(String[]args) {
	   Main fr = new Main();
	   fr.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	   fr.setSize(845,715);
	   fr.setVisible(true);
   }

   
   public Main() {
	    super("Road system");
	    panel = new RoadSystemPanel(this);
	    add(panel);
	    panel.setVisible(true);

		mb = new JMenuBar();
		m1 = new JMenu("File");
		m2 = new JMenu("Background");
		m3 = new JMenu("Vehicles color");
		m4 = new JMenu("Help");
		m5 = new JMenu("Build a map");
		m6 = new JMenu("Clone a car");
		m7 = new JMenu("Reports");
		mi = new JMenuItem[names.length];

		for(int i=0;i<names.length;i++) {
		    mi[i]=new JMenuItem(names[i]);
		    mi[i].addActionListener(this);
		}

		m1.add(mi[0]);

		m2.add(mi[1]);
		m2.addSeparator();
		m2.add(mi[2]);


		m3.add(mi[3]);
		m3.addSeparator();
		m3.add(mi[4]);
		m3.addSeparator();
		m3.add(mi[5]);
		m3.addSeparator();
		m3.add(mi[6]);
		
		m4.add(mi[7]);
		
//		m5.add(mi[?]);
		m5.addActionListener(this);

//		m6.add(mi[?]);
		m6.addActionListener(this);

//		m7.add(mi[?]);
		m7.addActionListener(this);


		mb.add(m1);
		mb.add(m2);
		mb.add(m3);
		mb.add(m4);
		mb.add(m5);
		mb.add(m6);
		mb.add(m7);
		
		setJMenuBar(mb);
   }
   

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == mi[0])
			destroy();
		else if(e.getSource() == mi[1])
			panel.setBackgr(1);
		else if(e.getSource() == mi[2])
			panel.setBackgr(0);
		else if(e.getSource() == mi[3])
			panel.setColorIndex(0);
		else if(e.getSource() == mi[4])
			panel.setColorIndex(1);
		else if(e.getSource() == mi[5])
			panel.setColorIndex(2);
		else if(e.getSource() == mi[6])
			panel.setColorIndex(3);
		else if(e.getSource() == mi[7])
			printHelp();
		else if(e.getSource() == m5)
			BuildMap();
		else if(e.getSource() == m6)
			CloneCar();
		else if(e.getSource() == m7)
			Reports();
		
	}
	
	
	public void destroy() {
		System.exit(0);
	}
	
	
	public void printHelp() {
		JOptionPane.showMessageDialog(this, "Home Work 3\nGUI @ Threads");
	}
	
	public void BuildMap() {
		//TODO: build a map button
	}
	
	public void CloneCar() {
		//TODO: panel to choose car ID for cloning
		int index; //
		Vehicle vehicle = panel.getDriving().getVehicles().get(index).clone();
		panel.getDriving().
	}
	
	public void Reports() {
		//TODO: report button
	}

}
