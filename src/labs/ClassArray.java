package labs;

import java.io.Serializable;
import java.util.HashMap;

//������ ������� ���������� ������������� ������ ���������������� ��������� Serializable
public class ClassArray<T extends ITransport> implements Serializable {
	//������������ ������� HashMap
	private HashMap<Integer,T> places;
	private int maxCount;
	private T defaultValue;
	
	public ClassArray(int size, T defaultValue) {
		this.defaultValue = defaultValue;
		places = new HashMap<Integer, T>();
		this.maxCount = size;
	}
	
	public int addShip(T ship) {
		for(int i = 0;i<maxCount;i++) {
			if(checkFreePlace(i)) {
				places.put(i, ship);
				return i;
			}
		}
		return -1;
	}
	
	public T getShip(int index) {
		if(!checkFreePlace(index)) {
			T ship = places.get(index);
			places.remove(index);
			return ship;
		}
		return defaultValue;
	}
	
	public T popShip(int index) {
		if(!checkFreePlace(index)) {
			return places.get(index);
		}
		return defaultValue;
	}
	
	private boolean checkFreePlace(int index) {
		return !places.containsKey(index);
	}
}
