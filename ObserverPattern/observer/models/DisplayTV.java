package observer.models;

import observer.DataProvider;
import observer.interfaces.ObserverInterface;

public class DisplayTV implements ObserverInterface {

	DataProvider dp;

	public DisplayTV(DataProvider dp) {
		this.dp = dp;
	}

	@Override
	public void update() {
		System.out.println("TV updated. current temperature : " + dp.getTemperature());
	}

	@Override
	public String toString() {
		return "DisplayTV";
	}

}
