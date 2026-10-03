package pt.iscte.dcti.pcd.race;

import java.util.Observable;

public class Car extends Observable implements Runnable {
	private int id;
	private int limit;
	private int position=0;
	
	public int getId() {
		return id;
	}

	public int getPosition() {
		return position;
	}

	public Car(int id, int limit) {
		super();
		this.id = id;
		this.limit = limit;
	}

	@Override
	public void run() {
		while (position < limit) {
			try {
				Thread.sleep((long) (10 + Math.random() * 100));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			position++;
			setChanged();
			notifyObservers();
		}
	}
	
	
}
