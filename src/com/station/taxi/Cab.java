package com.station.taxi;

import java.util.ArrayList;

/**
 *  Tax cab object
 * @author alex
 *
 */
public class Cab extends Thread {
	public static final int MAX_PASSANGERS = 4;

	private static final int ONE_SECOND = 1000;
	private static final int STATE_BREAK=0;
	private static final int STATE_DRIVING=1;
	private static final int STATE_WAITING=2;

	private ArrayList<Passenger> mPassangers = new ArrayList<Passenger>(MAX_PASSANGERS);
	private String mWhileWaiting;
	private int mNumber;
	private TaxiMeter mMeter;
	private int mState;
	private int mDrivingTime = 0;
	private boolean mKeepRunning = true;
	
	public Cab(int num, String whileWaiting) {
		mNumber = num;
		mWhileWaiting = whileWaiting;
	}
	/**
	 * Cab Id Number
	 * @return
	 */
	public int getNumer() {
		return mNumber;
	}
	/**
	 * Action while waiting
	 * @return
	 */
	public String getWhileWaitingAction() {
		return mWhileWaiting;
	}
	/**
	 * Add passanger to Cab
	 * @param passanger
	 * @throws Exception
	 */
	public void addPassanger(Passenger passanger) throws Exception {
		if (mPassangers.size() > 0) {
			Passenger first = mPassangers.get(0);
			if (!first.getDestination().equals(passanger.getDestination())) {
				throw new Exception("Wrong destination");
			}
		}
		mPassangers.add(passanger);
	}
	/**
	 * Set TaxiMeter instance
	 * @param meter
	 */
	public void setMeter(TaxiMeter meter) {
		mMeter = meter;
	}
	/**
	 * Check if cab is full
	 * @return
	 */
	public boolean isFull() {
		return mPassangers.size() == MAX_PASSANGERS;
	}
		
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		while ( mKeepRunning ) {
			switch(mState) {
				case STATE_DRIVING:
					driving();
				break;
				case STATE_WAITING:
					// TODO
				break;
				case STATE_BREAK:
					// TODO
				break;								
			}
			
	        try {
	        	sleep(50); 
	        } catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 */
	private void driving() {
		try {
			sleep(ONE_SECOND * mDrivingTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		mMeter.calc(mDrivingTime); 
		notifyArrival();
		mState = STATE_WAITING;
	}
	/**
	 * 
	 * @param drivingTime
	 * @throws Exception 
	 */
	public void drive(Integer drivingTime) throws Exception {
		if (mPassangers.size() == 0) {
			throw new Exception("Empty cab");
		}
		mMeter.reset();
		if (drivingTime != null) {
			mDrivingTime = drivingTime;
		} else {
			// TODO fill mDrivingTime
		}
		mState = STATE_DRIVING;
	}
	
	private void notifyArrival() {
		for(Passenger p: mPassangers) {
			p.onArrival(this, mMeter.getCurrentValue());
		}
	}
	
	/**
	 * Go to break
	 */
	public void requestBreak() {
		//TODO
		mState = STATE_BREAK;
	}
	
	/**
	 * Go to waiting queue
	 */
	public void requestWaiting() {
		//TODO
		mState = STATE_WAITING;
	}
	
}
