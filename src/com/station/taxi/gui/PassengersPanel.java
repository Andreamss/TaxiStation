package com.station.taxi.gui;

import java.awt.GridLayout;

import javax.swing.JPanel;

import com.station.taxi.Passenger;
/**
 * Panel will contain passengers in waiting state
 * @author alex
 *
 */
public class PassengersPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private HashMap<String, PassengerView> mPassViews = new HashMap<String, PassengerView>();
	public PassengersPanel() {
		setLayout(new GridLayout(0, 1, 2, 2));
	}
	public void addPassanger(Passenger p) {
//		PassengerView curr = new PassengerView(p);
//		mPassViews.put(p.getPassangerName(), curr);
//		add(curr);
//		validate();
	}
	public boolean removePassanger(Passenger p) {
//		if (mPassViews.containsKey(p.getPassangerName())) {
//			final PassengerView view = mPassViews.get(p.getPassangerName());
//			remove(view);
//			return true;
//		}
		return false;
		
	}
}
