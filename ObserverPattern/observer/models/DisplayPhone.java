package observer.models;

import observer.DataProvider;
import observer.interfaces.ObserverInterface;

public class DisplayPhone implements ObserverInterface {

	DataProvider dp;

	public DisplayPhone(DataProvider dp) {
		this.dp = dp;
	}

	@Override
	public void update() {
		System.out.println("Phone updated. current temperature : " + dp.getTemperature());
	}

	@Override
	public String toString() {
		return "DisplayPhone";
	}

}
