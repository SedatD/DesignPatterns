import java.util.ArrayList;
import java.util.Random;

public class Main {

	private static final int SIZE_311 = 311;
	private static final int SIZE_31 = 31;
	
	private static int avg = 0;

	private static Hash hashObj;

	public static void main(String[] args) {
		run();
		runDouble();
		// (firstHash(key) + i * secondHash(key)) % tableSize
		// https://www.geeksforgeeks.org/double-hashing/
		// https://www.geeksforgeeks.org/hashing-set-3-open-addressing/
	}

	private static void run() {
		hashObj = new Hash(SIZE_31);
		generateHardcoded();
		// generateRandom();
		Print_Table(hashObj.getHashList());
	}

	private static void runDouble() {
		hashObj = new Hash(SIZE_31);
		// generateHardcodedDouble();
		// generateRandomDouble();
		Print_Table(hashObj.getHashList());
	}

	private static void generateHardcoded() {
		int i = 0;
		computeAvarages(hashObj.Lin_Probe(3, i++, SIZE_31));
		computeAvarages(hashObj.Lin_Probe(9, i++, SIZE_31));
		computeAvarages(hashObj.Lin_Probe(44, i++, SIZE_31));
		computeAvarages(hashObj.Lin_Probe(123, i++, SIZE_31));
		computeAvarages(hashObj.Lin_Probe(99, i++, SIZE_31));
		computeAvarages(hashObj.Lin_Probe(332, i++, SIZE_31));
		computeAvarages(hashObj.Lin_Probe(69, i++, SIZE_31));
		computeAvarages(hashObj.Lin_Probe(97, i++, SIZE_31));
		computeAvarages(hashObj.Lin_Probe(33, i++, SIZE_31));
		computeAvarages(hashObj.Lin_Probe(22, i++, SIZE_31));
		computeAvarages(hashObj.Lin_Probe(52, i++, SIZE_31));
		computeAvarages(hashObj.Lin_Probe(569, i++, SIZE_31));
		computeAvarages(hashObj.Lin_Probe(873, i++, SIZE_31));
		computeAvarages(hashObj.Lin_Probe(773, i++, SIZE_31));
		computeAvarages(hashObj.Lin_Probe(987, i++, SIZE_31));
		computeAvarages(hashObj.Lin_Probe(35, i++, SIZE_31));
		computeAvarages(hashObj.Lin_Probe(14, i++, SIZE_31));
		computeAvarages(hashObj.Lin_Probe(89, i++, SIZE_31));
		computeAvarages(hashObj.Lin_Probe(339, i++, SIZE_31));
		computeAvarages(hashObj.Lin_Probe(42, i++, SIZE_31));
	}

	private static void generateRandom() {
		Random rand = new Random();
		int random = -1;
		int i = 0;
		while (true) {
			random = rand.nextInt(1000) % SIZE_311;
			hashObj.Lin_Probe(3, i++, SIZE_31);
			i++;
			if (i == SIZE_311)
				break;
		}
	}

	private static void computeAvarages(int probes) {
		avg = (avg + probes) / 2;
	}

	private static void Print_Table(ArrayList<Integer> list) {
		System.out.println("avg : " + avg);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + " --> " + list.get(i));
		}
	}

}
