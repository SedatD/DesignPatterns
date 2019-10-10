package observer;

import observer.models.DisplayPhone;
import observer.models.DisplayTV;

public class Main {

	public static void main(String[] args) {

		DataProvider dataProvider = new DataProvider();

		DisplayPhone displayPhone = new DisplayPhone(dataProvider);
		DisplayTV displayTV = new DisplayTV(dataProvider);

		dataProvider.add(displayPhone);
		dataProvider.add(displayTV);

		System.out.println("dataProvider list : " + dataProvider.getOiList().toString());

		dataProvider.setTemperature(28);
		dataProvider.update();

		dataProvider.setTemperature(32);
		dataProvider.update();

	}

}
