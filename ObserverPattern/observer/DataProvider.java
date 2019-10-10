package observer;

import java.util.ArrayList;

import observer.interfaces.ObservableInterface;
import observer.interfaces.ObserverInterface;

public class DataProvider implements ObservableInterface {

	private ArrayList<ObserverInterface> oiList = new ArrayList<ObserverInterface>();
	private int temperature;

	@Override
	public boolean add(ObserverInterface oi) {
		oiList.add(oi);
		return true;
	}

	@Override
	public boolean remove(ObserverInterface oi) {
		oiList.remove(oi);
		return true;
	}

	@Override
	public void update() {
		for (ObserverInterface oi : oiList) {
			System.out.println("updating... " + oi.toString());
			oi.update();
		}
	}

	public ArrayList<ObserverInterface> getOiList() {
		return oiList;
	}

	public void setOiList(ArrayList<ObserverInterface> oiList) {
		this.oiList = oiList;
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		System.out.println("temperature has changed to : " + temperature);
		this.temperature = temperature;
	}

}
