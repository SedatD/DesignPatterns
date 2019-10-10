package observer.interfaces;

public interface ObservableInterface {

	boolean add(ObserverInterface oi);

	boolean remove(ObserverInterface oi);

	void update();

}
