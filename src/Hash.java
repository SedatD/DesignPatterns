import java.util.ArrayList;

public class Hash {
	
	private ArrayList<Integer> hashList = new ArrayList<Integer>();
	
	public Hash(int size) {
		hashList = new ArrayList<Integer>(size);
	}
	
	public Integer Lin_Probe(int key, int orig_loc, int table_size) {
		int probes = 0;
		int hashLocation;
		
		while (true) {
			hashLocation = Mod_Hash(key, table_size);
			
			if(hashList.get(hashLocation) != null) {
				
				if(orig_loc == hashLocation) {
					probes = 1;
				}
				
				hashList.add(hashLocation, key);
				break;
			}
			
			probes++;
		}
		
		return probes;
	}
	
	private Integer Double_Probe(int key, int orig_loc, int table_size) {
		int probes = 0;
		
		return probes;
	}
	
	private int Mod_Hash(int key, int N) {
		return key % N;
	}

	public ArrayList<Integer> getHashList() {
		return hashList;
	}

	public void setHashList(ArrayList<Integer> hashList) {
		this.hashList = hashList;
	}

}
